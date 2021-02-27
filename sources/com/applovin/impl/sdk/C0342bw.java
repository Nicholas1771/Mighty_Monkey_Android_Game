package com.applovin.impl.sdk;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.sdk.bw */
final class C0342bw implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAdViewEventListener f624a;

    /* renamed from: b */
    final /* synthetic */ AppLovinAd f625b;

    /* renamed from: c */
    final /* synthetic */ AppLovinAdView f626c;

    /* renamed from: d */
    final /* synthetic */ AppLovinSdk f627d;

    C0342bw(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinSdk appLovinSdk) {
        this.f624a = appLovinAdViewEventListener;
        this.f625b = appLovinAd;
        this.f626c = appLovinAdView;
        this.f627d = appLovinSdk;
    }

    public void run() {
        try {
            this.f624a.adClosedFullscreen(C0330bk.m648b(this.f625b), this.f626c);
        } catch (Throwable th) {
            this.f627d.getLogger().userError("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen closed event", th);
        }
    }
}
