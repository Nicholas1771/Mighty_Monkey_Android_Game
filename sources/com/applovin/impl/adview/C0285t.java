package com.applovin.impl.adview;

import android.webkit.WebSettings;

/* renamed from: com.applovin.impl.adview.t */
class C0285t implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f397a;

    /* renamed from: b */
    final /* synthetic */ Boolean f398b;

    /* renamed from: c */
    final /* synthetic */ C0279n f399c;

    C0285t(C0279n nVar, WebSettings webSettings, Boolean bool) {
        this.f399c = nVar;
        this.f397a = webSettings;
        this.f398b = bool;
    }

    public void run() {
        this.f397a.setGeolocationEnabled(this.f398b.booleanValue());
    }
}
