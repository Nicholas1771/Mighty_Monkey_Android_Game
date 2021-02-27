package com.applovin.impl.adview;

import android.webkit.WebSettings;

/* renamed from: com.applovin.impl.adview.x */
class C0289x implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f409a;

    /* renamed from: b */
    final /* synthetic */ Integer f410b;

    /* renamed from: c */
    final /* synthetic */ C0279n f411c;

    C0289x(C0279n nVar, WebSettings webSettings, Integer num) {
        this.f411c = nVar;
        this.f409a = webSettings;
        this.f410b = num;
    }

    public void run() {
        this.f409a.setMixedContentMode(this.f410b.intValue());
    }
}
