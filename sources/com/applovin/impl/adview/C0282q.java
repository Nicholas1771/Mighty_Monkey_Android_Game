package com.applovin.impl.adview;

import android.webkit.WebSettings;

/* renamed from: com.applovin.impl.adview.q */
class C0282q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f388a;

    /* renamed from: b */
    final /* synthetic */ Boolean f389b;

    /* renamed from: c */
    final /* synthetic */ C0279n f390c;

    C0282q(C0279n nVar, WebSettings webSettings, Boolean bool) {
        this.f390c = nVar;
        this.f388a = webSettings;
        this.f389b = bool;
    }

    public void run() {
        this.f388a.setBuiltInZoomControls(this.f389b.booleanValue());
    }
}
