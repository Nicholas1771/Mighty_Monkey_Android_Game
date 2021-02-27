package com.applovin.impl.sdk;

/* renamed from: com.applovin.impl.sdk.p */
class C0459p extends C0386dm {

    /* renamed from: a */
    final /* synthetic */ AppLovinAdServiceImpl f1172a;

    /* renamed from: b */
    private final C0451h f1173b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0459p(AppLovinAdServiceImpl appLovinAdServiceImpl, C0451h hVar) {
        super("UpdateAdTask", appLovinAdServiceImpl.f416a);
        this.f1172a = appLovinAdServiceImpl;
        this.f1173b = hVar;
    }

    public void run() {
        boolean z = true;
        this.f764e.mo4779d("AppLovinAdService", "Attempt update for spec: " + this.f1173b);
        C0458o oVar = (C0458o) this.f1172a.f419d.get(this.f1173b);
        synchronized (oVar.f1166b) {
            boolean a = this.f1172a.m414a(this.f1173b.mo4765a());
            boolean e = this.f1172a.m410a();
            boolean z2 = !oVar.f1170f.isEmpty();
            if (System.currentTimeMillis() <= oVar.f1168d) {
                z = false;
            }
            this.f764e.mo4779d("AppLovinAdService", "Update ad states - isRefreshEnabled=" + a + " hasUpdateListeners=" + z2 + " isCurrentAdExpired=" + z + " isDeviceOn=" + e + " isWaitingForAd=" + oVar.f1169e);
            if (!a || !z2 || !z || !e || oVar.f1169e) {
                this.f764e.mo4779d("AppLovinAdService", "Ad update skipped");
            } else {
                this.f764e.mo4779d("AppLovinAdService", "Performing ad update...");
                oVar.f1169e = true;
                this.f1172a.m408a(this.f1173b, new C0457n(this.f1172a, oVar, (C0454k) null));
            }
        }
    }
}
