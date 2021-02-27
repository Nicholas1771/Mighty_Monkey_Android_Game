package com.applovin.impl.p003a;

import android.net.Uri;
import com.applovin.impl.sdk.C0444fq;
import com.applovin.impl.sdk.C0446fs;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.a.f */
public class C0185f {

    /* renamed from: a */
    private int f60a;

    /* renamed from: b */
    private int f61b;

    /* renamed from: c */
    private Uri f62c;

    /* renamed from: d */
    private C0188i f63d;

    /* renamed from: e */
    private Set<C0191l> f64e = new HashSet();

    /* renamed from: f */
    private Map<String, Set<C0191l>> f65f = new HashMap();

    private C0185f() {
    }

    /* renamed from: a */
    public static C0185f m70a(C0446fs fsVar, C0185f fVar, C0186g gVar, AppLovinSdk appLovinSdk) {
        C0446fs b;
        if (fsVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified.");
        } else {
            C0185f fVar2 = fVar != null ? fVar : new C0185f();
            try {
                if (fVar2.f60a == 0 && fVar2.f61b == 0) {
                    int e = C0444fq.m1174e(fsVar.mo4738b().get("width"));
                    int e2 = C0444fq.m1174e(fsVar.mo4738b().get("height"));
                    if (e > 0 && e2 > 0) {
                        fVar2.f60a = e;
                        fVar2.f61b = e2;
                    }
                }
                fVar2.f63d = C0188i.m83a(fsVar, fVar2.f63d, appLovinSdk);
                if (fVar2.f62c == null && (b = fsVar.mo4737b("CompanionClickThrough")) != null) {
                    String c = b.mo4740c();
                    if (AppLovinSdkUtils.isValidString(c)) {
                        fVar2.f62c = Uri.parse(c);
                    }
                }
                C0193n.m106a(fsVar.mo4736a("CompanionClickTracking"), fVar2.f64e, gVar, appLovinSdk);
                C0193n.m105a(fsVar, fVar2.f65f, gVar, appLovinSdk);
                return fVar2;
            } catch (Throwable th) {
                appLovinSdk.getLogger().mo4781e("VastCompanionAd", "Error occurred while initializing", th);
                return null;
            }
        }
    }

    /* renamed from: a */
    public Uri mo3887a() {
        return this.f62c;
    }

    /* renamed from: b */
    public C0188i mo3888b() {
        return this.f63d;
    }

    /* renamed from: c */
    public Set<C0191l> mo3889c() {
        return this.f64e;
    }

    /* renamed from: d */
    public Map<String, Set<C0191l>> mo3890d() {
        return this.f65f;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0185f)) {
            return false;
        }
        C0185f fVar = (C0185f) obj;
        if (this.f60a != fVar.f60a || this.f61b != fVar.f61b) {
            return false;
        }
        if (this.f62c != null) {
            if (!this.f62c.equals(fVar.f62c)) {
                return false;
            }
        } else if (fVar.f62c != null) {
            return false;
        }
        if (this.f63d != null) {
            if (!this.f63d.equals(fVar.f63d)) {
                return false;
            }
        } else if (fVar.f63d != null) {
            return false;
        }
        if (this.f64e != null) {
            if (!this.f64e.equals(fVar.f64e)) {
                return false;
            }
        } else if (fVar.f64e != null) {
            return false;
        }
        if (this.f65f != null) {
            z = this.f65f.equals(fVar.f65f);
        } else if (fVar.f65f != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f64e != null ? this.f64e.hashCode() : 0) + (((this.f63d != null ? this.f63d.hashCode() : 0) + (((this.f62c != null ? this.f62c.hashCode() : 0) + (((this.f60a * 31) + this.f61b) * 31)) * 31)) * 31)) * 31;
        if (this.f65f != null) {
            i = this.f65f.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "VastCompanionAd{width=" + this.f60a + ", height=" + this.f61b + ", destinationUri=" + this.f62c + ", nonVideoResource=" + this.f63d + ", clickTrackers=" + this.f64e + ", eventTrackers=" + this.f65f + '}';
    }
}
