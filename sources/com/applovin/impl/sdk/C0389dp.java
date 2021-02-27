package com.applovin.impl.sdk;

/* renamed from: com.applovin.impl.sdk.dp */
public class C0389dp<T> implements Comparable {

    /* renamed from: a */
    private static int f982a = 0;

    /* renamed from: b */
    private final int f983b;

    /* renamed from: c */
    private final String f984c;

    /* renamed from: d */
    private final T f985d;

    private C0389dp(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified");
        } else if (t == null) {
            throw new IllegalArgumentException("No default value specified");
        } else {
            this.f984c = str;
            this.f985d = t;
            this.f983b = f982a;
            f982a++;
        }
    }

    /* renamed from: a */
    public int mo4529a() {
        return this.f983b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public T mo4530a(Object obj) {
        return this.f985d.getClass().cast(obj);
    }

    /* renamed from: b */
    public String mo4531b() {
        return this.f984c;
    }

    /* renamed from: c */
    public T mo4532c() {
        return this.f985d;
    }

    public int compareTo(Object obj) {
        if (obj == null || !(obj instanceof C0389dp)) {
            return 0;
        }
        return this.f984c.compareTo(((C0389dp) obj).mo4531b());
    }
}
