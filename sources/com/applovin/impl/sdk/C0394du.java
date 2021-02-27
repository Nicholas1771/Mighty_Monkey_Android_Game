package com.applovin.impl.sdk;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.du */
class C0394du {

    /* renamed from: a */
    private final AppLovinSdkImpl f1006a;

    /* renamed from: b */
    private final Map<String, Long> f1007b = new HashMap();

    C0394du(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f1006a = appLovinSdkImpl;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4619a() {
        synchronized (this.f1007b) {
            this.f1007b.clear();
        }
        mo4627d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4620a(String str) {
        mo4621a(str, 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4621a(String str, long j) {
        synchronized (this.f1007b) {
            Long l = this.f1007b.get(str);
            if (l == null) {
                l = 0L;
            }
            this.f1007b.put(str, Long.valueOf(l.longValue() + j));
        }
        mo4627d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public long mo4622b(String str) {
        long longValue;
        synchronized (this.f1007b) {
            Long l = this.f1007b.get(str);
            if (l == null) {
                l = 0L;
            }
            longValue = l.longValue();
        }
        return longValue;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public JSONObject mo4623b() throws JSONException {
        JSONObject jSONObject;
        synchronized (this.f1007b) {
            jSONObject = new JSONObject();
            for (Map.Entry next : this.f1007b.entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4624b(String str, long j) {
        synchronized (this.f1007b) {
            this.f1007b.put(str, Long.valueOf(j));
        }
        mo4627d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo4625c() {
        try {
            JSONObject jSONObject = new JSONObject((String) this.f1006a.get(C0392ds.f997f, "{}"));
            synchronized (this.f1007b) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String next = keys.next();
                        this.f1007b.put(next, Long.valueOf(jSONObject.getLong(next)));
                    } catch (JSONException e) {
                    }
                }
            }
        } catch (Throwable th) {
            this.f1006a.getLogger().mo4781e("StatsManager", "Unable to load stats", th);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo4626c(String str) {
        synchronized (this.f1007b) {
            this.f1007b.remove(str);
        }
        mo4627d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo4627d() {
        try {
            this.f1006a.put(C0392ds.f997f, mo4623b().toString());
        } catch (Throwable th) {
            this.f1006a.getLogger().mo4781e("StatsManager", "Unable to save stats", th);
        }
    }
}
