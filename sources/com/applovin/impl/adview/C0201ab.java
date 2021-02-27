package com.applovin.impl.adview;

import com.applovin.impl.sdk.C0296ad;

/* renamed from: com.applovin.impl.adview.ab */
class C0201ab implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0296ad f165a;

    /* renamed from: b */
    final /* synthetic */ C0279n f166b;

    C0201ab(C0279n nVar, C0296ad adVar) {
        this.f166b = nVar;
        this.f165a = adVar;
    }

    public void run() {
        this.f166b.getSettings().setMediaPlaybackRequiresUserGesture(this.f165a.mo4275R());
    }
}
