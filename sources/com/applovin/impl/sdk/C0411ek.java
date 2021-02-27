package com.applovin.impl.sdk;

import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ek */
class C0411ek extends C0431fd<JSONObject> {

    /* renamed from: a */
    final /* synthetic */ C0410ej f1039a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0411ek(C0410ej ejVar, String str, JSONObject jSONObject, String str2, AppLovinSdkImpl appLovinSdkImpl) {
        super(str, jSONObject, str2, appLovinSdkImpl);
        this.f1039a = ejVar;
    }

    /* renamed from: a */
    public void mo4524a(int i) {
        this.f1039a.m999b(i);
    }

    /* renamed from: a */
    public void mo4525a(JSONObject jSONObject, int i) {
        if (i == 200) {
            this.f1039a.m1000b(jSONObject);
        } else {
            this.f1039a.m999b(i);
        }
    }
}
