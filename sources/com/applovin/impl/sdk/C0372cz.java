package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.cz */
class C0372cz implements AppLovinNativeAdLoadListener {

    /* renamed from: a */
    final /* synthetic */ C0371cy f720a;

    C0372cz(C0371cy cyVar) {
        this.f720a = cyVar;
    }

    public void onNativeAdsFailedToLoad(int i) {
        if (this.f720a.f717b != null) {
            this.f720a.f717b.onNativeAdsFailedToLoad(i);
        }
    }

    public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
        if (this.f720a.f717b != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f720a.f716a);
            arrayList.addAll(this.f720a.f718c);
            this.f720a.f717b.onNativeAdsLoaded(arrayList);
        }
    }
}
