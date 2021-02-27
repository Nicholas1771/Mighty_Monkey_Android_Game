package com.applovin.impl.sdk;

import android.graphics.Color;
import android.net.Uri;
import android.support.p000v4.view.ViewCompat;
import com.applovin.impl.adview.C0211al;
import com.applovin.impl.adview.C0264ck;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ad */
public abstract class C0296ad extends C0453j {
    public C0296ad(C0451h hVar, JSONObject jSONObject, JSONObject jSONObject2, AppLovinSdkImpl appLovinSdkImpl) {
        super(hVar, jSONObject, jSONObject2, appLovinSdkImpl);
    }

    /* renamed from: a */
    private float m474a(AppLovinAdType appLovinAdType, float f, boolean z) {
        if (appLovinAdType.equals(AppLovinAdType.INCENTIVIZED)) {
            return 0.5f;
        }
        return (!appLovinAdType.equals(AppLovinAdType.REGULAR) || !z || f != -1.0f) ? 0.0f : 0.5f;
    }

    /* renamed from: a */
    private C0211al m475a(boolean z) {
        return z ? C0211al.WhiteXOnTransparentGrey : C0211al.WhiteXOnOpaqueBlack;
    }

    /* renamed from: A */
    public boolean mo4258A() {
        return C0329bj.m632a(this.f1152b, "hide_close_on_exit", (Boolean) false, (AppLovinSdk) this.f1154d).booleanValue();
    }

    /* renamed from: B */
    public boolean mo4259B() {
        return C0329bj.m632a(this.f1152b, "lock_current_orientation", (Boolean) false, (AppLovinSdk) this.f1154d).booleanValue();
    }

    /* renamed from: C */
    public int mo4260C() {
        return C0329bj.m630a(this.f1152b, "countdown_length", 0, (AppLovinSdk) this.f1154d);
    }

    /* renamed from: D */
    public int mo4261D() {
        int parseColor = Color.parseColor("#C8FFFFFF");
        String a = C0329bj.m634a(this.f1152b, "countdown_color", (String) null, (AppLovinSdk) this.f1154d);
        if (!C0444fq.isValidString(a)) {
            return parseColor;
        }
        try {
            return Color.parseColor(a);
        } catch (Throwable th) {
            this.f1154d.getLogger().mo4781e("DirectAd", "Unable to parse countdown color", th);
            return parseColor;
        }
    }

    /* renamed from: E */
    public int mo4262E() {
        String a = C0329bj.m634a(this.f1152b, "video_background_color", (String) null, (AppLovinSdk) this.f1154d);
        if (!C0444fq.isValidString(a)) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        try {
            return Color.parseColor(a);
        } catch (Throwable th) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
    }

    /* renamed from: F */
    public int mo4263F() {
        int i = mo3867f() ? ViewCompat.MEASURED_STATE_MASK : -1157627904;
        String a = C0329bj.m634a(this.f1152b, "graphic_background_color", (String) null, (AppLovinSdk) this.f1154d);
        if (!C0444fq.isValidString(a)) {
            return i;
        }
        try {
            return Color.parseColor(a);
        } catch (Throwable th) {
            return i;
        }
    }

    /* renamed from: G */
    public C0297ae mo4264G() {
        String a = C0329bj.m634a(this.f1152b, "poststitial_dismiss_type", (String) null, (AppLovinSdk) this.f1154d);
        if (C0444fq.isValidString(a)) {
            if ("dismiss".equalsIgnoreCase(a)) {
                return C0297ae.DISMISS;
            }
            if ("no_dismiss".equalsIgnoreCase(a)) {
                return C0297ae.DO_NOT_DISMISS;
            }
        }
        return C0297ae.UNSPECIFIED;
    }

    /* renamed from: H */
    public String mo4265H() {
        return C0329bj.m634a(this.f1152b, "cache_prefix", (String) null, (AppLovinSdk) this.f1154d);
    }

    /* renamed from: I */
    public boolean mo4266I() {
        return C0329bj.m632a(this.f1152b, "progress_bar_enabled", (Boolean) false, (AppLovinSdk) this.f1154d).booleanValue();
    }

    /* renamed from: J */
    public int mo4267J() {
        String a = C0329bj.m634a(this.f1152b, "progress_bar_color", "#C8FFFFFF", (AppLovinSdk) this.f1154d);
        if (!C0444fq.isValidString(a)) {
            return 0;
        }
        try {
            return Color.parseColor(a);
        } catch (Throwable th) {
            return 0;
        }
    }

