package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.en */
public class C0414en extends C0386dm implements C0442fo {

    /* renamed from: a */
    private final C0451h f1045a;

    /* renamed from: b */
    private final JSONObject f1046b;

    /* renamed from: g */
    private final JSONObject f1047g;

    /* renamed from: h */
    private final AppLovinAdLoadListener f1048h;

    C0414en(C0451h hVar, JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        super("TaskLoadAdapterAd", appLovinSdkImpl);
        if (hVar == null) {
            throw new IllegalArgumentException("No ad spec specified");
        } else if (jSONObject == null) {
            throw new IllegalArgumentException("No ad object specified");
        } else if (jSONObject2 == null) {
            throw new IllegalArgumentException("No response specified");
        } else {
            this.f1045a = hVar;
            this.f1046b = jSONObject;
            this.f1047g = jSONObject2;
            this.f1048h = appLovinAdLoadListener;
        }
    }

    /* renamed from: c */
    public String mo4672c() {
        return "tPAA";
    }

    public void run() {
        try {
            this.f763d.getMediationService().mo4221a(new C0345bz(this.f1045a, this.f1046b, this.f1047g, this.f763d), this.f1048h);
        } catch (Throwable th) {
            this.f764e.mo4781e(this.f762c, "Unable to process adapter ad", th);
            if (this.f1048h != null) {
                this.f1048h.failedToReceiveAd(AppLovinErrorCodes.MEDIATION_ADAPTER_LOAD_FAILED);
            }
        }
    }
}
