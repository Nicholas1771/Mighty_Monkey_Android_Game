package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;

/* renamed from: com.applovin.impl.sdk.co */
class C0361co implements AppLovinAdDisplayListener {

    /* renamed from: a */
    final /* synthetic */ C0345bz f684a;

    /* renamed from: b */
    final /* synthetic */ MediationServiceImpl f685b;

    C0361co(MediationServiceImpl mediationServiceImpl, C0345bz bzVar) {
        this.f685b = mediationServiceImpl;
        this.f684a = bzVar;
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        this.f685b.m461b(this.f684a);
    }

    public void adHidden(AppLovinAd appLovinAd) {
    }
}
