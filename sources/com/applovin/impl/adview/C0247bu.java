package com.applovin.impl.adview;

/* renamed from: com.applovin.impl.adview.bu */
class C0247bu implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f305a;

    /* renamed from: b */
    final /* synthetic */ int f306b;

    /* renamed from: c */
    final /* synthetic */ C0246bt f307c;

    C0247bu(C0246bt btVar, int i, int i2) {
        this.f307c = btVar;
        this.f305a = i;
        this.f306b = i2;
    }

    public void run() {
        this.f307c.f304a.logger.mo4780e("InterActivity", "Video view error (" + this.f305a + "," + this.f306b + ").");
        this.f307c.f304a.handleMediaError();
    }
}
