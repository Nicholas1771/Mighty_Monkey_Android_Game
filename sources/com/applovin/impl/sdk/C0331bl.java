package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.sdk.bl */
final class C0331bl implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAdDisplayListener f584a;

    /* renamed from: b */
    final /* synthetic */ AppLovinAd f585b;

    /* renamed from: c */
    final /* synthetic */ AppLovinSdk f586c;

    C0331bl(AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAd appLovinAd, AppLovinSdk appLovinSdk) {
        this.f584a = appLovinAdDisplayListener;
        this.f585b = appLovinAd;
        this.f586c = appLovinSdk;
    }

    public void run() {
        try {
            this.f584a.adDisplayed(C0330bk.m648b(this.f585b));
        } catch (Throwable th) {
            this.f586c.getLogger().userError("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being displayed", th);
        }
    }
}
