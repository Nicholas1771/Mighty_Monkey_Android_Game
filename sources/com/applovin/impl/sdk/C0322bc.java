package com.applovin.impl.sdk;

/* renamed from: com.applovin.impl.sdk.bc */
class C0322bc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0321bb f576a;

    C0322bc(C0321bb bbVar) {
        this.f576a = bbVar;
    }

    public void run() {
        if (this.f576a.f575c != null) {
            this.f576a.f575c.dismiss();
        }
    }
}
