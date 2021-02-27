package com.applovin.impl.adview;

import android.view.View;

/* renamed from: com.applovin.impl.adview.j */
class C0275j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdViewControllerImpl f374a;

    private C0275j(AdViewControllerImpl adViewControllerImpl) {
        this.f374a = adViewControllerImpl;
    }

    /* synthetic */ C0275j(AdViewControllerImpl adViewControllerImpl, C0199a aVar) {
        this(adViewControllerImpl);
    }

    public void run() {
        if (this.f374a.f141n == null) {
            return;
        }
        if (this.f374a.f137j != null) {
            this.f374a.f132e.mo4779d("AppLovinAdView", "Rendering advertisement ad for #" + this.f374a.f141n.getAdIdNumber() + " over placement: \"" + this.f374a.f134g + "\"...");
            AdViewControllerImpl.m145b((View) this.f374a.f137j, this.f374a.f141n.getSize());
            this.f374a.f137j.mo4131a(this.f374a.f141n, this.f374a.f134g);
            return;
        }
        this.f374a.f130c.getLogger().userError("AppLovinAdView", "Unable to render advertisement for ad #" + this.f374a.f141n.getAdIdNumber() + ". Please make sure you are not calling AppLovinAdView.destroy() prematurely.");
    }
}
