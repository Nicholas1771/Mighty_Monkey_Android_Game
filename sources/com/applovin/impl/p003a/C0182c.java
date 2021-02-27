package com.applovin.impl.p003a;

import com.applovin.impl.sdk.AppLovinSdkImpl;
import com.applovin.impl.sdk.C0451h;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.a.c */
public class C0182c {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C0451h f39a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public JSONObject f40b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public JSONObject f41c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AppLovinSdkImpl f42d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f43e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f44f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C0190k f45g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C0194o f46h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C0185f f47i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Set<C0191l> f48j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Set<C0191l> f49k;

    private C0182c() {
    }

    /* renamed from: a */
    public C0180a mo3875a() {
        return new C0180a(this);
    }

    /* renamed from: a */
    public C0182c mo3876a(C0185f fVar) {
        this.f47i = fVar;
        return this;
    }

    /* renamed from: a */
    public C0182c mo3877a(C0190k kVar) {
        this.f45g = kVar;
        return this;
    }

    /* renamed from: a */
    public C0182c mo3878a(C0194o oVar) {
        this.f46h = oVar;
        return this;
    }

    /* renamed from: a */
    public C0182c mo3879a(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        this.f42d = appLovinSdkImpl;
        return this;
    }

    /* renamed from: a */
    public C0182c mo3880a(C0451h hVar) {
        if (hVar == null) {
            throw new IllegalArgumentException("No ad spec specified.");
        }
        this.f39a = hVar;
        return this;
    }

    /* renamed from: a */
    public C0182c mo3881a(String str) {
        this.f43e = str;
        return this;
    }

    /* renamed from: a */
    public C0182c mo3882a(Set<C0191l> set) {
        this.f48j = set;
        return this;
    }

    /* renamed from: a */
    public C0182c mo3883a(JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No ad object specified.");
        }
        this.f40b = jSONObject;
        return this;
    }

    /* renamed from: b */
    public C0182c mo3884b(String str) {
        this.f44f = str;
        return this;
    }

    /* renamed from: b */
    public C0182c mo3885b(Set<C0191l> set) {
        this.f49k = set;
        return this;
    }

    /* renamed from: b */
    public C0182c mo3886b(JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No full ad response specified.");
        }
        this.f41c = jSONObject;
        return this;
    }
}
