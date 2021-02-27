package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdk;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ev */
class C0422ev extends C0386dm implements AppLovinAdLoadListener {

    /* renamed from: a */
    final /* synthetic */ C0421eu f1072a;

    /* renamed from: b */
    private final JSONArray f1073b;

    /* renamed from: g */
    private final int f1074g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0422ev(C0421eu euVar, int i, JSONArray jSONArray) {
        super("TaskProcessNextWaterfallAd", euVar.f763d);
        this.f1072a = euVar;
        if (jSONArray == null) {
            throw new IllegalArgumentException("No ad objects array specified");
        } else if (i < 0 || i >= jSONArray.length()) {
            throw new IllegalArgumentException("Invalid ad index specified: " + i);
        } else {
            this.f1073b = jSONArray;
            this.f1074g = i;
        }
    }

    /* renamed from: a */
    private void m1056a(int i) throws JSONException {
        if ("adapter".equals(m1057b(i))) {
            this.f763d.mo4169a().mo4681a((C0386dm) new C0420et(this.f1072a.f1070b, this.f1073b.getJSONObject(i), this.f1072a.f1069a, this.f763d), C0416ep.BACKGROUND);
        }
    }

    /* renamed from: b */
    private String m1057b(int i) {
        if (i < 0 || i >= this.f1073b.length()) {
            return "undefined";
        }
        try {
            return C0329bj.m634a(this.f1073b.getJSONObject(i), "type", "undefined", (AppLovinSdk) this.f763d);
        } catch (JSONException e) {
            this.f764e.mo4780e(this.f762c, "Unable to parse next ad from the ad response");
            return "undefined";
        }
    }

    /* renamed from: c */
    private void m1058c() throws JSONException {
        JSONObject jSONObject = this.f1073b.getJSONObject(this.f1074g);
        String b = m1057b(this.f1074g);
        if (AppLovinSdk.URI_SCHEME.equalsIgnoreCase(b)) {
            this.f764e.mo4779d(this.f762c, "Starting task for AppLovin ad...");
            this.f763d.mo4169a().mo4680a((C0386dm) new C0428fa(this.f1072a.f1070b, jSONObject, this.f1072a.f1069a, this, this.f763d));
        } else if ("vast".equalsIgnoreCase(b)) {
            this.f764e.mo4779d(this.f762c, "Starting task for VAST ad...");
            this.f763d.mo4169a().mo4680a((C0386dm) C0423ew.m1060a(this.f1072a.f1070b, jSONObject, this.f1072a.f1069a, this, this.f763d));
        } else if ("adapter".equalsIgnoreCase(b)) {
            this.f764e.mo4779d(this.f762c, "Starting task for adapter ad...");
            this.f763d.mo4169a().mo4680a((C0386dm) new C0414en(this.f1072a.f1070b, jSONObject, this.f1072a.f1069a, this, this.f763d));
        } else {
            this.f764e.mo4785w(this.f762c, "Unable to process ad of unknown type: " + b);
            failedToReceiveAd(AppLovinErrorCodes.INVALID_RESPONSE);
        }
    }

    public void adReceived(AppLovinAd appLovinAd) {
        this.f1072a.m1051a(appLovinAd);
    }

    public void failedToReceiveAd(int i) {
        if (this.f1074g < this.f1073b.length() - 1) {
            this.f764e.mo4782i(this.f762c, "Attempting to load next ad (" + this.f1074g + ") after failure...");
            this.f763d.mo4169a().mo4681a((C0386dm) new C0422ev(this.f1072a, this.f1074g + 1, this.f1073b), C0416ep.BACKGROUND);
            return;
        }
        this.f1072a.m1054d();
    }

    public void run() {
        try {
            if (this.f1074g == 0) {
                int intValue = ((Integer) this.f763d.get(C0387dn.f952da)).intValue();
                int i = 1;
                while (i <= intValue && i < this.f1073b.length()) {
                    m1056a(i);
                    i++;
                }
            } else {
                int intValue2 = ((Integer) this.f763d.get(C0387dn.f952da)).intValue() + this.f1074g;
                if (intValue2 < this.f1073b.length()) {
                    m1056a(intValue2);
                }
            }
            m1058c();
        } catch (Throwable th) {
            this.f764e.mo4781e(this.f762c, "Encountered error while processing ad number " + this.f1074g, th);
            this.f1072a.m1054d();
        }
    }
}
