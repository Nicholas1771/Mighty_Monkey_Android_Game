package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;

/* renamed from: com.applovin.impl.adview.bm */
class C0239bm implements AppLovinAdDisplayListener {

    /* renamed from: a */
    final /* synthetic */ C0225az f295a;

    C0239bm(C0225az azVar) {
        this.f295a = azVar;
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        if (!this.f295a.f256g) {
            this.f295a.m251a(appLovinAd);
        }
    }

    public void adHidden(AppLovinAd appLovinAd) {
        this.f295a.m259b(appLovinAd);
    }
}
