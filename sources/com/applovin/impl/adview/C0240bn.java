package com.applovin.impl.adview;

import com.applovin.impl.sdk.C0330bk;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.adview.bn */
class C0240bn implements AppLovinAdClickListener {

    /* renamed from: a */
    final /* synthetic */ C0225az f296a;

    C0240bn(C0225az azVar) {
        this.f296a = azVar;
    }

    public void adClicked(AppLovinAd appLovinAd) {
        this.f296a.m270e();
        C0330bk.m641a(this.f296a.f251b.mo4072e(), appLovinAd, (AppLovinSdk) this.f296a.sdk);
    }
}
