package com.applovin.impl.sdk;

import com.applovin.mediation.AppLovinMediationErrorCode;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.cg */
class C0353cg implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0345bz f662a;

    /* renamed from: b */
    final /* synthetic */ C0358cl f663b;

    /* renamed from: c */
    final /* synthetic */ C0351ce f664c;

    C0353cg(C0351ce ceVar, C0345bz bzVar, C0358cl clVar) {
        this.f664c = ceVar;
        this.f662a = bzVar;
        this.f663b = clVar;
    }

    public void run() {
        this.f664c.m694b(this.f662a);
        C0354ch chVar = new C0354ch(this);
        if (this.f662a.getType() == AppLovinAdType.REGULAR) {
            if (this.f662a.getSize() == AppLovinAdSize.INTERSTITIAL) {
                this.f664c.f655b.loadInterstitialAd(this.f664c.f658e, this.f664c.f656c.getApplicationContext(), chVar);
            } else {
                this.f664c.f657d.mo4780e("MediationAdapterWrapper", "Failed to load " + this.f662a + ": " + this.f662a.getSize() + "> is not a supported ad size");
                this.f664c.m687a(AppLovinMediationErrorCode.INTERNAL_AD_SIZE_NOT_SUPPORTED.getErrorCode(), this.f663b);
            }
        } else if (this.f662a.getType() == AppLovinAdType.INCENTIVIZED) {
            this.f664c.f655b.loadIncentivizedAd(this.f664c.f658e, this.f664c.f656c.getApplicationContext(), chVar);
        } else {
            this.f664c.f657d.mo4780e("MediationAdapterWrapper", "Failed to load " + this.f662a + ": " + this.f662a.getType() + " is not a supported ad type");
            this.f664c.m687a(AppLovinMediationErrorCode.INTERNAL_AD_TYPE_NOT_SUPPORTED.getErrorCode(), this.f663b);
        }
        if (this.f663b.f676c.get()) {
            return;
        }
        if (this.f662a.mo4395g() == 0) {
            this.f664c.f657d.mo4779d("MediationAdapterWrapper", "Failing ad " + this.f662a + " since it has 0 timeout");
            this.f664c.m687a((int) AppLovinErrorCodes.MEDIATION_ADAPTER_IMMEDIATE_TIMEOUT, this.f663b);
        } else if (this.f662a.mo4395g() > 0) {
            this.f664c.f657d.mo4779d("MediationAdapterWrapper", "Setting timeout " + this.f662a.mo4395g() + " sec. for " + this.f662a);
            this.f664c.f656c.mo4169a().mo4682a((C0386dm) new C0359cm(this.f664c, this.f663b, (C0352cf) null), C0416ep.MAIN, TimeUnit.SECONDS.toMillis((long) this.f662a.mo4395g()));
        } else {
            this.f664c.f657d.mo4779d("MediationAdapterWrapper", "Negative timeout set for " + this.f662a + ", not scheduling a timeout");
        }
    }
}
