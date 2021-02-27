package com.applovin.impl.sdk;

import android.app.Activity;
import com.applovin.sdk.AppLovinAdRewardListener;

/* renamed from: com.applovin.impl.sdk.ba */
class C0320ba {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AppLovinSdkImpl f568a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C0305am f569b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Activity f570c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AppLovinAdRewardListener f571d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Runnable f572e;

    private C0320ba() {
    }

    /* synthetic */ C0320ba(C0315aw awVar) {
        this();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0314av mo4360a() {
        return new C0314av(this, (C0315aw) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0320ba mo4361a(Activity activity) {
        this.f570c = activity;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0320ba mo4362a(AppLovinSdkImpl appLovinSdkImpl) {
        this.f568a = appLovinSdkImpl;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0320ba mo4363a(C0305am amVar) {
        this.f569b = amVar;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0320ba mo4364a(AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f571d = appLovinAdRewardListener;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0320ba mo4365a(Runnable runnable) {
        this.f572e = runnable;
        return this;
    }
}
