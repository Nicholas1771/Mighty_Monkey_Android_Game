package com.applovin.impl.sdk;

import java.util.Map;

/* renamed from: com.applovin.impl.sdk.dj */
public class C0383dj {

    /* renamed from: a */
    private final String f756a;

    /* renamed from: b */
    private final Map<String, String> f757b;

    /* renamed from: c */
    private final long f758c;

    /* renamed from: d */
    private final String f759d;

    public C0383dj(String str, Map<String, String> map, long j, String str2) {
        this.f756a = str;
        this.f757b = map;
        this.f758c = j;
        this.f759d = str2;
    }

    /* renamed from: a */
    public String mo4517a() {
        return this.f756a;
    }

    /* renamed from: b */
    public Map<String, String> mo4518b() {
        return this.f757b;
    }

    /* renamed from: c */
    public long mo4519c() {
        return this.f758c;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0383dj djVar = (C0383dj) obj;
        if (this.f758c != djVar.f758c) {
            return false;
        }
        if (this.f756a != null) {
            if (!this.f756a.equals(djVar.f756a)) {
                return false;
            }
        } else if (djVar.f756a != null) {
            return false;
        }
        if (this.f757b != null) {
            if (!this.f757b.equals(djVar.f757b)) {
                return false;
            }
        } else if (djVar.f757b != null) {
            return false;
        }
        if (this.f759d == null ? djVar.f759d != null : !this.f759d.equals(djVar.f759d)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((this.f757b != null ? this.f757b.hashCode() : 0) + ((this.f756a != null ? this.f756a.hashCode() : 0) * 31)) * 31) + ((int) (this.f758c ^ (this.f758c >>> 32)))) * 31;
        if (this.f759d != null) {
            i = this.f759d.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SdkEvent{eventType='" + this.f756a + '\'' + ", parameters=" + this.f757b + ", creationTsMillis=" + this.f758c + ", uniqueIdentifier='" + this.f759d + '\'' + '}';
    }
}
