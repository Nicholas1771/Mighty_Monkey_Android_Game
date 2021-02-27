package com.applovin.impl.sdk;

import android.net.Uri;
import com.applovin.impl.adview.C0211al;
import com.applovin.sdk.AppLovinSdk;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.g */
public final class C0450g extends C0296ad {
    public C0450g(C0451h hVar, JSONObject jSONObject, JSONObject jSONObject2, AppLovinSdkImpl appLovinSdkImpl) {
        super(hVar, jSONObject, jSONObject2, appLovinSdkImpl);
    }

    /* renamed from: Y */
    private String m1209Y() {
        return C0329bj.m634a(this.f1152b, "stream_url", "", (AppLovinSdk) this.f1154d);
    }

    /* renamed from: a */
    public String mo3855a() {
        return C0329bj.m634a(this.f1152b, "html", (String) null, (AppLovinSdk) this.f1154d);
    }

    /* renamed from: a */
    public void mo4757a(Uri uri) {
        try {
            this.f1152b.put("video", uri.toString());
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public void mo4758a(String str) {
        try {
            this.f1152b.put("html", str);
        } catch (Throwable th) {
        }
    }

    /* renamed from: b */
    public boolean mo3860b() {
        return this.f1152b.has("stream_url");
    }

    /* renamed from: c */
    public void mo4759c() {
        this.f1152b.remove("stream_url");
    }

    /* renamed from: d */
    public Uri mo3864d() {
        String Y = m1209Y();
        if (C0444fq.isValidString(Y)) {
            return Uri.parse(Y);
        }
        String e = mo4760e();
        if (C0444fq.isValidString(e)) {
            return Uri.parse(e);
        }
        return null;
    }

    /* renamed from: e */
    public String mo4760e() {
        return C0329bj.m634a(this.f1152b, "video", "", (AppLovinSdk) this.f1154d);
    }

    /* renamed from: f */
    public boolean mo3867f() {
        return mo3864d() != null;
    }

    /* renamed from: g */
    public Uri mo3868g() {
        String a = C0329bj.m634a(this.f1152b, "click_url", "", (AppLovinSdk) this.f1154d);
        if (C0444fq.isValidString(a)) {
            return Uri.parse(a);
        }
        return null;
    }

    /* renamed from: h */
    public float mo4761h() {
        return C0329bj.m629a(this.f1152b, "mraid_close_delay_graphic", 0.0f, (AppLovinSdk) this.f1154d);
    }

    /* renamed from: i */
    public boolean mo4762i() {
        return C0329bj.m632a(this.f1152b, "close_button_graphic_hidden", (Boolean) false, (AppLovinSdk) this.f1154d).booleanValue();
    }

    /* renamed from: j */
    public boolean mo4763j() {
        if (this.f1152b.has("close_button_expandable_hidden")) {
            return C0329bj.m632a(this.f1152b, "close_button_expandable_hidden", (Boolean) false, (AppLovinSdk) this.f1154d).booleanValue();
        }
        return true;
    }

    /* renamed from: k */
    public C0211al mo4764k() {
        return mo4282a(C0329bj.m630a(this.f1152b, "expandable_style", C0211al.Invisible.ordinal(), (AppLovinSdk) this.f1154d));
    }
}
