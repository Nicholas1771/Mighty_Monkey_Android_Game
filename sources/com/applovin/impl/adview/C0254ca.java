package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;

/* renamed from: com.applovin.impl.adview.ca */
class C0254ca implements AppLovinAdLoadListener {

    /* renamed from: a */
    final /* synthetic */ String f329a;

    /* renamed from: b */
    final /* synthetic */ C0252bz f330b;

    C0254ca(C0252bz bzVar, String str) {
        this.f330b = bzVar;
        this.f329a = str;
    }

    public void adReceived(AppLovinAd appLovinAd) {
        this.f330b.m332b(appLovinAd);
        this.f330b.showAndRender(appLovinAd, this.f329a);
    }

    public void failedToReceiveAd(int i) {
        this.f330b.m323a(i);
    }
}
