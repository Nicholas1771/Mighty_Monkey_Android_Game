package com.applovin.mediation;

public class AppLovinMediationAdapterInfo {

    /* renamed from: a */
    private final String f1196a;

    /* renamed from: b */
    private final String f1197b;

    /* renamed from: c */
    private final String f1198c;

    /* renamed from: d */
    private final AppLovinMediationAdapterStatus f1199d;

    /* renamed from: e */
    private final AppLovinMediationAdapter f1200e;

    /* renamed from: f */
    private final AppLovinMediationAdapterConfig f1201f;

    public AppLovinMediationAdapterInfo(String str, String str2, String str3, AppLovinMediationAdapterStatus appLovinMediationAdapterStatus) {
        this(str, str2, str3, appLovinMediationAdapterStatus, (AppLovinMediationAdapter) null, (AppLovinMediationAdapterConfig) null);
    }

    public AppLovinMediationAdapterInfo(String str, String str2, String str3, AppLovinMediationAdapterStatus appLovinMediationAdapterStatus, AppLovinMediationAdapter appLovinMediationAdapter, AppLovinMediationAdapterConfig appLovinMediationAdapterConfig) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified");
        } else if (str2 == null) {
            throw new IllegalArgumentException("No class name specified");
        } else if (appLovinMediationAdapterStatus == null) {
            throw new IllegalArgumentException("No status specified");
        } else {
            this.f1196a = str;
            this.f1197b = str2;
            this.f1198c = str3;
            this.f1199d = appLovinMediationAdapterStatus;
            this.f1200e = appLovinMediationAdapter;
            this.f1201f = appLovinMediationAdapterConfig;
        }
    }

    public AppLovinMediationAdapter getAdapter() {
        return this.f1200e;
    }

    public AppLovinMediationAdapterConfig getAdapterConfiguration() {
        return this.f1201f;
    }

    public String getClassName() {
        return this.f1197b;
    }

    public String getName() {
        return this.f1196a;
    }

    public AppLovinMediationAdapterStatus getStatus() {
        return this.f1199d;
    }

    public String getVersion() {
        return this.f1198c;
    }

    public String toString() {
        return "[Adapter Info - <" + this.f1196a + " : " + this.f1197b + "> v" + this.f1198c + " with configuration: " + this.f1201f + "]";
    }
}
