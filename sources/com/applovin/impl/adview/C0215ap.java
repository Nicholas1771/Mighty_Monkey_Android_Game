package com.applovin.impl.adview;

/* renamed from: com.applovin.impl.adview.ap */
class C0215ap {

    /* renamed from: a */
    private final String f223a;

    /* renamed from: b */
    private final C0214ao f224b;

    /* renamed from: c */
    private final long f225c;

    private C0215ap(String str, long j, C0214ao aoVar) {
        this.f223a = str;
        this.f225c = j;
        this.f224b = aoVar;
    }

    /* synthetic */ C0215ap(String str, long j, C0214ao aoVar, C0213an anVar) {
        this(str, j, aoVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m206a() {
        return this.f223a;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public long m208b() {
        return this.f225c;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public C0214ao m211c() {
        return this.f224b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0215ap)) {
            return false;
        }
        C0215ap apVar = (C0215ap) obj;
        return this.f223a != null ? this.f223a.equalsIgnoreCase(apVar.f223a) : apVar.f223a == null;
    }

    public int hashCode() {
        if (this.f223a != null) {
            return this.f223a.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "CountdownProxy{identifier='" + this.f223a + '\'' + ", countdownStepMillis=" + this.f225c + '}';
    }
}
