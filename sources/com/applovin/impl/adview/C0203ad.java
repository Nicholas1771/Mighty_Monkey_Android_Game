package com.applovin.impl.adview;

import android.webkit.WebSettings;

/* renamed from: com.applovin.impl.adview.ad */
class C0203ad implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f168a;

    /* renamed from: b */
    final /* synthetic */ WebSettings.PluginState f169b;

    /* renamed from: c */
    final /* synthetic */ C0279n f170c;

    C0203ad(C0279n nVar, WebSettings webSettings, WebSettings.PluginState pluginState) {
        this.f170c = nVar;
        this.f168a = webSettings;
        this.f169b = pluginState;
    }

    public void run() {
        this.f168a.setPluginState(this.f169b);
    }
}
