package com.applovin.impl.sdk;

import android.content.Context;
import com.applovin.sdk.AppLovinLogger;

/* renamed from: com.applovin.impl.sdk.dm */
abstract class C0386dm implements Runnable {

    /* renamed from: c */
    final String f762c;

    /* renamed from: d */
    protected final AppLovinSdkImpl f763d;

    /* renamed from: e */
    final AppLovinLogger f764e;

    /* renamed from: f */
    final Context f765f;

    C0386dm(String str, AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f763d = appLovinSdkImpl;
        this.f762c = str == null ? getClass().getSimpleName() : str;
        this.f764e = appLovinSdkImpl.getLogger();
        this.f765f = appLovinSdkImpl.getApplicationContext();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo4527a() {
        return this.f762c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4528b() {
    }
}
