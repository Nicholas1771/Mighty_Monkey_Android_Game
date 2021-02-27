package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdk;
import java.util.Arrays;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.j */
abstract class C0453j implements C0344by, AppLovinAd {

    /* renamed from: a */
    protected final C0451h f1151a;

    /* renamed from: b */
    protected final JSONObject f1152b;

    /* renamed from: c */
    protected final JSONObject f1153c;

    /* renamed from: d */
    protected final AppLovinSdkImpl f1154d;

    /* renamed from: e */
    private C0299ag f1155e;

    C0453j(C0451h hVar, JSONObject jSONObject, JSONObject jSONObject2, AppLovinSdkImpl appLovinSdkImpl) {
        if (hVar == null) {
            throw new IllegalArgumentException("No ad spec specified");
        } else if (jSONObject == null) {
            throw new IllegalArgumentException("No ad object specified");
        } else if (jSONObject2 == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else {
            this.f1151a = hVar;
            this.f1152b = jSONObject;
            this.f1153c = jSONObject2;
            this.f1154d = appLovinSdkImpl;
        }
    }

    /* renamed from: a */
    private String mo3855a() {
        char[] charArray = this.f1152b.toString().toCharArray();
        Arrays.sort(charArray);
        return new String(charArray) + getType() + getSize() + mo4291l();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4771a(C0299ag agVar) {
        this.f1155e = agVar;
    }

    public boolean equals(Object obj) {
        Object obj2;
        if (!(obj instanceof C0299ag) || (obj2 = ((C0299ag) obj).mo3855a()) == null) {
            obj2 = obj;
        }
        if (this == obj2) {
            return true;
        }
        if (obj2 == null || getClass() != obj2.getClass()) {
            return false;
        }
        C0453j jVar = (C0453j) obj2;
        if (this.f1151a == null ? jVar.f1151a != null : !this.f1151a.equals(jVar.f1151a)) {
            return false;
        }
        return mo3855a().equals(jVar.mo3855a());
    }

    /* renamed from: f */
    public boolean mo3867f() {
        this.f1154d.getLogger().mo4780e("AppLovinAdBase", "Attempting to invoke hasVideoUrl() from base ad class");
        return false;
    }

    public long getAdIdNumber() {
        return C0329bj.m631a(this.f1152b, "ad_id", -1, (AppLovinSdk) this.f1154d);
    }

    public AppLovinAdSize getSize() {
        return this.f1151a.mo4765a();
    }

    public AppLovinAdType getType() {
        return this.f1151a.mo4766b();
    }

    public int hashCode() {
        return this.f1151a.hashCode() + mo3855a().hashCode();
    }

    public boolean isVideoAd() {
        return this.f1152b.has("is_video_ad") ? C0329bj.m632a(this.f1152b, "is_video_ad", (Boolean) false, (AppLovinSdk) this.f1154d).booleanValue() : mo3867f();
    }

    /* renamed from: l */
    public String mo4291l() {
        String a = C0329bj.m634a(this.f1152b, "clcode", "", (AppLovinSdk) this.f1154d);
        return C0444fq.isValidString(a) ? a : C0329bj.m634a(this.f1153c, "clcode", "", (AppLovinSdk) this.f1154d);
    }

    /* renamed from: m */
    public C0451h mo4292m() {
        return this.f1151a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public C0299ag mo4772n() {
        return this.f1155e;
    }

    public String toString() {
        return "[" + getClass().getSimpleName() + " #" + getAdIdNumber() + " adType=" + getType() + ", adSize=" + getSize() + ", adObject=" + this.f1152b + "]";
    }
}
