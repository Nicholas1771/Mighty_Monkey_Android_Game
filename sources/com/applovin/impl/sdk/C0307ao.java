package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdRewardListener;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.ao */
class C0307ao implements AppLovinAdRewardListener {

    /* renamed from: a */
    final /* synthetic */ C0305am f535a;

    C0307ao(C0305am amVar) {
        this.f535a = amVar;
    }

    public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
        this.f535a.f518a.getLogger().mo4779d("IncentivizedAdController", "User declined to view");
    }

    public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
        this.f535a.f518a.getLogger().mo4779d("IncentivizedAdController", "User over quota: " + map);
    }

    public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
        this.f535a.f518a.getLogger().mo4779d("IncentivizedAdController", "Reward rejected: " + map);
    }

    public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
        this.f535a.f518a.getLogger().mo4779d("IncentivizedAdController", "Reward validated: " + map);
    }

    public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
        this.f535a.f518a.getLogger().mo4779d("IncentivizedAdController", "Reward validation failed: " + i);
    }
}
