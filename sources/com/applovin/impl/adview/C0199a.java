package com.applovin.impl.adview;

/* renamed from: com.applovin.impl.adview.a */
class C0199a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdViewControllerImpl f163a;

    C0199a(AdViewControllerImpl adViewControllerImpl) {
        this.f163a = adViewControllerImpl;
    }

    public void run() {
        if (this.f163a.f144q != null) {
            this.f163a.f132e.mo4779d("AppLovinAdView", "Detaching expanded ad: " + this.f163a.f144q.mo4005a());
            C0217ar unused = this.f163a.f145r = this.f163a.f144q;
            C0217ar unused2 = this.f163a.f144q = null;
            this.f163a.m139a(this.f163a.f133f);
        }
    }
}
