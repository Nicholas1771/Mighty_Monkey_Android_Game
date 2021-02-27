package com.applovin.impl.adview;

import android.webkit.WebSettings;

/* renamed from: com.applovin.impl.adview.s */
class C0284s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f394a;

    /* renamed from: b */
    final /* synthetic */ Boolean f395b;

    /* renamed from: c */
    final /* synthetic */ C0279n f396c;

    C0284s(C0279n nVar, WebSettings webSettings, Boolean bool) {
        this.f396c = nVar;
        this.f394a = webSettings;
        this.f395b = bool;
    }

    public void run() {
        this.f394a.setSaveFormData(this.f395b.booleanValue());
    }
}
