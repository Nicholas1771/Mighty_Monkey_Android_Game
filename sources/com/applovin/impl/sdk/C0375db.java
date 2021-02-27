package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.db */
class C0375db implements AppLovinNativeAdLoadListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinNativeAdLoadListener f726a;

    /* renamed from: b */
    final /* synthetic */ C0367cu f727b;

    C0375db(C0367cu cuVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f727b = cuVar;
        this.f726a = appLovinNativeAdLoadListener;
    }

    public void onNativeAdsFailedToLoad(int i) {
        this.f727b.m756a(this.f726a, i);
    }

    public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
        this.f727b.m757a(this.f726a, list);
    }
}
