package com.applovin.impl.adview;

/* renamed from: com.applovin.impl.adview.h */
class C0273h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdViewControllerImpl f372a;

    private C0273h(AdViewControllerImpl adViewControllerImpl) {
        this.f372a = adViewControllerImpl;
    }

    /* synthetic */ C0273h(AdViewControllerImpl adViewControllerImpl, C0199a aVar) {
        this(adViewControllerImpl);
    }

    public void run() {
        if (this.f372a.f137j != null) {
            this.f372a.f137j.setVisibility(8);
        }
    }
}
