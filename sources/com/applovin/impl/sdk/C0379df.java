package com.applovin.impl.sdk;

import java.util.Map;

/* renamed from: com.applovin.impl.sdk.df */
final class C0379df {

    /* renamed from: a */
    private int f740a;

    /* renamed from: b */
    private String f741b;

    /* renamed from: c */
    private String f742c;

    /* renamed from: d */
    private Map<String, String> f743d;

    C0379df(String str, Map<String, String> map, int i, String str2) {
        this.f740a = i;
        this.f743d = map;
        this.f741b = str;
        this.f742c = str2;
    }

    /* renamed from: a */
    public int mo4498a() {
        return this.f740a;
    }

    /* renamed from: a */
    public void mo4499a(int i) {
        this.f740a = i;
    }

    /* renamed from: b */
    public String mo4500b() {
        return this.f741b;
    }

    /* renamed from: c */
    public String mo4501c() {
        return this.f742c;
    }

    /* renamed from: d */
    public Map<String, String> mo4502d() {
        return this.f743d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0379df dfVar = (C0379df) obj;
        if (this.f740a != dfVar.f740a) {
            return false;
        }
        if (this.f741b == null ? dfVar.f741b != null : !this.f741b.equals(dfVar.f741b)) {
            return false;
        }
        if (this.f742c == null ? dfVar.f742c != null : !this.f742c.equals(dfVar.f742c)) {
            return false;
        }
        if (this.f743d != null) {
            if (this.f743d.equals(dfVar.f743d)) {
                return true;
            }
        } else if (dfVar.f743d == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f742c != null ? this.f742c.hashCode() : 0) + (((this.f741b != null ? this.f741b.hashCode() : 0) + (this.f740a * 31)) * 31)) * 31;
        if (this.f743d != null) {
            i = this.f743d.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "PostbackRequest{attemptNumber=" + this.f740a + ", targetUrl='" + this.f741b + '\'' + ", backupUrl='" + this.f742c + '\'' + ", requestBody=" + this.f743d + '}';
    }
}
