package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.sdk.bu */
final class C0340bu implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAdVideoPlaybackListener f615a;

    /* renamed from: b */
    final /* synthetic */ AppLovinAd f616b;

    /* renamed from: c */
    final /* synthetic */ double f617c;

    /* renamed from: d */
    final /* synthetic */ boolean f618d;

    /* renamed from: e */
    final /* synthetic */ AppLovinSdk f619e;

    C0340bu(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAd appLovinAd, double d, boolean z, AppLovinSdk appLovinSdk) {
        this.f615a = appLovinAdVideoPlaybackListener;
        this.f616b = appLovinAd;
        this.f617c = d;
        this.f618d = z;
        this.f619e = appLovinSdk;
    }

    public void run() {
        try {
            this.f615a.videoPlaybackEnded(C0330bk.m648b(this.f616b), this.f617c, this.f618d);
        } catch (Throwable th) {
            this.f619e.getLogger().userError("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback ended", th);
        }
    }
}
