package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.cy */
class C0371cy implements AppLovinNativeAdLoadListener {

    /* renamed from: a */
    final /* synthetic */ List f716a;

    /* renamed from: b */
    final /* synthetic */ AppLovinNativeAdLoadListener f717b;

    /* renamed from: c */
    final /* synthetic */ List f718c;

    /* renamed from: d */
    final /* synthetic */ C0367cu f719d;

    C0371cy(C0367cu cuVar, List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, List list2) {
        this.f719d = cuVar;
        this.f716a = list;
        this.f717b = appLovinNativeAdLoadListener;
        this.f718c = list2;
    }

    public void onNativeAdsFailedToLoad(int i) {
        if (this.f717b != null) {
            this.f717b.onNativeAdsFailedToLoad(i);
        }
    }

    public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
        this.f719d.m761c(this.f716a, new C0372cz(this));
    }
}
