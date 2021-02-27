package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;

/* renamed from: com.applovin.impl.sdk.c */
class C0346c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAdDisplayListener f634a;

    /* renamed from: b */
    final /* synthetic */ AppLovinAd f635b;

    /* renamed from: c */
    final /* synthetic */ C0319b f636c;

    C0346c(C0319b bVar, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAd appLovinAd) {
        this.f636c = bVar;
        this.f634a = appLovinAdDisplayListener;
        this.f635b = appLovinAd;
    }

    public void run() {
        this.f634a.adDisplayed(this.f635b);
    }
}
