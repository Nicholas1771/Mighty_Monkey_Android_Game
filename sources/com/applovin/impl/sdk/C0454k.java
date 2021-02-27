package com.applovin.impl.sdk;

import android.net.Uri;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.sdk.AppLovinPostbackListener;

/* renamed from: com.applovin.impl.sdk.k */
class C0454k implements AppLovinPostbackListener {

    /* renamed from: a */
    final /* synthetic */ AdViewControllerImpl f1156a;

    /* renamed from: b */
    final /* synthetic */ Uri f1157b;

    /* renamed from: c */
    final /* synthetic */ C0296ad f1158c;

    /* renamed from: d */
    final /* synthetic */ AppLovinAdView f1159d;

    /* renamed from: e */
    final /* synthetic */ AppLovinAdServiceImpl f1160e;

    C0454k(AppLovinAdServiceImpl appLovinAdServiceImpl, AdViewControllerImpl adViewControllerImpl, Uri uri, C0296ad adVar, AppLovinAdView appLovinAdView) {
        this.f1160e = appLovinAdServiceImpl;
        this.f1156a = adViewControllerImpl;
        this.f1157b = uri;
        this.f1158c = adVar;
        this.f1159d = appLovinAdView;
    }

    public void onPostbackFailure(String str, int i) {
        this.f1160e.f418c.post(new C0456m(this));
    }

    public void onPostbackSuccess(String str) {
        this.f1160e.f418c.post(new C0455l(this));
    }
}
