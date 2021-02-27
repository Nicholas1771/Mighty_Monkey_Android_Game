package com.applovin.impl.adview;

/* renamed from: com.applovin.impl.adview.au */
class C0220au implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0217ar f236a;

    C0220au(C0217ar arVar) {
        this.f236a = arVar;
    }

    public void run() {
        this.f236a.f232g.removeView(this.f236a.f229d);
        C0220au.super.dismiss();
    }
}
