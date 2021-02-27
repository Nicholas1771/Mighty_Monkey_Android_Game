package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.eu */
class C0421eu extends C0386dm implements C0442fo {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final JSONObject f1069a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C0451h f1070b;

    /* renamed from: g */
    private final AppLovinAdLoadListener f1071g;

    C0421eu(JSONObject jSONObject, C0451h hVar, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        super("TaskProcessAdWaterfall", appLovinSdkImpl);
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (hVar == null) {
            throw new IllegalArgumentException("No ad spec specified");
        } else {
            this.f1069a = jSONObject;
            this.f1070b = hVar;
            this.f1071g = appLovinAdLoadListener;
        }
    }

    /* renamed from: a */
    private void m1048a(int i) {
        C0444fq.m1163a(this.f1071g, this.f1070b, i, this.f763d);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1051a(AppLovinAd appLovinAd) {
        try {
            if (this.f1071g != null) {
                this.f1071g.adReceived(appLovinAd);
            }
        } catch (Throwable th) {
            this.f764e.mo4781e(this.f762c, "Unable process a ad received notification", th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m1054d() {
        m1048a(-6);
    }

    /* renamed from: c */
    public String mo4672c() {
        return "tPAW";
    }

    public void run() {
        try {
            this.f764e.mo4779d(this.f762c, "Processing ad response...");
            JSONArray jSONArray = this.f1069a.getJSONArray("ads");
            int length = jSONArray.length();
            if (length > 0) {
                this.f764e.mo4779d(this.f762c, "Loading the first out of " + length + " ads...");
                this.f763d.mo4169a().mo4680a((C0386dm) new C0422ev(this, 0, jSONArray));
                return;
            }
            this.f764e.mo4785w(this.f762c, "No ads were returned from the server");
            m1048a((int) AppLovinErrorCodes.NO_FILL);
        } catch (Throwable th) {
            this.f764e.mo4781e(this.f762c, "Encountered error while processing ad response", th);
            m1054d();
        }
    }
}
