package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

/* renamed from: com.applovin.impl.sdk.aq */
class C0309aq implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAd f538a;

    /* renamed from: b */
    final /* synthetic */ C0308ap f539b;

    C0309aq(C0308ap apVar, AppLovinAd appLovinAd) {
        this.f539b = apVar;
        this.f538a = appLovinAd;
    }

    public void run() {
        this.f539b.f537b.adReceived(this.f538a);
    }
}
