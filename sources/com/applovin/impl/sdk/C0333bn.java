package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinSdk;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.bn */
final class C0333bn implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAdRewardListener f591a;

    /* renamed from: b */
    final /* synthetic */ AppLovinAd f592b;

    /* renamed from: c */
    final /* synthetic */ Map f593c;

    /* renamed from: d */
    final /* synthetic */ AppLovinSdk f594d;

    C0333bn(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map map, AppLovinSdk appLovinSdk) {
        this.f591a = appLovinAdRewardListener;
        this.f592b = appLovinAd;
        this.f593c = map;
        this.f594d = appLovinSdk;
    }

    public void run() {
        try {
            this.f591a.userOverQuota(C0330bk.m648b(this.f592b), this.f593c);
        } catch (Throwable th) {
            this.f594d.getLogger().userError("ListenerCallbackInvoker", "Unable to notify ad reward listener about exceeding quota", th);
        }
    }
}
