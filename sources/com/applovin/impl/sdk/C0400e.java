package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;

/* renamed from: com.applovin.impl.sdk.e */
class C0400e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAdClickListener f1017a;

    /* renamed from: b */
    final /* synthetic */ AppLovinAd f1018b;

    /* renamed from: c */
    final /* synthetic */ C0319b f1019c;

    C0400e(C0319b bVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAd appLovinAd) {
        this.f1019c = bVar;
        this.f1017a = appLovinAdClickListener;
        this.f1018b = appLovinAd;
    }

    public void run() {
        this.f1017a.adClicked(this.f1018b);
    }
}
