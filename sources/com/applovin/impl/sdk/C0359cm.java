package com.applovin.impl.sdk;

import com.applovin.mediation.AppLovinMediationAdapter;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinErrorCodes;

/* renamed from: com.applovin.impl.sdk.cm */
class C0359cm extends C0386dm {

    /* renamed from: a */
    final /* synthetic */ C0351ce f677a;

    /* renamed from: b */
    private final C0358cl f678b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private C0359cm(C0351ce ceVar, C0358cl clVar) {
        super("TaskTimeoutMediatedAd", ceVar.f656c);
        this.f677a = ceVar;
        if (clVar == null) {
            throw new IllegalArgumentException("No loadState specified");
        }
        this.f678b = clVar;
    }

    /* synthetic */ C0359cm(C0351ce ceVar, C0358cl clVar, C0352cf cfVar) {
        this(ceVar, clVar);
    }

    public void run() {
        this.f764e.mo4785w(this.f762c, "Timing out " + this.f678b.f674a + "...");
        AppLovinMediationAdapter d = this.f677a.mo4423d();
        if (this.f678b.f674a.getType().equals(AppLovinAdType.INCENTIVIZED)) {
            d.processIncentivizedAdLoadTimeout();
        } else {
            d.processInterstitialAdLoadTimeout();
        }
        this.f677a.m687a((int) AppLovinErrorCodes.MEDIATION_ADAPTER_TIMEOUT, this.f678b);
    }
}
