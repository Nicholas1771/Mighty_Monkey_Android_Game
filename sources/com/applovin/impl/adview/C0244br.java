package com.applovin.impl.adview;

/* renamed from: com.applovin.impl.adview.br */
class C0244br implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f300a;

    /* renamed from: b */
    final /* synthetic */ int f301b;

    /* renamed from: c */
    final /* synthetic */ C0243bq f302c;

    C0244br(C0243bq bqVar, int i, int i2) {
        this.f302c = bqVar;
        this.f300a = i;
        this.f301b = i2;
    }

    public void run() {
        this.f302c.f299a.f298a.logger.mo4780e("InterActivity", "Media player error (" + this.f300a + "," + this.f301b + ").");
        this.f302c.f299a.f298a.handleMediaError();
    }
}
