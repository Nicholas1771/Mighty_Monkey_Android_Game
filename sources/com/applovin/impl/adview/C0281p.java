package com.applovin.impl.adview;

import android.webkit.WebSettings;

/* renamed from: com.applovin.impl.adview.p */
class C0281p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f385a;

    /* renamed from: b */
    final /* synthetic */ Boolean f386b;

    /* renamed from: c */
    final /* synthetic */ C0279n f387c;

    C0281p(C0279n nVar, WebSettings webSettings, Boolean bool) {
        this.f387c = nVar;
        this.f385a = webSettings;
        this.f386b = bool;
    }

    public void run() {
        this.f385a.setAllowContentAccess(this.f386b.booleanValue());
    }
}
