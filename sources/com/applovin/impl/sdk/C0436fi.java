package com.applovin.impl.sdk;

/* renamed from: com.applovin.impl.sdk.fi */
class C0436fi extends C0431fd<C0446fs> {

    /* renamed from: a */
    final /* synthetic */ C0435fh f1106a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0436fi(C0435fh fhVar, String str, C0446fs fsVar, String str2, AppLovinSdkImpl appLovinSdkImpl) {
        super(str, fsVar, str2, appLovinSdkImpl);
        this.f1106a = fhVar;
    }

    /* renamed from: a */
    public void mo4524a(int i) {
        this.f764e.mo4780e(this.f762c, "Unable to resolve VAST wrapper. Server returned " + i);
        this.f1106a.m1123a(i);
    }

    /* renamed from: a */
    public void mo4525a(C0446fs fsVar, int i) {
        this.f763d.mo4169a().mo4680a((C0386dm) C0423ew.m1059a(fsVar, this.f1106a.f1104a, this.f1106a.f1105b, this.f763d));
    }
}
