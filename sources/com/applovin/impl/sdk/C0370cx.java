package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;

/* renamed from: com.applovin.impl.sdk.cx */
class C0370cx implements AppLovinNativeAdPrecacheListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinNativeAdPrecacheListener f714a;

    /* renamed from: b */
    final /* synthetic */ C0367cu f715b;

    C0370cx(C0367cu cuVar, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        this.f715b = cuVar;
        this.f714a = appLovinNativeAdPrecacheListener;
    }

    public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
    }

    public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
    }

    public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
        this.f715b.m758a(this.f714a, appLovinNativeAd, i, true);
    }

    public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd) {
        this.f715b.m759a(this.f714a, appLovinNativeAd, true);
    }
}
