package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;

/* renamed from: com.applovin.impl.sdk.ci */
class C0355ci implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0345bz f666a;

    /* renamed from: b */
    final /* synthetic */ C0351ce f667b;

    C0355ci(C0351ce ceVar, C0345bz bzVar) {
        this.f667b = ceVar;
        this.f666a = bzVar;
    }

    public void run() {
        this.f667b.m694b(this.f666a);
        if (this.f666a.getType() == AppLovinAdType.REGULAR) {
            if (this.f666a.getSize() == AppLovinAdSize.INTERSTITIAL) {
                this.f667b.f655b.prepareInterstitialAd(this.f667b.f658e, this.f667b.f656c.getApplicationContext());
            }
        } else if (this.f666a.getType() == AppLovinAdType.INCENTIVIZED) {
            this.f667b.f655b.prepareIncentivizedAd(this.f667b.f658e, this.f667b.f656c.getApplicationContext());
        }
    }
}
