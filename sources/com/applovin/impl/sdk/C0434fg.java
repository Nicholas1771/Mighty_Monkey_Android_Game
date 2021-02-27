package com.applovin.impl.sdk;

import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.fg */
class C0434fg implements C0465v<JSONObject> {

    /* renamed from: a */
    final /* synthetic */ C0433ff f1103a;

    C0434fg(C0433ff ffVar) {
        this.f1103a = ffVar;
    }

    /* renamed from: a */
    public void mo4524a(int i) {
        this.f1103a.f764e.mo4779d("TaskReportReward", "Failed to report reward for ad: " + this.f1103a.f1102a.getAdIdNumber() + " - error code: " + i);
    }

    /* renamed from: a */
    public void mo4525a(JSONObject jSONObject, int i) {
        this.f1103a.f764e.mo4779d("TaskReportReward", "Reported reward successfully for ad: " + this.f1103a.f1102a.getAdIdNumber());
    }
}
