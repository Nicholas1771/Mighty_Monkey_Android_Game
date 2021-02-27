package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.p003a.C0180a;
import com.applovin.impl.p003a.C0197r;
import com.applovin.impl.sdk.AppLovinSdkImpl;
import com.applovin.impl.sdk.C0296ad;
import com.applovin.impl.sdk.C0298af;
import com.applovin.impl.sdk.C0319b;
import com.applovin.impl.sdk.C0345bz;
import com.applovin.impl.sdk.C0391dr;
import com.applovin.impl.sdk.C0395dv;
import com.applovin.impl.sdk.C0444fq;
import com.applovin.impl.sdk.C0463t;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.drive.DriveFile;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.applovin.impl.adview.bz */
class C0252bz implements AppLovinInterstitialAdDialog {

    /* renamed from: d */
    public static volatile boolean f312d = false;

    /* renamed from: e */
    public static volatile boolean f313e = false;

    /* renamed from: f */
    private static final Map<String, C0252bz> f314f = Collections.synchronizedMap(new HashMap());

    /* renamed from: p */
    private static volatile boolean f315p;

    /* renamed from: a */
    protected final String f316a;

    /* renamed from: b */
    protected final AppLovinSdkImpl f317b;

    /* renamed from: c */
    protected final WeakReference<Context> f318c;

    /* renamed from: g */
    private final C0319b f319g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public volatile AppLovinAdLoadListener f320h;

    /* renamed from: i */
    private volatile AppLovinAdDisplayListener f321i;

    /* renamed from: j */
    private volatile AppLovinAdVideoPlaybackListener f322j;

    /* renamed from: k */
    private volatile AppLovinAdClickListener f323k;

    /* renamed from: l */
    private volatile C0296ad f324l;

    /* renamed from: m */
    private volatile C0298af f325m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public volatile C0216aq f326n;

    /* renamed from: o */
    private volatile String f327o;

    C0252bz(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (context == null) {
            throw new IllegalArgumentException("No context specified");
        } else {
            this.f317b = (AppLovinSdkImpl) appLovinSdk;
            this.f316a = UUID.randomUUID().toString();
            this.f319g = new C0319b();
            this.f318c = new WeakReference<>(context);
            f312d = true;
            f313e = false;
        }
    }

