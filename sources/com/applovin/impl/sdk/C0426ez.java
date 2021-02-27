package com.applovin.impl.sdk;

import com.applovin.impl.p003a.C0186g;
import com.applovin.sdk.AppLovinAdLoadListener;

/* renamed from: com.applovin.impl.sdk.ez */
final class C0426ez extends C0423ew {

    /* renamed from: a */
    private final C0446fs f1078a;

    C0426ez(C0446fs fsVar, C0186g gVar, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        super(gVar, appLovinAdLoadListener, appLovinSdkImpl);
        if (fsVar == null) {
            throw new IllegalArgumentException("No response specified.");
        } else if (gVar == null) {
            throw new IllegalArgumentException("No context specified.");
        } else if (appLovinAdLoadListener == null) {
            throw new IllegalArgumentException("No callback specified.");
        } else {
            this.f1078a = fsVar;
        }
    }

    public void run() {
        this.f764e.mo4779d(this.f762c, "Processing VAST Wrapper response...");
        mo4691a(this.f1078a);
    }
}
