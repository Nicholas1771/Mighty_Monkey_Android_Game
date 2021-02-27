package com.applovin.impl.sdk;

import android.content.pm.ApplicationInfo;
import com.applovin.mediation.AppLovinMediationAdapter;
import com.applovin.sdk.AppLovinLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.cc */
class C0349cc {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Map<String, String> f645a = new HashMap();

    /* renamed from: b */
    private final AppLovinSdkImpl f646b;

    /* renamed from: c */
    private final AppLovinLogger f647c;

    /* renamed from: d */
    private final Object f648d = new Object();

    /* renamed from: e */
    private final Map<String, C0351ce> f649e = new HashMap();

    /* renamed from: f */
    private final Collection<String> f650f = new HashSet();

    /* renamed from: g */
    private final Collection<C0350cd> f651g = new HashSet();

    static {
        f645a.put("chartboost", "com.applovin.mediation.impl.AppLovinChartboostMediationAdapter");
        f645a.put("facebook", "com.applovin.mediation.impl.AppLovinFacebookMediationAdapter");
        f645a.put("google", "com.applovin.mediation.impl.AppLovinGoogleMediationAdapter");
        f645a.put("heyzap", "com.applovin.mediation.impl.AppLovinHeyzapMediationAdapter");
        f645a.put("inmobi", "com.applovin.mediation.impl.AppLovinInMobiMediationAdapter");
        f645a.put("mopub", "com.applovin.mediation.impl.AppLovinMoPubMediationAdapter");
        f645a.put("ironsource", "com.applovin.mediation.impl.AppLovinIronSourceMediationAdapter");
        f645a.put("vungle", "com.applovin.mediation.impl.AppLovinVungleMediationAdapter");
        f645a.put("unity", "com.applovin.mediation.impl.AppLovinUnityMediationAdapter");
    }

    C0349cc(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f646b = appLovinSdkImpl;
        this.f647c = appLovinSdkImpl.getLogger();
    }

    /* renamed from: a */
    private C0351ce m667a(C0350cd cdVar, Map<String, String> map) {
        if (cdVar == null) {
            throw new IllegalArgumentException("No adapter spec specified");
        }
        synchronized (this.f648d) {
            String a = cdVar.mo4409a();
            if (this.f650f.contains(a)) {
                this.f647c.mo4779d("MediationAdapterManager", "Not attempting to load " + cdVar + " due to prior errors");
                return null;
            } else if (this.f649e.containsKey(a)) {
                C0351ce ceVar = this.f649e.get(a);
                return ceVar;
            } else {
                C0351ce b = m670b(cdVar, map);
                if (b != null) {
                    this.f647c.mo4779d("MediationAdapterManager", "Loaded " + cdVar);
                    this.f649e.put(a, b);
                    return b;
                }
                this.f647c.mo4780e("MediationAdapterManager", "Failed to load " + cdVar);
                this.f650f.add(a);
                return null;
            }
        }
    }

    /* renamed from: a */
    private String m668a(String str) {
        if (!C0444fq.isValidString(str)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = this.f646b.getApplicationContext().getPackageManager().getApplicationInfo(this.f646b.getApplicationContext().getPackageName(), 128);
            Collection<C0350cd> b = C0350cd.m682b(applicationInfo.metaData.getString("applovin.mediation:load"), this.f647c);
            if (!b.isEmpty()) {
                for (C0350cd next : b) {
                    if (next.mo4410b().equalsIgnoreCase(str) && C0444fq.isValidString(next.mo4409a())) {
                        return next.mo4409a();
                    }
                }
            }
            return applicationInfo.metaData.getString("applovin.mediation." + str + ":" + "class");
        } catch (Throwable th) {
            this.f647c.mo4781e("MediationAdapterManager", "Unable to retrieve classname from Android Manifest for adapter name: " + str, th);
            return null;
        }
    }

    /* renamed from: a */
    private void m669a(Collection<C0350cd> collection, String str) {
        for (C0350cd next : collection) {
            C0351ce a = mo4404a(next.mo4410b(), next.mo4409a(), (Map<String, String>) null);
            if (a != null) {
                this.f647c.mo4782i("MediationAdapterManager", "Loaded " + str + " adapter: " + a);
            }
        }
    }

    /* renamed from: b */
    private C0351ce m670b(C0350cd cdVar, Map<String, String> map) {
        try {
            Class<?> cls = Class.forName(cdVar.mo4409a());
            if (cls != null) {
                Object newInstance = cls.newInstance();
                if (newInstance instanceof AppLovinMediationAdapter) {
                    C0351ce ceVar = new C0351ce(cdVar.mo4410b(), (AppLovinMediationAdapter) newInstance, this.f646b);
                    ceVar.mo4420a(map);
                    if (ceVar.mo4421b()) {
                        return ceVar;
                    }
                    this.f647c.userError("MediationAdapterManager", "Failed to initialize " + cdVar);
                    return null;
                }
                this.f647c.userError("MediationAdapterManager", cdVar + " error: not an instance of '" + AppLovinMediationAdapter.class.getName() + "'.");
                return null;
            }
            this.f647c.userError("MediationAdapterManager", "No class found for " + cdVar);
            return null;
        } catch (Throwable th) {
            this.f647c.userError("MediationAdapterManager", "Failed to load: " + cdVar, th);
            return null;
        }
    }

