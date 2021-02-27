package com.applovin.impl.adview;

/* renamed from: com.applovin.impl.adview.bk */
class C0237bk implements C0267cn {

    /* renamed from: a */
    final /* synthetic */ C0225az f291a;

    C0237bk(C0225az azVar) {
        this.f291a = azVar;
    }

    /* renamed from: a */
    public void mo4045a(C0265cl clVar) {
        this.f291a.logger.mo4779d("InterActivity", "Clicking through from video button...");
        this.f291a.clickThroughFromVideo();
    }

    /* renamed from: b */
    public void mo4046b(C0265cl clVar) {
        this.f291a.logger.mo4779d("InterActivity", "Closing ad from video button...");
        this.f291a.dismiss();
    }

    /* renamed from: c */
    public void mo4047c(C0265cl clVar) {
        this.f291a.logger.mo4779d("InterActivity", "Skipping video from video button...");
        this.f291a.skipVideo();
    }
}
