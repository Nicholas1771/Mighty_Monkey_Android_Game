package com.applovin.mediation;

import java.util.Map;

public class AppLovinMediatedAdInfo {

    /* renamed from: a */
    private final Map<String, Object> f1195a;

    public AppLovinMediatedAdInfo(Map<String, Object> map) {
        this.f1195a = map;
    }

    public boolean containsKey(String str) {
        if (this.f1195a != null) {
            return this.f1195a.containsKey(str);
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppLovinMediatedAdInfo)) {
            return false;
        }
        AppLovinMediatedAdInfo appLovinMediatedAdInfo = (AppLovinMediatedAdInfo) obj;
        return this.f1195a != null ? this.f1195a.equals(appLovinMediatedAdInfo.f1195a) : appLovinMediatedAdInfo.f1195a == null;
    }

    public Object get(String str) {
        if (this.f1195a != null) {
            return this.f1195a.get(str);
        }
        return null;
    }

    public int hashCode() {
        if (this.f1195a != null) {
            return this.f1195a.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "AppLovinMediatedAdInfo{adInfo=" + this.f1195a + "}";
    }
}
