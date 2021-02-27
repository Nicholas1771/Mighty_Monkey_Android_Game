package com.applovin.impl.sdk;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.sdk.bx */
final class C0343bx implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAdViewEventListener f628a;

    /* renamed from: b */
    final /* synthetic */ AppLovinAd f629b;

    /* renamed from: c */
    final /* synthetic */ AppLovinAdView f630c;

    /* renamed from: d */
    final /* synthetic */ AppLovinSdk f631d;

    C0343bx(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinSdk appLovinSdk) {
        this.f628a = appLovinAdViewEventListener;
        this.f629b = appLovinAd;
        this.f630c = appLovinAdView;
        this.f631d = appLovinSdk;
    }

    public void run() {
        try {
            this.f628a.adLeftApplication(C0330bk.m648b(this.f629b), this.f630c);
        } catch (Throwable th) {
            this.f631d.getLogger().userError("ListenerCallbackInvoker", "Unable to notify ad event listener about application leave event", th);
        }
    }
}
