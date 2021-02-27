package com.applovin.impl.sdk;

import android.webkit.WebSettings;
import com.applovin.sdk.AppLovinSdk;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.fr */
public final class C0445fr {

    /* renamed from: a */
    private AppLovinSdk f1121a;

    /* renamed from: b */
    private JSONObject f1122b;

    C0445fr(JSONObject jSONObject, AppLovinSdk appLovinSdk) {
        this.f1121a = appLovinSdk;
        this.f1122b = jSONObject;
    }

    /* renamed from: a */
    public Integer mo4721a() {
        String a = C0329bj.m634a(this.f1122b, "mixed_content_mode", (String) null, this.f1121a);
        if (!C0444fq.isValidString(a)) {
            return null;
        }
        if ("always_allow".equalsIgnoreCase(a)) {
            return 0;
        }
        if ("never_allow".equalsIgnoreCase(a)) {
            return 1;
        }
        return "compatibility_mode".equalsIgnoreCase(a) ? 2 : null;
    }

    /* renamed from: b */
    public WebSettings.PluginState mo4722b() {
        String a = C0329bj.m634a(this.f1122b, "plugin_state", (String) null, this.f1121a);
        if (!C0444fq.isValidString(a)) {
            return null;
        }
        if ("on".equalsIgnoreCase(a)) {
            return WebSettings.PluginState.ON;
        }
        if ("on_demand".equalsIgnoreCase(a)) {
            return WebSettings.PluginState.ON_DEMAND;
        }
        if ("off".equalsIgnoreCase(a)) {
            return WebSettings.PluginState.OFF;
        }
        return null;
    }

    /* renamed from: c */
    public Boolean mo4723c() {
        return C0329bj.m632a(this.f1122b, "allow_file_access", (Boolean) null, this.f1121a);
    }

    /* renamed from: d */
    public Boolean mo4724d() {
        return C0329bj.m632a(this.f1122b, "load_with_overview_mode", (Boolean) null, this.f1121a);
    }

    /* renamed from: e */
    public Boolean mo4725e() {
        return C0329bj.m632a(this.f1122b, "use_wide_view_port", (Boolean) null, this.f1121a);
    }

    /* renamed from: f */
    public Boolean mo4726f() {
        return C0329bj.m632a(this.f1122b, "allow_content_access", (Boolean) null, this.f1121a);
    }

    /* renamed from: g */
    public Boolean mo4727g() {
        return C0329bj.m632a(this.f1122b, "use_built_in_zoom_controls", (Boolean) null, this.f1121a);
    }

    /* renamed from: h */
    public Boolean mo4728h() {
        return C0329bj.m632a(this.f1122b, "display_zoom_controls", (Boolean) null, this.f1121a);
    }

    /* renamed from: i */
    public Boolean mo4729i() {
        return C0329bj.m632a(this.f1122b, "save_form_data", (Boolean) null, this.f1121a);
    }

    /* renamed from: j */
    public Boolean mo4730j() {
        return C0329bj.m632a(this.f1122b, "geolocation_enabled", (Boolean) null, this.f1121a);
    }

    /* renamed from: k */
    public Boolean mo4731k() {
        return C0329bj.m632a(this.f1122b, "need_initial_focus", (Boolean) null, this.f1121a);
    }

    /* renamed from: l */
    public Boolean mo4732l() {
        return C0329bj.m632a(this.f1122b, "allow_file_access_from_file_urls", (Boolean) null, this.f1121a);
    }

    /* renamed from: m */
    public Boolean mo4733m() {
        return C0329bj.m632a(this.f1122b, "allow_universal_access_from_file_urls", (Boolean) null, this.f1121a);
    }

    /* renamed from: n */
    public Boolean mo4734n() {
        return C0329bj.m632a(this.f1122b, "offscreen_pre_raster", (Boolean) null, this.f1121a);
    }
}
