package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.sdk.bq */
final class C0336bq implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAdRewardListener f603a;

    /* renamed from: b */
    final /* synthetic */ AppLovinAd f604b;

    /* renamed from: c */
    final /* synthetic */ AppLovinSdk f605c;

    C0336bq(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, AppLovinSdk appLovinSdk) {
        this.f603a = appLovinAdRewardListener;
        this.f604b = appLovinAd;
        this.f605c = appLovinSdk;
    }

    public void run() {
        try {
            this.f603a.userDeclinedToViewAd(C0330bk.m648b(this.f604b));
        } catch (Throwable th) {
            this.f605c.getLogger().userError("ListenerCallbackInvoker", "Unable to notify ad reward listener about user declining to view ad", th);
        }
    }
}
