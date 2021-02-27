package com.applovin.impl.sdk;

import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.dk */
abstract class C0384dk extends C0386dm {
    protected C0384dk(String str, AppLovinSdkImpl appLovinSdkImpl) {
        super(str, appLovinSdkImpl);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4523a(String str, JSONObject jSONObject, C0465v vVar) {
        C0385dl dlVar = new C0385dl(this, "POST", new JSONObject(), "Repeat" + this.f762c, this.f763d, vVar);
        dlVar.mo4701a(C0466w.m1275a(str, (Map<String, String>) null, this.f763d));
        dlVar.mo4706b(C0466w.m1285c(str, (Map<String, String>) null, this.f763d));
        dlVar.mo4702a(jSONObject);
        dlVar.mo4707c(((Integer) this.f763d.get(C0387dn.f962g)).intValue());
        dlVar.mo4700a(C0387dn.f965j);
        dlVar.mo4705b(C0387dn.f969n);
        dlVar.run();
    }
}
