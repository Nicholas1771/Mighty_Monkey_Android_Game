package com.applovin.impl.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkSettings;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.dq */
class C0390dq {

    /* renamed from: a */
    private final AppLovinSdkImpl f986a;

    /* renamed from: b */
    private final AppLovinLogger f987b;

    /* renamed from: c */
    private final Context f988c;

    /* renamed from: d */
    private final SharedPreferences f989d;

    /* renamed from: e */
    private final Object[] f990e = new Object[C0387dn.m831b()];

    C0390dq(AppLovinSdkImpl appLovinSdkImpl) {
        this.f986a = appLovinSdkImpl;
        this.f987b = appLovinSdkImpl.getLogger();
        this.f988c = appLovinSdkImpl.getApplicationContext();
        this.f989d = this.f988c.getSharedPreferences("com.applovin.sdk.1", 0);
    }

    /* renamed from: a */
    private static C0389dp<?> m836a(String str) {
        for (C0389dp<?> next : C0387dn.m830a()) {
            if (next.mo4531b().equals(str)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static Object m837a(String str, JSONObject jSONObject, Object obj) throws JSONException {
        if (obj instanceof Boolean) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        if (obj instanceof Float) {
            return Float.valueOf((float) jSONObject.getDouble(str));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        if (obj instanceof Long) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        if (obj instanceof String) {
            return jSONObject.getString(str);
        }
        throw new RuntimeException("SDK Error: unknown value type: " + obj.getClass());
    }

    /* renamed from: d */
    private String m838d() {
        return "com.applovin.sdk." + C0444fq.m1157a(this.f986a.getSdkKey()) + ".";
    }

    /* renamed from: a */
    public <T> T mo4534a(C0389dp<T> dpVar) {
        T c;
        if (dpVar == null) {
            throw new IllegalArgumentException("No setting type specified");
        }
        synchronized (this.f990e) {
            try {
                Object obj = this.f990e[dpVar.mo4529a()];
                c = obj != null ? dpVar.mo4530a(obj) : dpVar.mo4532c();
            } catch (Throwable th) {
                this.f986a.getLogger().mo4780e("SettingsManager", "Unable to retrieve value for setting " + dpVar.mo4531b() + "; using default...");
                c = dpVar.mo4532c();
            }
        }
        return c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4535a() {
        if (this.f988c == null) {
            throw new IllegalArgumentException("No context specified");
        }
        this.f987b.mo4782i("SettingsManager", "Saving settings with the application...");
        String d = m838d();
        synchronized (this.f990e) {
            for (C0389dp next : C0387dn.m830a()) {
                Object obj = this.f990e[next.mo4529a()];
                if (obj != null) {
                    this.f986a.put(d + next.mo4531b(), obj, this.f989d);
                }
            }
        }
        this.f987b.mo4779d("SettingsManager", "Settings saved with the application.");
    }

    /* renamed from: a */
    public <T> void mo4536a(C0389dp<?> dpVar, Object obj) {
        if (dpVar == null) {
            throw new IllegalArgumentException("No setting type specified");
        } else if (obj == null) {
            throw new IllegalArgumentException("No new value specified");
        } else {
            synchronized (this.f990e) {
                this.f990e[dpVar.mo4529a()] = obj;
            }
            this.f987b.mo4779d("SettingsManager", "Setting update: " + dpVar.mo4531b() + " set to \"" + obj + "\"");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4537a(AppLovinSdkSettings appLovinSdkSettings) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        long j = 0;
        boolean z6 = false;
        this.f987b.mo4782i("SettingsManager", "Loading user-defined settings...");
        if (appLovinSdkSettings != null) {
            synchronized (this.f990e) {
                this.f990e[C0387dn.f964i.mo4529a()] = Boolean.valueOf(appLovinSdkSettings.isVerboseLoggingEnabled());
                long bannerAdRefreshSeconds = appLovinSdkSettings.getBannerAdRefreshSeconds();
                if (bannerAdRefreshSeconds >= 0) {
                    if (bannerAdRefreshSeconds > 0) {
                        j = Math.max(30, bannerAdRefreshSeconds);
                    }
                    this.f990e[C0387dn.f766A.mo4529a()] = Long.valueOf(j);
                    this.f990e[C0387dn.f981z.mo4529a()] = true;
                } else if (bannerAdRefreshSeconds == -1) {
                    this.f990e[C0387dn.f981z.mo4529a()] = false;
                }
                String autoPreloadSizes = appLovinSdkSettings.getAutoPreloadSizes();
                if (!C0444fq.isValidString(autoPreloadSizes)) {
                    autoPreloadSizes = "NONE";
                }
                if (autoPreloadSizes.equals("NONE")) {
                    this.f990e[C0387dn.f776K.mo4529a()] = "";
                    this.f990e[C0387dn.f777L.mo4529a()] = "";
                } else {
                    this.f990e[C0387dn.f776K.mo4529a()] = autoPreloadSizes;
                    this.f990e[C0387dn.f777L.mo4529a()] = autoPreloadSizes;
                }
                String autoPreloadTypes = appLovinSdkSettings.getAutoPreloadTypes();
                if (!C0444fq.isValidString(autoPreloadTypes)) {
                    autoPreloadTypes = "NONE";
                }
                if (!"NONE".equals(autoPreloadTypes)) {
                    z2 = false;
                    z = false;
                    for (String next : C0462s.m1246a(autoPreloadTypes)) {
                        if (next.equals(AppLovinAdType.REGULAR.getLabel())) {
                            z3 = z6;
                            z5 = z2;
                            z4 = true;
                        } else if (next.equals(AppLovinAdType.INCENTIVIZED.getLabel()) || next.contains("INCENT") || next.contains("REWARD")) {
                            z3 = z6;
                            z4 = z;
                            z5 = true;
                        } else if (next.equals(AppLovinAdType.NATIVE.getLabel())) {
                            z3 = true;
                            z5 = z2;
                            z4 = z;
                        } else {
                            z3 = z6;
                            z5 = z2;
                            z4 = z;
                        }
                        z = z4;
                        z2 = z5;
                        z6 = z3;
                    }
                } else {
                    z2 = false;
                    z = false;
                }
                if (!z) {
                    this.f990e[C0387dn.f776K.mo4529a()] = "";
                    this.f990e[C0387dn.f777L.mo4529a()] = "";
                }
                this.f990e[C0387dn.f778M.mo4529a()] = Boolean.valueOf(z2);
                this.f990e[C0387dn.f779N.mo4529a()] = Boolean.valueOf(z2);
                this.f990e[C0387dn.f883bl.mo4529a()] = Boolean.valueOf(z6);
                if (appLovinSdkSettings instanceof C0328bi) {
                    for (Map.Entry next2 : ((C0328bi) appLovinSdkSettings).mo4377b().entrySet()) {
                        this.f990e[((C0389dp) next2.getKey()).mo4529a()] = next2.getValue();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4538a(JSONObject jSONObject) {
        this.f987b.mo4779d("SettingsManager", "Loading settings from JSON array...");
        synchronized (this.f990e) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && next.length() > 0) {
                    try {
                        C0389dp<?> a = m836a(next);
                        if (a != null) {
                            Object a2 = m837a(next, jSONObject, a.mo4532c());
                            this.f990e[a.mo4529a()] = a2;
                            this.f987b.mo4779d("SettingsManager", "Setting update: " + a.mo4531b() + " set to \"" + a2 + "\"");
                        } else {
                            this.f987b.mo4785w("SettingsManager", "Unknown setting recieved: " + next);
                        }
                    } catch (JSONException e) {
                        this.f987b.mo4781e("SettingsManager", "Unable to parse JSON settings array", e);
                    } catch (Throwable th) {
                        this.f987b.mo4781e("SettingsManager", "Unable to convert setting object ", th);
                    }
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.applovin.impl.sdk.dp, com.applovin.impl.sdk.dp<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> mo4539b(com.applovin.impl.sdk.C0389dp<java.lang.String> r2) {
        /*
            r1 = this;
            java.lang.Object r0 = r1.mo4534a(r2)
            java.lang.String r0 = (java.lang.String) r0
            java.util.List r0 = com.applovin.impl.sdk.C0462s.m1246a(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C0390dq.mo4539b(com.applovin.impl.sdk.dp):java.util.List");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4540b() {
        if (this.f988c == null) {
            throw new IllegalArgumentException("No context specified");
        }
        this.f987b.mo4782i("SettingsManager", "Loading settings saved with the application...");
        String d = m838d();
        synchronized (this.f990e) {
            for (C0389dp next : C0387dn.m830a()) {
                try {
                    String str = d + next.mo4531b();
                    Object c = next.mo4532c();
                    Object obj = this.f986a.get(str, c, c.getClass(), this.f989d);
                    if (obj != null) {
                        this.f990e[next.mo4529a()] = obj;
                    } else {
                        this.f987b.mo4780e("SettingsManager", "Unable to find value for setting: " + str);
                    }
                } catch (Exception e) {
                    this.f987b.mo4781e("SettingsManager", "Unable to load \"" + next.mo4531b() + "\"", e);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo4541c() {
        synchronized (this.f990e) {
            Arrays.fill(this.f990e, (Object) null);
        }
        this.f986a.clear(this.f989d);
    }
}
