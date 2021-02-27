package com.applovin.impl.sdk;

import android.graphics.Point;
import android.text.TextUtils;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.mediation.AppLovinMediationAdapterInfo;
import com.applovin.mediation.AppLovinMediationAdapterStats;
import com.applovin.mediation.AppLovinMediationAdapterStatus;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ej */
class C0410ej extends C0386dm implements C0442fo {

    /* renamed from: a */
    private final C0451h f1036a;

    /* renamed from: b */
    private final AppLovinAdLoadListener f1037b;

    /* renamed from: g */
    private boolean f1038g = false;

    C0410ej(C0451h hVar, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        super("FetchNextAd", appLovinSdkImpl);
        this.f1036a = hVar;
        this.f1037b = appLovinAdLoadListener;
    }

    /* renamed from: a */
    private String m995a(AppLovinMediationAdapterInfo appLovinMediationAdapterInfo) {
        if (appLovinMediationAdapterInfo == null) {
            return null;
        }
        return appLovinMediationAdapterInfo.getVersion();
    }

    /* renamed from: a */
    private void m996a(C0394du duVar) {
        if (System.currentTimeMillis() - duVar.mo4622b("ad_session_start") > TimeUnit.MINUTES.toMillis((long) ((Integer) this.f763d.get(C0387dn.f978w)).intValue())) {
            duVar.mo4624b("ad_session_start", System.currentTimeMillis());
            duVar.mo4626c("ad_imp_session");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m999b(int i) {
        this.f764e.mo4780e(this.f762c, "Unable to fetch " + this.f1036a + " ad: server returned " + i);
        try {
            mo4669a(i);
        } catch (Throwable th) {
            this.f764e.userError(this.f762c, "Unable process a failure to recieve an ad", th);
        }
        C0466w.m1284b(i, this.f763d);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1000b(JSONObject jSONObject) {
        C0466w.m1278a(jSONObject, this.f763d);
        C0386dm a = mo4667a(jSONObject);
        if (((Boolean) this.f763d.get(C0387dn.f940cp)).booleanValue()) {
            this.f763d.mo4169a().mo4680a(a);
        } else {
            this.f763d.mo4169a().mo4681a(a, C0416ep.MAIN);
        }
    }

    /* renamed from: d */
    private String m1001d() {
        return (!C0463t.m1255c() || !C0463t.m1250a((Class<?>) AppLovinInterstitialActivity.class, this.f765f)) ? "custom_size,launch_app" : "custom_size,launch_app" + ",video";
    }

    /* renamed from: f */
    private void m1002f(Map<String, String> map) {
        if (this.f763d.getSettings().isTestAdsEnabled()) {
            map.put("test_ads", Boolean.toString(true));
        }
        map.put("api_did", this.f763d.get(C0387dn.f898c));
        map.put("sdk_key", this.f763d.getSdkKey());
        map.put("sdk_version", AppLovinSdk.VERSION);
        map.put("app_version", C0444fq.m1172c(this.f763d.getDataCollector().mo4793c().f479b));
        map.put("build", Integer.toString(57));
        String str = (String) this.f763d.get(C0387dn.f771F);
        if (str != null && str.length() > 0) {
            map.put("plugin_version", str);
        }
        map.put("accept", m1001d());
        map.put("v1", Boolean.toString(C0463t.m1251a("android.permission.WRITE_EXTERNAL_STORAGE", this.f765f)));
        map.put("v2", Boolean.toString(C0463t.m1250a((Class<?>) AppLovinInterstitialActivity.class, this.f765f)));
        map.put("v3", Boolean.toString(C0463t.m1249a(this.f765f)));
        map.put("v4", Boolean.toString(C0463t.m1253b(this.f765f)));
        map.put("m", this.f1036a.mo4767c().toString());
        map.put("preloading", String.valueOf(this.f1038g));
        map.put("size", this.f1036a.mo4765a().getLabel());
        map.put("format", "json");
        map.put("ia", Long.toString(this.f763d.getDataCollector().mo4793c().f481d));
    }

    /* renamed from: g */
    private void m1003g(Map<String, String> map) {
        if (((Boolean) this.f763d.get(C0387dn.f780O)).booleanValue()) {
            C0394du b = this.f763d.mo4171b();
            map.put("li", String.valueOf(b.mo4622b("ad_imp")));
            map.put("si", String.valueOf(b.mo4622b("ad_imp_session")));
            map.put("ld", String.valueOf(b.mo4622b("last_displayed_ad_id_number")));
            map.put("dt", String.valueOf(b.mo4622b("ad_dismiss_duration")));
            map.put("ct", String.valueOf(b.mo4622b("ad_time_to_click_through")));
            map.put("pd", String.valueOf(b.mo4622b("ad_paused_duration")));
            map.put("fd", String.valueOf(b.mo4622b("first_ad_shown_duration")));
            map.put("sc", this.f763d.get(C0387dn.f979x));
        }
    }

    /* renamed from: h */
    private void m1004h(Map<String, String> map) {
        Map<String, String> a = C0292a.m468a(this.f763d);
        if (a.isEmpty()) {
            try {
                m1005i(a);
                C0292a.m470a(a, this.f763d);
            } catch (Exception e) {
                this.f764e.mo4781e(this.f762c, "Unable to populate device information", e);
            }
        }
        try {
            m1006j(a);
        } catch (Exception e2) {
            this.f764e.mo4781e(this.f762c, "Unable to populate ephemeral device information", e2);
        }
        map.putAll(a);
        map.put("network", C0466w.m1272a(this.f763d));
        m1008l(map);
        map.put("vz", C0444fq.m1158a(this.f763d.getApplicationContext().getPackageName(), this.f763d));
    }

    /* renamed from: i */
    private void m1005i(Map<String, String> map) {
        C0295ac a = this.f763d.getDataCollector().mo4790a();
        map.put("brand", C0444fq.m1172c(a.f486c));
        map.put("carrier", C0444fq.m1172c(a.f490g));
        map.put("country_code", C0444fq.m1172c(a.f489f));
        map.put("locale", C0444fq.m1172c(a.f491h.toString()));
        map.put("model", C0444fq.m1172c(a.f484a));
        map.put("os", C0444fq.m1172c(a.f485b));
        map.put("platform", "android");
        map.put("revision", C0444fq.m1172c(a.f487d));
        map.put("orientation_lock", a.f492i);
        map.put("tz_offset", String.valueOf(a.f495l));
        map.put("wvvc", String.valueOf(a.f496m));
        map.put("adns", String.valueOf(a.f493j));
        map.put("adnsd", String.valueOf(a.f494k));
        map.put("sim", a.f501r ? "1" : "0");
        map.put("gy", String.valueOf(a.f502s));
        m1007k(map);
    }

    /* renamed from: j */
    private void m1006j(Map<String, String> map) {
        C0295ac b = this.f763d.getDataCollector().mo4792b();
        C0294ab abVar = b.f498o;
        if (abVar != null) {
            map.put("act", String.valueOf(abVar.f482a));
            map.put("acm", String.valueOf(abVar.f483b));
        }
        map.put("adr", b.f497n ? "1" : "0");
        map.put("volume", String.valueOf(b.f499p));
        String str = b.f500q;
        if (AppLovinSdkUtils.isValidString(str)) {
            map.put("ua", C0444fq.m1172c(str));
        }
        m1007k(map);
        m1009m(map);
    }

    /* renamed from: k */
    private void m1007k(Map<String, String> map) {
        Point c = C0463t.m1254c(this.f763d.getApplicationContext());
        map.put("dx", Integer.toString(c.x));
        map.put("dy", Integer.toString(c.y));
    }

    /* renamed from: l */
    private void m1008l(Map<String, String> map) {
        C0469z d = this.f763d.getDataCollector().mo4794d();
        String str = d.f1194b;
        boolean z = d.f1193a;
        if ((!z || ((Boolean) this.f763d.getSettingsManager().mo4534a(C0387dn.f848bC)).booleanValue()) && AppLovinSdkUtils.isValidString(str)) {
            map.put("idfa", str);
        }
        map.put("dnt", Boolean.toString(z));
    }

    /* renamed from: m */
    private void m1009m(Map<String, String> map) {
        Collection<AppLovinMediationAdapterInfo> adapterInfo = this.f763d.getMediationService().getAdapterInfo();
        if (adapterInfo != null && !adapterInfo.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (AppLovinMediationAdapterInfo next : adapterInfo) {
                if (next.getStatus() == AppLovinMediationAdapterStatus.READY) {
                    sb.append(next.getName());
                    String a = m995a(next);
                    if (!TextUtils.isEmpty(a)) {
                        sb.append(":");
                        sb.append(a);
                    }
                    sb.append(",");
                }
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            if (sb.length() > 0) {
                map.put("aa", sb.toString());
            }
        }
        AppLovinMediationAdapterStats lastAdapterStats = this.f763d.getMediationService().getLastAdapterStats();
        if (lastAdapterStats != null) {
            map.put("lman", lastAdapterStats.getAdapterName());
            map.put("lmat", String.valueOf(lastAdapterStats.getLastAdLoadMillis()));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0386dm mo4667a(JSONObject jSONObject) {
        return new C0421eu(jSONObject, this.f1036a, this.f1037b, this.f763d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo4668a(Map<String, String> map) {
        return C0466w.m1282b("3.0/ad", map, this.f763d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4669a(int i) {
        if (this.f1037b == null) {
            return;
        }
        if (this.f1037b instanceof C0302aj) {
            ((C0302aj) this.f1037b).mo4308a(this.f1036a, i);
        } else {
            this.f1037b.failedToReceiveAd(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4670a(boolean z) {
        this.f1038g = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo4671b(Map<String, String> map) {
        return C0466w.m1286d("3.0/ad", map, this.f763d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4528b() {
        super.mo4528b();
        m999b(-410);
    }

    /* renamed from: c */
    public String mo4672c() {
        return "tFNA";
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo4673c(Map<String, String> map) {
        m1004h(map);
        m1003g(map);
        m1002f(map);
        mo4674d(map);
        mo4675e(map);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo4674d(Map<String, String> map) {
        map.put("require", this.f1036a.mo4766b().getLabel());
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo4675e(Map<String, String> map) {
        C0439fl a = C0437fj.m1130a().mo4713a("tFNA");
        if (a != null) {
            map.put("etf", Long.toString(a.mo4716b()));
            map.put("ntf", a.mo4715a());
        }
        C0439fl a2 = C0437fj.m1130a().mo4713a("tRA");
        if (a2 != null) {
            map.put("etr", Long.toString(a2.mo4716b()));
            map.put("ntr", a2.mo4715a());
        }
    }

    public void run() {
        if (this.f1038g) {
            this.f764e.mo4779d(this.f762c, "Preloading next ad of spec: " + this.f1036a);
        } else {
            this.f764e.mo4779d(this.f762c, "Fetching next ad of spec: " + this.f1036a);
        }
        C0394du b = this.f763d.mo4171b();
        b.mo4620a("ad_req");
        m996a(b);
        try {
            C0411ek ekVar = new C0411ek(this, "GET", new JSONObject(), "RepeatFetchNextAd", this.f763d);
            HashMap hashMap = new HashMap();
            mo4673c(hashMap);
            ekVar.mo4701a(mo4668a((Map<String, String>) hashMap));
            ekVar.mo4706b(mo4671b((Map<String, String>) hashMap));
            ekVar.mo4704b(((Integer) this.f763d.get(C0387dn.f976u)).intValue());
            ekVar.mo4707c(((Integer) this.f763d.get(C0387dn.f963h)).intValue());
            ekVar.mo4700a(C0387dn.f966k);
            ekVar.mo4705b(C0387dn.f970o);
            ekVar.run();
        } catch (Throwable th) {
            this.f764e.mo4781e(this.f762c, "Unable to fetch ad " + this.f1036a, th);
            m999b(0);
        }
    }
}
