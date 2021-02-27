package com.applovin.impl.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.sdk.em */
class C0413em implements Runnable {

    /* renamed from: a */
    private final AppLovinSdkImpl f1042a;

    /* renamed from: b */
    private final AppLovinLogger f1043b;

    /* renamed from: c */
    private final Context f1044c;

    C0413em(AppLovinSdkImpl appLovinSdkImpl) {
        this.f1042a = appLovinSdkImpl;
        this.f1044c = appLovinSdkImpl.getApplicationContext();
        this.f1043b = appLovinSdkImpl.getLogger();
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [com.applovin.impl.sdk.dp, com.applovin.impl.sdk.dp<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1030a(com.applovin.impl.sdk.C0389dp<java.lang.String> r6, com.applovin.impl.sdk.C0452i r7) {
        /*
            r5 = this;
            com.applovin.impl.sdk.AppLovinSdkImpl r0 = r5.f1042a
            java.lang.Object r0 = r0.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            int r1 = r0.length()
            if (r1 <= 0) goto L_0x0055
            java.util.List r0 = com.applovin.impl.sdk.C0462s.m1246a(r0)
            java.util.Iterator r1 = r0.iterator()
        L_0x0016:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0055
            java.lang.Object r0 = r1.next()
            java.lang.String r0 = (java.lang.String) r0
            com.applovin.sdk.AppLovinAdSize r0 = com.applovin.sdk.AppLovinAdSize.fromString(r0)
            if (r0 == 0) goto L_0x0016
            com.applovin.impl.sdk.AppLovinSdkImpl r2 = r5.f1042a
            com.applovin.impl.sdk.f r2 = r2.mo4172c()
            com.applovin.impl.sdk.h r3 = new com.applovin.impl.sdk.h
            com.applovin.sdk.AppLovinAdType r4 = com.applovin.sdk.AppLovinAdType.REGULAR
            r3.<init>(r4, r7, r0)
            r2.mo4473f(r3)
            com.applovin.sdk.AppLovinAdSize r2 = com.applovin.sdk.AppLovinAdSize.INTERSTITIAL
            java.lang.String r2 = r2.getLabel()
            java.lang.String r0 = r0.getLabel()
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0016
            com.applovin.impl.sdk.i r0 = com.applovin.impl.sdk.C0452i.DIRECT
            if (r7 != r0) goto L_0x0052
            com.applovin.impl.sdk.dp<java.lang.Boolean> r0 = com.applovin.impl.sdk.C0387dn.f778M
        L_0x004e:
            r5.m1033b(r0, r7)
            goto L_0x0016
        L_0x0052:
            com.applovin.impl.sdk.dp<java.lang.Boolean> r0 = com.applovin.impl.sdk.C0387dn.f779N
            goto L_0x004e
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C0413em.m1030a(com.applovin.impl.sdk.dp, com.applovin.impl.sdk.i):void");
    }

    /* renamed from: a */
    private boolean m1031a() {
        if (C0467x.m1289a("android.permission.INTERNET", this.f1044c)) {
            return true;
        }
        this.f1043b.userError("TaskInitializeSdk", "Unable to enable AppLovin SDK: no android.permission.INTERNET");
        return false;
    }

    /* renamed from: b */
    private void m1032b() {
        this.f1042a.mo4169a().mo4682a((C0386dm) new C0396dw(this.f1042a), C0416ep.MAIN, 500);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.applovin.impl.sdk.dp, com.applovin.impl.sdk.dp<java.lang.Boolean>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1033b(com.applovin.impl.sdk.C0389dp<java.lang.Boolean> r5, com.applovin.impl.sdk.C0452i r6) {
        /*
            r4 = this;
            com.applovin.impl.sdk.AppLovinSdkImpl r0 = r4.f1042a
            java.lang.Object r0 = r0.get(r5)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0020
            com.applovin.impl.sdk.AppLovinSdkImpl r0 = r4.f1042a
            com.applovin.impl.sdk.f r0 = r0.mo4172c()
            com.applovin.impl.sdk.h r1 = new com.applovin.impl.sdk.h
            com.applovin.sdk.AppLovinAdType r2 = com.applovin.sdk.AppLovinAdType.INCENTIVIZED
            com.applovin.sdk.AppLovinAdSize r3 = com.applovin.sdk.AppLovinAdSize.INTERSTITIAL
            r1.<init>(r2, r6, r3)
            r0.mo4473f(r1)
        L_0x0020:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C0413em.m1033b(com.applovin.impl.sdk.dp, com.applovin.impl.sdk.i):void");
    }

    /* renamed from: c */
    private void m1034c() {
        m1030a(C0387dn.f776K, C0452i.DIRECT);
        m1030a(C0387dn.f777L, C0452i.INDIRECT);
        m1035d();
    }

    /* renamed from: d */
    private void m1035d() {
        if (((Boolean) this.f1042a.get(C0387dn.f883bl)).booleanValue()) {
            this.f1042a.mo4175d().mo4473f(C0451h.f1142h);
        }
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f1043b.mo4779d("TaskInitializeSdk", "Initializing AppLovin SDK 7.4.1...");
        try {
            if (m1031a()) {
                C0394du b = this.f1042a.mo4171b();
                b.mo4625c();
                b.mo4626c("ad_imp_session");
                b.mo4624b("first_ad_shown_duration", -1);
                C0292a.m471b(this.f1042a);
                this.f1042a.getFileManager().mo4321d(this.f1044c);
                this.f1042a.getFileManager().mo4320c(this.f1044c);
                this.f1042a.getMediationService().mo4219a();
                m1034c();
                m1032b();
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f1044c);
                if (!AppLovinSdkUtils.isValidString((String) this.f1042a.get(C0392ds.f992a, null, defaultSharedPreferences))) {
                    this.f1042a.put(C0392ds.f992a, Boolean.toString(true), defaultSharedPreferences);
                }
                this.f1042a.getPersistentPostbackManager().mo4490a();
                this.f1042a.getEventService().trackEvent("landing");
                this.f1042a.mo4170a(true);
            } else {
                this.f1042a.mo4170a(false);
            }
            this.f1043b.mo4779d("TaskInitializeSdk", "AppLovin SDK 7.4.1 initialization " + (this.f1042a.isEnabled() ? "succeeded" : "failed") + " in " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        } catch (Throwable th) {
            Throwable th2 = th;
            this.f1043b.mo4779d("TaskInitializeSdk", "AppLovin SDK 7.4.1 initialization " + (this.f1042a.isEnabled() ? "succeeded" : "failed") + " in " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            throw th2;
        }
    }
}
