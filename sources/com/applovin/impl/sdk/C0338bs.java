package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.sdk.bs */
final class C0338bs implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAdClickListener f609a;

    /* renamed from: b */
    final /* synthetic */ AppLovinAd f610b;

    /* renamed from: c */
    final /* synthetic */ AppLovinSdk f611c;

    C0338bs(AppLovinAdClickListener appLovinAdClickListener, AppLovinAd appLovinAd, AppLovinSdk appLovinSdk) {
        this.f609a = appLovinAdClickListener;
        this.f610b = appLovinAd;
        this.f611c = appLovinSdk;
    }

    public void run() {
        try {
            this.f609a.adClicked(C0330bk.m648b(this.f610b));
        } catch (Throwable th) {
            this.f611c.getLogger().userError("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being clicked", th);
        }
    }
}
