package com.applovin.impl.adview;

import android.webkit.WebSettings;

/* renamed from: com.applovin.impl.adview.af */
class C0205af implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f174a;

    /* renamed from: b */
    final /* synthetic */ Boolean f175b;

    /* renamed from: c */
    final /* synthetic */ C0279n f176c;

    C0205af(C0279n nVar, WebSettings webSettings, Boolean bool) {
        this.f176c = nVar;
        this.f174a = webSettings;
        this.f175b = bool;
    }

    public void run() {
        this.f174a.setLoadWithOverviewMode(this.f175b.booleanValue());
    }
}
