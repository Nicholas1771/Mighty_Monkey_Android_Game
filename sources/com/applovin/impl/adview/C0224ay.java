package com.applovin.impl.adview;

import android.view.animation.Animation;

/* renamed from: com.applovin.impl.adview.ay */
class C0224ay implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ C0223ax f240a;

    C0224ay(C0223ax axVar) {
        this.f240a = axVar;
    }

    public void onAnimationEnd(Animation animation) {
        this.f240a.f239a.f233h.setClickable(true);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
