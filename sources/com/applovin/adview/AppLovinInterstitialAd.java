package com.applovin.adview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.applovin.impl.adview.InterstitialAdDialogCreatorImpl;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;

public class AppLovinInterstitialAd extends View {

    /* renamed from: a */
    private AppLovinInterstitialAdDialog f18a;

    public AppLovinInterstitialAd(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppLovinInterstitialAd(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18a = null;
        AppLovinSdk instance = AppLovinSdk.getInstance(context);
        if (instance != null && !instance.hasCriticalErrors()) {
            this.f18a = new InterstitialAdDialogCreatorImpl().createInterstitialAdDialog(instance, context);
        }
        setVisibility(8);
    }

    public static AppLovinInterstitialAdDialog create(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (context != null) {
            return new InterstitialAdDialogCreatorImpl().createInterstitialAdDialog(appLovinSdk, context);
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    public static boolean isAdReadyToDisplay(Context context) {
        return AppLovinSdk.getInstance(context).getAdService().hasPreloadedAd(AppLovinAdSize.INTERSTITIAL);
    }

    public static void show(Context context) {
        show(context, (String) null);
    }

    public static void show(Context context, String str) {
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        AppLovinSdk instance = AppLovinSdk.getInstance(context);
        if (instance != null && !instance.hasCriticalErrors()) {
            show(instance, context, str);
        }
    }

    public static void show(AppLovinSdk appLovinSdk, Context context, String str) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (context == null) {
            throw new IllegalArgumentException("No context specified");
        } else {
            AppLovinSdkUtils.runOnUiThread(new C0178b(appLovinSdk, context, str));
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f18a != null) {
            this.f18a.show();
        }
    }
}
