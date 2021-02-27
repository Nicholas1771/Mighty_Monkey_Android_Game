package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinLogger;

/* renamed from: com.applovin.impl.sdk.es */
class C0419es implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0415eo f1062a;

    /* renamed from: b */
    private final String f1063b;

    /* renamed from: c */
    private final C0386dm f1064c;

    /* renamed from: d */
    private final C0416ep f1065d;

    C0419es(C0415eo eoVar, C0386dm dmVar, C0416ep epVar) {
        this.f1062a = eoVar;
        this.f1063b = dmVar.mo4527a();
        this.f1064c = dmVar;
        this.f1065d = epVar;
    }

    public void run() {
        String str;
        String str2;
        String str3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            C0463t.m1248a();
            if (this.f1062a.f1050b.mo4176e()) {
                this.f1062a.f1051c.mo4782i(this.f1063b, "Task re-scheduled...");
                this.f1062a.mo4682a(this.f1064c, this.f1065d, 2000);
            } else if (this.f1062a.f1050b.isEnabled()) {
                this.f1062a.f1051c.mo4782i(this.f1063b, "Task started execution...");
                this.f1064c.run();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (this.f1064c instanceof C0442fo) {
                    C0437fj.m1130a().mo4714a(((C0442fo) this.f1064c).mo4672c(), currentTimeMillis2, C0466w.m1272a(this.f1062a.f1050b));
                }
                this.f1062a.f1051c.mo4782i(this.f1063b, "Task executed successfully in " + currentTimeMillis2 + "ms.");
                C0394du b = this.f1062a.f1050b.mo4171b();
                b.mo4620a(this.f1063b + "_count");
                b.mo4621a(this.f1063b + "_time", currentTimeMillis2);
            } else {
                if (this.f1062a.f1050b.mo4177f()) {
                    this.f1062a.f1050b.mo4178g();
                } else {
                    this.f1062a.f1051c.mo4785w(this.f1063b, "Task not executed, SDK is disabled");
                }
                this.f1064c.mo4528b();
            }
        } catch (Throwable th) {
            this.f1062a.f1051c.mo4781e(this.f1063b, "Task failed execution in " + (System.currentTimeMillis() - currentTimeMillis) + "ms.", th);
        } finally {
            AppLovinLogger b2 = this.f1062a.f1051c;
            str = "TaskManager";
            str2 = " queue finished task ";
            StringBuilder append = new StringBuilder().append(this.f1065d).append(str2).append(this.f1064c.mo4527a());
            str3 = " with queue size ";
            b2.mo4782i(str, append.append(str3).append(this.f1062a.m1038a(this.f1065d) - 1).toString());
        }
    }
}
