package com.applovin.impl.adview;

/* renamed from: com.applovin.impl.adview.an */
class C0213an implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0215ap f220a;

    /* renamed from: b */
    final /* synthetic */ int f221b;

    /* renamed from: c */
    final /* synthetic */ C0212am f222c;

    C0213an(C0212am amVar, C0215ap apVar, int i) {
        this.f222c = amVar;
        this.f220a = apVar;
        this.f221b = i;
    }

    public void run() {
        C0214ao b = this.f220a.m211c();
        if (!b.mo4000b()) {
            this.f222c.f216a.mo4779d("CountdownManager", "Ending countdown for " + this.f220a.m206a());
        } else if (this.f222c.f219d.get() == this.f221b) {
            try {
                b.mo3999a();
            } catch (Throwable th) {
                this.f222c.f216a.mo4781e("CountdownManager", "Encountered error on countdown step for: " + this.f220a.m206a(), th);
            }
            this.f222c.m198a(this.f220a, this.f221b);
        } else {
            this.f222c.f216a.mo4785w("CountdownManager", "Killing duplicate countdown from previous generation: " + this.f220a.m206a());
        }
    }
}
