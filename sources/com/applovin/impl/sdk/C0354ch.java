package com.applovin.impl.sdk;

import com.applovin.mediation.AppLovinMediatedAdInfo;
import com.applovin.mediation.AppLovinMediationErrorCode;
import com.applovin.mediation.AppLovinMediationLoadListener;

/* renamed from: com.applovin.impl.sdk.ch */
class C0354ch implements AppLovinMediationLoadListener {

    /* renamed from: a */
    final /* synthetic */ C0353cg f665a;

    C0354ch(C0353cg cgVar) {
        this.f665a = cgVar;
    }

    public void adLoaded(AppLovinMediatedAdInfo appLovinMediatedAdInfo) {
        this.f665a.f664c.f657d.mo4779d("MediationAdapterWrapper", "Successfully loaded " + this.f665a.f662a);
        this.f665a.f664c.m691a(appLovinMediatedAdInfo, this.f665a.f663b);
    }

    public void failedToLoadAd(AppLovinMediationErrorCode appLovinMediationErrorCode) {
        if (appLovinMediationErrorCode == null) {
            appLovinMediationErrorCode = AppLovinMediationErrorCode.NETWORK_UNSPECIFIED;
        }
        this.f665a.f664c.f657d.mo4780e("MediationAdapterWrapper", "Failed to load " + this.f665a.f662a + ": " + appLovinMediationErrorCode);
        this.f665a.f664c.m687a(appLovinMediationErrorCode.getErrorCode(), this.f665a.f663b);
    }
}
