package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinSdk;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.bm */
final class C0332bm implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAdRewardListener f587a;

    /* renamed from: b */
    final /* synthetic */ AppLovinAd f588b;

    /* renamed from: c */
    final /* synthetic */ Map f589c;

    /* renamed from: d */
    final /* synthetic */ AppLovinSdk f590d;

    C0332bm(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map map, AppLovinSdk appLovinSdk) {
        this.f587a = appLovinAdRewardListener;
        this.f588b = appLovinAd;
        this.f589c = map;
        this.f590d = appLovinSdk;
    }

    public void run() {
        try {
            this.f587a.userRewardVerified(C0330bk.m648b(this.f588b), this.f589c);
        } catch (Throwable th) {
            this.f590d.getLogger().userError("ListenerCallbackInvoker", "Unable to notify ad reward listener about successful reward validation request", th);
        }
    }
}
