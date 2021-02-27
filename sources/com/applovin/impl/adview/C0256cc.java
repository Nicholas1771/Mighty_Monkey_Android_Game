package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;

/* renamed from: com.applovin.impl.adview.cc */
class C0256cc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAd f333a;

    /* renamed from: b */
    final /* synthetic */ C0252bz f334b;

    C0256cc(C0252bz bzVar, AppLovinAd appLovinAd) {
        this.f334b = bzVar;
        this.f333a = appLovinAd;
    }

    public void run() {
        if (this.f334b.f320h != null) {
            this.f334b.f320h.adReceived(this.f333a);
        }
    }
}
