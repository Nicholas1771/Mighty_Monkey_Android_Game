package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdk;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.fa */
class C0428fa extends C0386dm implements C0442fo {

    /* renamed from: a */
    private final C0451h f1079a;

    /* renamed from: b */
    private final JSONObject f1080b;

    /* renamed from: g */
    private final JSONObject f1081g;

    /* renamed from: h */
    private final AppLovinAdLoadListener f1082h;

    C0428fa(C0451h hVar, JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        super("TaskRenderAppLovinAd", appLovinSdkImpl);
        this.f1079a = hVar;
        this.f1080b = jSONObject;
        this.f1081g = jSONObject2;
        this.f1082h = appLovinAdLoadListener;
    }

    /* renamed from: a */
    private C0416ep m1084a(String str) {
        return "main".equalsIgnoreCase(str) ? C0416ep.MAIN : C0416ep.BACKGROUND;
    }

    /* renamed from: d */
    private void m1085d() throws JSONException, IllegalArgumentException {
        if (C0444fq.isValidString(C0329bj.m634a(this.f1080b, "html", (String) null, (AppLovinSdk) this.f763d))) {
            C0450g gVar = new C0450g(this.f1079a, this.f1080b, this.f1081g, this.f763d);
            boolean booleanValue = C0329bj.m632a(this.f1080b, "vs_cache_immediately", (Boolean) false, (AppLovinSdk) this.f763d).booleanValue();
            boolean booleanValue2 = C0329bj.m632a(this.f1080b, "vs_load_immediately", (Boolean) true, (AppLovinSdk) this.f763d).booleanValue();
            String a = C0329bj.m634a(this.f1080b, "vs_ad_cache_priority", "background", (AppLovinSdk) this.f763d);
            this.f764e.mo4779d(this.f762c, "Creating cache task...");
            C0401ea eaVar = new C0401ea(gVar, this.f1082h, this.f763d);
            if (!gVar.mo3860b() || booleanValue) {
                this.f763d.mo4169a().mo4680a((C0386dm) eaVar);
                return;
            }
            C0416ep a2 = m1084a(a);
            eaVar.mo4652a(booleanValue2);
            this.f763d.mo4169a().mo4681a((C0386dm) eaVar, a2);
            return;
        }
        this.f764e.mo4780e(this.f762c, "No HTML received for requested ad");
        C0444fq.m1163a(this.f1082h, this.f1079a, -6, this.f763d);
    }

    /* renamed from: c */
    public String mo4672c() {
        return "tRA";
    }

    public void run() {
        try {
            m1085d();
        } catch (Throwable th) {
            if (th instanceof JSONException) {
                this.f764e.mo4781e(this.f762c, "Unable to parse ad service response", th);
            } else if (th instanceof IllegalArgumentException) {
                this.f764e.mo4781e(this.f762c, "Ad response is not valid", th);
            } else {
                this.f764e.mo4781e(this.f762c, "Unable to render ad", th);
            }
            C0444fq.m1163a(this.f1082h, this.f1079a, -6, this.f763d);
        }
    }
}
