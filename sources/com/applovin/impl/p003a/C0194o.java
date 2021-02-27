package com.applovin.impl.p003a;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.applovin.impl.sdk.C0391dr;
import com.applovin.impl.sdk.C0444fq;
import com.applovin.impl.sdk.C0446fs;
import com.applovin.impl.sdk.C0462s;
import com.applovin.sdk.AppLovinSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.a.o */
public class C0194o {

    /* renamed from: a */
    private List<C0197r> f104a = Collections.EMPTY_LIST;

    /* renamed from: b */
    private List<String> f105b = Collections.EMPTY_LIST;

    /* renamed from: c */
    private int f106c;

    /* renamed from: d */
    private Uri f107d;

    /* renamed from: e */
    private final Set<C0191l> f108e = new HashSet();

    /* renamed from: f */
    private final Map<String, Set<C0191l>> f109f = new HashMap();

    private C0194o() {
    }

    private C0194o(C0186g gVar) {
        this.f105b = gVar.mo3899f();
    }

    /* renamed from: a */
    private static int m115a(String str, AppLovinSdk appLovinSdk) {
        try {
            List<String> a = C0462s.m1247a(str, ":");
            if (a.size() == 3) {
                int e = C0444fq.m1174e(a.get(0));
                int e2 = C0444fq.m1174e(a.get(1));
                return (int) (((long) C0444fq.m1174e(a.get(2))) + TimeUnit.HOURS.toSeconds((long) e) + TimeUnit.MINUTES.toSeconds((long) e2));
            }
        } catch (Throwable th) {
            appLovinSdk.getLogger().mo4780e("VastVideoCreative", "Unable to parse duration from \"" + str + "\"");
        }
        return 0;
    }

    /* renamed from: a */
    public static C0194o m116a(C0446fs fsVar, C0194o oVar, C0186g gVar, AppLovinSdk appLovinSdk) {
        C0446fs b;
        List<C0197r> a;
        C0446fs b2;
        int a2;
        if (fsVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (gVar == null) {
            throw new IllegalArgumentException("No context specified.");
        } else if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified.");
        } else {
            C0194o oVar2 = oVar != null ? oVar : new C0194o(gVar);
            try {
                if (oVar2.f106c == 0 && (b2 = fsVar.mo4737b("Duration")) != null && (a2 = m115a(b2.mo4740c(), appLovinSdk)) > 0) {
                    oVar2.f106c = a2;
                }
                C0446fs b3 = fsVar.mo4737b("MediaFiles");
                if (!(b3 == null || (a = m117a(b3, appLovinSdk)) == null || a.size() <= 0)) {
                    if (oVar2.f104a != null) {
                        a.addAll(oVar2.f104a);
                    }
                    oVar2.f104a = a;
                }
                C0446fs b4 = fsVar.mo4737b("VideoClicks");
                if (b4 != null) {
                    if (oVar2.f107d == null && (b = b4.mo4737b("ClickThrough")) != null) {
                        String c = b.mo4740c();
                        if (C0444fq.isValidString(c)) {
                            oVar2.f107d = Uri.parse(c);
                        }
                    }
                    C0193n.m106a(b4.mo4736a("ClickTracking"), oVar2.f108e, gVar, appLovinSdk);
                }
                C0193n.m105a(fsVar, oVar2.f109f, gVar, appLovinSdk);
                return oVar2;
            } catch (Throwable th) {
                appLovinSdk.getLogger().mo4781e("VastVideoCreative", "Error occurred while initializing", th);
                return null;
            }
        }
    }

    /* renamed from: a */
    private static List<C0197r> m117a(C0446fs fsVar, AppLovinSdk appLovinSdk) {
        List<C0446fs> a = fsVar.mo4736a("MediaFile");
        ArrayList arrayList = new ArrayList(a.size());
        C0391dr drVar = new C0391dr(appLovinSdk);
        List<String> a2 = C0462s.m1246a(drVar.mo4566Y());
        List<String> a3 = C0462s.m1246a(drVar.mo4567Z());
        for (C0446fs a4 : a) {
            C0197r a5 = C0197r.m125a(a4, appLovinSdk);
            if (a5 != null) {
                try {
                    String d = a5.mo3933d();
                    if (!C0444fq.isValidString(d) || a2.contains(d)) {
                        if (drVar.mo4569aa()) {
                            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(a5.mo3931b().toString());
                            if (C0444fq.isValidString(fileExtensionFromUrl) && !a3.contains(fileExtensionFromUrl)) {
                                arrayList.add(a5);
                            }
                        }
                        appLovinSdk.getLogger().mo4785w("VastVideoCreative", "Video file not supported: " + a5);
                    } else {
                        arrayList.add(a5);
                    }
                } catch (Throwable th) {
                    appLovinSdk.getLogger().mo4781e("VastVideoCreative", "Failed to validate vidoe file: " + a5, th);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public C0197r mo3919a(C0196q qVar) {
        if (this.f104a == null || this.f104a.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(3);
        for (String next : this.f105b) {
            for (C0197r next2 : this.f104a) {
                String d = next2.mo3933d();
                if (C0444fq.isValidString(d) && next.equalsIgnoreCase(d)) {
                    arrayList.add(next2);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        List<C0197r> list = !arrayList.isEmpty() ? arrayList : this.f104a;
        Collections.sort(list, new C0195p(this));
        return qVar == C0196q.LOW ? list.get(0) : qVar == C0196q.MEDIUM ? list.get(list.size() / 2) : list.get(list.size() - 1);
    }

    /* renamed from: a */
    public List<C0197r> mo3920a() {
        return this.f104a;
    }

    /* renamed from: b */
    public Uri mo3921b() {
        return this.f107d;
    }

    /* renamed from: c */
    public Set<C0191l> mo3922c() {
        return this.f108e;
    }

    /* renamed from: d */
    public Map<String, Set<C0191l>> mo3923d() {
        return this.f109f;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0194o)) {
            return false;
        }
        C0194o oVar = (C0194o) obj;
        if (this.f106c != oVar.f106c) {
            return false;
        }
        if (this.f104a != null) {
            if (!this.f104a.equals(oVar.f104a)) {
                return false;
            }
        } else if (oVar.f104a != null) {
            return false;
        }
        if (this.f107d != null) {
            if (!this.f107d.equals(oVar.f107d)) {
                return false;
            }
        } else if (oVar.f107d != null) {
            return false;
        }
        if (this.f108e != null) {
            if (!this.f108e.equals(oVar.f108e)) {
                return false;
            }
        } else if (oVar.f108e != null) {
            return false;
        }
        if (this.f109f != null) {
            z = this.f109f.equals(oVar.f109f);
        } else if (oVar.f109f != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f108e != null ? this.f108e.hashCode() : 0) + (((this.f107d != null ? this.f107d.hashCode() : 0) + ((((this.f104a != null ? this.f104a.hashCode() : 0) * 31) + this.f106c) * 31)) * 31)) * 31;
        if (this.f109f != null) {
            i = this.f109f.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "VastVideoCreative{videoFiles=" + this.f104a + ", durationSeconds=" + this.f106c + ", destinationUri=" + this.f107d + ", clickTrackers=" + this.f108e + ", eventTrackers=" + this.f109f + '}';
    }
}
