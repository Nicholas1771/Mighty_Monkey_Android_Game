package com.applovin.impl.sdk;

/* renamed from: com.applovin.impl.sdk.ar */
class C0310ar implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f540a;

    /* renamed from: b */
    final /* synthetic */ C0308ap f541b;

    C0310ar(C0308ap apVar, int i) {
        this.f541b = apVar;
        this.f540a = i;
    }

    public void run() {
        this.f541b.f537b.failedToReceiveAd(this.f540a);
    }
}
