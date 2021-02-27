package com.applovin.impl.sdk;

import com.applovin.impl.p003a.C0180a;
import com.applovin.impl.p003a.C0185f;
import com.applovin.impl.p003a.C0186g;
import com.applovin.impl.p003a.C0187h;
import com.applovin.impl.p003a.C0190k;
import com.applovin.impl.p003a.C0191l;
import com.applovin.impl.p003a.C0193n;
import com.applovin.impl.p003a.C0194o;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdk;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.fc */
class C0430fc extends C0386dm implements C0442fo {

    /* renamed from: a */
    private C0186g f1085a;

    /* renamed from: b */
    private final AppLovinAdLoadListener f1086b;

    C0430fc(C0186g gVar, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        super("TaskRenderVastAd", appLovinSdkImpl);
        if (gVar == null) {
            throw new IllegalArgumentException("No context specified.");
        }
        this.f1086b = appLovinAdLoadListener;
        this.f1085a = gVar;
    }

    /* renamed from: a */
    private void m1093a(C0187h hVar, Throwable th) {
        this.f764e.mo4781e(this.f762c, "Failed to render valid VAST ad", th);
        C0193n.m104a(this.f1085a, this.f1085a.mo3898e(), this.f1086b, hVar, -6, this.f763d);
    }

    /* renamed from: c */
    public String mo4672c() {
        return "tRVA";
    }

    public void run() {
        C0185f fVar = null;
        this.f764e.mo4779d(this.f762c, "Rendering VAST ad...");
        String str = "";
        String str2 = "";
        int size = this.f1085a.mo3895b().size();
        HashSet hashSet = new HashSet(size);
        HashSet hashSet2 = new HashSet(size);
        C0194o oVar = null;
        C0190k kVar = null;
        for (C0446fs next : this.f1085a.mo3895b()) {
            C0446fs c = next.mo4739c(C0193n.m110a(next) ? "Wrapper" : "InLine");
            if (c != null) {
                C0446fs c2 = c.mo4739c("AdSystem");
                if (c2 != null) {
                    kVar = C0190k.m90a(c2, kVar, this.f763d);
                }
                str = C0193n.m101a(c, "AdTitle", str);
                str2 = C0193n.m101a(c, "Description", str2);
                C0193n.m106a(c.mo4736a("Impression"), (Set<C0191l>) hashSet, this.f1085a, (AppLovinSdk) this.f763d);
                C0193n.m106a(c.mo4736a("Error"), (Set<C0191l>) hashSet2, this.f1085a, (AppLovinSdk) this.f763d);
                C0446fs b = c.mo4737b("Creatives");
                if (b != null) {
                    for (C0446fs next2 : b.mo4741d()) {
                        C0446fs b2 = next2.mo4737b("Linear");
                        if (b2 != null) {
                            oVar = C0194o.m116a(b2, oVar, this.f1085a, this.f763d);
                        } else {
                            C0446fs c3 = next2.mo4739c("CompanionAds");
                            if (c3 != null) {
                                C0446fs c4 = c3.mo4739c("Companion");
                                if (c4 != null) {
                                    fVar = C0185f.m70a(c4, fVar, this.f1085a, this.f763d);
                                }
                            } else {
                                this.f764e.mo4780e(this.f762c, "Received and will skip rendering for an unidentified creative: " + next2);
                            }
                        }
                    }
                }
            } else {
                this.f764e.mo4780e(this.f762c, "Did not find wrapper or inline response for node: " + next);
            }
            str = str;
            str2 = str2;
            kVar = kVar;
        }
        try {
            C0180a a = C0180a.m29k().mo3879a(this.f763d).mo3883a(this.f1085a.mo3896c()).mo3886b(this.f1085a.mo3897d()).mo3880a(this.f1085a.mo3898e()).mo3881a(str).mo3884b(str2).mo3877a(kVar).mo3878a(oVar).mo3876a(fVar).mo3882a((Set<C0191l>) hashSet).mo3885b((Set<C0191l>) hashSet2).mo3875a();
            C0187h a2 = C0193n.m97a(a);
            if (a2 == null) {
                this.f763d.mo4169a().mo4680a((C0386dm) new C0405ee(a, this.f1086b, this.f763d));
            } else {
                m1093a(a2, (Throwable) null);
            }
        } catch (Throwable th) {
            m1093a(C0187h.GENERAL_WRAPPER_ERROR, th);
        }
    }
}
