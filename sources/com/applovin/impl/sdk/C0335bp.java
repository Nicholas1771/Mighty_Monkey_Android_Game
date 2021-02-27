package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.sdk.bp */
final class C0335bp implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAdRewardListener f599a;

    /* renamed from: b */
    final /* synthetic */ AppLovinAd f600b;

    /* renamed from: c */
    final /* synthetic */ int f601c;

    /* renamed from: d */
    final /* synthetic */ AppLovinSdk f602d;

    C0335bp(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, int i, AppLovinSdk appLovinSdk) {
        this.f599a = appLovinAdRewardListener;
        this.f600b = appLovinAd;
        this.f601c = i;
        this.f602d = appLovinSdk;
    }

    public void run() {
        try {
            this.f599a.validationRequestFailed(C0330bk.m648b(this.f600b), this.f601c);
        } catch (Throwable th) {
            this.f602d.getLogger().userError("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request failing", th);
        }
    }
}
