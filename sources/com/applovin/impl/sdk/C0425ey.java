package com.applovin.impl.sdk;

import com.applovin.impl.p003a.C0187h;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdk;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ey */
final class C0425ey extends C0423ew {

    /* renamed from: a */
    private final JSONObject f1077a;

    C0425ey(C0451h hVar, JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        super(new C0424ex(hVar, jSONObject, jSONObject2), appLovinAdLoadListener, appLovinSdkImpl);
        if (appLovinAdLoadListener == null) {
            throw new IllegalArgumentException("No callback specified.");
        }
        this.f1077a = jSONObject;
    }

    public void run() {
        this.f764e.mo4779d(this.f762c, "Processing SDK JSON response...");
        String a = C0329bj.m634a(this.f1077a, "xml", (String) null, (AppLovinSdk) this.f763d);
        if (!C0444fq.isValidString(a)) {
            this.f764e.mo4780e(this.f762c, "No VAST response received.");
            mo4690a(C0187h.NO_WRAPPER_RESPONSE);
        } else if (a.length() < ((Integer) this.f763d.get(C0387dn.f917cS)).intValue()) {
            try {
                mo4691a(C0447ft.m1197a(a, (AppLovinSdk) this.f763d));
            } catch (Throwable th) {
                this.f764e.mo4781e(this.f762c, "Unable to parse VAST response", th);
                mo4690a(C0187h.XML_PARSING);
            }
        } else {
            this.f764e.mo4780e(this.f762c, "VAST response is over max length");
            mo4690a(C0187h.XML_PARSING);
        }
    }
}