    /* renamed from: K */
    public int mo4268K() {
        return C0444fq.m1152a(this.f1152b);
    }

    /* renamed from: L */
    public int mo4269L() {
        return C0329bj.m630a(this.f1152b, "close_button_size", ((Integer) this.f1154d.get(C0387dn.f803aK)).intValue(), (AppLovinSdk) this.f1154d);
    }

    /* renamed from: M */
    public int mo4270M() {
        return C0329bj.m630a(this.f1152b, "close_button_top_margin", ((Integer) this.f1154d.get(C0387dn.f804aL)).intValue(), (AppLovinSdk) this.f1154d);
    }

    /* renamed from: N */
    public int mo4271N() {
        return C0329bj.m630a(this.f1152b, "close_button_horizontal_margin", ((Integer) this.f1154d.get(C0387dn.f805aM)).intValue(), (AppLovinSdk) this.f1154d);
    }

    /* renamed from: O */
    public boolean mo4272O() {
        return C0329bj.m632a(this.f1152b, "lhs_close_button", (Boolean) this.f1154d.get(C0387dn.f891bt), (AppLovinSdk) this.f1154d).booleanValue();
    }

    /* renamed from: P */
    public boolean mo4273P() {
        return C0329bj.m632a(this.f1152b, "lhs_skip_button", (Boolean) this.f1154d.get(C0387dn.f892bu), (AppLovinSdk) this.f1154d).booleanValue();
    }

    /* renamed from: Q */
    public boolean mo4274Q() {
        return C0329bj.m632a(this.f1152b, "render_poststitial_on_attach", (Boolean) false, (AppLovinSdk) this.f1154d).booleanValue();
    }

    /* renamed from: R */
    public boolean mo4275R() {
        return C0329bj.m632a(this.f1152b, "playback_requires_user_action", (Boolean) true, (AppLovinSdk) this.f1154d).booleanValue();
    }

    /* renamed from: S */
    public boolean mo4276S() {
        return C0329bj.m632a(this.f1152b, "sanitize_webview", (Boolean) false, (AppLovinSdk) this.f1154d).booleanValue();
    }

    /* renamed from: T */
    public String mo4277T() {
        String a = C0329bj.m634a(this.f1152b, "base_url", "/", (AppLovinSdk) this.f1154d);
        if ("null".equalsIgnoreCase(a)) {
            return null;
        }
        return a;
    }

    /* renamed from: U */
    public boolean mo4278U() {
        return C0329bj.m632a(this.f1152b, "web_contents_debugging_enabled", (Boolean) false, (AppLovinSdk) this.f1154d).booleanValue();
    }

    /* renamed from: V */
    public C0445fr mo4279V() {
        JSONObject a = C0329bj.m638a(this.f1152b, "web_view_settings", (JSONObject) null, (AppLovinSdk) this.f1154d);
        if (a != null) {
            return new C0445fr(a, this.f1154d);
        }
        return null;
    }

