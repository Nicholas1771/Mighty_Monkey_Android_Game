package com.applovin.impl.adview;

import android.view.View;

/* renamed from: com.applovin.impl.adview.d */
class C0269d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdViewControllerImpl f366a;

    C0269d(AdViewControllerImpl adViewControllerImpl) {
        this.f366a = adViewControllerImpl;
    }

    public void run() {
        this.f366a.m149d();
        if (this.f366a.f129b != null && this.f366a.f137j != null && this.f366a.f137j.getParent() == null) {
            this.f366a.f129b.addView(this.f366a.f137j);
            AdViewControllerImpl.m145b((View) this.f366a.f137j, this.f366a.f141n.getSize());
        }
    }
}
