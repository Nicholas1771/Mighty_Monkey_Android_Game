package com.applovin.impl.sdk;

import com.applovin.impl.p003a.C0186g;
import com.applovin.impl.p003a.C0187h;
import com.applovin.impl.p003a.C0193n;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ew */
abstract class C0423ew extends C0386dm implements C0442fo {

    /* renamed from: a */
    private final AppLovinAdLoadListener f1075a;

    /* renamed from: b */
    private final C0424ex f1076b;

    C0423ew(C0186g gVar, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        super("TaskProcessVastResponse", appLovinSdkImpl);
        if (gVar == null) {
            throw new IllegalArgumentException("No context specified.");
        }
        this.f1075a = appLovinAdLoadListener;
        this.f1076b = (C0424ex) gVar;
    }

    /* renamed from: a */
    public static C0423ew m1059a(C0446fs fsVar, C0186g gVar, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        return new C0426ez(fsVar, gVar, appLovinAdLoadListener, appLovinSdkImpl);
    }

    /* renamed from: a */
    public static C0423ew m1060a(C0451h hVar, JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        return new C0425ey(hVar, jSONObject, jSONObject2, appLovinAdLoadListener, appLovinSdkImpl);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4690a(C0187h hVar) {
        this.f764e.mo4780e(this.f762c, "Failed to process VAST response due to VAST error code " + hVar);
        C0193n.m104a(this.f1076b, this.f1076b.mo3898e(), this.f1075a, hVar, -6, this.f763d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4691a(C0446fs fsVar) {
        int a = this.f1076b.mo3894a();
        this.f764e.mo4779d(this.f762c, "Finished parsing XML at depth " + a);
        this.f1076b.mo4692a(fsVar);
        if (C0193n.m110a(fsVar)) {
            int intValue = ((Integer) this.f763d.get(C0387dn.f914cP)).intValue();
            if (a < intValue) {
                this.f764e.mo4779d(this.f762c, "VAST response is wrapper. Resolving...");
                this.f763d.mo4169a().mo4680a((C0386dm) new C0435fh(this.f1076b, this.f1075a, this.f763d));
                return;
            }
            this.f764e.mo4780e(this.f762c, "Reached beyond max wrapper depth of " + intValue);
            mo4690a(C0187h.WRAPPER_LIMIT_REACHED);
        } else if (C0193n.m113b(fsVar)) {
            this.f764e.mo4779d(this.f762c, "VAST response is inline. Rendering ad...");
            this.f763d.mo4169a().mo4680a((C0386dm) new C0430fc(this.f1076b, this.f1075a, this.f763d));
        } else {
            this.f764e.mo4780e(this.f762c, "VAST response is an error");
            mo4690a(C0187h.NO_WRAPPER_RESPONSE);
        }
    }

    /* renamed from: c */
    public String mo4672c() {
        return "tPVR";
    }
}
