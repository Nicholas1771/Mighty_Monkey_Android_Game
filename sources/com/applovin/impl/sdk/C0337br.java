package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.sdk.br */
final class C0337br implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAdDisplayListener f606a;

    /* renamed from: b */
    final /* synthetic */ AppLovinAd f607b;

    /* renamed from: c */
    final /* synthetic */ AppLovinSdk f608c;

    C0337br(AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAd appLovinAd, AppLovinSdk appLovinSdk) {
        this.f606a = appLovinAdDisplayListener;
        this.f607b = appLovinAd;
        this.f608c = appLovinSdk;
    }

    public void run() {
        try {
            this.f606a.adHidden(C0330bk.m648b(this.f607b));
        } catch (Throwable th) {
            this.f608c.getLogger().userError("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being hidden", th);
        }
    }
}
