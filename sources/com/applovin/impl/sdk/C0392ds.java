package com.applovin.impl.sdk;

import java.util.HashSet;

/* renamed from: com.applovin.impl.sdk.ds */
public class C0392ds<T> {

    /* renamed from: a */
    static final C0392ds<String> f992a = new C0392ds<>("com.applovin.sdk.impl.isFirstRun", String.class);

    /* renamed from: b */
    static final C0392ds<HashSet> f993b = new C0392ds<>("com.applovin.sdk.impl.postbackQueue.key", HashSet.class);

    /* renamed from: c */
    static final C0392ds<Integer> f994c = new C0392ds<>("com.applovin.sdk.last_version_code", Integer.class);

    /* renamed from: d */
    static final C0392ds<String> f995d = new C0392ds<>("com.applovin.sdk.device_data", String.class);

    /* renamed from: e */
    static final C0392ds<String> f996e = new C0392ds<>("com.applovin.sdk.zones", String.class);

    /* renamed from: f */
    static final C0392ds<String> f997f = new C0392ds<>("com.applovin.sdk.stats", String.class);

    /* renamed from: g */
    static final C0392ds<String> f998g = new C0392ds<>("com.applovin.sdk.loaded_mediation_adapters", String.class);

    /* renamed from: h */
    public static final C0392ds<Integer> f999h = new C0392ds<>("com.applovin.sdk.last_video_position", Integer.class);

    /* renamed from: i */
    public static final C0392ds<Boolean> f1000i = new C0392ds<>("com.applovin.sdk.should_resume_video", Boolean.class);

    /* renamed from: j */
    private final String f1001j;

    /* renamed from: k */
    private final Class<T> f1002k;

    C0392ds(String str, Class<T> cls) {
        this.f1001j = str;
        this.f1002k = cls;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo4608a() {
        return this.f1001j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Class<T> mo4609b() {
        return this.f1002k;
    }

    public String toString() {
        return "Key{name='" + this.f1001j + '\'' + "type='" + this.f1002k + '\'' + '}';
    }
}
