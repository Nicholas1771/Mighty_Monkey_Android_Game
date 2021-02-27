package com.applovin.impl.sdk;

import com.applovin.impl.p003a.C0186g;
import com.applovin.impl.p003a.C0187h;
import com.applovin.impl.p003a.C0193n;
import com.applovin.sdk.AppLovinAdLoadListener;

/* renamed from: com.applovin.impl.sdk.fh */
class C0435fh extends C0386dm implements C0442fo {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C0186g f1104a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AppLovinAdLoadListener f1105b;

    C0435fh(C0186g gVar, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        super("TaskResolveVastWrapper", appLovinSdkImpl);
        this.f1105b = appLovinAdLoadListener;
        this.f1104a = gVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1123a(int i) {
        this.f764e.mo4780e(this.f762c, "Failed to resolve VAST wrapper due to error code " + i);
        if (i == -103) {
            C0444fq.m1163a(this.f1105b, this.f1104a.mo3898e(), i, this.f763d);
        } else {
            C0193n.m104a(this.f1104a, this.f1104a.mo3898e(), this.f1105b, i == -102 ? C0187h.TIMED_OUT : C0187h.GENERAL_WRAPPER_ERROR, i, this.f763d);
        }
    }

    /* renamed from: c */
    public String mo4672c() {
        return "tRVW";
    }

    public void run() {
        String a = C0193n.m100a(this.f1104a);
        if (C0444fq.isValidString(a)) {
            this.f764e.mo4779d(this.f762c, "Resolving VAST ad with depth " + this.f1104a.mo3894a() + " at " + a);
            try {
                C0436fi fiVar = new C0436fi(this, "GET", C0446fs.f1123a, "RepeatResolveVastWrapper", this.f763d);
                fiVar.mo4701a(a);
                fiVar.mo4704b(((Integer) this.f763d.get(C0387dn.f916cR)).intValue());
                fiVar.mo4707c(((Integer) this.f763d.get(C0387dn.f915cQ)).intValue());
                this.f763d.mo4169a().mo4680a((C0386dm) fiVar);
            } catch (Throwable th) {
                this.f764e.mo4781e(this.f762c, "Unable to resolve VAST wrapper", th);
                m1123a(-1);
            }
        } else {
            this.f764e.mo4780e(this.f762c, "Resolving VAST failed. Could not find resolution URL");
            m1123a(-1);
        }
    }
}
