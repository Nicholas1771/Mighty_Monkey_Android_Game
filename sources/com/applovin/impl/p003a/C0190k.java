package com.applovin.impl.p003a;

import com.applovin.impl.sdk.C0444fq;
import com.applovin.impl.sdk.C0446fs;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.a.k */
public class C0190k {

    /* renamed from: a */
    private String f94a;

    /* renamed from: b */
    private String f95b;

    private C0190k() {
    }

    /* renamed from: a */
    public static C0190k m90a(C0446fs fsVar, C0190k kVar, AppLovinSdk appLovinSdk) {
        if (fsVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified.");
        } else {
            C0190k kVar2 = kVar != null ? kVar : new C0190k();
            try {
                if (!C0444fq.isValidString(kVar2.f94a)) {
                    String c = fsVar.mo4740c();
                    if (C0444fq.isValidString(c)) {
                        kVar2.f94a = c;
                    }
                }
                if (!C0444fq.isValidString(kVar2.f95b)) {
                    String str = fsVar.mo4738b().get("version");
                    if (C0444fq.isValidString(str)) {
                        kVar2.f95b = str;
                    }
                }
                return kVar2;
            } catch (Throwable th) {
                appLovinSdk.getLogger().mo4781e("VastSystemInfo", "Error occurred while initializing", th);
                return null;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0190k)) {
            return false;
        }
        C0190k kVar = (C0190k) obj;
        if (this.f94a == null ? kVar.f94a != null : !this.f94a.equals(kVar.f94a)) {
            return false;
        }
        return this.f95b != null ? this.f95b.equals(kVar.f95b) : kVar.f95b == null;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f94a != null ? this.f94a.hashCode() : 0) * 31;
        if (this.f95b != null) {
            i = this.f95b.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "VastSystemInfo{name='" + this.f94a + '\'' + ", version='" + this.f95b + '\'' + '}';
    }
}