    /* renamed from: e */
    private Collection<C0350cd> m672e() {
        try {
            ApplicationInfo applicationInfo = this.f646b.getApplicationContext().getPackageManager().getApplicationInfo(this.f646b.getApplicationContext().getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                return Collections.emptyList();
            }
            String string = applicationInfo.metaData.getString("applovin.mediation:load");
            Collection<C0350cd> b = C0350cd.m682b(string, this.f647c);
            if (b == null || b.isEmpty()) {
                this.f647c.mo4779d("MediationAdapterManager", "No adapter specs found in: '" + string + "'");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(b.size());
            for (C0350cd next : b) {
                if (!C0444fq.isValidString(next.mo4410b())) {
                    this.f647c.userError("MediationAdapterManager", "Ignored loading of adapter with class " + next.mo4409a() + ": no name specified");
                } else if (C0444fq.isValidString(next.mo4409a())) {
                    arrayList.add(next);
                } else {
                    String string2 = applicationInfo.metaData.getString("applovin.mediation." + next.mo4410b() + ":" + "class");
                    if (C0444fq.isValidString(string2)) {
                        arrayList.add(new C0350cd(next.mo4410b(), string2));
                    } else {
                        String str = f645a.get(next.mo4410b());
                        if (C0444fq.isValidString(str)) {
                            arrayList.add(new C0350cd(next.mo4410b(), str));
                        } else {
                            this.f647c.userError("MediationAdapterManager", "Ignored loading of " + next.mo4410b() + ": no default adapter class found");
                        }
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            this.f647c.userError("MediationAdapterManager", "Unable to load applovin.mediation:loadfrom AndroidManifest.xml", th);
            return Collections.emptyList();
        }
    }

    /* renamed from: f */
    private Collection<C0350cd> m673f() {
        return C0350cd.m682b((String) this.f646b.get(C0392ds.f998g), this.f647c);
    }

    /* renamed from: g */
    private void m674g() {
        String a;
        synchronized (this.f648d) {
            a = C0350cd.m681a(this.f651g);
        }
        this.f646b.put(C0392ds.f998g, a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0351ce mo4404a(String str, String str2, Map<String, String> map) {
        String a;
        if (!C0444fq.isValidString(str)) {
            this.f647c.mo4780e("MediationAdapterManager", "No adapter name provided for " + str2 + ", not loading the adapter ");
            return null;
        }
        if (C0444fq.isValidString(str2)) {
            this.f647c.mo4779d("MediationAdapterManager", "Loading adapter using explicit classname: " + str2);
            a = str2;
        } else if (map == null || !map.containsKey("class")) {
            a = m668a(str);
            if (!C0444fq.isValidString(a)) {
                a = f645a.get(str.toLowerCase());
                if (C0444fq.isValidString(a)) {
                    this.f647c.mo4779d("MediationAdapterManager", "Loading '" + str + "' adapter using resolved default classname: " + a);
                } else {
                    this.f647c.mo4785w("MediationAdapterManager", "Unable to find default classname for '" + str + "'");
                    return null;
                }
            }
        } else {
            a = map.get("class");
            if (C0444fq.isValidString(a)) {
                this.f647c.mo4779d("MediationAdapterManager", "Loading '" + str + "' adapter using configured classname: " + a);
            } else {
                this.f647c.mo4785w("MediationAdapterManager", "Invalid configured classname for '" + str + "'");
                return null;
            }
        }
        return m667a(new C0350cd(str, a), map);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4405a() {
        synchronized (this.f648d) {
            if (((Boolean) this.f646b.get(C0387dn.f953db)).booleanValue()) {
                m669a(m673f(), "last used");
            }
            if (((Boolean) this.f646b.get(C0387dn.f954dc)).booleanValue()) {
                m669a(m672e(), "AndroidManifest");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4406a(C0351ce ceVar) {
        if (ceVar != null) {
            C0350cd cdVar = new C0350cd(ceVar.mo4415a(), ceVar.mo4425f());
            synchronized (this.f648d) {
                if (!this.f651g.contains(cdVar)) {
                    this.f651g.add(cdVar);
                    m674g();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Collection<String> mo4407b() {
        ArrayList arrayList;
        synchronized (this.f648d) {
            arrayList = new ArrayList(this.f650f);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Collection<C0351ce> mo4408c() {
        ArrayList arrayList;
        synchronized (this.f648d) {
            arrayList = new ArrayList(this.f649e.values());
        }
        return arrayList;
    }
}
