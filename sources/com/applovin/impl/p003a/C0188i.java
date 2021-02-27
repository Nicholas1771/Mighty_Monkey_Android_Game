package com.applovin.impl.p003a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.C0444fq;
import com.applovin.impl.sdk.C0446fs;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.a.i */
public class C0188i {

    /* renamed from: a */
    private C0189j f86a;

    /* renamed from: b */
    private Uri f87b;

    /* renamed from: c */
    private String f88c;

    private C0188i() {
    }

    /* renamed from: a */
    static C0188i m83a(C0446fs fsVar, C0188i iVar, AppLovinSdk appLovinSdk) {
        if (fsVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified.");
        } else {
            C0188i iVar2 = iVar != null ? iVar : new C0188i();
            try {
                if (iVar2.f87b != null || C0444fq.isValidString(iVar2.f88c)) {
                    return iVar2;
                }
                String a = m84a(fsVar, "StaticResource");
                if (URLUtil.isValidUrl(a)) {
                    iVar2.f87b = Uri.parse(a);
                    iVar2.f86a = C0189j.STATIC;
                    return iVar2;
                }
                String a2 = m84a(fsVar, "IFrameResource");
                if (C0444fq.isValidString(a2)) {
                    iVar2.f86a = C0189j.IFRAME;
                    if (URLUtil.isValidUrl(a2)) {
                        iVar2.f87b = Uri.parse(a2);
                        return iVar2;
                    }
                    iVar2.f88c = a2;
                    return iVar2;
                }
                String a3 = m84a(fsVar, "HTMLResource");
                if (!C0444fq.isValidString(a3)) {
                    return iVar2;
                }
                iVar2.f86a = C0189j.HTML;
                if (URLUtil.isValidUrl(a3)) {
                    iVar2.f87b = Uri.parse(a3);
                    return iVar2;
                }
                iVar2.f88c = a3;
                return iVar2;
            } catch (Throwable th) {
                appLovinSdk.getLogger().mo4781e("VastNonVideoResource", "Error occurred while initializing", th);
                return null;
            }
        }
    }

    /* renamed from: a */
    private static String m84a(C0446fs fsVar, String str) {
        C0446fs b = fsVar.mo4737b(str);
        if (b != null) {
            return b.mo4740c();
        }
        return null;
    }

    /* renamed from: a */
    public C0189j mo3902a() {
        return this.f86a;
    }

    /* renamed from: a */
    public void mo3903a(Uri uri) {
        this.f87b = uri;
    }

    /* renamed from: a */
    public void mo3904a(String str) {
        this.f88c = str;
    }

    /* renamed from: b */
    public Uri mo3905b() {
        return this.f87b;
    }

    /* renamed from: c */
    public String mo3906c() {
        return this.f88c;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0188i)) {
            return false;
        }
        C0188i iVar = (C0188i) obj;
        if (this.f86a != iVar.f86a) {
            return false;
        }
        if (this.f87b != null) {
            if (!this.f87b.equals(iVar.f87b)) {
                return false;
            }
        } else if (iVar.f87b != null) {
            return false;
        }
        if (this.f88c != null) {
            z = this.f88c.equals(iVar.f88c);
        } else if (iVar.f88c != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f87b != null ? this.f87b.hashCode() : 0) + ((this.f86a != null ? this.f86a.hashCode() : 0) * 31)) * 31;
        if (this.f88c != null) {
            i = this.f88c.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "VastNonVideoResource{type=" + this.f86a + ", resourceUri=" + this.f87b + ", resourceContents='" + this.f88c + '\'' + '}';
    }
}
