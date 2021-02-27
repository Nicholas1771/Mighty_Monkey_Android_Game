package com.applovin.impl.p003a;

import android.net.Uri;
import com.applovin.impl.sdk.C0296ad;
import com.applovin.impl.sdk.C0329bj;
import com.applovin.impl.sdk.C0391dr;
import com.applovin.impl.sdk.C0444fq;
import com.applovin.impl.sdk.C0462s;
import com.applovin.sdk.AppLovinSdk;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.a.a */
public class C0180a extends C0296ad {

    /* renamed from: e */
    private final String f32e;

    /* renamed from: f */
    private final String f33f;

    /* renamed from: g */
    private final C0190k f34g;

    /* renamed from: h */
    private final C0194o f35h;

    /* renamed from: i */
    private final C0185f f36i;

    /* renamed from: j */
    private final Set<C0191l> f37j;

    /* renamed from: k */
    private final Set<C0191l> f38k;

    private C0180a(C0182c cVar) {
        super(cVar.f39a, cVar.f40b, cVar.f41c, cVar.f42d);
        this.f32e = cVar.f43e;
        this.f34g = cVar.f45g;
        this.f33f = cVar.f44f;
        this.f35h = cVar.f46h;
        this.f36i = cVar.f47i;
        this.f37j = cVar.f48j;
        this.f38k = cVar.f49k;
    }

    /* renamed from: Y */
    private C0196q m25Y() {
        C0196q[] a = C0196q.m124a();
        int W = new C0391dr(this.f1154d).mo4564W();
        return (W < 0 || W >= a.length) ? C0196q.UNSPECIFIED : a[W];
    }

    /* renamed from: Z */
    private Set<C0191l> m26Z() {
        return this.f35h != null ? this.f35h.mo3922c() : Collections.emptySet();
    }

