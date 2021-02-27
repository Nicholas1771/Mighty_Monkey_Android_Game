package com.applovin.impl.sdk;

import android.content.SharedPreferences;
import com.applovin.sdk.AppLovinLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.dd */
public class C0377dd {

    /* renamed from: a */
    private final AppLovinSdkImpl f732a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AppLovinLogger f733b;

    /* renamed from: c */
    private ArrayList<C0379df> f734c;

    /* renamed from: d */
    private ArrayList<C0379df> f735d;

    /* renamed from: e */
    private final Object f736e;

    /* renamed from: f */
    private final SharedPreferences f737f;

    C0377dd(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f732a = appLovinSdkImpl;
        this.f733b = appLovinSdkImpl.getLogger();
        this.f737f = appLovinSdkImpl.getApplicationContext().getSharedPreferences("com.applovin.sdk.impl.postbackQueue.domain", 0);
        this.f736e = new Object();
        this.f734c = m774c();
        this.f735d = new ArrayList<>();
    }

    /* renamed from: a */
    private void m770a(C0379df dfVar) {
        synchronized (this.f736e) {
            m773b(dfVar);
            m775c(dfVar);
        }
    }

    /* renamed from: b */
    private C0379df m771b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("attemptNumber");
            return new C0379df(jSONObject.getString("targetUrl"), C0329bj.m636a(jSONObject.getJSONObject("requestBody")), i, jSONObject.getString("backupUrl"));
        } catch (Exception e) {
            this.f733b.mo4786w("PersistentPostbackManager", "Unable to inflate postback request from JSON.", e);
            return null;
        }
    }

    /* renamed from: b */
    private void m773b(C0379df dfVar) {
        synchronized (this.f736e) {
            if (this.f734c.size() < ((Integer) this.f732a.get(C0387dn.f856bK)).intValue()) {
                this.f734c.add(dfVar);
                m776d();
                this.f733b.mo4779d("PersistentPostbackManager", "Enqueued postback: " + dfVar);
            } else {
                this.f733b.mo4785w("PersistentPostbackManager", "Persistent queue has reached maximum size; postback retried in memory only." + dfVar);
            }
        }
    }

    /* renamed from: c */
    private ArrayList<C0379df> m774c() {
        if (C0463t.m1252b()) {
            Set<String> set = (Set) this.f732a.get(C0392ds.f993b, new LinkedHashSet(0), this.f737f);
            ArrayList<C0379df> arrayList = new ArrayList<>(Math.max(1, set.size()));
            int intValue = ((Integer) this.f732a.get(C0387dn.f857bL)).intValue();
            this.f733b.mo4779d("PersistentPostbackManager", "Deserializing " + set.size() + " postback(s).");
            for (String str : set) {
                C0379df b = m771b(str);
                if (b == null) {
                    this.f733b.mo4780e("PersistentPostbackManager", "Unable to deserialize postback json: " + str);
                } else if (b.mo4498a() > intValue) {
                    arrayList.add(b);
                } else {
                    this.f733b.mo4779d("PersistentPostbackManager", "Skipping deserialization because maximum attempt count exceeded for postback: " + b);
                }
            }
            this.f733b.mo4779d("PersistentPostbackManager", "Successfully loaded postback queue with " + arrayList.size() + " postback(s).");
            return arrayList;
        }
        this.f733b.mo4779d("PersistentPostbackManager", "Loading new postback queue due to old Android version...");
        return new ArrayList<>();
    }

    /* renamed from: c */
    private void m775c(C0379df dfVar) {
        this.f733b.mo4779d("PersistentPostbackManager", "Preparing to submit postback..." + dfVar);
        synchronized (this.f736e) {
            dfVar.mo4499a(dfVar.mo4498a() + 1);
            m776d();
        }
        int intValue = ((Integer) this.f732a.get(C0387dn.f857bL)).intValue();
        if (dfVar.mo4498a() > intValue) {
            this.f733b.mo4785w("PersistentPostbackManager", "Exceeded maximum persisted attempt count of " + intValue + ". Dequeuing postback: " + dfVar);
            m777d(dfVar);
            return;
        }
        this.f732a.getPostbackService().dispatchPostbackAsync(dfVar.mo4500b(), dfVar.mo4502d(), dfVar.mo4501c(), new C0378de(this, dfVar));
    }

    /* renamed from: d */
    private void m776d() {
        if (C0463t.m1255c()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.f734c.size());
            Iterator<C0379df> it = this.f734c.iterator();
            while (it.hasNext()) {
                String f = m779f(it.next());
                if (f != null) {
                    linkedHashSet.add(f);
                }
            }
            this.f732a.put(C0392ds.f993b, linkedHashSet);
            this.f733b.mo4779d("PersistentPostbackManager", "Wrote updated postback queue to disk.");
            return;
        }
        this.f733b.mo4779d("PersistentPostbackManager", "Skipping writing postback queue to disk due to old Android version...");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m777d(C0379df dfVar) {
        synchronized (this.f736e) {
            this.f734c.remove(dfVar);
            m776d();
        }
        this.f733b.mo4779d("PersistentPostbackManager", "Dequeued successfully transmitted postback: " + dfVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m778e(C0379df dfVar) {
        synchronized (this.f736e) {
            this.f735d.add(dfVar);
        }
    }

    /* renamed from: f */
    private String m779f(C0379df dfVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("attemptNumber", dfVar.mo4498a());
            jSONObject.put("targetUrl", dfVar.mo4500b());
            String c = dfVar.mo4501c();
            if (C0444fq.isValidString(c)) {
                jSONObject.put("backupUrl", c);
            }
            Map<String, String> d = dfVar.mo4502d();
            if (d != null) {
                jSONObject.put("requestBody", new JSONObject(d));
            }
            return jSONObject.toString();
        } catch (Exception e) {
            this.f733b.mo4786w("PersistentPostbackManager", "Unable to serialize postback request to JSON.", e);
            return null;
        }
    }

    /* renamed from: a */
    public void mo4490a() {
        synchronized (this.f736e) {
            if (this.f734c != null) {
                for (C0379df c : new ArrayList(this.f734c)) {
                    m775c(c);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo4491a(String str) {
        mo4492a(str, (Map<String, String>) null);
    }

    /* renamed from: a */
    public void mo4492a(String str, Map<String, String> map) {
        mo4493a(str, map, true);
    }

    /* renamed from: a */
    public void mo4493a(String str, Map<String, String> map, boolean z) {
        mo4494a(str, map, z, (String) null);
    }

    /* renamed from: a */
    public void mo4494a(String str, Map<String, String> map, boolean z, String str2) {
        if (C0444fq.isValidString(str)) {
            if (z) {
                String str3 = "&postback_ts=" + System.currentTimeMillis();
                str = str + str3;
                if (C0444fq.isValidString(str2)) {
                    str2 = str2 + str3;
                }
            }
            m770a(new C0379df(str, map, 0, str2));
        }
    }

    /* renamed from: b */
    public void mo4495b() {
        synchronized (this.f736e) {
            Iterator<C0379df> it = this.f735d.iterator();
            while (it.hasNext()) {
                m775c(it.next());
            }
            this.f735d.clear();
        }
    }
}
