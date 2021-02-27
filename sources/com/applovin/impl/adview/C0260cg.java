package com.applovin.impl.adview;

import android.app.Activity;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.adview.cg */
class C0260cg extends C0252bz {
    C0260cg(AppLovinSdk appLovinSdk, Activity activity) {
        super(appLovinSdk, activity);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4067a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f317b.getAdService().loadNextMediatedAd(AppLovinAdSize.INTERSTITIAL, appLovinAdLoadListener);
    }
}
