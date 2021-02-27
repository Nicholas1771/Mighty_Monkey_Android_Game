package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.sdk.bt */
final class C0339bt implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAdVideoPlaybackListener f612a;

    /* renamed from: b */
    final /* synthetic */ AppLovinAd f613b;

    /* renamed from: c */
    final /* synthetic */ AppLovinSdk f614c;

    C0339bt(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAd appLovinAd, AppLovinSdk appLovinSdk) {
        this.f612a = appLovinAdVideoPlaybackListener;
        this.f613b = appLovinAd;
        this.f614c = appLovinSdk;
    }

    public void run() {
        try {
            this.f612a.videoPlaybackBegan(C0330bk.m648b(this.f613b));
        } catch (Throwable th) {
            this.f614c.getLogger().userError("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback began", th);
        }
    }
}
