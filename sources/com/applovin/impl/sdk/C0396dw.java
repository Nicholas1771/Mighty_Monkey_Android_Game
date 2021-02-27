package com.applovin.impl.sdk;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.dw */
class C0396dw extends C0386dm {
    C0396dw(AppLovinSdkImpl appLovinSdkImpl) {
        super("SubmitData", appLovinSdkImpl);
    }

    /* renamed from: a */
    private boolean m943a(String str) {
        try {
            if (C0444fq.isValidString(str) && !AppLovinSdk.VERSION.equals(str)) {
                List<String> a = C0462s.m1247a(str, "\\.");
                List<String> a2 = C0462s.m1247a(AppLovinSdk.VERSION, "\\.");
                if (a.size() == 3 && a2.size() == 3) {
                    for (int i = 0; i < 3; i++) {
                        int parseInt = Integer.parseInt(a2.get(i));
                        int parseInt2 = Integer.parseInt(a.get(i));
                        if (parseInt < parseInt2) {
                            return true;
                        }
                        if (parseInt > parseInt2) {
                            return false;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            this.f763d.getLogger().mo4781e(this.f762c, "Encountered exception while checking if current version is outdated", th);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4636a(JSONObject jSONObject) {
        try {
            JSONObject a = C0466w.m1276a(jSONObject);
            C0390dq settingsManager = this.f763d.getSettingsManager();
            settingsManager.mo4536a(C0387dn.f898c, a.getString("device_id"));
            settingsManager.mo4536a(C0387dn.f960e, a.getString("device_token"));
            settingsManager.mo4536a(C0387dn.f951d, a.getString("publisher_id"));
            settingsManager.mo4535a();
            C0466w.m1278a(a, this.f763d);
            if (a.has("adserver_parameters")) {
                settingsManager.mo4536a(C0387dn.f980y, a.getJSONObject("adserver_parameters").toString());
            }
            String a2 = C0329bj.m634a(a, "latest_version", "", (AppLovinSdk) this.f763d);
            if (m943a(a2)) {
                this.f763d.getLogger().userError("ALSdk", "Please integrate the latest version of the AppLovin SDK (" + a2 + "). Not doing so can negatively impact your eCPMs!");
            }
        } catch (Throwable th) {
            this.f764e.mo4781e(this.f762c, "Unable to parse API response", th);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4637b(JSONObject jSONObject) throws JSONException {
        C0467x dataCollector = this.f763d.getDataCollector();
        C0293aa c = dataCollector.mo4793c();
        C0295ac a = dataCollector.mo4790a();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("model", a.f484a);
        jSONObject2.put("os", a.f485b);
        jSONObject2.put("brand", a.f486c);
        jSONObject2.put("sdk_version", a.f488e);
        jSONObject2.put("revision", a.f487d);
        jSONObject2.put("adns", (double) a.f493j);
        jSONObject2.put("adnsd", a.f494k);
        jSONObject2.put("gy", a.f502s);
        jSONObject2.put("country_code", a.f489f);
        jSONObject2.put("carrier", a.f490g);
        jSONObject2.put("orientation_lock", a.f492i);
        jSONObject2.put("tz_offset", a.f495l);
        jSONObject2.put("adr", a.f497n ? "1" : "0");
        jSONObject2.put("wvvc", a.f496m);
        jSONObject2.put("volume", a.f499p);
        jSONObject2.put("type", "android");
        jSONObject2.put("sim", a.f501r ? "1" : "0");
        C0469z d = dataCollector.mo4794d();
        String str = d.f1194b;
        boolean z = d.f1193a;
        if ((!z || ((Boolean) this.f763d.getSettingsManager().mo4534a(C0387dn.f848bC)).booleanValue()) && AppLovinSdkUtils.isValidString(str)) {
            jSONObject2.put("idfa", str);
        }
        C0294ab abVar = a.f498o;
        if (abVar != null) {
            jSONObject2.put("act", abVar.f482a);
            jSONObject2.put("acm", abVar.f483b);
        }
        String str2 = a.f500q;
        if (AppLovinSdkUtils.isValidString(str2)) {
            jSONObject2.put("ua", C0444fq.m1172c(str2));
        }
        jSONObject2.put("dnt", z);
        Locale locale = a.f491h;
        if (locale != null) {
            jSONObject2.put("locale", C0444fq.m1172c(locale.toString()));
        }
        jSONObject.put("device_info", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("package_name", c.f480c);
        jSONObject3.put("app_name", c.f478a);
        jSONObject3.put("app_version", c.f479b);
        jSONObject3.put("installed_at", c.f481d);
        jSONObject3.put("applovin_sdk_version", AppLovinSdk.VERSION);
        jSONObject3.put("ic", this.f763d.isInitializedInMainActivity());
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f765f);
        String str3 = (String) this.f763d.get(C0392ds.f992a, null, defaultSharedPreferences);
        if (AppLovinSdkUtils.isValidString(str3)) {
            jSONObject3.put("first_install", str3);
            if (str3.equalsIgnoreCase(Boolean.toString(true))) {
                this.f763d.put(C0392ds.f992a, Boolean.toString(false), defaultSharedPreferences);
            }
        }
        String str4 = (String) this.f763d.get(C0387dn.f771F);
        if (str4 != null && str4.length() > 0) {
            jSONObject3.put("plugin_version", str4);
        }
        jSONObject.put("app_info", jSONObject3);
        if (((Boolean) this.f763d.get(C0387dn.f780O)).booleanValue()) {
            jSONObject.put("stats", this.f763d.mo4171b().mo4623b());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo4638c(JSONObject jSONObject) {
        C0397dx dxVar = new C0397dx(this, "POST", new JSONObject(), "Repeat" + this.f762c, this.f763d);
        dxVar.mo4701a(C0466w.m1275a("device", (Map<String, String>) null, this.f763d));
        dxVar.mo4706b(C0466w.m1285c("device", (Map<String, String>) null, this.f763d));
        dxVar.mo4702a(jSONObject);
        dxVar.mo4707c(((Integer) this.f763d.get(C0387dn.f961f)).intValue());
        dxVar.mo4700a(C0387dn.f965j);
        dxVar.mo4705b(C0387dn.f969n);
        dxVar.run();
    }

    public void run() {
        try {
            this.f764e.mo4782i(this.f762c, "Submitting user data...");
            JSONObject jSONObject = new JSONObject();
            mo4637b(jSONObject);
            jSONObject.put("sc", this.f763d.get(C0387dn.f979x));
            mo4638c(jSONObject);
        } catch (JSONException e) {
            this.f764e.mo4781e(this.f762c, "Unable to build JSON message with collected data", e);
        }
    }
}
