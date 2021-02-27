package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinLogger;

/* renamed from: com.applovin.impl.adview.e */
class C0270e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAd f367a;

    /* renamed from: b */
    final /* synthetic */ AdViewControllerImpl f368b;

    C0270e(AdViewControllerImpl adViewControllerImpl, AppLovinAd appLovinAd) {
        this.f368b = adViewControllerImpl;
        this.f367a = appLovinAd;
    }

    public void run() {
        try {
            if (this.f368b.f151x != null) {
                this.f368b.f151x.adReceived(this.f367a);
            }
        } catch (Throwable th) {
            this.f368b.f132e.userError(AppLovinLogger.SDK_TAG, "Exception while running ad load callback: " + th.getMessage());
        }
    }
}
