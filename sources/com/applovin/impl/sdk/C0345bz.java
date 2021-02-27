package com.applovin.impl.sdk;

import com.applovin.mediation.AppLovinMediatedAdInfo;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdk;
import java.util.Collections;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.bz */
public class C0345bz extends C0453j {

    /* renamed from: e */
    private final boolean f632e;

    /* renamed from: f */
    private final AppLovinMediatedAdInfo f633f;

    public C0345bz(C0345bz bzVar, boolean z, AppLovinMediatedAdInfo appLovinMediatedAdInfo) {
        super(bzVar.f1151a, bzVar.f1152b, bzVar.f1153c, bzVar.f1154d);
        this.f632e = z;
        this.f633f = appLovinMediatedAdInfo;
    }

    C0345bz(C0451h hVar, JSONObject jSONObject, JSONObject jSONObject2, AppLovinSdkImpl appLovinSdkImpl) {
        super(hVar, jSONObject, jSONObject2, appLovinSdkImpl);
        this.f632e = false;
        this.f633f = null;
    }

    /* renamed from: a */
    public boolean mo3855a() {
        return this.f632e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo4391b() {
        return C0329bj.m634a(this.f1152b, "class", (String) null, (AppLovinSdk) this.f1154d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo4392c() {
        return C0329bj.m634a(this.f1152b, "name", (String) null, (AppLovinSdk) this.f1154d);
    }

    /* renamed from: d */
    public AppLovinMediatedAdInfo mo4393d() {
        return this.f633f;
    }

    /* renamed from: e */
    public Map<String, String> mo4394e() {
        if (this.f1152b.has("config")) {
            try {
                return C0329bj.m636a(this.f1152b.getJSONObject("config"));
            } catch (JSONException e) {
                this.f1154d.getLogger().mo4781e("MediatedAd", "Failed to retrieve mediation configuration", e);
            }
        }
        return Collections.emptyMap();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        C0345bz bzVar = (C0345bz) obj;
        if (this.f632e != bzVar.f632e) {
            return false;
        }
        return this.f633f != null ? this.f633f.equals(bzVar.f633f) : bzVar.f633f == null;
    }

    /* renamed from: f */
    public /* bridge */ /* synthetic */ boolean mo3867f() {
        return super.mo3867f();
    }

    /* renamed from: g */
    public int mo4395g() {
        return C0329bj.m630a(this.f1152b, "timeout_sec", 5, (AppLovinSdk) this.f1154d);
    }

    public /* bridge */ /* synthetic */ long getAdIdNumber() {
        return super.getAdIdNumber();
    }

    public /* bridge */ /* synthetic */ AppLovinAdSize getSize() {
        return super.getSize();
    }

    public /* bridge */ /* synthetic */ AppLovinAdType getType() {
        return super.getType();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f632e ? 1 : 0) + (super.hashCode() * 31)) * 31;
        if (this.f633f != null) {
            i = this.f633f.hashCode();
        }
        return hashCode + i;
    }

    public /* bridge */ /* synthetic */ boolean isVideoAd() {
        return super.isVideoAd();
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
