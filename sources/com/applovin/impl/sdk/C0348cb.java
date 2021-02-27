package com.applovin.impl.sdk;

import com.applovin.mediation.AppLovinMediationAdapterConfig;
import com.applovin.sdk.AppLovinLogger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.cb */
class C0348cb implements AppLovinMediationAdapterConfig {

    /* renamed from: a */
    private final AppLovinSdkImpl f637a;

    /* renamed from: b */
    private final AppLovinLogger f638b;

    /* renamed from: c */
    private final String f639c;

    /* renamed from: d */
    private final String f640d;

    /* renamed from: e */
    private final Object f641e = new Object();

    /* renamed from: f */
    private Map<String, String> f642f;

    /* renamed from: g */
    private final Set<String> f643g = new HashSet(5);

    /* renamed from: h */
    private final Map<String, String> f644h = new HashMap(5);

    C0348cb(String str, AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (str == null) {
            throw new IllegalArgumentException("No classname specified");
        } else {
            this.f637a = appLovinSdkImpl;
            this.f638b = appLovinSdkImpl.getLogger();
            this.f639c = str.toLowerCase();
            this.f640d = "applovin.mediation." + str + ":config";
        }
    }

    /* renamed from: a */
    private Map<String, String> m664a() {
        Throwable th;
        Map<String, String> map;
        try {
            String str = (String) this.f637a.get(new C0392ds(this.f640d, String.class));
            if (str == null || str.isEmpty()) {
                this.f638b.mo4779d("MediationAdapterConfigWrapper", "Last known config for '" + this.f639c + "' is missing");
                return null;
            }
            map = C0329bj.m636a(new JSONObject(str));
            try {
                this.f638b.mo4779d("MediationAdapterConfigWrapper", "Last known config for '" + this.f639c + "' is: " + map);
                return map;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            map = null;
            th = th4;
            this.f638b.mo4781e("MediationAdapterConfigWrapper", "Unable to load the last known configuration for " + this.f639c, th);
            return map;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4397a(Map<String, String> map) {
        synchronized (this.f641e) {
            if (map != null) {
                if (!map.isEmpty()) {
                    this.f642f = map;
                    mo4398b(map);
                }
            }
            this.f642f = m664a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4398b(Map<String, String> map) {
        if (map != null) {
            try {
                String jSONObject = C0329bj.m637a(map).toString();
                this.f637a.put(new C0392ds(this.f640d, String.class), jSONObject);
                synchronized (this.f641e) {
                    this.f642f = map;
                }
            } catch (Throwable th) {
                this.f638b.mo4781e("MediationAdapterConfigWrapper", "Unable to save the last known configuration for " + this.f639c, th);
            }
        }
    }

    public Boolean getBoolean(String str, Boolean bool) {
        if (str == null) {
            throw new IllegalArgumentException("No key specified");
        }
        String string = getString(str, (String) null);
        return string != null ? Boolean.valueOf(Boolean.parseBoolean(string)) : bool;
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false).booleanValue();
    }

    public int getInt(String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException("No key specified");
        }
        String string = getString(str, (String) null);
        if (string == null || !C0444fq.m1173d(string)) {
            return i;
        }
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            this.f638b.mo4786w("MediationAdapterConfigWrapper", "Unable to parse int for " + str, e);
            return i;
        }
    }

    public long getLong(String str, long j) {
        if (str == null) {
            throw new IllegalArgumentException("No key specified");
        }
        String string = getString(str, (String) null);
        if (string == null) {
            return j;
        }
        try {
            String trim = string.replace("L", "").trim();
            return C0444fq.m1173d(trim) ? Long.parseLong(trim) : j;
        } catch (NumberFormatException e) {
            this.f638b.mo4786w("MediationAdapterConfigWrapper", "Unable to parse long for " + str, e);
            return j;
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getString(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            if (r7 != 0) goto L_0x000a
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No key specified"
            r0.<init>(r1)
            throw r0
        L_0x000a:
            java.lang.Object r1 = r6.f641e
            monitor-enter(r1)
            java.util.Map<java.lang.String, java.lang.String> r0 = r6.f642f     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x0023
            java.util.Map<java.lang.String, java.lang.String> r0 = r6.f642f     // Catch:{ all -> 0x0054 }
            boolean r0 = r0.containsKey(r7)     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x0023
            java.util.Map<java.lang.String, java.lang.String> r0 = r6.f642f     // Catch:{ all -> 0x0054 }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ all -> 0x0054 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0054 }
            monitor-exit(r1)     // Catch:{ all -> 0x0054 }
        L_0x0022:
            return r0
        L_0x0023:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0054 }
            r0.<init>()     // Catch:{ all -> 0x0054 }
            java.lang.String r2 = "applovin.mediation."
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0054 }
            java.lang.String r2 = r6.f639c     // Catch:{ all -> 0x0054 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0054 }
            java.lang.String r2 = ":"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0054 }
            java.lang.StringBuilder r0 = r0.append(r7)     // Catch:{ all -> 0x0054 }
            java.lang.String r2 = r0.toString()     // Catch:{ all -> 0x0054 }
            java.util.Map<java.lang.String, java.lang.String> r0 = r6.f644h     // Catch:{ all -> 0x0054 }
            boolean r0 = r0.containsKey(r2)     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x0057
            java.util.Map<java.lang.String, java.lang.String> r0 = r6.f644h     // Catch:{ all -> 0x0054 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0054 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0054 }
            monitor-exit(r1)     // Catch:{ all -> 0x0054 }
            goto L_0x0022
        L_0x0054:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0054 }
            throw r0
        L_0x0057:
            java.util.Set<java.lang.String> r0 = r6.f643g     // Catch:{ all -> 0x0054 }
            boolean r0 = r0.contains(r2)     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x0062
            monitor-exit(r1)     // Catch:{ all -> 0x0054 }
            r0 = r8
            goto L_0x0022
        L_0x0062:
            com.applovin.impl.sdk.AppLovinSdkImpl r0 = r6.f637a     // Catch:{ Throwable -> 0x009b }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ Throwable -> 0x009b }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ Throwable -> 0x009b }
            com.applovin.impl.sdk.AppLovinSdkImpl r3 = r6.f637a     // Catch:{ Throwable -> 0x009b }
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ Throwable -> 0x009b }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ Throwable -> 0x009b }
            r4 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r3, r4)     // Catch:{ Throwable -> 0x009b }
            android.os.Bundle r3 = r0.metaData     // Catch:{ Throwable -> 0x009b }
            if (r3 == 0) goto L_0x0098
            android.os.Bundle r0 = r0.metaData     // Catch:{ Throwable -> 0x009b }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Throwable -> 0x009b }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Throwable -> 0x009b }
            if (r0 == 0) goto L_0x0093
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.f644h     // Catch:{ Throwable -> 0x009b }
            r3.put(r2, r0)     // Catch:{ Throwable -> 0x009b }
            monitor-exit(r1)     // Catch:{ all -> 0x0054 }
            goto L_0x0022
        L_0x0093:
            java.util.Set<java.lang.String> r0 = r6.f643g     // Catch:{ Throwable -> 0x009b }
            r0.add(r2)     // Catch:{ Throwable -> 0x009b }
        L_0x0098:
            monitor-exit(r1)     // Catch:{ all -> 0x0054 }
            r0 = r8
            goto L_0x0022
        L_0x009b:
            r0 = move-exception
            com.applovin.sdk.AppLovinLogger r2 = r6.f638b     // Catch:{ all -> 0x0054 }
            java.lang.String r3 = "MediationAdapterConfigWrapper"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0054 }
            r4.<init>()     // Catch:{ all -> 0x0054 }
            java.lang.String r5 = "Unable to load "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x0054 }
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch:{ all -> 0x0054 }
            java.lang.String r5 = "from AndroidManifest.xml"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x0054 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0054 }
            r2.mo4781e(r3, r4, r0)     // Catch:{ all -> 0x0054 }
            goto L_0x0098
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C0348cb.getString(java.lang.String, java.lang.String):java.lang.String");
    }
}
