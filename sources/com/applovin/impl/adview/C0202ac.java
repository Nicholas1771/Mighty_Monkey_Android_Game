package com.applovin.impl.adview;

import android.webkit.WebView;

/* renamed from: com.applovin.impl.adview.ac */
class C0202ac implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0279n f167a;

    C0202ac(C0279n nVar) {
        this.f167a = nVar;
    }

    public void run() {
        WebView.setWebContentsDebuggingEnabled(true);
    }
}
