package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinPostbackListener;

/* renamed from: com.applovin.impl.sdk.dg */
class C0380dg implements AppLovinPostbackListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinPostbackListener f744a;

    /* renamed from: b */
    final /* synthetic */ PostbackServiceImpl f745b;

    C0380dg(PostbackServiceImpl postbackServiceImpl, AppLovinPostbackListener appLovinPostbackListener) {
        this.f745b = postbackServiceImpl;
        this.f744a = appLovinPostbackListener;
    }

    public void onPostbackFailure(String str, int i) {
        this.f745b.f475a.getLogger().mo4780e("PostbackService", "Failed to dispatch postback. Error code: " + i + " URL: " + str);
        if (this.f744a != null) {
            this.f744a.onPostbackFailure(str, i);
        }
    }

    public void onPostbackSuccess(String str) {
        this.f745b.f475a.getLogger().mo4779d("PostbackService", "Successfully dispatched postback to URL: " + str);
        if (this.f744a != null) {
            this.f744a.onPostbackSuccess(str);
        }
    }
}
