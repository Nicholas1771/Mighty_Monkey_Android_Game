package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;

/* renamed from: com.applovin.impl.sdk.cn */
class C0360cn implements AppLovinAdLoadListener {

    /* renamed from: a */
    final /* synthetic */ C0351ce f679a;

    /* renamed from: b */
    final /* synthetic */ long f680b;

    /* renamed from: c */
    final /* synthetic */ AppLovinAdLoadListener f681c;

    /* renamed from: d */
    final /* synthetic */ C0345bz f682d;

    /* renamed from: e */
    final /* synthetic */ MediationServiceImpl f683e;

    C0360cn(MediationServiceImpl mediationServiceImpl, C0351ce ceVar, long j, AppLovinAdLoadListener appLovinAdLoadListener, C0345bz bzVar) {
        this.f683e = mediationServiceImpl;
        this.f679a = ceVar;
        this.f680b = j;
        this.f681c = appLovinAdLoadListener;
        this.f682d = bzVar;
    }

    public void adReceived(AppLovinAd appLovinAd) {
        synchronized (this.f683e.f452d) {
            String unused = this.f683e.f454f = this.f679a.mo4415a();
            long unused2 = this.f683e.f453e = System.currentTimeMillis() - this.f680b;
        }
        if (((Boolean) this.f683e.f449a.get(C0387dn.f953db)).booleanValue()) {
            this.f683e.f451c.mo4406a(this.f679a);
        }
        this.f683e.m457a(appLovinAd, this.f681c);
    }

    public void failedToReceiveAd(int i) {
        this.f683e.m456a(this.f682d, i, this.f681c);
    }
}
