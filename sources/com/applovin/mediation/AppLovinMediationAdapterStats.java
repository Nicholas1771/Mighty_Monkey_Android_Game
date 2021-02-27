package com.applovin.mediation;

public class AppLovinMediationAdapterStats {

    /* renamed from: a */
    private final String f1202a;

    /* renamed from: b */
    private final long f1203b;

    public AppLovinMediationAdapterStats(String str, long j) {
        if (str == null) {
            throw new IllegalArgumentException("No adapter name specified");
        }
        this.f1202a = str;
        this.f1203b = j;
    }

    public String getAdapterName() {
        return this.f1202a;
    }

    public long getLastAdLoadMillis() {
        return this.f1203b;
    }

    public String toString() {
        return "[Adapter Stats - <" + this.f1202a + " : loaded in " + this.f1203b + "milliseconds>]";
    }
}
