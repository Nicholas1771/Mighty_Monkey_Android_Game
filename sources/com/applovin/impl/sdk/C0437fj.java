package com.applovin.impl.sdk;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.fj */
public class C0437fj {

    /* renamed from: a */
    private static final C0437fj f1107a = new C0437fj();

    /* renamed from: b */
    private final Object f1108b = new Object();

    /* renamed from: c */
    private final Map<String, C0439fl> f1109c = new HashMap(2);

    private C0437fj() {
    }

    /* renamed from: a */
    static C0437fj m1130a() {
        return f1107a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0439fl mo4713a(String str) {
        C0439fl remove;
        synchronized (this.f1108b) {
            remove = this.f1109c.remove(str);
        }
        return remove;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4714a(String str, long j, String str2) {
        C0439fl flVar = new C0439fl(this, str2, j);
        synchronized (this.f1108b) {
            this.f1109c.put(str, flVar);
        }
    }
}
