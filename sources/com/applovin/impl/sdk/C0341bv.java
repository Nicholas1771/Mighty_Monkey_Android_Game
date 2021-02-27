package com.applovin.impl.sdk;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.sdk.bv */
final class C0341bv implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAdViewEventListener f620a;

    /* renamed from: b */
    final /* synthetic */ AppLovinAd f621b;

    /* renamed from: c */
    final /* synthetic */ AppLovinAdView f622c;

    /* renamed from: d */
    final /* synthetic */ AppLovinSdk f623d;

    C0341bv(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinSdk appLovinSdk) {
        this.f620a = appLovinAdViewEventListener;
        this.f621b = appLovinAd;
        this.f622c = appLovinAdView;
        this.f623d = appLovinSdk;
    }

    public void run() {
        try {
            this.f620a.adOpenedFullscreen(C0330bk.m648b(this.f621b), this.f622c);
        } catch (Throwable th) {
            this.f623d.getLogger().userError("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen opened event", th);
        }
    }
}
