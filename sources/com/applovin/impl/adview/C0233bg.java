package com.applovin.impl.adview;

import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.adview.bg */
class C0233bg implements C0214ao {

    /* renamed from: a */
    final /* synthetic */ long f284a;

    /* renamed from: b */
    final /* synthetic */ C0225az f285b;

    C0233bg(C0225az azVar, long j) {
        this.f285b = azVar;
        this.f284a = j;
    }

    /* renamed from: a */
    public void mo3999a() {
        if (this.f285b.f243C != null) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(this.f284a - ((long) this.f285b.videoView.getCurrentPosition()));
            if (seconds <= 0) {
                this.f285b.f243C.setVisibility(8);
                boolean unused = this.f285b.f265p = true;
            } else if (this.f285b.m299s()) {
                this.f285b.f243C.mo3970a((int) seconds);
            }
        }
    }

    /* renamed from: b */
    public boolean mo4000b() {
        return this.f285b.m299s();
    }
}
