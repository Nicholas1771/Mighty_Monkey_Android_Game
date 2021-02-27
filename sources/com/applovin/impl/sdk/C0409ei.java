package com.applovin.impl.sdk;

import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ei */
class C0409ei extends C0431fd<JSONObject> {

    /* renamed from: a */
    final /* synthetic */ C0408eh f1035a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0409ei(C0408eh ehVar, String str, JSONObject jSONObject, String str2, AppLovinSdkImpl appLovinSdkImpl) {
        super(str, jSONObject, str2, appLovinSdkImpl);
        this.f1035a = ehVar;
    }

    /* renamed from: a */
    public void mo4524a(int i) {
        this.f1035a.f1030g.onPostbackFailure(this.f1035a.f1028a, i);
    }

    /* renamed from: a */
    public void mo4525a(JSONObject jSONObject, int i) {
        this.f1035a.f1030g.onPostbackSuccess(this.f1035a.f1028a);
    }
}
