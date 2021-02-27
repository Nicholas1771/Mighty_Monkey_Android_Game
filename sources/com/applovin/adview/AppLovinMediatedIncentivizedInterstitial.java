package com.applovin.adview;

import android.content.Context;
import com.applovin.impl.sdk.C0305am;
import com.applovin.impl.sdk.C0347ca;
import com.applovin.sdk.AppLovinSdk;

public class AppLovinMediatedIncentivizedInterstitial extends AppLovinIncentivizedInterstitial {
    public AppLovinMediatedIncentivizedInterstitial(Context context) {
        super(context);
    }

    public AppLovinMediatedIncentivizedInterstitial(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    public static AppLovinMediatedIncentivizedInterstitial create(Context context) {
        return create(AppLovinSdk.getInstance(context));
    }

    public static AppLovinMediatedIncentivizedInterstitial create(AppLovinSdk appLovinSdk) {
        return new AppLovinMediatedIncentivizedInterstitial(appLovinSdk);
    }

    /* access modifiers changed from: protected */
    public C0305am createIncentivizedAdController(AppLovinSdk appLovinSdk) {
        return new C0347ca(appLovinSdk);
    }
}
