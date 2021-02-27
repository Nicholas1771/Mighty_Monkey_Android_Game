package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.sdk.dv */
public class C0395dv {

    /* renamed from: a */
    private final C0394du f1008a;

    public C0395dv(AppLovinSdkImpl appLovinSdkImpl) {
        this.f1008a = appLovinSdkImpl.mo4171b();
    }

    public C0395dv(AppLovinSdk appLovinSdk) {
        this.f1008a = ((AppLovinSdkImpl) appLovinSdk).mo4171b();
    }

    /* renamed from: a */
    public void mo4628a() {
        this.f1008a.mo4620a("ad_imp");
        this.f1008a.mo4620a("ad_imp_session");
    }

    /* renamed from: a */
    public void mo4629a(long j) {
        this.f1008a.mo4624b("ad_dismiss_duration", j);
    }

    /* renamed from: a */
    public void mo4630a(AppLovinAd appLovinAd) {
        this.f1008a.mo4624b("last_displayed_ad_id_number", appLovinAd.getAdIdNumber());
    }

    /* renamed from: b */
    public long mo4631b() {
        return this.f1008a.mo4622b("ad_time_to_click_through");
    }

    /* renamed from: b */
    public void mo4632b(long j) {
        this.f1008a.mo4624b("ad_time_to_click_through", j);
    }

    /* renamed from: c */
    public long mo4633c() {
        return this.f1008a.mo4622b("first_ad_shown_duration");
    }

    /* renamed from: c */
    public void mo4634c(long j) {
        this.f1008a.mo4624b("ad_paused_duration", j);
    }

    /* renamed from: d */
    public void mo4635d(long j) {
        this.f1008a.mo4624b("first_ad_shown_duration", j);
    }
}
