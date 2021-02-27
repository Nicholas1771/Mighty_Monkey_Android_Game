package com.applovin.sdk;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class AppLovinAdType {
    public static final AppLovinAdType INCENTIVIZED = new AppLovinAdType("VIDEOA");
    public static final AppLovinAdType NATIVE = new AppLovinAdType("NATIVE");
    public static final AppLovinAdType REGULAR = new AppLovinAdType("REGULAR");

    /* renamed from: a */
    private final String f1210a;

    public AppLovinAdType(String str) {
        this.f1210a = str;
    }

    public static Set<AppLovinAdType> allTypes() {
        HashSet hashSet = new HashSet(2);
        hashSet.add(REGULAR);
        hashSet.add(INCENTIVIZED);
        return hashSet;
    }

    public static AppLovinAdType fromString(String str) {
        return str.toUpperCase(Locale.ENGLISH).equals(INCENTIVIZED.getLabel()) ? INCENTIVIZED : REGULAR;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppLovinAdType appLovinAdType = (AppLovinAdType) obj;
        if (this.f1210a != null) {
            if (this.f1210a.equals(appLovinAdType.f1210a)) {
                return true;
            }
        } else if (appLovinAdType.f1210a == null) {
            return true;
        }
        return false;
    }

    public String getLabel() {
        return this.f1210a.toUpperCase(Locale.ENGLISH);
    }

    public int hashCode() {
        if (this.f1210a != null) {
            return this.f1210a.hashCode();
        }
        return 0;
    }

    public String toString() {
        return getLabel();
    }
}
