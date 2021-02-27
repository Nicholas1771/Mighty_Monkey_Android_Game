package com.applovin.impl.sdk;

import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.et */
public class C0420et extends C0386dm implements C0442fo {

    /* renamed from: a */
    private final C0451h f1066a;

    /* renamed from: b */
    private final JSONObject f1067b;

    /* renamed from: g */
    private final JSONObject f1068g;

    C0420et(C0451h hVar, JSONObject jSONObject, JSONObject jSONObject2, AppLovinSdkImpl appLovinSdkImpl) {
        super("TaskLoadAdapterAd", appLovinSdkImpl);
        if (hVar == null) {
            throw new IllegalArgumentException("No ad spec specified");
        } else if (jSONObject == null) {
            throw new IllegalArgumentException("No ad object specified");
        } else if (jSONObject2 == null) {
            throw new IllegalArgumentException("No response specified");
        } else {
            this.f1066a = hVar;
            this.f1067b = jSONObject;
            this.f1068g = jSONObject2;
        }
    }

    /* renamed from: c */
    public String mo4672c() {
        return "tPAA";
    }

    public void run() {
        try {
            this.f763d.getMediationService().mo4220a(new C0345bz(this.f1066a, this.f1067b, this.f1068g, this.f763d));
        } catch (Throwable th) {
            this.f764e.mo4781e(this.f762c, "Unable to prepare adapter ad", th);
        }
    }
}
