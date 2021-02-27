package com.applovin.impl.sdk;

import com.applovin.mediation.AppLovinMediatedAdInfo;
import com.applovin.mediation.AppLovinMediationDisplayListener;
import com.applovin.mediation.AppLovinMediationErrorCode;
import com.applovin.sdk.AppLovinAd;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.ck */
class C0357ck implements AppLovinMediationDisplayListener {

    /* renamed from: a */
    final /* synthetic */ C0356cj f673a;

    C0357ck(C0356cj cjVar) {
        this.f673a = cjVar;
    }

    public void adClicked(AppLovinMediatedAdInfo appLovinMediatedAdInfo) {
        this.f673a.f668a.mo4359c(this.f673a.f669b);
    }

    public void adDisplayed(AppLovinMediatedAdInfo appLovinMediatedAdInfo) {
        this.f673a.f668a.mo4350a((AppLovinAd) this.f673a.f669b);
    }

    public void adHidden(AppLovinMediatedAdInfo appLovinMediatedAdInfo) {
        this.f673a.f668a.mo4355b((AppLovinAd) this.f673a.f669b);
    }

    public void failedToDisplayAd(AppLovinMediatedAdInfo appLovinMediatedAdInfo, AppLovinMediationErrorCode appLovinMediationErrorCode) {
        this.f673a.f668a.mo4355b((AppLovinAd) this.f673a.f669b);
    }

    public void rewardRejected(AppLovinMediatedAdInfo appLovinMediatedAdInfo, Map<String, String> map) {
        this.f673a.f668a.mo4358b(map, this.f673a.f669b);
    }

    public void rewardVerified(AppLovinMediatedAdInfo appLovinMediatedAdInfo, Map<String, String> map) {
        this.f673a.f668a.mo4354a(map, this.f673a.f669b);
    }
}
