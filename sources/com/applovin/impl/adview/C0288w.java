package com.applovin.impl.adview;

import android.webkit.WebSettings;

/* renamed from: com.applovin.impl.adview.w */
class C0288w implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f406a;

    /* renamed from: b */
    final /* synthetic */ Boolean f407b;

    /* renamed from: c */
    final /* synthetic */ C0279n f408c;

    C0288w(C0279n nVar, WebSettings webSettings, Boolean bool) {
        this.f408c = nVar;
        this.f406a = webSettings;
        this.f407b = bool;
    }

    public void run() {
        this.f406a.setAllowUniversalAccessFromFileURLs(this.f407b.booleanValue());
    }
}
