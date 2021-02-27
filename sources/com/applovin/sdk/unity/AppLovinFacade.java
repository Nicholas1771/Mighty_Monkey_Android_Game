package com.applovin.sdk.unity;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.unity3d.player.UnityPlayer;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class AppLovinFacade {
    public static final float AD_POSITION_BOTTOM = -50000.0f;
    public static final float AD_POSITION_CENTER = -10000.0f;
    public static final float AD_POSITION_LEFT = -20000.0f;
    public static final float AD_POSITION_RIGHT = -30000.0f;
    public static final float AD_POSITION_TOP = -40000.0f;
    public static final String SERIALIZED_KEY_VALUE_PAIR_SEPARATOR = String.valueOf(28);
    public static final String SERIALIZED_KEY_VALUE_SEPARATOR = String.valueOf(29);
    public static final String TAG = "AppLovinFacade-Unity";
    public static final String UNITY_PLUGIN_BUILD = "40400";
    public static final String UNITY_PLUGIN_VERSION = "4.4.0";
    private static final Map<Activity, AppLovinFacade> facades = new WeakHashMap();
    private static String gameObjectToNotify;
    private static String sdkKey;
    private static AppLovinSdkSettings sdkSettings;
    /* access modifiers changed from: private */
    public AppLovinAdView adView;
    private int adWidth;
    private final DisplayMetrics displayMetric;
    /* access modifiers changed from: private */
    public float horizontalPosition = -10000.0f;
    /* access modifiers changed from: private */
    public AppLovinIncentivizedInterstitial incentivizedInterstitial;
    /* access modifiers changed from: private */
    public volatile boolean interCurrentlyShowing = false;
    private volatile boolean isImmersive = false;
    /* access modifiers changed from: private */
    public volatile boolean isIncentReady = false;
    /* access modifiers changed from: private */
    public volatile AppLovinAd lastInterstitial;
    private final AppLovinLogger logger;
    /* access modifiers changed from: private */
    public FrameLayout mainLayout;
    /* access modifiers changed from: private */
    public final Activity parentActivity;
    private int screenHeight;
    private int screenWidth;
    /* access modifiers changed from: private */
    public final AppLovinSdk sdk;
    /* access modifiers changed from: private */
    public float verticalPosition = -10000.0f;

    /* access modifiers changed from: private */
    public static AppLovinSdk getAppropriateSdkInstance(Activity currentActivity) {
        if (sdkSettings == null) {
            sdkSettings = new AppLovinSdkSettings();
        }
        if (sdkKey != null) {
            return AppLovinSdk.getInstance(sdkKey, sdkSettings, currentActivity);
        }
        return AppLovinSdk.getInstance(currentActivity);
    }

    public static AppLovinFacade getAppLovinFacade(Activity activity) {
        AppLovinFacade facade;
        synchronized (facades) {
            facade = facades.get(activity);
            if (facade == null) {
                facade = new AppLovinFacade(activity);
                facades.put(activity, facade);
            }
        }
        return facade;
    }

    public static void SetAdPosition(Activity currentActivity, String horizontal, String vertical) {
        getAppLovinFacade(currentActivity).setAdPosition(stringCompatibility(horizontal), stringCompatibility(vertical));
    }

    public static void SetAdPosition(Activity currentActivity, float x, float y) {
        getAppLovinFacade(currentActivity).setAdPosition(x, y);
    }

    public static void ShowAd(Activity currentActivity) {
        getAppLovinFacade(currentActivity).showAd();
    }

    public static void HideAd(Activity currentActivity) {
        getAppLovinFacade(currentActivity).hideAd();
    }

    public static void LoadNextAd(Activity currentActivity) {
        getAppLovinFacade(currentActivity).loadNextAd();
    }

    public static void SetAdWidth(Activity currentActivity, int width) {
        getAppLovinFacade(currentActivity).setAdWidth(width);
    }

    public static void ShowInterstitial(Activity currentActivity, String placement) {
        getAppLovinFacade(currentActivity).showInterstitial(placement);
    }

    public static void LoadIncentInterstitial(Activity currentActivity) {
        getAppLovinFacade(currentActivity).preloadIncentInterstitial();
    }

    public static void ShowIncentInterstitial(Activity currentActivity, String placement) {
        getAppLovinFacade(currentActivity).showIncentInterstitial(placement);
    }

    private static boolean sdkInitialized(Activity currentActivity) {
        if (currentActivity == null || getAppropriateSdkInstance(currentActivity) == null) {
            return false;
        }
        return true;
    }

    public static void InitializeSdk(Activity currentActivity) {
        if (!sdkInitialized(currentActivity)) {
            AppLovinSdk.initializeSdk(currentActivity);
        }
    }

    public static void SetSdkKey(Activity currentActivity, String key) {
        sdkKey = key;
    }

    public static void SetVerboseLoggingOn(String isVerboseLogging) {
        if (sdkSettings == null) {
            sdkSettings = new AppLovinSdkSettings();
        }
        sdkSettings.setVerboseLogging(Boolean.parseBoolean(isVerboseLogging));
    }

    public static void SetMuted(String muted) {
        if (sdkSettings == null) {
            sdkSettings = new AppLovinSdkSettings();
        }
        sdkSettings.setMuted(Boolean.parseBoolean(muted));
    }

    public static String IsMuted() {
        if (sdkSettings == null) {
            sdkSettings = new AppLovinSdkSettings();
        }
        return Boolean.toString(sdkSettings.isMuted());
    }

    public static void SetTestAdsEnabled(String enabled) {
        if (sdkSettings == null) {
            sdkSettings = new AppLovinSdkSettings();
        }
        sdkSettings.setTestAdsEnabled(Boolean.parseBoolean(enabled));
    }

    public static String IsTestAdsEnabled() {
        if (sdkSettings == null) {
            sdkSettings = new AppLovinSdkSettings();
        }
        return Boolean.toString(sdkSettings.isTestAdsEnabled());
    }

    public static void PreloadInterstitial(Activity currentActivity) {
        getAppLovinFacade(currentActivity).preloadInterstitial();
    }

    public static String IsInterstitialReady(Activity currentActivity) {
        return getAppLovinFacade(currentActivity).isInterstitialReady(currentActivity);
    }

    public static String IsInterstitialShowing(Activity currentActivity) {
        return getAppLovinFacade(currentActivity).isInterstitialShowing();
    }

    public static String IsIncentReady(Activity currentActivity) {
        return getAppLovinFacade(currentActivity).isIncentReady();
    }

    public static String IsCurrentInterstitialVideo(Activity currentActivity) {
        return getAppLovinFacade(currentActivity).isCurrentInterstitialVideo();
    }

    public static void TrackEvent(Activity currentActivity, String eventType, String serializedParameters) {
        getAppLovinFacade(currentActivity).trackEvent(currentActivity, eventType, serializedParameters);
    }

    public static void EnableImmersiveMode(Activity currentActivity) {
        getAppLovinFacade(currentActivity).enableImmersiveMode(currentActivity);
    }

    public AppLovinFacade(Activity currentActivity) {
        if (currentActivity == null) {
            throw new IllegalArgumentException("No activity specified");
        }
        this.parentActivity = currentActivity;
        this.sdk = getAppropriateSdkInstance(currentActivity);
        this.logger = this.sdk.getLogger();
        try {
            this.sdk.setPluginVersion("unity-4.4.0");
        } catch (Throwable th) {
            this.logger.userError(AppLovinLogger.SDK_TAG, "AppLovin SDK may be out of date. Please consider updating to the latest version.");
        }
        Display display = this.parentActivity.getWindowManager().getDefaultDisplay();
        this.displayMetric = this.parentActivity.getResources().getDisplayMetrics();
        if (Build.VERSION.SDK_INT > 13) {
            Point size = new Point();
            display.getSize(size);
            this.screenWidth = size.x;
            this.screenHeight = size.y;
        } else {
            this.screenWidth = display.getWidth();
            this.screenHeight = display.getHeight();
        }
        if (this.screenWidth > this.screenHeight) {
            this.adWidth = (int) TypedValue.applyDimension(1, 320.0f, this.displayMetric);
        } else {
            this.adWidth = this.screenWidth;
        }
        try {
            Bundle metaData = this.parentActivity.getPackageManager().getApplicationInfo(this.parentActivity.getPackageName(), 128).metaData;
            if (metaData != null) {
                int userAdWidth = metaData.getInt("applovin.sdk.ad.width", 0);
                if (userAdWidth > 0) {
                    setAdWidth(userAdWidth);
                }
                if (metaData.getString("applovin.sdk.ad.position.vertical") != null) {
                    this.verticalPosition = stringCompatibility(metaData.getString("applovin.sdk.ad.position.vertical"));
                }
                if (metaData.getString("applovin.sdk.ad.position.horizontal") != null) {
                    this.horizontalPosition = stringCompatibility(metaData.getString("applovin.sdk.ad.position.horizontal"));
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(AppLovinLogger.SDK_TAG, "Name not found", e);
        }
        this.parentActivity.runOnUiThread(new Runnable() {
            public void run() {
                AppLovinAdView unused = AppLovinFacade.this.adView = new AppLovinAdView(AppLovinFacade.this.sdk, AppLovinAdSize.BANNER, (Context) AppLovinFacade.this.parentActivity);
                AppLovinFacade.this.adView.setVisibility(8);
                AppLovinFacade.this.setAdViewListeners();
                FrameLayout unused2 = AppLovinFacade.this.mainLayout = new FrameLayout(AppLovinFacade.this.parentActivity);
                AppLovinFacade.this.mainLayout.addView(AppLovinFacade.this.adView, new FrameLayout.LayoutParams(-2, -2, 51));
                AppLovinFacade.this.parentActivity.addContentView(AppLovinFacade.this.mainLayout, new ViewGroup.LayoutParams(-1, -1));
                AppLovinFacade.this.updateAdPosition();
            }
        });
    }

    private String isIncentReady() {
        return Boolean.toString(this.isIncentReady);
    }

    private String isCurrentInterstitialVideo() {
        return Boolean.toString(this.lastInterstitial != null && this.lastInterstitial.isVideoAd());
    }

    /* access modifiers changed from: private */
    public void setAdViewListeners() {
        UnityListenerWrapper listenerWrapper = new UnityListenerWrapper();
        this.adView.setAdLoadListener(new TypeRememberingLoadListener(AppLovinAdSize.BANNER, AppLovinAdType.REGULAR, listenerWrapper));
        this.adView.setAdDisplayListener(listenerWrapper);
        this.adView.setAdVideoPlaybackListener(listenerWrapper);
        this.adView.setAdClickListener(listenerWrapper);
        this.adView.setAdViewEventListener(listenerWrapper);
    }

    private void enableImmersiveMode(Activity currentActivity) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.isImmersive = true;
            this.parentActivity.runOnUiThread(new Runnable() {
                public void run() {
                    AppLovinFacade.this.parentActivity.getWindow().getDecorView().setSystemUiVisibility(5894);
                }
            });
        }
    }

    private void disableImmersiveMode() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.parentActivity.runOnUiThread(new Runnable() {
                public void run() {
                    AppLovinFacade.this.parentActivity.getWindow().getDecorView().setSystemUiVisibility(1792);
                }
            });
        }
    }

    public static float stringCompatibility(String val) {
        if (val.equals("left")) {
            return -20000.0f;
        }
        if (val.equals("right")) {
            return -30000.0f;
        }
        if (val.equals("top")) {
            return -40000.0f;
        }
        if (val.equals("bottom")) {
            return -50000.0f;
        }
        if (val.equals("center") || val.equals("middle")) {
        }
        return -10000.0f;
    }

    public void showAd() {
        this.logger.mo4779d(AppLovinLogger.SDK_TAG, "Show AppLovin Ad");
        loadNextAd();
        this.parentActivity.runOnUiThread(new Runnable() {
            public void run() {
                AppLovinFacade.this.adView.setVisibility(0);
                AppLovinFacade.this.mainLayout.setVisibility(0);
            }
        });
    }

    public void hideAd() {
        this.logger.mo4779d(AppLovinLogger.SDK_TAG, "Hide AppLovin Ad");
        this.parentActivity.runOnUiThread(new Runnable() {
            public void run() {
                AppLovinFacade.this.mainLayout.setVisibility(8);
            }
        });
    }

    public void loadNextAd() {
        this.logger.mo4779d(AppLovinLogger.SDK_TAG, "AppLovin Load Next Ad");
        this.parentActivity.runOnUiThread(new Runnable() {
            public void run() {
                AppLovinFacade.this.setAdViewListeners();
                AppLovinFacade.this.adView.loadNextAd();
            }
        });
    }

    public void setAdWidth(int width) {
        this.adWidth = (int) TypedValue.applyDimension(1, (float) width, this.displayMetric);
        this.parentActivity.runOnUiThread(new Runnable() {
            public void run() {
                AppLovinFacade.this.updatePadding();
            }
        });
    }

    public void showInterstitial(final String placement) {
        if (this.isImmersive) {
            disableImmersiveMode();
        }
        this.parentActivity.runOnUiThread(new Runnable() {
            public void run() {
                AppLovinInterstitialAdDialog adDialog = AppLovinInterstitialAd.create(AppLovinFacade.getAppropriateSdkInstance(AppLovinFacade.this.parentActivity), AppLovinFacade.this.parentActivity);
                UnityListenerWrapper listenerWrapper = new UnityListenerWrapper();
                adDialog.setAdLoadListener(new TypeRememberingLoadListener(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.REGULAR, listenerWrapper));
                adDialog.setAdDisplayListener(listenerWrapper);
                adDialog.setAdVideoPlaybackListener(listenerWrapper);
                adDialog.setAdClickListener(listenerWrapper);
                if (AppLovinFacade.this.lastInterstitial != null) {
                    adDialog.showAndRender(AppLovinFacade.this.lastInterstitial, placement);
                } else {
                    adDialog.show(placement);
                }
            }
        });
    }

    public void preloadIncentInterstitial() {
        this.incentivizedInterstitial = AppLovinIncentivizedInterstitial.create(getAppropriateSdkInstance(this.parentActivity));
        this.incentivizedInterstitial.preload(new TypeRememberingLoadListener(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, new UnityListenerWrapper()));
    }

    public void showIncentInterstitial(final String placement) {
        this.parentActivity.runOnUiThread(new Runnable() {
            public void run() {
                UnityListenerWrapper listenerWrapper = new UnityListenerWrapper();
                if (AppLovinFacade.this.incentivizedInterstitial != null) {
                    AppLovinFacade.this.incentivizedInterstitial.show(AppLovinFacade.this.parentActivity, placement, listenerWrapper, listenerWrapper, listenerWrapper, listenerWrapper);
                } else {
                    AppLovinFacade.this.sendToCSharp("LOADFAILED");
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void updatePadding() {
        int difference = this.screenWidth - this.adWidth;
        if (this.horizontalPosition == -20000.0f) {
            this.adView.setPadding(0, 0, difference, 0);
        } else if (this.horizontalPosition == -10000.0f) {
            this.adView.setPadding(difference / 2, 0, difference / 2, 0);
        } else if (this.horizontalPosition == -30000.0f) {
            this.adView.setPadding(difference, 0, 0, 0);
        }
    }

    public void updateAdPosition() {
        if (this.horizontalPosition == 0.0f) {
            throw new NullPointerException("No horizontal position specifed");
        } else if (this.verticalPosition == 0.0f) {
            throw new NullPointerException("No vertical position specifed");
        } else {
            this.parentActivity.runOnUiThread(new Runnable() {
                public void run() {
                    int gravity = 17;
                    if (AppLovinFacade.this.horizontalPosition == -20000.0f) {
                        gravity = 3;
                    } else if (AppLovinFacade.this.horizontalPosition == -10000.0f) {
                        gravity = 17;
                    } else if (AppLovinFacade.this.horizontalPosition == -30000.0f) {
                        gravity = 5;
                    }
                    if (AppLovinFacade.this.verticalPosition == -40000.0f) {
                        gravity |= 48;
                    } else if (AppLovinFacade.this.verticalPosition == -50000.0f) {
                        gravity |= 80;
                    }
                    AppLovinFacade.this.updatePadding();
                    AppLovinFacade.this.mainLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, gravity));
                }
            });
        }
    }

    public void setAdPosition(float horizontal, float vertical) {
        if (horizontal == 0.0f) {
            throw new NullPointerException("No horizontal position specified");
        } else if (vertical == 0.0f) {
            throw new NullPointerException("No vertical position specified");
        } else {
            this.horizontalPosition = horizontal;
            this.verticalPosition = vertical;
            updateAdPosition();
        }
    }

    public void preloadInterstitial() {
        final UnityListenerWrapper listenerWrapper = new UnityListenerWrapper();
        getAppropriateSdkInstance(this.parentActivity).getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, new TypeRememberingLoadListener(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.REGULAR, new UnityExtendedLoadListener() {
            public void onAdReceived(AppLovinAd ad) {
                AppLovinAd unused = AppLovinFacade.this.lastInterstitial = ad;
                listenerWrapper.onAdReceived(ad);
            }

            public void onAdLoadFailed(AppLovinAdSize size, AppLovinAdType type, int errorCode) {
                listenerWrapper.onAdLoadFailed(size, type, errorCode);
            }
        }));
    }

    public static void SetIncentivizedUsername(Activity currentActivity, String username) {
        new AppLovinIncentivizedInterstitial(getAppropriateSdkInstance(currentActivity)).setUserIdentifier(username);
    }

    public String isInterstitialReady(Activity activity) {
        boolean hasLastInter;
        boolean z = false;
        if (this.lastInterstitial != null) {
            hasLastInter = true;
        } else {
            hasLastInter = false;
        }
        boolean hasPreloadedInter = getAppropriateSdkInstance(activity).getAdService().hasPreloadedAd(AppLovinAdSize.INTERSTITIAL);
        if (hasLastInter || hasPreloadedInter) {
            z = true;
        }
        return Boolean.toString(z);
    }

    public String isInterstitialShowing() {
        return Boolean.toString(this.interCurrentlyShowing);
    }

    public static void SetUnityAdListener(String gameObjectToNotify2) {
        gameObjectToNotify = gameObjectToNotify2;
    }

    public void sendToCSharp(String message) {
        this.logger.mo4779d(TAG, "Sending message to Unity/C#: " + message);
        if (gameObjectToNotify != null) {
            UnityPlayer.UnitySendMessage(gameObjectToNotify, "onAppLovinEventReceived", message);
        } else {
            this.logger.mo4779d(TAG, "Skipping sending message to Unity/C#: No GameObject provided.");
        }
    }

    public void trackEvent(Activity activity, String eventType, String serializedParameters) {
        this.logger.mo4779d(TAG, "Tracking event of type " + eventType + "; parameters: " + serializedParameters);
        if (serializedParameters == null) {
            getAppropriateSdkInstance(activity).getEventService().trackEvent(eventType);
            return;
        }
        getAppropriateSdkInstance(activity).getEventService().trackEvent(eventType, deserializeParameters(serializedParameters));
    }

    private static Map<String, String> deserializeParameters(String serializedParameters) {
        Map<String, String> deserialized = new HashMap<>();
        for (String keyValuePair : serializedParameters.split(SERIALIZED_KEY_VALUE_PAIR_SEPARATOR)) {
            if (keyValuePair.length() > 0) {
                String[] splitPair = keyValuePair.split(SERIALIZED_KEY_VALUE_SEPARATOR);
                if (splitPair.length > 1) {
                    deserialized.put(splitPair[0], splitPair[1]);
                }
            }
        }
        return deserialized;
    }

    private class UnityListenerWrapper implements UnityExtendedLoadListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener, AppLovinAdRewardListener, AppLovinAdViewEventListener {
        private UnityListenerWrapper() {
        }

        public void adDisplayed(AppLovinAd ad) {
            AppLovinFacade.this.sendToCSharp("DISPLAYED" + (ad.getType().equals(AppLovinAdType.INCENTIVIZED) ? "REWARDED" : ad.getSize().getLabel()));
            if (ad.getSize().equals(AppLovinAdSize.INTERSTITIAL)) {
                boolean unused = AppLovinFacade.this.interCurrentlyShowing = true;
            }
        }

        public void adHidden(AppLovinAd ad) {
            AppLovinFacade.this.sendToCSharp("HIDDEN" + (ad.getType().equals(AppLovinAdType.INCENTIVIZED) ? "REWARDED" : ad.getSize().getLabel()));
            if (ad.getSize().equals(AppLovinAdSize.INTERSTITIAL)) {
                boolean unused = AppLovinFacade.this.interCurrentlyShowing = false;
                AppLovinAd unused2 = AppLovinFacade.this.lastInterstitial = null;
            }
            if (ad.getType().equals(AppLovinAdType.INCENTIVIZED)) {
                boolean unused3 = AppLovinFacade.this.isIncentReady = false;
            }
        }

        public void onAdReceived(AppLovinAd ad) {
            if (ad.getType().equals(AppLovinAdType.INCENTIVIZED)) {
                AppLovinFacade.this.sendToCSharp("LOADEDREWARDED");
                boolean unused = AppLovinFacade.this.isIncentReady = true;
                return;
            }
            AppLovinFacade.this.sendToCSharp("LOADED" + ad.getSize().getLabel());
        }

        public void onAdLoadFailed(AppLovinAdSize size, AppLovinAdType type, int errorCode) {
            AppLovinFacade.this.sendToCSharp("LOADFAILED");
            if (type.equals(AppLovinAdType.INCENTIVIZED)) {
                AppLovinFacade.this.sendToCSharp("LOADREWARDEDFAILED");
            } else {
                AppLovinFacade.this.sendToCSharp("LOAD" + size.getLabel().toUpperCase() + "FAILED");
            }
        }

        public void userRewardVerified(AppLovinAd ad, Map response) {
            AppLovinFacade.this.sendToCSharp("REWARDAPPROVED");
            String amountStr = (String) response.get(AppLovinEventParameters.REVENUE_AMOUNT);
            String currencyName = (String) response.get(AppLovinEventParameters.REVENUE_CURRENCY);
            if (amountStr != null && currencyName != null) {
                AppLovinFacade.this.sendToCSharp("REWARDAPPROVEDINFO|" + amountStr + "|" + currencyName);
            }
        }

        public void userOverQuota(AppLovinAd ad, Map response) {
            AppLovinFacade.this.sendToCSharp("REWARDOVERQUOTA");
        }

        public void userRewardRejected(AppLovinAd ad, Map response) {
            AppLovinFacade.this.sendToCSharp("REWARDREJECTED");
        }

        public void validationRequestFailed(AppLovinAd ad, int errorCode) {
            if (errorCode == -600) {
                AppLovinFacade.this.sendToCSharp("USERCLOSEDEARLY");
            } else {
                AppLovinFacade.this.sendToCSharp("REWARDTIMEOUT");
            }
        }

        public void userDeclinedToViewAd(AppLovinAd ad) {
            AppLovinFacade.this.sendToCSharp("USERDECLINED");
        }

        public void videoPlaybackBegan(AppLovinAd ad) {
            AppLovinFacade.this.sendToCSharp("VIDEOBEGAN");
        }

        public void videoPlaybackEnded(AppLovinAd ad, double percentViewed, boolean fullyWatched) {
            AppLovinFacade.this.sendToCSharp("VIDEOSTOPPED");
        }

        public void adClicked(AppLovinAd ad) {
            AppLovinFacade.this.sendToCSharp("CLICKED");
        }

        public void adOpenedFullscreen(AppLovinAd ad, AppLovinAdView adView) {
            AppLovinFacade.this.sendToCSharp("OPENEDFULLSCREEN");
        }

        public void adClosedFullscreen(AppLovinAd ad, AppLovinAdView adView) {
            AppLovinFacade.this.sendToCSharp("CLOSEDFULLSCREEN");
        }

        public void adLeftApplication(AppLovinAd ad, AppLovinAdView adView) {
            AppLovinFacade.this.sendToCSharp("LEFTAPPLICATION");
        }

        public void adFailedToDisplay(AppLovinAd ad, AppLovinAdView adView, AppLovinAdViewDisplayErrorCode code) {
            AppLovinFacade.this.sendToCSharp("DISPLAYFAILED");
        }
    }
}
