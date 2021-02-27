package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;

/* renamed from: com.applovin.impl.sdk.ap */
class C0308ap implements AppLovinAdLoadListener {

    /* renamed from: a */
    final /* synthetic */ C0305am f536a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AppLovinAdLoadListener f537b;

    C0308ap(C0305am amVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f536a = amVar;
        this.f537b = appLovinAdLoadListener;
    }

    public void adReceived(AppLovinAd appLovinAd) {
        AppLovinAd unused = this.f536a.f520c = appLovinAd;
        if (this.f537b != null) {
            C0444fq.runOnUiThread(new C0309aq(this, appLovinAd));
        }
    }

    public void failedToReceiveAd(int i) {
        if (this.f537b != null) {
            C0444fq.runOnUiThread(new C0310ar(this, i));
        }
    }
}
