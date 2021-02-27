package com.applovin.impl.adview;

import android.view.animation.AlphaAnimation;

/* renamed from: com.applovin.impl.adview.be */
class C0231be implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0225az f281a;

    C0231be(C0225az azVar) {
        this.f281a = azVar;
    }

    public void run() {
        try {
            if (!this.f281a.f261l && this.f281a.f241A != null) {
                boolean unused = this.f281a.f261l = true;
                this.f281a.f241A.setVisibility(0);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration((long) this.f281a.settingsProxy.mo4585d());
                alphaAnimation.setRepeatCount(0);
                this.f281a.f241A.startAnimation(alphaAnimation);
                if (this.f281a.m290o() && this.f281a.f242B != null) {
                    this.f281a.f242B.setVisibility(0);
                    this.f281a.f242B.bringToFront();
                }
            }
        } catch (Throwable th) {
            this.f281a.logger.mo4785w("InterActivity", "Unable to show skip button: " + th);
        }
    }
}
