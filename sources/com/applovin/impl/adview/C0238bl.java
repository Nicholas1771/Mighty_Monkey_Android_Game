package com.applovin.impl.adview;

import android.view.View;
import android.view.animation.Animation;

/* renamed from: com.applovin.impl.adview.bl */
class C0238bl implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ View f292a;

    /* renamed from: b */
    final /* synthetic */ boolean f293b;

    /* renamed from: c */
    final /* synthetic */ C0225az f294c;

    C0238bl(C0225az azVar, View view, boolean z) {
        this.f294c = azVar;
        this.f292a = view;
        this.f293b = z;
    }

    public void onAnimationEnd(Animation animation) {
        if (!this.f293b) {
            this.f292a.setVisibility(4);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        this.f292a.setVisibility(0);
    }
}
