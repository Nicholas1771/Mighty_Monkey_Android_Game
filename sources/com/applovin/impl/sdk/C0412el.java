package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.el */
class C0412el extends C0410ej {

    /* renamed from: a */
    private int f1040a;

    /* renamed from: b */
    private final AppLovinNativeAdLoadListener f1041b;

    public C0412el(AppLovinSdkImpl appLovinSdkImpl, int i, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super(C0451h.f1142h, (AppLovinAdLoadListener) null, appLovinSdkImpl);
        this.f1041b = appLovinNativeAdLoadListener;
        this.f1040a = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0386dm mo4667a(JSONObject jSONObject) {
        return new C0429fb(jSONObject, this.f763d, this.f1041b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo4668a(Map<String, String> map) {
        return C0466w.m1282b("nad", map, this.f763d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4669a(int i) {
        if (this.f1041b != null) {
            this.f1041b.onNativeAdsFailedToLoad(i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo4671b(Map<String, String> map) {
        return C0466w.m1286d("nad", map, this.f763d);
    }

    /* renamed from: c */
    public String mo4672c() {
        return "tFNW";
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo4674d(Map<String, String> map) {
        map.put("slot_count", Integer.toString(this.f1040a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo4675e(Map<String, String> map) {
        C0439fl a = C0437fj.m1130a().mo4713a("tFNW");
        if (a != null) {
            map.put("etfw", Long.toString(a.mo4716b()));
            map.put("ntfw", a.mo4715a());
        }
    }
}
