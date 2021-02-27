package com.applovin.impl.p003a;

import com.applovin.impl.sdk.C0444fq;
import com.applovin.impl.sdk.C0446fs;
import com.applovin.impl.sdk.C0462s;
import com.applovin.sdk.AppLovinSdk;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.a.l */
public class C0191l {

    /* renamed from: a */
    private String f96a;

    /* renamed from: b */
    private String f97b;

    /* renamed from: c */
    private String f98c;

    /* renamed from: d */
    private long f99d = -1;

    /* renamed from: e */
    private int f100e = -1;

    private C0191l() {
    }

    /* renamed from: a */
    private static int m91a(String str, C0186g gVar) {
        if ("start".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("firstQuartile".equalsIgnoreCase(str)) {
            return 25;
        }
        if ("midpoint".equalsIgnoreCase(str)) {
            return 50;
        }
        if ("thirdQuartile".equalsIgnoreCase(str)) {
            return 75;
        }
        if (!"complete".equalsIgnoreCase(str)) {
            return -1;
        }
        if (gVar != null) {
            return gVar.mo3900g();
        }
        return 95;
    }

    /* renamed from: a */
    public static C0191l m92a(C0446fs fsVar, C0186g gVar, AppLovinSdk appLovinSdk) {
        long j;
        if (fsVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified.");
        } else {
            try {
                String c = fsVar.mo4740c();
                if (C0444fq.isValidString(c)) {
                    C0191l lVar = new C0191l();
                    lVar.f98c = c;
                    lVar.f96a = fsVar.mo4738b().get("id");
                    lVar.f97b = fsVar.mo4738b().get("event");
                    lVar.f100e = m91a(lVar.mo3913a(), gVar);
                    String str = fsVar.mo4738b().get("offset");
                    if (C0444fq.isValidString(str)) {
                        String trim = str.trim();
                        if (trim.contains("%")) {
                            lVar.f100e = C0444fq.m1174e(trim.substring(0, trim.length() - 1));
                        } else if (trim.contains(":")) {
                            List<String> a = C0462s.m1247a(trim, ":");
                            int size = a.size();
                            if (size > 0) {
                                long j2 = 0;
                                int i = size - 1;
                                while (i >= 0) {
                                    String str2 = a.get(i);
                                    if (C0444fq.m1173d(str2)) {
                                        int parseInt = Integer.parseInt(str2);
                                        if (i == size - 1) {
                                            j = ((long) parseInt) + j2;
                                        } else if (i == size - 2) {
                                            j = TimeUnit.MINUTES.toSeconds((long) parseInt) + j2;
                                        } else if (i == size - 3) {
                                            j = TimeUnit.HOURS.toSeconds((long) parseInt) + j2;
                                        }
                                        i--;
                                        j2 = j;
                                    }
                                    j = j2;
                                    i--;
                                    j2 = j;
                                }
                                lVar.f99d = j2;
                                lVar.f100e = -1;
                            }
                        } else {
                            appLovinSdk.getLogger().mo4780e("VastTracker", "Unable to parse time offset from rawOffsetString = " + trim);
                        }
                    }
                    return lVar;
                }
                appLovinSdk.getLogger().mo4780e("VastTracker", "Unable to create tracker. Could not find URL.");
                return null;
            } catch (Throwable th) {
                appLovinSdk.getLogger().mo4781e("VastTracker", "Error occurred while initializing", th);
            }
        }
    }

    /* renamed from: a */
    public String mo3913a() {
        return this.f97b;
    }

    /* renamed from: a */
    public boolean mo3914a(long j, int i) {
        boolean z = this.f99d >= 0;
        boolean z2 = j >= this.f99d;
        boolean z3 = this.f100e >= 0;
        boolean z4 = i >= this.f100e;
        if (!z || !z2) {
            return z3 && z4;
        }
        return true;
    }

    /* renamed from: b */
    public String mo3915b() {
        return this.f98c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0191l)) {
            return false;
        }
        C0191l lVar = (C0191l) obj;
        if (this.f99d != lVar.f99d || this.f100e != lVar.f100e) {
            return false;
        }
        if (this.f96a != null) {
            if (!this.f96a.equals(lVar.f96a)) {
                return false;
            }
        } else if (lVar.f96a != null) {
            return false;
        }
        if (this.f97b != null) {
            if (!this.f97b.equals(lVar.f97b)) {
                return false;
            }
        } else if (lVar.f97b != null) {
            return false;
        }
        return this.f98c.equals(lVar.f98c);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f96a != null ? this.f96a.hashCode() : 0) * 31;
        if (this.f97b != null) {
            i = this.f97b.hashCode();
        }
        return ((((((hashCode + i) * 31) + this.f98c.hashCode()) * 31) + ((int) (this.f99d ^ (this.f99d >>> 32)))) * 31) + this.f100e;
    }

    public String toString() {
        return "VastTracker{identifier='" + this.f96a + '\'' + ", event='" + this.f97b + '\'' + ", uriString='" + this.f98c + '\'' + ", offsetSeconds=" + this.f99d + ", offsetPercent=" + this.f100e + '}';
    }
}
