package com.applovin.impl.sdk;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.applovin.impl.sdk.dz */
class C0399dz implements C0465v<String> {

    /* renamed from: a */
    final /* synthetic */ AtomicReference f1014a;

    /* renamed from: b */
    final /* synthetic */ String f1015b;

    /* renamed from: c */
    final /* synthetic */ C0398dy f1016c;

    C0399dz(C0398dy dyVar, AtomicReference atomicReference, String str) {
        this.f1016c = dyVar;
        this.f1014a = atomicReference;
        this.f1015b = str;
    }

    /* renamed from: a */
    public void mo4524a(int i) {
        this.f1016c.f764e.mo4780e(this.f1016c.f762c, "Failed to load resource from '" + this.f1015b + "'");
    }

    /* renamed from: a */
    public void mo4525a(String str, int i) {
        this.f1014a.set(str);
    }
}
