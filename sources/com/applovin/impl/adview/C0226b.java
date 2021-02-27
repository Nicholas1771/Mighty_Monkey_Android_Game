package com.applovin.impl.adview;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.C0330bk;
import com.applovin.impl.sdk.C0391dr;
import com.applovin.impl.sdk.C0444fq;
import com.applovin.impl.sdk.C0450g;

/* renamed from: com.applovin.impl.adview.b */
class C0226b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdViewControllerImpl f276a;

    C0226b(AdViewControllerImpl adViewControllerImpl) {
        this.f276a = adViewControllerImpl;
    }

    public void run() {
        if (this.f276a.f144q == null && (this.f276a.f141n instanceof C0450g) && this.f276a.f137j != null) {
            C0450g gVar = (C0450g) this.f276a.f141n;
            Object f = this.f276a.f128a;
            if (!(f instanceof Activity)) {
                f = C0444fq.m1153a((View) this.f276a.f137j, this.f276a.f130c);
            }
            if (f instanceof Activity) {
                if (this.f276a.f129b != null) {
                    this.f276a.f129b.removeView(this.f276a.f137j);
                }
                C0217ar unused = this.f276a.f144q = new C0217ar(gVar, this.f276a.f134g, this.f276a.f137j, (Activity) f, this.f276a.f130c);
                this.f276a.f144q.setOnDismissListener(new C0253c(this));
                this.f276a.f144q.show();
                C0330bk.m640a(this.f276a.f153z, this.f276a.f141n, (AppLovinAdView) this.f276a.f129b, this.f276a.f130c);
                return;
            }
            this.f276a.f132e.userError("AppLovinAdView", "Unable to expand ad. No Activity found.");
            Uri g = gVar.mo3868g();
            C0391dr drVar = new C0391dr(this.f276a.f130c);
            if (g != null && drVar.mo4575ag()) {
                ((AppLovinAdServiceImpl) this.f276a.f130c.getAdService()).trackAndLaunchClick(gVar, this.f276a.f134g, this.f276a.getParentView(), this.f276a, g);
            }
            this.f276a.f137j.mo4132a("javascript:al_onFailedExpand();");
        }
    }
}
