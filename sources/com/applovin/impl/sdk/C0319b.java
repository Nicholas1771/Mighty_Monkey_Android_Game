package com.applovin.impl.sdk;

import android.os.Handler;
import android.os.Looper;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.b */
public class C0319b {

    /* renamed from: a */
    private static final Handler f562a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private WeakReference<AppLovinAdDisplayListener> f563b = new WeakReference<>((Object) null);

    /* renamed from: c */
    private WeakReference<AppLovinAdClickListener> f564c = new WeakReference<>((Object) null);

    /* renamed from: d */
    private WeakReference<AppLovinAdRewardListener> f565d = new WeakReference<>((Object) null);

    /* renamed from: e */
    private AppLovinAdDisplayListener f566e;

    /* renamed from: f */
    private AppLovinAdClickListener f567f;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4350a(AppLovinAd appLovinAd) {
        AppLovinAdDisplayListener appLovinAdDisplayListener = (AppLovinAdDisplayListener) this.f563b.get();
        if (appLovinAdDisplayListener != null) {
            f562a.post(new C0346c(this, appLovinAdDisplayListener, appLovinAd));
        }
        if (this.f566e != null) {
            this.f566e.adDisplayed(appLovinAd);
        }
    }

    /* renamed from: a */
    public void mo4351a(AppLovinAdClickListener appLovinAdClickListener) {
        this.f564c = new WeakReference<>(appLovinAdClickListener);
    }

    /* renamed from: a */
    public void mo4352a(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f563b = new WeakReference<>(appLovinAdDisplayListener);
    }

    /* renamed from: a */
    public void mo4353a(AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f565d = new WeakReference<>(appLovinAdRewardListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4354a(Map<String, String> map, C0345bz bzVar) {
        AppLovinAdRewardListener appLovinAdRewardListener = (AppLovinAdRewardListener) this.f565d.get();
        if (appLovinAdRewardListener != null) {
            appLovinAdRewardListener.userRewardVerified(bzVar, map);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4355b(AppLovinAd appLovinAd) {
        AppLovinAdDisplayListener appLovinAdDisplayListener = (AppLovinAdDisplayListener) this.f563b.get();
        if (appLovinAdDisplayListener != null) {
            f562a.post(new C0373d(this, appLovinAdDisplayListener, appLovinAd));
        }
        if (this.f566e != null) {
            this.f566e.adHidden(appLovinAd);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4356b(AppLovinAdClickListener appLovinAdClickListener) {
        this.f567f = appLovinAdClickListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4357b(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f566e = appLovinAdDisplayListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4358b(Map<String, String> map, C0345bz bzVar) {
        AppLovinAdRewardListener appLovinAdRewardListener = (AppLovinAdRewardListener) this.f565d.get();
        if (appLovinAdRewardListener != null) {
            appLovinAdRewardListener.userRewardRejected(bzVar, map);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo4359c(AppLovinAd appLovinAd) {
        AppLovinAdClickListener appLovinAdClickListener = (AppLovinAdClickListener) this.f564c.get();
        if (appLovinAdClickListener != null) {
            f562a.post(new C0400e(this, appLovinAdClickListener, appLovinAd));
        }
        if (this.f567f != null) {
            this.f567f.adClicked(appLovinAd);
        }
    }
}
