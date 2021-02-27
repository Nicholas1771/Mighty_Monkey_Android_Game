package com.applovin.impl.sdk;

import java.util.Map;

/* renamed from: com.applovin.impl.sdk.cf */
class C0352cf implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Map f660a;

    /* renamed from: b */
    final /* synthetic */ C0351ce f661b;

    C0352cf(C0351ce ceVar, Map map) {
        this.f661b = ceVar;
        this.f660a = map;
    }

    public void run() {
        try {
            this.f661b.f658e.mo4397a(this.f660a);
            this.f661b.f655b.initialize(this.f661b.f658e, this.f661b.f656c, this.f661b.f656c.getInitializationActivity());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
