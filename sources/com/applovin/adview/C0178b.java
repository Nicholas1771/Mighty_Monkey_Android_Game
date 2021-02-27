package com.applovin.adview;

import android.content.Context;
import com.applovin.impl.adview.InterstitialAdDialogCreatorImpl;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.adview.b */
final class C0178b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinSdk f26a;

    /* renamed from: b */
    final /* synthetic */ Context f27b;

    /* renamed from: c */
    final /* synthetic */ String f28c;

    C0178b(AppLovinSdk appLovinSdk, Context context, String str) {
        this.f26a = appLovinSdk;
        this.f27b = context;
        this.f28c = str;
    }

    public void run() {
        new InterstitialAdDialogCreatorImpl().createInterstitialAdDialog(this.f26a, this.f27b).show(this.f28c);
    }
}
