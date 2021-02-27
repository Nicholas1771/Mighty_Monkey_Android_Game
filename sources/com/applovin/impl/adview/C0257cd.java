package com.applovin.impl.adview;

/* renamed from: com.applovin.impl.adview.cd */
class C0257cd implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f335a;

    /* renamed from: b */
    final /* synthetic */ C0252bz f336b;

    C0257cd(C0252bz bzVar, int i) {
        this.f336b = bzVar;
        this.f335a = i;
    }

    public void run() {
        if (this.f336b.f320h != null) {
            this.f336b.f320h.failedToReceiveAd(this.f335a);
        }
    }
}
