package com.applovin.impl.adview;

import android.webkit.WebSettings;

/* renamed from: com.applovin.impl.adview.v */
class C0287v implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f403a;

    /* renamed from: b */
    final /* synthetic */ Boolean f404b;

    /* renamed from: c */
    final /* synthetic */ C0279n f405c;

    C0287v(C0279n nVar, WebSettings webSettings, Boolean bool) {
        this.f405c = nVar;
        this.f403a = webSettings;
        this.f404b = bool;
    }

    public void run() {
        this.f403a.setAllowFileAccessFromFileURLs(this.f404b.booleanValue());
    }
}
