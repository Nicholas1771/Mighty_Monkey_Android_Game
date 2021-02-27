package com.applovin.impl.adview;

import com.applovin.impl.sdk.C0329bj;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.adview.ck */
public class C0264ck {

    /* renamed from: a */
    private final AppLovinLogger f347a;

    /* renamed from: b */
    private int f348b;

    /* renamed from: c */
    private int f349c;

    /* renamed from: d */
    private int f350d;

    /* renamed from: e */
    private int f351e;

    /* renamed from: f */
    private boolean f352f;

    /* renamed from: g */
    private int f353g;

    /* renamed from: h */
    private int f354h;

    /* renamed from: i */
    private int f355i;

    /* renamed from: j */
    private float f356j;

    /* renamed from: k */
    private float f357k;

    public C0264ck(JSONObject jSONObject, AppLovinSdk appLovinSdk) {
        this.f347a = appLovinSdk.getLogger();
        this.f347a.mo4782i("VideoButtonProperties", "Updating video button properties with JSON = " + jSONObject);
        this.f348b = C0329bj.m630a(jSONObject, "width", 64, appLovinSdk);
        this.f349c = C0329bj.m630a(jSONObject, "height", 7, appLovinSdk);
        this.f350d = C0329bj.m630a(jSONObject, "margin", 20, appLovinSdk);
        this.f351e = C0329bj.m630a(jSONObject, "gravity", 85, appLovinSdk);
        this.f352f = C0329bj.m632a(jSONObject, "tap_to_fade", (Boolean) false, appLovinSdk).booleanValue();
        this.f353g = C0329bj.m630a(jSONObject, "tap_to_fade_duration_milliseconds", 500, appLovinSdk);
        this.f354h = C0329bj.m630a(jSONObject, "fade_in_duration_milliseconds", 500, appLovinSdk);
        this.f355i = C0329bj.m630a(jSONObject, "fade_out_duration_milliseconds", 500, appLovinSdk);
        this.f356j = C0329bj.m629a(jSONObject, "fade_in_delay_seconds", 1.0f, appLovinSdk);
        this.f357k = C0329bj.m629a(jSONObject, "fade_out_delay_seconds", 6.0f, appLovinSdk);
    }

    /* renamed from: a */
    public int mo4091a() {
        return this.f348b;
    }

    /* renamed from: b */
    public int mo4092b() {
        return this.f349c;
    }

    /* renamed from: c */
    public int mo4093c() {
        return this.f350d;
    }

    /* renamed from: d */
    public int mo4094d() {
        return this.f351e;
    }

    /* renamed from: e */
    public boolean mo4095e() {
        return this.f352f;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0264ck ckVar = (C0264ck) obj;
        if (this.f348b != ckVar.f348b || this.f349c != ckVar.f349c || this.f350d != ckVar.f350d || this.f351e != ckVar.f351e || this.f352f != ckVar.f352f || this.f353g != ckVar.f353g || this.f354h != ckVar.f354h || this.f355i != ckVar.f355i || Float.compare(ckVar.f356j, this.f356j) != 0) {
            return false;
        }
        if (Float.compare(ckVar.f357k, this.f357k) != 0) {
            z = false;
        }
        return z;
    }

    /* renamed from: f */
    public long mo4097f() {
        return (long) this.f353g;
    }

    /* renamed from: g */
    public long mo4098g() {
        return (long) this.f354h;
    }

    /* renamed from: h */
    public long mo4099h() {
        return (long) this.f355i;
    }

    public int hashCode() {
        int i = 0;
        int floatToIntBits = ((this.f356j != 0.0f ? Float.floatToIntBits(this.f356j) : 0) + (((((((((this.f352f ? 1 : 0) + (((((((this.f348b * 31) + this.f349c) * 31) + this.f350d) * 31) + this.f351e) * 31)) * 31) + this.f353g) * 31) + this.f354h) * 31) + this.f355i) * 31)) * 31;
        if (this.f357k != 0.0f) {
            i = Float.floatToIntBits(this.f357k);
        }
        return floatToIntBits + i;
    }

    /* renamed from: i */
    public float mo4101i() {
        return this.f356j;
    }

    /* renamed from: j */
    public float mo4102j() {
        return this.f357k;
    }

    public String toString() {
        return "VideoButtonProperties{widthPercentOfScreen=" + this.f348b + ", heightPercentOfScreen=" + this.f349c + ", margin=" + this.f350d + ", gravity=" + this.f351e + ", tapToFade=" + this.f352f + ", tapToFadeDurationMillis=" + this.f353g + ", fadeInDurationMillis=" + this.f354h + ", fadeOutDurationMillis=" + this.f355i + ", fadeInDelay=" + this.f356j + ", fadeOutDelay=" + this.f357k + '}';
    }
}
