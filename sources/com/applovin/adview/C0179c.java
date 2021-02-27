package com.applovin.adview;

import android.app.Activity;
import com.applovin.impl.adview.MediatedInterstitialAdDialogCreatorImpl;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.adview.c */
final class C0179c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinSdk f29a;

    /* renamed from: b */
    final /* synthetic */ Activity f30b;

    /* renamed from: c */
    final /* synthetic */ String f31c;

    C0179c(AppLovinSdk appLovinSdk, Activity activity, String str) {
        this.f29a = appLovinSdk;
        this.f30b = activity;
        this.f31c = str;
    }

    public void run() {
        new MediatedInterstitialAdDialogCreatorImpl().createInterstitialAdDialog(this.f29a, this.f30b).show(this.f31c);
    }
}
