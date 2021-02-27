package com.applovin.impl.sdk;

import android.app.Activity;
import com.applovin.sdk.AppLovinAdRewardListener;
import java.util.Timer;

/* renamed from: com.applovin.impl.sdk.av */
class C0314av {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AppLovinSdkImpl f552a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C0305am f553b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Activity f554c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Runnable f555d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final AppLovinAdRewardListener f556e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Timer f557f;

    private C0314av(C0320ba baVar) {
        this.f552a = baVar.f568a;
        this.f553b = baVar.f569b;
        this.f554c = baVar.f570c;
        this.f555d = baVar.f572e;
        this.f556e = baVar.f571d;
        this.f557f = new Timer("IncentivizedAdLauncher");
    }

    /* synthetic */ C0314av(C0320ba baVar, C0315aw awVar) {
        this(baVar);
    }

    /* renamed from: b */
    static C0320ba m592b() {
        return new C0320ba((C0315aw) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4345a() {
        this.f554c.runOnUiThread(new C0315aw(this));
    }
}
