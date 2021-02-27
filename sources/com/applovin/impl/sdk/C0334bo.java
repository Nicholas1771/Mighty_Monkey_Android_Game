package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinSdk;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.bo */
final class C0334bo implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAdRewardListener f595a;

    /* renamed from: b */
    final /* synthetic */ AppLovinAd f596b;

    /* renamed from: c */
    final /* synthetic */ Map f597c;

    /* renamed from: d */
    final /* synthetic */ AppLovinSdk f598d;

    C0334bo(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map map, AppLovinSdk appLovinSdk) {
        this.f595a = appLovinAdRewardListener;
        this.f596b = appLovinAd;
        this.f597c = map;
        this.f598d = appLovinSdk;
    }

    public void run() {
        try {
            this.f595a.userRewardRejected(C0330bk.m648b(this.f596b), this.f597c);
        } catch (Throwable th) {
            this.f598d.getLogger().userError("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request being rejected", th);
        }
    }
}
