package com.applovin.impl.adview;

import android.view.animation.AlphaAnimation;
import com.applovin.impl.sdk.C0391dr;

/* renamed from: com.applovin.impl.adview.ax */
class C0223ax implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0217ar f239a;

    C0223ax(C0217ar arVar) {
        this.f239a = arVar;
    }

    public void run() {
        try {
            if (this.f239a.f233h == null) {
                this.f239a.m217c();
            }
            this.f239a.f233h.setVisibility(0);
            this.f239a.f233h.bringToFront();
            C0391dr drVar = new C0391dr(this.f239a.f227b);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(drVar.mo4556O());
            alphaAnimation.setAnimationListener(new C0224ay(this));
            this.f239a.f233h.startAnimation(alphaAnimation);
        } catch (Throwable th) {
            this.f239a.f228c.mo4781e("ExpandedAdDialog", "Unable to fade in close button", th);
            this.f239a.m217c();
        }
    }
}
