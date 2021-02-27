package com.applovin.impl.adview;

import android.webkit.WebSettings;

/* renamed from: com.applovin.impl.adview.y */
class C0290y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f412a;

    /* renamed from: b */
    final /* synthetic */ Boolean f413b;

    /* renamed from: c */
    final /* synthetic */ C0279n f414c;

    C0290y(C0279n nVar, WebSettings webSettings, Boolean bool) {
        this.f414c = nVar;
        this.f412a = webSettings;
        this.f413b = bool;
    }

    public void run() {
        this.f412a.setOffscreenPreRaster(this.f413b.booleanValue());
    }
}
