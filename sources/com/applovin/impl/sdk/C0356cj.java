package com.applovin.impl.sdk;

import android.app.Activity;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;

/* renamed from: com.applovin.impl.sdk.cj */
class C0356cj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0319b f668a;

    /* renamed from: b */
    final /* synthetic */ C0345bz f669b;

    /* renamed from: c */
    final /* synthetic */ String f670c;

    /* renamed from: d */
    final /* synthetic */ Activity f671d;

    /* renamed from: e */
    final /* synthetic */ C0351ce f672e;

    C0356cj(C0351ce ceVar, C0319b bVar, C0345bz bzVar, String str, Activity activity) {
        this.f672e = ceVar;
        this.f668a = bVar;
        this.f669b = bzVar;
        this.f670c = str;
        this.f671d = activity;
    }

    public void run() {
        C0357ck ckVar = new C0357ck(this);
        if (this.f669b.getType() == AppLovinAdType.REGULAR) {
            if (this.f669b.getSize() == AppLovinAdSize.INTERSTITIAL) {
                this.f672e.f655b.showInterstitialAd(this.f669b.mo4393d(), this.f672e.f658e, this.f670c, this.f671d, ckVar);
            } else {
                this.f672e.f657d.mo4780e("MediationAdapterWrapper", "Failed to display " + this.f669b + ": " + this.f669b.getSize() + " is not a supported ad size");
                throw new IllegalArgumentException("Unsupported ad size");
            }
        } else if (this.f669b.getType() == AppLovinAdType.INCENTIVIZED) {
            this.f672e.f655b.showIncentivizedAd(this.f669b.mo4393d(), this.f672e.f658e, this.f670c, this.f671d, ckVar);
        } else {
            this.f672e.f657d.mo4780e("MediationAdapterWrapper", "Failed to display " + this.f669b + ": " + this.f669b.getType() + " is not a supported ad type");
            throw new IllegalArgumentException("Unsupported ad type");
        }
    }
}
