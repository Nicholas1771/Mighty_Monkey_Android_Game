package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import android.widget.RelativeLayout;
import com.applovin.adview.AdViewController;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.adview.ClickTrackingOverlayView;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.C0296ad;
import com.applovin.impl.sdk.C0297ae;
import com.applovin.impl.sdk.C0300ah;
import com.applovin.impl.sdk.C0330bk;
import com.applovin.impl.sdk.C0391dr;
import com.applovin.impl.sdk.C0395dv;
import com.applovin.impl.sdk.C0444fq;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;

public class AdViewControllerImpl implements AdViewController {

    /* renamed from: A */
    private volatile AppLovinAdClickListener f126A;

    /* renamed from: B */
    private volatile boolean f127B;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f128a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ViewGroup f129b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AppLovinSdk f130c;

    /* renamed from: d */
    private AppLovinAdService f131d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AppLovinLogger f132e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public AppLovinAdSize f133f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f134g;

    /* renamed from: h */
    private C0207ah f135h;

    /* renamed from: i */
    private C0276k f136i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C0279n f137j;

    /* renamed from: k */
    private AppLovinAd f138k;

    /* renamed from: l */
    private Runnable f139l;

    /* renamed from: m */
    private Runnable f140m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public volatile AppLovinAd f141n = null;

    /* renamed from: o */
    private volatile AppLovinAd f142o = null;

    /* renamed from: p */
    private ClickTrackingOverlayView f143p = null;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public C0217ar f144q = null;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public C0217ar f145r = null;

    /* renamed from: s */
    private final AtomicReference<AppLovinAd> f146s = new AtomicReference<>();

    /* renamed from: t */
    private volatile boolean f147t = false;

    /* renamed from: u */
    private volatile boolean f148u = true;

    /* renamed from: v */
    private volatile boolean f149v = false;

    /* renamed from: w */
    private volatile boolean f150w = false;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public volatile AppLovinAdLoadListener f151x;

    /* renamed from: y */
    private volatile AppLovinAdDisplayListener f152y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public volatile AppLovinAdViewEventListener f153z;

