package com.applovin.impl.p003a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.C0444fq;
import com.applovin.impl.sdk.C0446fs;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.a.r */
public class C0197r {

    /* renamed from: a */
    private Uri f116a;

    /* renamed from: b */
    private Uri f117b;

    /* renamed from: c */
    private C0198s f118c;

    /* renamed from: d */
    private String f119d;

    /* renamed from: e */
    private int f120e;

    /* renamed from: f */
    private int f121f;

    /* renamed from: g */
    private int f122g;

    private C0197r() {
    }

    /* renamed from: a */
    public static C0197r m125a(C0446fs fsVar, AppLovinSdk appLovinSdk) {
        if (fsVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified.");
        } else {
            try {
                String c = fsVar.mo4740c();
                if (URLUtil.isValidUrl(c)) {
                    Uri parse = Uri.parse(c);
                    C0197r rVar = new C0197r();
                    rVar.f116a = parse;
                    rVar.f117b = parse;
                    rVar.f122g = C0444fq.m1174e(fsVar.mo4738b().get("bitrate"));
                    rVar.f118c = m126a(fsVar.mo4738b().get("delivery"));
                    rVar.f121f = C0444fq.m1174e(fsVar.mo4738b().get("height"));
                    rVar.f120e = C0444fq.m1174e(fsVar.mo4738b().get("width"));
                    rVar.f119d = fsVar.mo4738b().get("type").toLowerCase();
                    return rVar;
                }
                appLovinSdk.getLogger().mo4780e("VastVideoFile", "Unable to create video file. Could not find URL.");
                return null;
            } catch (Throwable th) {
                appLovinSdk.getLogger().mo4781e("VastVideoFile", "Error occurred while initializing", th);
            }
        }
    }

    /* renamed from: a */
    private static C0198s m126a(String str) {
        if (C0444fq.isValidString(str)) {
            if ("progressive".equalsIgnoreCase(str)) {
                return C0198s.Progressive;
            }
            if ("streaming".equalsIgnoreCase(str)) {
                return C0198s.Streaming;
            }
        }
        return C0198s.Progressive;
    }

    /* renamed from: a */
    public Uri mo3929a() {
        return this.f116a;
    }

    /* renamed from: a */
    public void mo3930a(Uri uri) {
        this.f117b = uri;
    }

    /* renamed from: b */
    public Uri mo3931b() {
        return this.f117b;
    }

    /* renamed from: c */
    public boolean mo3932c() {
        return this.f118c == C0198s.Streaming;
    }

    /* renamed from: d */
    public String mo3933d() {
        return this.f119d;
    }

    /* renamed from: e */
    public int mo3934e() {
        return this.f122g;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0197r)) {
            return false;
        }
        C0197r rVar = (C0197r) obj;
        if (this.f120e != rVar.f120e || this.f121f != rVar.f121f || this.f122g != rVar.f122g) {
            return false;
        }
        if (this.f116a != null) {
            if (!this.f116a.equals(rVar.f116a)) {
                return false;
            }
        } else if (rVar.f116a != null) {
            return false;
        }
        if (this.f117b != null) {
            if (!this.f117b.equals(rVar.f117b)) {
                return false;
            }
        } else if (rVar.f117b != null) {
            return false;
        }
        if (this.f118c != rVar.f118c) {
            return false;
        }
        if (this.f119d != null) {
            z = this.f119d.equals(rVar.f119d);
        } else if (rVar.f119d != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f118c != null ? this.f118c.hashCode() : 0) + (((this.f117b != null ? this.f117b.hashCode() : 0) + ((this.f116a != null ? this.f116a.hashCode() : 0) * 31)) * 31)) * 31;
        if (this.f119d != null) {
            i = this.f119d.hashCode();
        }
        return ((((((hashCode + i) * 31) + this.f120e) * 31) + this.f121f) * 31) + this.f122g;
    }

    public String toString() {
        return "VastVideoFile{sourceVideoUri=" + this.f116a + ", videoUri=" + this.f117b + ", deliveryType=" + this.f118c + ", fileType='" + this.f119d + '\'' + ", width=" + this.f120e + ", height=" + this.f121f + ", bitrate=" + this.f122g + '}';
    }
}
