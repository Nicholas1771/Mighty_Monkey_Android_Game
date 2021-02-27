package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.sdk.ct */
class C0366ct implements AppLovinNativeAdPrecacheListener {

    /* renamed from: a */
    final /* synthetic */ C0365cs f707a;

    C0366ct(C0365cs csVar) {
        this.f707a = csVar;
    }

    public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
        this.f707a.mo4507b(C0451h.f1142h, i);
    }

    public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
        if (!AppLovinSdkUtils.isValidString(appLovinNativeAd.getVideoUrl())) {
            this.f707a.mo4508c((C0344by) appLovinNativeAd);
        }
    }

    public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
        this.f707a.f747b.mo4785w("NativeAdPreloadManager", "Video failed to cache during native ad preload. " + i);
        this.f707a.mo4508c((C0344by) appLovinNativeAd);
    }

    public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd) {
        this.f707a.mo4508c((C0344by) appLovinNativeAd);
    }
}
