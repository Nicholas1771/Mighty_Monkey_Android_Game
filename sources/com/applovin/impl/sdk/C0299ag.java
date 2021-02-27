package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ag */
public final class C0299ag extends C0453j {

    /* renamed from: e */
    private AppLovinAd f511e;

    public C0299ag(C0451h hVar, AppLovinSdkImpl appLovinSdkImpl) {
        super(hVar, new JSONObject(), new JSONObject(), appLovinSdkImpl);
    }

    /* renamed from: c */
    private AppLovinAd m523c() {
        return (AppLovinAd) this.f1154d.mo4172c().mo4467b(this.f1151a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AppLovinAd mo3855a() {
        return this.f511e != null ? this.f511e : m523c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4304a(AppLovinAd appLovinAd) {
        this.f511e = appLovinAd;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public AppLovinAd mo4305b() {
        return this.f511e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppLovinAd a = mo3855a();
        return a != null ? a.equals(obj) : super.equals(obj);
    }

    /* renamed from: f */
    public /* bridge */ /* synthetic */ boolean mo3867f() {
        return super.mo3867f();
    }

    public long getAdIdNumber() {
        AppLovinAd a = mo3855a();
        if (a != null) {
            return a.getAdIdNumber();
        }
        return 0;
    }

    public /* bridge */ /* synthetic */ AppLovinAdSize getSize() {
        return super.getSize();
    }

    public /* bridge */ /* synthetic */ AppLovinAdType getType() {
        return super.getType();
    }

    public int hashCode() {
        AppLovinAd a = mo3855a();
        return a != null ? a.hashCode() : super.hashCode();
    }

    public boolean isVideoAd() {
        AppLovinAd a = mo3855a();
        if (a != null) {
            return a.isVideoAd();
        }
        return false;
    }

    /* renamed from: l */
    public /* bridge */ /* synthetic */ String mo4291l() {
        return super.mo4291l();
    }

    /* renamed from: m */
    public /* bridge */ /* synthetic */ C0451h mo4292m() {
        return super.mo4292m();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
