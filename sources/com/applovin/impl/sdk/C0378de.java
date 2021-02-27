package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinPostbackListener;

/* renamed from: com.applovin.impl.sdk.de */
class C0378de implements AppLovinPostbackListener {

    /* renamed from: a */
    final /* synthetic */ C0379df f738a;

    /* renamed from: b */
    final /* synthetic */ C0377dd f739b;

    C0378de(C0377dd ddVar, C0379df dfVar) {
        this.f739b = ddVar;
        this.f738a = dfVar;
    }

    public void onPostbackFailure(String str, int i) {
        this.f739b.f733b.mo4782i("PersistentPostbackManager", "Failed to submit postback with errorCode " + i + ". Will retry later...  Postback: " + this.f738a);
        this.f739b.m778e(this.f738a);
    }

    public void onPostbackSuccess(String str) {
        this.f739b.m777d(this.f738a);
        this.f739b.f733b.mo4779d("PersistentPostbackManager", "Successfully submitted postback: " + this.f738a);
        this.f739b.mo4495b();
    }
}
