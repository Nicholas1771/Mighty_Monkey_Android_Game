package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.cv */
class C0368cv implements AppLovinNativeAdLoadListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinNativeAdLoadListener f710a;

    /* renamed from: b */
    final /* synthetic */ C0367cu f711b;

    C0368cv(C0367cu cuVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f711b = cuVar;
        this.f710a = appLovinNativeAdLoadListener;
    }

    public void onNativeAdsFailedToLoad(int i) {
        this.f711b.m756a(this.f710a, i);
    }

    public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
        this.f711b.mo4482a(list, this.f710a);
    }
}
