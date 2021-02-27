package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ff */
class C0433ff extends C0384dk {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C0296ad f1102a;

    public C0433ff(C0296ad adVar, AppLovinSdkImpl appLovinSdkImpl) {
        super("TaskReportReward", appLovinSdkImpl);
        this.f1102a = adVar;
    }

    public void run() {
        String userIdentifier = this.f763d.getUserIdentifier();
        String l = this.f1102a.mo4291l();
        HashMap hashMap = new HashMap(2);
        if (AppLovinSdkUtils.isValidString(l)) {
            hashMap.put("clcode", l);
        } else {
            hashMap.put("clcode", "NO_CLCODE");
        }
        if (userIdentifier != null) {
            hashMap.put("user_id", userIdentifier);
        }
        C0376dc a = C0376dc.m763a();
        String b = a.mo4489b(this.f1102a);
        if (b != null) {
            hashMap.put("result", b);
            Map<String, String> a2 = a.mo4486a(this.f1102a);
            if (a2 != null) {
                hashMap.put("params", a2);
            }
            mo4523a("cr", new JSONObject(hashMap), new C0434fg(this));
            return;
        }
        this.f764e.mo4779d("TaskReportReward", "No reward result was found for ad: " + this.f1102a);
    }
}
