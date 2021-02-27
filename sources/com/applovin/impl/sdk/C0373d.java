package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;

/* renamed from: com.applovin.impl.sdk.d */
class C0373d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAdDisplayListener f721a;

    /* renamed from: b */
    final /* synthetic */ AppLovinAd f722b;

    /* renamed from: c */
    final /* synthetic */ C0319b f723c;

    C0373d(C0319b bVar, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAd appLovinAd) {
        this.f723c = bVar;
        this.f721a = appLovinAdDisplayListener;
        this.f722b = appLovinAd;
    }

    public void run() {
        this.f721a.adHidden(this.f722b);
    }
}
