package com.applovin.impl.adview;

import android.widget.ProgressBar;

/* renamed from: com.applovin.impl.adview.bh */
class C0234bh implements C0214ao {

    /* renamed from: a */
    final /* synthetic */ C0225az f286a;

    C0234bh(C0225az azVar) {
        this.f286a = azVar;
    }

    /* renamed from: a */
    public void mo3999a() {
        if (this.f286a.f248H == null) {
            return;
        }
        if (this.f286a.shouldContinueFullLengthVideoCountdown()) {
            ProgressBar x = this.f286a.f248H;
            x.setProgress((int) (((float) this.f286a.settingsProxy.mo4572ad()) * (((float) this.f286a.videoView.getCurrentPosition()) / ((float) this.f286a.videoView.getDuration()))));
            return;
        }
        this.f286a.f248H.setVisibility(8);
    }

    /* renamed from: b */
    public boolean mo4000b() {
        return this.f286a.shouldContinueFullLengthVideoCountdown();
    }
}
