package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.da */
class C0374da implements AppLovinNativeAdLoadListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinNativeAdLoadListener f724a;

    /* renamed from: b */
    final /* synthetic */ C0367cu f725b;

    C0374da(C0367cu cuVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f725b = cuVar;
        this.f724a = appLovinNativeAdLoadListener;
    }

    public void onNativeAdsFailedToLoad(int i) {
        if (this.f724a != null) {
            this.f724a.onNativeAdsFailedToLoad(i);
        }
    }

    public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
        if (this.f724a != null) {
            this.f724a.onNativeAdsLoaded(list);
        }
    }
}
