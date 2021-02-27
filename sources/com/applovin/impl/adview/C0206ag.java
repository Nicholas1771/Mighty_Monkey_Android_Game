package com.applovin.impl.adview;

import android.webkit.WebSettings;

/* renamed from: com.applovin.impl.adview.ag */
class C0206ag implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f177a;

    /* renamed from: b */
    final /* synthetic */ Boolean f178b;

    /* renamed from: c */
    final /* synthetic */ C0279n f179c;

    C0206ag(C0279n nVar, WebSettings webSettings, Boolean bool) {
        this.f179c = nVar;
        this.f177a = webSettings;
        this.f178b = bool;
    }

    public void run() {
        this.f177a.setUseWideViewPort(this.f178b.booleanValue());
    }
}
