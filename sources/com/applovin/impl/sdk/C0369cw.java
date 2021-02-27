package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;

/* renamed from: com.applovin.impl.sdk.cw */
class C0369cw implements AppLovinNativeAdPrecacheListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinNativeAdPrecacheListener f712a;

    /* renamed from: b */
    final /* synthetic */ C0367cu f713b;

    C0369cw(C0367cu cuVar, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        this.f713b = cuVar;
        this.f712a = appLovinNativeAdPrecacheListener;
    }

    public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
        this.f713b.m758a(this.f712a, appLovinNativeAd, i, false);
    }

    public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
        this.f713b.m759a(this.f712a, appLovinNativeAd, false);
        this.f713b.m755a(appLovinNativeAd, this.f712a);
    }

    public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
    }

    public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd) {
    }
}
