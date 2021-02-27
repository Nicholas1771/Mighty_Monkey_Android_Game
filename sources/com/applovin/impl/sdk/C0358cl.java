package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.cl */
class C0358cl {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C0345bz f674a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AppLovinAdLoadListener f675b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AtomicBoolean f676c = new AtomicBoolean();

    C0358cl(C0345bz bzVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f675b = appLovinAdLoadListener;
        this.f674a = bzVar;
    }
}
