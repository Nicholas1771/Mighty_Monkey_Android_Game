package com.applovin.impl.adview;

import android.webkit.WebSettings;

/* renamed from: com.applovin.impl.adview.r */
class C0283r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f391a;

    /* renamed from: b */
    final /* synthetic */ Boolean f392b;

    /* renamed from: c */
    final /* synthetic */ C0279n f393c;

    C0283r(C0279n nVar, WebSettings webSettings, Boolean bool) {
        this.f393c = nVar;
        this.f391a = webSettings;
        this.f392b = bool;
    }

    public void run() {
        this.f391a.setDisplayZoomControls(this.f392b.booleanValue());
    }
}
