package com.applovin.impl.sdk;

import com.applovin.impl.p003a.C0186g;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ex */
final class C0424ex extends C0186g {
    C0424ex(C0451h hVar, JSONObject jSONObject, JSONObject jSONObject2) {
        super(hVar, jSONObject, jSONObject2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4692a(C0446fs fsVar) {
        if (fsVar == null) {
            throw new IllegalArgumentException("No aggregated vast response specified");
        }
        this.f67a.add(fsVar);
    }
}
