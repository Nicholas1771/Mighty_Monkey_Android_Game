package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.SoftReference;

/* renamed from: com.applovin.impl.sdk.am */
public class C0305am {

    /* renamed from: a */
    protected final AppLovinSdkImpl f518a;

    /* renamed from: b */
    protected final AppLovinAdServiceImpl f519b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AppLovinAd f520c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f521d;

    /* renamed from: e */
    private SoftReference<AppLovinAdLoadListener> f522e;

    /* renamed from: f */
    private final Object f523f = new Object();

    /* renamed from: g */
    private volatile String f524g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C0440fm f525h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public volatile boolean f526i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public SoftReference<AppLovinInterstitialAdDialog> f527j;

    public C0305am(AppLovinSdk appLovinSdk) {
        this.f518a = (AppLovinSdkImpl) appLovinSdk;
        this.f519b = (AppLovinAdServiceImpl) appLovinSdk.getAdService();
    }

    /* renamed from: a */
    private void m559a(Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (mo4327a()) {
            C0453j jVar = (C0453j) this.f520c;
            if (jVar.f1151a.mo4767c() == C0452i.INDIRECT) {
                AppLovinAd a = C0444fq.m1156a(this.f520c, (AppLovinSdk) this.f518a);
                if (!(a instanceof C0345bz)) {
                    this.f518a.getLogger().userError("IncentivizedAdController", "Skipping mediated incentivized video playback: an unknown ad was pre-loaded: '" + a + "'");
                    m569d();
                } else if (context instanceof Activity) {
                    m563a((C0345bz) a, (Activity) context, appLovinAdRewardListener, appLovinAdDisplayListener, appLovinAdClickListener);
                } else {
                    this.f518a.getLogger().userError("IncentivizedAdController", "Skipping incentivized video playback: Activity required.");
                    m565a(this.f520c, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener);
                }
            } else {
                m564a(jVar, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            }
        } else {
            this.f518a.getLogger().userError("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
            m569d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m560a(C0296ad adVar, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f525h = new C0440fm(adVar, appLovinAdRewardListener, this.f518a);
        this.f518a.mo4169a().mo4681a((C0386dm) this.f525h, C0416ep.BACKGROUND);
    }

    /* renamed from: a */
    private void m563a(C0345bz bzVar, Activity activity, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        C0319b bVar = new C0319b();
        bVar.mo4351a(appLovinAdClickListener);
        bVar.mo4352a(appLovinAdDisplayListener);
        bVar.mo4353a(appLovinAdRewardListener);
        this.f518a.getMediationService().showAd(bzVar, this.f521d, activity, bVar);
        m571e();
    }

    /* renamed from: a */
    private void m564a(C0453j jVar, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (!jVar.getType().equals(AppLovinAdType.INCENTIVIZED)) {
            this.f518a.getLogger().mo4780e("IncentivizedAdController", "Failed to render an ad of type " + jVar.getType() + " in an Incentivized Ad interstitial.");
            m565a((AppLovinAd) jVar, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener);
        } else if (!C0444fq.m1167a((AppLovinAd) jVar, this.f518a)) {
            m565a((AppLovinAd) jVar, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener);
        } else {
            if (jVar.f1151a.mo4767c() == C0452i.DIRECT) {
                if (!C0444fq.m1165a(jVar instanceof C0299ag ? (C0296ad) this.f518a.mo4172c().mo4467b(jVar.mo4292m()) : (C0296ad) jVar, context, this.f518a)) {
                    this.f518a.getLogger().userError("IncentivizedAdController", "Failed to render an ad: video cache has been removed.");
                    m565a((AppLovinAd) jVar, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener);
                    return;
                }
            }
            C0306an anVar = new C0306an(this, jVar, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            boolean booleanValue = ((Boolean) this.f518a.get(C0387dn.f831am)).booleanValue();
            if (!booleanValue || !(context instanceof Activity) || ((Activity) context).isFinishing()) {
                if (booleanValue) {
                    this.f518a.getLogger().userError("IncentivizedAdController", "Unable to show Incentivized Ad prompt. Must pass in an active Activity context.");
                }
                anVar.run();
                return;
            }
            C0314av.m592b().mo4362a(this.f518a).mo4361a((Activity) context).mo4363a(this).mo4364a(appLovinAdRewardListener).mo4365a((Runnable) anVar).mo4360a().mo4345a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m565a(AppLovinAd appLovinAd, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener) {
        C0330bk.m646a(appLovinAdVideoPlaybackListener, appLovinAd, 0.0d, false, this.f518a);
        C0330bk.m650b(appLovinAdDisplayListener, appLovinAd, this.f518a);
    }

    /* renamed from: d */
    private void m569d() {
        AppLovinAdLoadListener appLovinAdLoadListener;
        if (this.f522e != null && (appLovinAdLoadListener = this.f522e.get()) != null) {
            appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m571e() {
        this.f520c = null;
        this.f521d = null;
    }

    /* renamed from: f */
    private AppLovinAdRewardListener m572f() {
        return new C0307ao(this);
    }

    /* renamed from: a */
    public void mo4322a(Context context, String str, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdRewardListener f = appLovinAdRewardListener == null ? m572f() : appLovinAdRewardListener;
        this.f521d = str;
        m559a(context, f, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    /* renamed from: a */
    public void mo4323a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f518a.getLogger().mo4779d("IncentivizedAdController", "User requested preload of incentivized ad...");
        this.f522e = new SoftReference<>(appLovinAdLoadListener);
        if (mo4327a()) {
            this.f518a.getLogger().userError("IncentivizedAdController", "Attempted to call preloadAndNotify: while an ad was already loaded or currently being played. Do not call preloadAndNotify: again until the last ad has been closed (adHidden).");
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.f520c);
                return;
            }
            return;
        }
        mo4329b((AppLovinAdLoadListener) new C0308ap(this, appLovinAdLoadListener));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4324a(AppLovinAdRewardListener appLovinAdRewardListener) {
        C0330bk.m644a(appLovinAdRewardListener, this.f520c, (AppLovinSdk) this.f518a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4325a(String str) {
        synchronized (this.f523f) {
            this.f524g = str;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4326a(String str, Context context) {
        if (str != null && ((Boolean) this.f518a.get(C0387dn.f832an)).booleanValue()) {
            new C0312at(this.f518a, context, str).mo4341a();
        }
    }

    /* renamed from: a */
    public boolean mo4327a() {
        return this.f520c != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo4328b() {
        String str;
        synchronized (this.f523f) {
            str = this.f524g;
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4329b(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f519b.mo4155a(appLovinAdLoadListener);
    }

    /* renamed from: c */
    public void mo4330c() {
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialog;
        if (this.f527j != null && (appLovinInterstitialAdDialog = this.f527j.get()) != null) {
            appLovinInterstitialAdDialog.dismiss();
        }
    }
}
