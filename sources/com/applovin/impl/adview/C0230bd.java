package com.applovin.impl.adview;

import android.view.animation.AlphaAnimation;

/* renamed from: com.applovin.impl.adview.bd */
class C0230bd implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0225az f280a;

    C0230bd(C0225az azVar) {
        this.f280a = azVar;
    }

    public void run() {
        try {
            if (this.f280a.f260k) {
                this.f280a.f274y.setVisibility(0);
                return;
            }
            boolean unused = this.f280a.f260k = true;
            if (this.f280a.m290o() && this.f280a.f275z != null) {
                this.f280a.f275z.setVisibility(0);
                this.f280a.f275z.bringToFront();
            }
            this.f280a.f274y.setVisibility(0);
            this.f280a.f274y.bringToFront();
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration((long) this.f280a.settingsProxy.mo4585d());
            alphaAnimation.setRepeatCount(0);
            this.f280a.f274y.startAnimation(alphaAnimation);
        } catch (Throwable th) {
            this.f280a.dismiss();
        }
    }
}