    /* renamed from: a */
    private void m136a(AppLovinAdView appLovinAdView, AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Context context) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (appLovinAdSize == null) {
            throw new IllegalArgumentException("No ad size specified");
        } else {
            this.f130c = appLovinSdk;
            this.f131d = appLovinSdk.getAdService();
            this.f132e = appLovinSdk.getLogger();
            this.f133f = appLovinAdSize;
            this.f128a = context;
            this.f129b = appLovinAdView;
            this.f138k = new C0300ah();
            this.f135h = new C0207ah(this, appLovinSdk);
            this.f140m = new C0273h(this, (C0199a) null);
            this.f139l = new C0275j(this, (C0199a) null);
            this.f136i = new C0276k(this, appLovinSdk);
            if (m141a(context)) {
                m139a(appLovinAdSize);
            } else {
                this.f132e.userError("AppLovinAdView", "Web view database is corrupt, AdView not loaded");
            }
        }
    }

    /* renamed from: a */
    private void m138a(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, Uri uri) {
        if (this.f143p != null) {
            this.f132e.mo4779d("AppLovinAdView", "Skipping click overlay rendering because it already exists");
        } else if (appLovinAdView != null) {
            this.f132e.mo4779d("AppLovinAdView", "Creating and rendering click overlay");
            this.f143p = new ClickTrackingOverlayView(appLovinAdView.getContext(), this.f130c);
            this.f143p.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            appLovinAdView.addView(this.f143p);
            appLovinAdView.bringChildToFront(this.f143p);
            ((AppLovinAdServiceImpl) this.f131d).trackAndLaunchForegroundClick(appLovinAd, this.f134g, appLovinAdView, this, uri);
        } else {
            this.f132e.mo4780e("AppLovinAdView", "Skipping click overlay rendering because AppLovinAdView has been destroyed");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m139a(AppLovinAdSize appLovinAdSize) {
        try {
            this.f137j = new C0279n(this.f135h, this.f130c, this.f128a);
            this.f137j.setBackgroundColor(0);
            this.f137j.setWillNotCacheDrawing(false);
            if (new C0391dr(this.f130c).mo4603v() && Build.VERSION.SDK_INT >= 19) {
                this.f137j.setLayerType(2, (Paint) null);
            }
            this.f129b.setBackgroundColor(0);
            this.f129b.addView(this.f137j);
            m145b((View) this.f137j, appLovinAdSize);
            if (!this.f147t) {
                m140a(this.f140m);
            }
            m140a((Runnable) new C0274i(this, (C0199a) null));
            this.f147t = true;
        } catch (Throwable th) {
            this.f132e.userError("AppLovinAdView", "Failed to create AdView: " + th.getMessage());
        }
    }

    /* renamed from: a */
    private void m140a(Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(runnable);
    }

    /* renamed from: a */
    private static boolean m141a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                return true;
            }
            WebViewDatabase instance = WebViewDatabase.getInstance(context);
            Method declaredMethod = WebViewDatabase.class.getDeclaredMethod("getCacheTotalSize", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(instance, new Object[0]);
            return true;
        } catch (NoSuchMethodException e) {
            Log.e("AppLovinAdView", "Error invoking getCacheTotalSize()", e);
            return true;
        } catch (IllegalArgumentException e2) {
            Log.e("AppLovinAdView", "Error invoking getCacheTotalSize()", e2);
            return true;
        } catch (IllegalAccessException e3) {
            Log.e("AppLovinAdView", "Error invoking getCacheTotalSize()", e3);
            return true;
        } catch (InvocationTargetException e4) {
            Log.e("AppLovinAdView", "getCacheTotalSize() reported exception", e4);
            return false;
        } catch (Throwable th) {
            Log.e("AppLovinAdView", "Unexpected error while checking DB state", th);
            return false;
        }
    }

    /* renamed from: b */
    private void m144b() {
        if (this.f131d != null) {
            this.f131d.removeAdUpdateListener(this.f136i, getSize());
        }
        if (this.f137j != null) {
            try {
                ViewParent parent = this.f137j.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(this.f137j);
                }
                this.f137j.removeAllViews();
                if (new C0391dr(this.f130c).mo4578aj()) {
                    this.f137j.loadUrl("about:blank");
                    this.f137j.onPause();
                    this.f137j.destroyDrawingCache();
                }
            } catch (Throwable th) {
                this.f132e.mo4786w("AppLovinAdView", "Unable to destroy ad view", th);
            }
            this.f137j.destroy();
            this.f137j = null;
        }
        this.f149v = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m145b(View view, AppLovinAdSize appLovinAdSize) {
        if (view != null) {
            DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
            int applyDimension = appLovinAdSize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel()) ? -1 : appLovinAdSize.getWidth() == -1 ? displayMetrics.widthPixels : (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getWidth(), displayMetrics);
            int applyDimension2 = appLovinAdSize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel()) ? -1 : appLovinAdSize.getHeight() == -1 ? displayMetrics.heightPixels : (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getHeight(), displayMetrics);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.width = applyDimension;
            layoutParams.height = applyDimension2;
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                layoutParams.addRule(10);
                layoutParams.addRule(9);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: c */
    private void m147c() {
        m140a((Runnable) new C0199a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m149d() {
        m140a((Runnable) new C0272g(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3938a() {
        if (this.f144q == null && this.f145r == null) {
            this.f132e.mo4779d("AppLovinAdView", "Ad: " + this.f141n + " with placement = \"" + this.f134g + "\" closed.");
            m140a(this.f140m);
            C0330bk.m650b(this.f152y, this.f141n, this.f130c);
            this.f141n = null;
            this.f134g = null;
        } else if (new C0391dr(this.f130c).mo4582an()) {
            contractAd();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3939a(int i) {
        if (!this.f149v) {
            this.f131d.addAdUpdateListener(this.f136i, this.f133f);
            m140a(this.f140m);
        }
        m140a((Runnable) new C0271f(this, i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3940a(AppLovinAd appLovinAd) {
        if (appLovinAd != null) {
            this.f150w = true;
            if (!this.f149v) {
                this.f131d.addAdUpdateListener(this.f136i, this.f133f);
                renderAd(appLovinAd);
            } else {
                this.f146s.set(appLovinAd);
                this.f132e.mo4779d("AppLovinAdView", "Ad view has paused when an ad was received, ad saved for later");
            }
            m140a((Runnable) new C0270e(this, appLovinAd));
            return;
        }
        this.f132e.mo4780e("AppLovinAdView", "No provided when to the view controller");
        mo3939a(-1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3941a(AppLovinAd appLovinAd, String str, AppLovinAdView appLovinAdView, Uri uri) {
        C0330bk.m641a(this.f126A, appLovinAd, this.f130c);
        if (appLovinAdView != null) {
            AppLovinAdServiceImpl appLovinAdServiceImpl = (AppLovinAdServiceImpl) this.f131d;
            if (!new C0391dr(this.f130c).mo4607z() || uri == null) {
                appLovinAdServiceImpl.trackAndLaunchClick(appLovinAd, str, appLovinAdView, this, uri);
            } else {
                m138a(appLovinAd, appLovinAdView, uri);
            }
        } else {
            this.f132e.mo4780e("AppLovinAdView", "Unable to process ad click - AppLovinAdView destroyed prematurely");
        }
    }

    public void contractAd() {
        m140a((Runnable) new C0269d(this));
    }

    public void destroy() {
        if (!(this.f137j == null || this.f144q == null)) {
            contractAd();
        }
        m144b();
    }

    public void dismissInterstitialIfRequired() {
        if (this.f128a instanceof AppLovinInterstitialActivity) {
            boolean z = ((C0296ad) this.f141n).mo4264G() == C0297ae.f504b;
            AppLovinInterstitialActivity appLovinInterstitialActivity = (AppLovinInterstitialActivity) this.f128a;
            if (z && appLovinInterstitialActivity.getPoststitialWasDisplayed()) {
                appLovinInterstitialActivity.dismiss();
            }
        }
    }

    public void expandAd() {
        m140a((Runnable) new C0226b(this));
    }

    public AppLovinAdViewEventListener getAdViewEventListener() {
        return this.f153z;
    }

    public C0279n getAdWebView() {
        return this.f137j;
    }

    public AppLovinAd getCurrentAd() {
        return this.f141n;
    }

    public AppLovinAdView getParentView() {
        return (AppLovinAdView) this.f129b;
    }

    public AppLovinSdk getSdk() {
        return this.f130c;
    }

    public AppLovinAdSize getSize() {
        return this.f133f;
    }

    public void initializeAdView(AppLovinAdView appLovinAdView, Context context, AppLovinAdSize appLovinAdSize, AppLovinSdk appLovinSdk, AttributeSet attributeSet) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (context == null) {
            Log.e(AppLovinLogger.SDK_TAG, "Unable to build AppLovinAdView: no context provided. Please use a different constructor for this view.");
        } else {
            if (appLovinAdSize == null && (appLovinAdSize = C0277l.m390a(attributeSet)) == null) {
                appLovinAdSize = AppLovinAdSize.BANNER;
            }
            if (appLovinSdk == null) {
                appLovinSdk = AppLovinSdk.getInstance(context);
            }
            if (appLovinSdk != null && !appLovinSdk.hasCriticalErrors()) {
                m136a(appLovinAdView, appLovinSdk, appLovinAdSize, context);
                if (C0277l.m391b(attributeSet)) {
                    loadNextAd();
                }
            }
        }
    }

    public boolean isAdReadyToDisplay() {
        return this.f130c.getAdService().hasPreloadedAd(this.f133f);
    }

    public boolean isAutoDestroy() {
        return this.f148u;
    }

    public boolean isForegroundClickInvalidated() {
        return this.f127B;
    }

    public void loadNextAd() {
        if (this.f130c == null || this.f136i == null || this.f128a == null || !this.f147t) {
            Log.i(AppLovinLogger.SDK_TAG, "Unable to load next ad: AppLovinAdView is not initialized.");
        } else {
            this.f131d.loadNextAd(this.f133f, this.f136i);
        }
    }

    public void onAdHtmlLoaded(WebView webView) {
        if (this.f141n instanceof C0296ad) {
            webView.setVisibility(0);
            try {
                if (this.f141n != this.f142o && this.f152y != null) {
                    this.f142o = this.f141n;
                    C0330bk.m642a(this.f152y, this.f141n, this.f130c);
                }
            } catch (Throwable th) {
                this.f132e.userError("AppLovinAdView", "Exception while notifying ad display listener", th);
            }
        }
    }

    public void onDetachedFromWindow() {
        if (this.f147t) {
            C0330bk.m650b(this.f152y, this.f141n, this.f130c);
            if (this.f137j == null || this.f144q == null) {
                this.f132e.mo4779d("AppLovinAdView", "onDetachedFromWindowCalled without an expanded ad present");
            } else {
                this.f132e.mo4779d("AppLovinAdView", "onDetachedFromWindowCalled with expanded ad present");
                if (new C0391dr(this.f130c).mo4580al()) {
                    contractAd();
                } else {
                    m147c();
                }
            }
            if (this.f148u) {
                m144b();
            }
        }
    }

    public void onVisibilityChanged(int i) {
        if (!this.f147t || !this.f148u) {
            return;
        }
        if (i == 8 || i == 4) {
            pause();
        } else if (i == 0) {
            resume();
        }
    }

    public void pause() {
        if (this.f147t) {
            if (new C0391dr(this.f130c).mo4581am()) {
                this.f131d.removeAdUpdateListener(this.f136i, getSize());
            }
            AppLovinAd appLovinAd = this.f141n;
            renderAd(this.f138k);
            if (appLovinAd != null) {
                this.f146s.set(appLovinAd);
            }
            this.f149v = true;
        }
    }

    public void removeClickTrackingOverlay() {
        if (this.f143p != null) {
            ViewParent parent = this.f143p.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.f143p);
                this.f143p = null;
                return;
            }
            return;
        }
        this.f132e.mo4779d("AppLovinAdView", "Asked to remove an overlay when none existed. Skipping...");
    }

    public void renderAd(AppLovinAd appLovinAd) {
        renderAd(appLovinAd, (String) null);
    }

    public void renderAd(AppLovinAd appLovinAd, String str) {
        if (appLovinAd == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (this.f147t) {
            AppLovinAd a = C0444fq.m1156a(appLovinAd, this.f130c);
            if (a != null && a != this.f141n) {
                this.f132e.mo4779d("AppLovinAdView", "Rendering ad #" + a.getAdIdNumber() + " (" + a.getSize() + ") over placement: " + str);
                if (!(this.f141n instanceof C0300ah)) {
                    C0330bk.m650b(this.f152y, this.f141n, this.f130c);
                }
                this.f146s.set((Object) null);
                this.f142o = null;
                this.f141n = a;
                this.f134g = str;
                if (a.getSize() == this.f133f) {
                    if (!(a instanceof C0300ah) && this.f144q != null) {
                        if (new C0391dr(this.f130c).mo4579ak()) {
                            m149d();
                            this.f132e.mo4779d("AppLovinAdView", "Fade out the old ad scheduled");
                        } else {
                            m147c();
                        }
                    }
                    if (!(a instanceof C0300ah) || (this.f144q == null && this.f145r == null)) {
                        m140a(this.f139l);
                    } else {
                        this.f132e.mo4779d("AppLovinAdView", "ignoring empty ad render with expanded ad");
                    }
                }
                if (new C0391dr(this.f130c).mo4574af() || !(a instanceof C0300ah)) {
                    new C0395dv(this.f130c).mo4628a();
                }
            } else if (a == null) {
                this.f132e.mo4785w("AppLovinAdView", "Unable to render ad: " + a + ". Internal inconsistency error.");
            } else {
                this.f132e.mo4785w("AppLovinAdView", "Ad #" + a.getAdIdNumber() + " is already showing, ignoring");
            }
        } else {
            Log.i(AppLovinLogger.SDK_TAG, "Unable to render ad: AppLovinAdView is not initialized.");
        }
    }

    public void resume() {
        if (this.f147t) {
            if (this.f150w && new C0391dr(this.f130c).mo4581am()) {
                this.f131d.addAdUpdateListener(this.f136i, this.f133f);
            }
            AppLovinAd andSet = this.f146s.getAndSet((Object) null);
            if (andSet != null) {
                renderAd(andSet);
            }
            this.f149v = false;
        }
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f126A = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f152y = appLovinAdDisplayListener;
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f151x = appLovinAdLoadListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
    }

    public void setAdViewEventListener(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        this.f153z = appLovinAdViewEventListener;
    }

    public void setAutoDestroy(boolean z) {
        this.f148u = z;
    }

    public void setIsForegroundClickInvalidated(boolean z) {
        this.f127B = z;
    }
}
