package com.applovin.impl.adview;

/* renamed from: com.applovin.impl.adview.f */
class C0271f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f369a;

    /* renamed from: b */
    final /* synthetic */ AdViewControllerImpl f370b;

    C0271f(AdViewControllerImpl adViewControllerImpl, int i) {
        this.f370b = adViewControllerImpl;
        this.f369a = i;
    }

    public void run() {
        try {
            if (this.f370b.f151x != null) {
                this.f370b.f151x.failedToReceiveAd(this.f369a);
            }
        } catch (Throwable th) {
            this.f370b.f132e.userError("AppLovinAdView", "Exception while running app load  callback", th);
        }
    }
}
