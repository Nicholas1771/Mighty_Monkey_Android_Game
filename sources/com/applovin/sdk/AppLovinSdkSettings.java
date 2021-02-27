package com.applovin.sdk;

public class AppLovinSdkSettings {

    /* renamed from: a */
    private boolean f1213a = false;

    /* renamed from: b */
    private boolean f1214b = false;

    /* renamed from: c */
    private long f1215c = -1;

    /* renamed from: d */
    private String f1216d = (AppLovinAdSize.INTERSTITIAL.getLabel() + "," + AppLovinAdSize.BANNER.getLabel() + "," + AppLovinAdSize.MREC.getLabel());

    /* renamed from: e */
    private String f1217e = (AppLovinAdType.INCENTIVIZED.getLabel() + "," + AppLovinAdType.REGULAR.getLabel() + "," + AppLovinAdType.NATIVE.getLabel());

    /* renamed from: f */
    private boolean f1218f = false;

    public String getAutoPreloadSizes() {
        return this.f1216d;
    }

    public String getAutoPreloadTypes() {
        return this.f1217e;
    }

    public long getBannerAdRefreshSeconds() {
        return this.f1215c;
    }

    public boolean isMuted() {
        return this.f1218f;
    }

    public boolean isTestAdsEnabled() {
        return this.f1213a;
    }

    public boolean isVerboseLoggingEnabled() {
        return this.f1214b;
    }

    public void setAutoPreloadSizes(String str) {
        this.f1216d = str;
    }

    public void setAutoPreloadTypes(String str) {
        this.f1217e = str;
    }

    public void setBannerAdRefreshSeconds(long j) {
        this.f1215c = j;
    }

    public void setMuted(boolean z) {
        this.f1218f = z;
    }

    public void setTestAdsEnabled(boolean z) {
        this.f1213a = z;
    }

    public void setVerboseLogging(boolean z) {
        this.f1214b = z;
    }
}
