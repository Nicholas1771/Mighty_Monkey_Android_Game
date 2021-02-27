package com.applovin.impl.adview;

/* renamed from: com.applovin.impl.adview.i */
class C0274i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdViewControllerImpl f373a;

    private C0274i(AdViewControllerImpl adViewControllerImpl) {
        this.f373a = adViewControllerImpl;
    }

    /* synthetic */ C0274i(AdViewControllerImpl adViewControllerImpl, C0199a aVar) {
        this(adViewControllerImpl);
    }

    public void run() {
        if (this.f373a.f137j != null) {
            try {
                this.f373a.f137j.loadDataWithBaseURL("/", "<html></html>", "text/html", (String) null, "");
            } catch (Exception e) {
            }
        }
    }
}