    /* renamed from: a */
    private Set<C0191l> m27a(C0183d dVar, String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return Collections.emptySet();
        }
        Map<String, Set<C0191l>> d = (dVar != C0183d.VIDEO || this.f35h == null) ? (dVar != C0183d.COMPANION_AD || this.f36i == null) ? null : this.f36i.mo3890d() : this.f35h.mo3923d();
        HashSet hashSet = new HashSet();
        if (d != null && !d.isEmpty()) {
            for (String str : strArr) {
                if (d.containsKey(str)) {
                    hashSet.addAll(d.get(str));
                }
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: aa */
    private Set<C0191l> m28aa() {
        return this.f36i != null ? this.f36i.mo3889c() : Collections.emptySet();
    }

    /* renamed from: k */
    public static C0182c m29k() {
        return new C0182c();
    }

    /* renamed from: a */
    public C0194o mo3855a() {
        return this.f35h;
    }

    /* renamed from: a */
    public String mo3856a(String str) {
        try {
            String a = C0329bj.m634a(this.f1152b, "vimp_url", "", (AppLovinSdk) this.f1154d);
            if (C0444fq.isValidString(a)) {
                String replace = a.replace("{CLCODE}", C0444fq.m1172c(mo4291l()));
                return (C0444fq.isValidString(str) ? replace.replace("{PLACEMENT}", C0444fq.m1172c(str)) : replace.replace("{PLACEMENT}", "")).toString();
            }
        } catch (Throwable th) {
            this.f1154d.getLogger().mo4781e("VastAd", "Unable to create VAST impression URL", th);
        }
        return "";
    }

    /* renamed from: a */
    public Set<C0191l> mo3857a(C0184e eVar, String str) {
        return mo3858a(eVar, new String[]{str});
    }

    /* renamed from: a */
    public Set<C0191l> mo3858a(C0184e eVar, String[] strArr) {
        this.f1154d.getLogger().mo4779d("VastAd", "Retrieving trackers of type '" + eVar + "' and events '" + strArr + "'...");
        if (eVar == C0184e.IMPRESSION) {
            return this.f37j;
        }
        if (eVar == C0184e.VIDEO_CLICK) {
            return m26Z();
        }
        if (eVar == C0184e.COMPANION_CLICK) {
            return m28aa();
        }
        if (eVar == C0184e.VIDEO) {
            return m27a(C0183d.VIDEO, strArr);
        }
        if (eVar == C0184e.COMPANION) {
            return m27a(C0183d.COMPANION_AD, strArr);
        }
        if (eVar == C0184e.ERROR) {
            return this.f38k;
        }
        this.f1154d.getLogger().mo4780e("VastAd", "Failed to retrieve trackers of invalid type '" + eVar + "' and events '" + strArr + "'");
        return Collections.emptySet();
    }

    /* renamed from: a */
    public boolean mo3859a(AppLovinSdk appLovinSdk) {
        return C0329bj.m632a(this.f1152b, "cache_companion_ad", (Boolean) true, appLovinSdk).booleanValue();
    }

    /* renamed from: b */
    public boolean mo3860b() {
        C0197r c = mo3862c();
        if (c != null) {
            return c.mo3932c();
        }
        return false;
    }

    /* renamed from: b */
    public boolean mo3861b(AppLovinSdk appLovinSdk) {
        return C0329bj.m632a(this.f1152b, "cache_video", (Boolean) true, appLovinSdk).booleanValue();
    }

    /* renamed from: c */
    public C0197r mo3862c() {
        if (this.f35h != null) {
            return this.f35h.mo3919a(m25Y());
        }
        return null;
    }

    /* renamed from: c */
    public void mo3863c(String str) {
        try {
            this.f1152b.put("html_template", str);
        } catch (Throwable th) {
        }
    }

    /* renamed from: d */
    public Uri mo3864d() {
        C0197r c = mo3862c();
        if (c != null) {
            return c.mo3931b();
        }
        return null;
    }

    /* renamed from: e */
    public C0185f mo3865e() {
        return this.f36i;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0180a) || !super.equals(obj)) {
            return false;
        }
        C0180a aVar = (C0180a) obj;
        if (this.f32e != null) {
            if (!this.f32e.equals(aVar.f32e)) {
                return false;
            }
        } else if (aVar.f32e != null) {
            return false;
        }
        if (this.f33f != null) {
            if (!this.f33f.equals(aVar.f33f)) {
                return false;
            }
        } else if (aVar.f33f != null) {
            return false;
        }
        if (this.f34g != null) {
            if (!this.f34g.equals(aVar.f34g)) {
                return false;
            }
        } else if (aVar.f34g != null) {
            return false;
        }
        if (this.f35h != null) {
            if (!this.f35h.equals(aVar.f35h)) {
                return false;
            }
        } else if (aVar.f35h != null) {
            return false;
        }
        if (this.f36i != null) {
            if (!this.f36i.equals(aVar.f36i)) {
                return false;
            }
        } else if (aVar.f36i != null) {
            return false;
        }
        if (this.f37j != null) {
            if (!this.f37j.equals(aVar.f37j)) {
                return false;
            }
        } else if (aVar.f37j != null) {
            return false;
        }
        if (this.f38k != null) {
            z = this.f38k.equals(aVar.f38k);
        } else if (aVar.f38k != null) {
            z = false;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r1 = r2.f35h.mo3920a();
     */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo3867f() {
        /*
            r2 = this;
            r0 = 0
            com.applovin.impl.a.o r1 = r2.f35h
            if (r1 == 0) goto L_0x0014
            com.applovin.impl.a.o r1 = r2.f35h
            java.util.List r1 = r1.mo3920a()
            if (r1 == 0) goto L_0x0014
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0014
            r0 = 1
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.p003a.C0180a.mo3867f():boolean");
    }

    /* renamed from: g */
    public Uri mo3868g() {
        if (this.f35h != null) {
            return this.f35h.mo3921b();
        }
        return null;
    }

    /* renamed from: h */
    public List<String> mo3869h() {
        return C0462s.m1246a(C0329bj.m634a(this.f1152b, "vast_resource_cache_prefix", "", (AppLovinSdk) this.f1154d));
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f37j != null ? this.f37j.hashCode() : 0) + (((this.f36i != null ? this.f36i.hashCode() : 0) + (((this.f35h != null ? this.f35h.hashCode() : 0) + (((this.f34g != null ? this.f34g.hashCode() : 0) + (((this.f33f != null ? this.f33f.hashCode() : 0) + (((this.f32e != null ? this.f32e.hashCode() : 0) + (super.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f38k != null) {
            i = this.f38k.hashCode();
        }
        return hashCode + i;
    }

    /* renamed from: i */
    public String mo3871i() {
        return C0329bj.m634a(this.f1152b, "html_template", "", (AppLovinSdk) this.f1154d);
    }

    /* renamed from: j */
    public Uri mo3872j() {
        String a = C0329bj.m634a(this.f1152b, "html_template_url", (String) null, (AppLovinSdk) this.f1154d);
        if (C0444fq.isValidString(a)) {
            return Uri.parse(a);
        }
        return null;
    }

    public String toString() {
        return "VastAd{title='" + this.f32e + '\'' + ", adDescription='" + this.f33f + '\'' + ", systemInfo=" + this.f34g + ", videoCreative=" + this.f35h + ", companionAd=" + this.f36i + ", impressionTrackers=" + this.f37j + ", errorTrackers=" + this.f38k + '}';
    }

    /* renamed from: x */
    public boolean mo3874x() {
        return mo3868g() != null;
    }
}
