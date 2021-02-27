package com.applovin.impl.p003a;

import com.applovin.impl.sdk.C0329bj;
import com.applovin.impl.sdk.C0444fq;
import com.applovin.impl.sdk.C0446fs;
import com.applovin.impl.sdk.C0451h;
import com.applovin.impl.sdk.C0462s;
import com.applovin.sdk.AppLovinSdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.a.g */
public class C0186g {

    /* renamed from: b */
    private static final List<String> f66b = Arrays.asList(new String[]{"video/mp4", "video/webm", "video/3gpp", "video/x-matroska"});

    /* renamed from: a */
    protected List<C0446fs> f67a;

    /* renamed from: c */
    private final C0451h f68c;

    /* renamed from: d */
    private final JSONObject f69d;

    /* renamed from: e */
    private final JSONObject f70e;

    public C0186g(C0451h hVar, JSONObject jSONObject, JSONObject jSONObject2) {
        if (hVar == null) {
            throw new IllegalArgumentException("No ad spec specified.");
        } else if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified.");
        } else {
            this.f68c = hVar;
            this.f69d = jSONObject;
            this.f70e = jSONObject2;
            this.f67a = new ArrayList();
        }
    }

    /* renamed from: a */
    public int mo3894a() {
        return this.f67a.size();
    }

    /* renamed from: b */
    public List<C0446fs> mo3895b() {
        return this.f67a;
    }

    /* renamed from: c */
    public JSONObject mo3896c() {
        return this.f69d;
    }

    /* renamed from: d */
    public JSONObject mo3897d() {
        return this.f70e;
    }

    /* renamed from: e */
    public C0451h mo3898e() {
        return this.f68c;
    }

    /* renamed from: f */
    public List<String> mo3899f() {
        List<String> a = C0462s.m1246a(C0329bj.m634a(this.f69d, "vast_preferred_video_types", (String) null, (AppLovinSdk) null));
        return !a.isEmpty() ? a : f66b;
    }

    /* renamed from: g */
    public int mo3900g() {
        return C0444fq.m1152a(this.f69d);
    }
}
