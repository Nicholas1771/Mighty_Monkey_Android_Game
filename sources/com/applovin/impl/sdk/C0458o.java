package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdUpdateListener;
import java.util.Collection;
import java.util.HashSet;

/* renamed from: com.applovin.impl.sdk.o */
class C0458o {

    /* renamed from: a */
    final C0451h f1165a;

    /* renamed from: b */
    final Object f1166b;

    /* renamed from: c */
    AppLovinAd f1167c;

    /* renamed from: d */
    long f1168d;

    /* renamed from: e */
    boolean f1169e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Collection<AppLovinAdUpdateListener> f1170f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Collection<AppLovinAdLoadListener> f1171g;

    private C0458o(C0451h hVar) {
        this.f1170f = new HashSet();
        this.f1171g = new HashSet();
        this.f1165a = hVar;
        this.f1166b = new Object();
        this.f1167c = null;
        this.f1168d = 0;
        this.f1169e = false;
    }

    /* synthetic */ C0458o(C0451h hVar, C0454k kVar) {
        this(hVar);
    }
}