    /* renamed from: a */
    public static C0252bz m321a(String str) {
        return f314f.get(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m323a(int i) {
        AppLovinSdkUtils.runOnUiThread(new C0257cd(this, i));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m324a(Context context) {
        Intent intent = new Intent(context, AppLovinInterstitialActivity.class);
        intent.putExtra(C0225az.KEY_WRAPPER_ID, this.f316a);
        AppLovinInterstitialActivity.lastKnownWrapper = this;
        if (context instanceof Activity) {
            try {
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(0, 0);
            } catch (Throwable th) {
                this.f317b.getLogger().mo4781e("InterstitialAdDialogWrapper", "Unable to remove pending transition animations", th);
            }
        } else {
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            context.startActivity(intent);
        }
        mo4068a(true);
    }

    /* renamed from: a */
    private void m328a(C0296ad adVar, String str, Context context) {
        f314f.put(this.f316a, this);
        this.f324l = adVar;
        this.f327o = str;
        this.f325m = this.f324l != null ? this.f324l.mo4293o() : C0298af.DEFAULT;
        if (!this.f324l.mo3860b() && this.f324l.mo3864d() != null && !this.f317b.getFileManager().mo4317a(this.f324l.mo3864d().getLastPathSegment(), context)) {
            if (this.f324l instanceof C0180a) {
                C0197r c = ((C0180a) this.f324l).mo3862c();
                if (c != null) {
                    this.f317b.getLogger().mo4780e("InterstitialAdDialogWrapper", "Cached video removed from local filesystem for VAST ad. Setting videoUri to source: " + c.mo3929a());
                    c.mo3930a(c.mo3929a());
                } else {
                    this.f317b.getLogger().mo4780e("InterstitialAdDialogWrapper", "Cached video removed from local filesystem for VAST ad and source uri not found. Failing ad show.");
                    m330a((AppLovinAd) adVar);
                    return;
                }
            } else {
                this.f317b.getLogger().mo4780e("InterstitialAdDialogWrapper", "Cached video removed from local filesystem for internal ad. Failing ad show.");
                m330a((AppLovinAd) adVar);
                return;
            }
        }
        if (C0463t.m1250a((Class<?>) AppLovinInterstitialActivity.class, context)) {
            long max = Math.max(0, new C0391dr(this.f317b).mo4550I());
            this.f317b.getLogger().mo4779d("InterstitialAdDialogWrapper", "Presenting ad with delay of " + max);
            m334j();
            new Handler(context.getMainLooper()).postDelayed(new C0255cb(this, context), max);
            return;
        }
        this.f317b.getLogger().userError("AppLovinInterstitialAdDialog", "Unable to launch ad. ");
        m330a((AppLovinAd) adVar);
    }

    /* renamed from: a */
    private void m329a(C0345bz bzVar, String str, Activity activity) {
        this.f317b.getMediationService().showAd(bzVar, str, activity, this.f319g);
        m334j();
    }

    /* renamed from: a */
    private void m330a(AppLovinAd appLovinAd) {
        if (this.f321i != null) {
            this.f321i.adHidden(appLovinAd);
        }
        f315p = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m332b(AppLovinAd appLovinAd) {
        AppLovinSdkUtils.runOnUiThread(new C0256cc(this, appLovinAd));
    }

    /* renamed from: i */
    private Context m333i() {
        if (this.f318c != null) {
            return (Context) this.f318c.get();
        }
        return null;
    }

    /* renamed from: j */
    private void m334j() {
        C0395dv dvVar = new C0395dv(this.f317b);
        if (dvVar.mo4633c() == -1) {
            dvVar.mo4635d(System.currentTimeMillis() - this.f317b.getInitializedTimeMillis());
        }
    }

    /* renamed from: a */
    public AppLovinSdk mo4065a() {
        return this.f317b;
    }

    /* renamed from: a */
    public void mo4066a(C0216aq aqVar) {
        this.f326n = aqVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4067a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f317b.getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, appLovinAdLoadListener);
    }

    /* renamed from: a */
    public void mo4068a(boolean z) {
        f315p = z;
    }

    /* renamed from: b */
    public AppLovinAd mo4069b() {
        return this.f324l;
    }

    /* renamed from: c */
    public AppLovinAdVideoPlaybackListener mo4070c() {
        return this.f322j;
    }

    /* renamed from: d */
    public AppLovinAdDisplayListener mo4071d() {
        return this.f321i;
    }

    public void dismiss() {
        AppLovinSdkUtils.runOnUiThread(new C0258ce(this));
    }

    /* renamed from: e */
    public AppLovinAdClickListener mo4072e() {
        return this.f323k;
    }

    /* renamed from: f */
    public C0298af mo4073f() {
        return this.f325m;
    }

    /* renamed from: g */
    public String mo4074g() {
        return this.f327o;
    }

    /* renamed from: h */
    public void mo4075h() {
        f312d = false;
        f313e = true;
        f314f.remove(this.f316a);
    }

    public boolean isAdReadyToDisplay() {
        return this.f317b.getAdService().hasPreloadedAd(AppLovinAdSize.INTERSTITIAL);
    }

    public boolean isShowing() {
        return f315p;
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f323k = appLovinAdClickListener;
        this.f319g.mo4351a(appLovinAdClickListener);
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f321i = appLovinAdDisplayListener;
        this.f319g.mo4352a(appLovinAdDisplayListener);
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f320h = appLovinAdLoadListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f322j = appLovinAdVideoPlaybackListener;
    }

    public void show() {
        show((String) null);
    }

    public void show(String str) {
        mo4067a((AppLovinAdLoadListener) new C0254ca(this, str));
    }

    public void showAndRender(AppLovinAd appLovinAd) {
        showAndRender(appLovinAd, (String) null);
    }

    public void showAndRender(AppLovinAd appLovinAd, String str) {
        C0391dr drVar = new C0391dr(this.f317b);
        if (isShowing() && !drVar.mo4576ah()) {
            this.f317b.getLogger().userError("AppLovinInterstitialAdDialog", "Attempted to show an interstitial while one is already displayed; ignoring.");
        } else if (!C0444fq.m1167a(appLovinAd, this.f317b)) {
            m330a(appLovinAd);
        } else {
            Context i = m333i();
            if (i != null) {
                AppLovinAd a = C0444fq.m1156a(appLovinAd, (AppLovinSdk) this.f317b);
                if (a == null) {
                    this.f317b.getLogger().mo4780e("InterstitialAdDialogWrapper", "Failed to show ad: " + appLovinAd);
                    m330a(appLovinAd);
                } else if (a instanceof C0296ad) {
                    m328a((C0296ad) a, str, i);
                } else if (!(a instanceof C0345bz)) {
                    this.f317b.getLogger().mo4780e("InterstitialAdDialogWrapper", "Failed to show interstitial: unknown ad type provided: '" + a + "'");
                    m330a(a);
                } else if (i instanceof Activity) {
                    m329a((C0345bz) a, str, (Activity) i);
                } else {
                    this.f317b.getLogger().userError("InterstitialAdDialogWrapper", "Failed to show interstitial: Activity required.");
                    m330a(a);
                }
            } else {
                this.f317b.getLogger().mo4780e("InterstitialAdDialogWrapper", "Failed to show interstitial: stale activity reference provided");
                m330a(appLovinAd);
            }
        }
    }
}
