package com.applovin.impl.adview;

/* renamed from: com.applovin.impl.adview.bf */
class C0232bf implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0210ak f282a;

    /* renamed from: b */
    final /* synthetic */ C0225az f283b;

    C0232bf(C0225az azVar, C0210ak akVar) {
        this.f283b = azVar;
        this.f282a = akVar;
    }

    public void run() {
        if (this.f282a.equals(this.f283b.f274y)) {
            this.f283b.m289n();
        } else if (this.f282a.equals(this.f283b.f241A)) {
            this.f283b.m292p();
        }
    }
}
