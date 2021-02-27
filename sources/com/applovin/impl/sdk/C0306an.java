package com.applovin.impl.sdk;

import android.content.Context;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.SoftReference;

/* renamed from: com.applovin.impl.sdk.an */
class C0306an implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0453j f528a;

    /* renamed from: b */
    final /* synthetic */ Context f529b;

    /* renamed from: c */
    final /* synthetic */ AppLovinAdRewardListener f530c;

    /* renamed from: d */
    final /* synthetic */ AppLovinAdVideoPlaybackListener f531d;

    /* renamed from: e */
    final /* synthetic */ AppLovinAdDisplayListener f532e;

    /* renamed from: f */
    final /* synthetic */ AppLovinAdClickListener f533f;

    /* renamed from: g */
    final /* synthetic */ C0305am f534g;

    C0306an(C0305am amVar, C0453j jVar, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        this.f534g = amVar;
        this.f528a = jVar;
        this.f529b = context;
        this.f530c = appLovinAdRewardListener;
        this.f531d = appLovinAdVideoPlaybackListener;
        this.f532e = appLovinAdDisplayListener;
        this.f533f = appLovinAdClickListener;
    }

    public void run() {
        AppLovinAd a = C0444fq.m1156a((AppLovinAd) this.f528a, (AppLovinSdk) this.f534g.f518a);
        if (a != null) {
            AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.f534g.f518a, this.f529b);
            C0311as asVar = new C0311as(this.f534g, this.f529b, this.f530c, this.f531d, this.f532e, this.f533f, (C0306an) null);
            create.setAdDisplayListener(asVar);
            create.setAdVideoPlaybackListener(asVar);
            create.setAdClickListener(asVar);
            create.showAndRender(a, this.f534g.f521d);
            SoftReference unused = this.f534g.f527j = new SoftReference(create);
            if (a instanceof C0296ad) {
                this.f534g.m560a((C0296ad) a, (AppLovinAdRewardListener) asVar);
                return;
            }
            return;
        }
        this.f534g.m565a((AppLovinAd) this.f528a, this.f531d, this.f532e);
    }
}
