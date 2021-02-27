package com.applovin.impl.adview;

import android.webkit.WebSettings;

/* renamed from: com.applovin.impl.adview.u */
class C0286u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f400a;

    /* renamed from: b */
    final /* synthetic */ Boolean f401b;

    /* renamed from: c */
    final /* synthetic */ C0279n f402c;

    C0286u(C0279n nVar, WebSettings webSettings, Boolean bool) {
        this.f402c = nVar;
        this.f400a = webSettings;
        this.f401b = bool;
    }

    public void run() {
        this.f400a.setNeedInitialFocus(this.f401b.booleanValue());
    }
}