    /* renamed from: W */
    public Uri mo4280W() {
        String a = C0329bj.m634a(this.f1152b, "mute_image", (String) null, (AppLovinSdk) this.f1154d);
        if (!AppLovinSdkUtils.isValidString(a)) {
            return null;
        }
        try {
            return Uri.parse(a);
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: X */
    public Uri mo4281X() {
        String a = C0329bj.m634a(this.f1152b, "unmute_image", "", (AppLovinSdk) this.f1154d);
        if (!AppLovinSdkUtils.isValidString(a)) {
            return null;
        }
        try {
            return Uri.parse(a);
        } catch (Throwable th) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0211al mo4282a(int i) {
        return i == 1 ? C0211al.WhiteXOnTransparentGrey : i == 2 ? C0211al.Invisible : C0211al.WhiteXOnOpaqueBlack;
    }

    /* renamed from: a */
    public String mo4283a(int i, String str, boolean z) {
        String t = mo4298t();
        return AppLovinSdkUtils.isValidString(t) ? C0444fq.m1160a(str, Uri.parse(t.replace("{CLCODE}", mo4291l())).buildUpon().appendQueryParameter(NativeAdImpl.QUERY_PARAM_VIDEO_PERCENT_VIEWED, Integer.toString(i)).appendQueryParameter("vid_ts", Long.toString(System.currentTimeMillis())).appendQueryParameter("uvs", Boolean.toString(z)).build().toString()) : "";
    }

    /* renamed from: b */
    public String mo4284b(String str) {
        String a = C0329bj.m634a(this.f1152b, "click_tracking_url", "", (AppLovinSdk) this.f1154d);
        return AppLovinSdkUtils.isValidString(a) ? C0444fq.m1160a(str, a.replace("{CLCODE}", mo4291l())) : "";
    }

    /* renamed from: b */
    public void mo4285b(Uri uri) {
        try {
            this.f1152b.put("mute_image", uri);
        } catch (Throwable th) {
        }
    }

    /* renamed from: b */
    public boolean mo3860b() {
        this.f1154d.getLogger().mo4780e("DirectAd", "Attempting to invoke isVideoStream() from base ad class");
        return false;
    }

    /* renamed from: c */
    public void mo4286c(Uri uri) {
        try {
            this.f1152b.put("unmute_image", uri);
        } catch (Throwable th) {
        }
    }

    /* renamed from: d */
    public Uri mo3864d() {
        this.f1154d.getLogger().mo4780e("DirectAd", "Attempting to invoke getVideoUri() from base ad class");
        return null;
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* renamed from: f */
    public /* bridge */ /* synthetic */ boolean mo3867f() {
        return super.mo3867f();
    }

    /* renamed from: g */
    public Uri mo3868g() {
        this.f1154d.getLogger().mo4780e("DirectAd", "Attempting to invoke getClickDestinationUri() from base ad class");
        return null;
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

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
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

    /* renamed from: o */
    public C0298af mo4293o() {
        String upperCase = C0329bj.m634a(this.f1152b, "ad_target", C0298af.DEFAULT.toString(), (AppLovinSdk) this.f1154d).toUpperCase(Locale.ENGLISH);
        return "ACTIVITY_PORTRAIT".equalsIgnoreCase(upperCase) ? C0298af.ACTIVITY_PORTRAIT : "ACTIVITY_LANDSCAPE".equalsIgnoreCase(upperCase) ? C0298af.ACTIVITY_LANDSCAPE : C0298af.DEFAULT;
    }

    /* renamed from: p */
    public float mo4294p() {
        return C0329bj.m629a(this.f1152b, "close_delay", 0.0f, (AppLovinSdk) this.f1154d);
    }

    /* renamed from: q */
    public float mo4295q() {
        return C0329bj.m629a(this.f1152b, "close_delay_graphic", m474a(getType(), mo4294p(), mo3867f()), (AppLovinSdk) this.f1154d);
    }

    /* renamed from: r */
    public C0211al mo4296r() {
        int a = C0329bj.m630a(this.f1152b, "close_style", -1, (AppLovinSdk) this.f1154d);
        return a == -1 ? m475a(mo3867f()) : mo4282a(a);
    }

    /* renamed from: s */
    public C0211al mo4297s() {
        int a = C0329bj.m630a(this.f1152b, "skip_style", -1, (AppLovinSdk) this.f1154d);
        return a == -1 ? mo4296r() : mo4282a(a);
    }

    /* renamed from: t */
    public String mo4298t() {
        return C0329bj.m634a(this.f1152b, "video_end_url", "", (AppLovinSdk) this.f1154d);
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* renamed from: u */
    public boolean mo4299u() {
        return C0329bj.m632a(this.f1152b, "dismiss_on_skip", (Boolean) false, (AppLovinSdk) this.f1154d).booleanValue();
    }

    /* renamed from: v */
    public String mo4300v() {
        JSONObject a = C0329bj.m638a(this.f1152b, "video_button_properties", (JSONObject) null, (AppLovinSdk) this.f1154d);
        return a != null ? C0329bj.m634a(a, "video_button_html", "", (AppLovinSdk) this.f1154d) : "";
    }

    /* renamed from: w */
    public C0264ck mo4301w() {
        return new C0264ck(C0329bj.m638a(this.f1152b, "video_button_properties", (JSONObject) null, (AppLovinSdk) this.f1154d), this.f1154d);
    }

    /* renamed from: x */
    public boolean mo3874x() {
        return C0329bj.m632a(this.f1152b, "video_clickable", (Boolean) false, (AppLovinSdk) this.f1154d).booleanValue();
    }

    /* renamed from: y */
    public boolean mo4302y() {
        return C0329bj.m632a(this.f1152b, "accelerate_hardware", (Boolean) false, (AppLovinSdk) this.f1154d).booleanValue();
    }

    /* renamed from: z */
    public boolean mo4303z() {
        return C0329bj.m632a(this.f1152b, "hide_close_on_exit_graphic", (Boolean) false, (AppLovinSdk) this.f1154d).booleanValue();
    }
}
