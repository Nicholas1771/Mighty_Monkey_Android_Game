package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;

/* renamed from: com.applovin.impl.sdk.cp */
class C0362cp implements AppLovinAdClickListener {

    /* renamed from: a */
    final /* synthetic */ C0345bz f686a;

    /* renamed from: b */
    final /* synthetic */ MediationServiceImpl f687b;

    C0362cp(MediationServiceImpl mediationServiceImpl, C0345bz bzVar) {
        this.f687b = mediationServiceImpl;
        this.f686a = bzVar;
    }

    public void adClicked(AppLovinAd appLovinAd) {
        this.f687b.m463c(this.f686a);
    }
}
