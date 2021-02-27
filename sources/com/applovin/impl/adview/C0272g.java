package com.applovin.impl.adview;

import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.C0330bk;
import com.applovin.impl.sdk.C0450g;
import com.applovin.sdk.AppLovinAd;

/* renamed from: com.applovin.impl.adview.g */
class C0272g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdViewControllerImpl f371a;

    C0272g(AdViewControllerImpl adViewControllerImpl) {
        this.f371a = adViewControllerImpl;
    }

    public void run() {
        C0450g gVar = null;
        if (this.f371a.f145r != null || this.f371a.f144q != null) {
            if (this.f371a.f145r != null) {
                C0450g a = this.f371a.f145r.mo4005a();
                this.f371a.f145r.dismiss();
                C0217ar unused = this.f371a.f145r = null;
                gVar = a;
            } else if (this.f371a.f144q != null) {
                C0450g a2 = this.f371a.f144q.mo4005a();
                this.f371a.f144q.dismiss();
                C0217ar unused2 = this.f371a.f144q = null;
                gVar = a2;
            }
            C0330bk.m649b(this.f371a.f153z, (AppLovinAd) gVar, (AppLovinAdView) this.f371a.f129b, this.f371a.f130c);
        }
    }
}
