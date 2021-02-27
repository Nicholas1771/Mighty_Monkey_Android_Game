package com.applovin.impl.adview;

import android.webkit.WebSettings;

/* renamed from: com.applovin.impl.adview.ae */
class C0204ae implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f171a;

    /* renamed from: b */
    final /* synthetic */ Boolean f172b;

    /* renamed from: c */
    final /* synthetic */ C0279n f173c;

    C0204ae(C0279n nVar, WebSettings webSettings, Boolean bool) {
        this.f173c = nVar;
        this.f171a = webSettings;
        this.f172b = bool;
    }

    public void run() {
        this.f171a.setAllowFileAccess(this.f172b.booleanValue());
    }
}
