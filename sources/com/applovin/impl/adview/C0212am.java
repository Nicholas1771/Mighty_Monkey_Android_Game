package com.applovin.impl.adview;

import android.os.Handler;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.applovin.impl.adview.am */
public final class C0212am {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AppLovinLogger f216a;

    /* renamed from: b */
    private final Handler f217b;

    /* renamed from: c */
    private final Set<C0215ap> f218c = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final AtomicInteger f219d = new AtomicInteger();

    public C0212am(Handler handler, AppLovinSdk appLovinSdk) {
        if (handler == null) {
            throw new IllegalArgumentException("No handler specified.");
        } else if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified.");
        } else {
            this.f217b = handler;
            this.f216a = appLovinSdk.getLogger();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m198a(C0215ap apVar, int i) {
        this.f217b.postDelayed(new C0213an(this, apVar, i), apVar.m208b());
    }

    /* renamed from: a */
    public void mo3994a() {
        HashSet<C0215ap> hashSet = new HashSet<>(this.f218c);
        this.f216a.mo4779d("CountdownManager", "Starting " + hashSet.size() + " countdowns...");
        int incrementAndGet = this.f219d.incrementAndGet();
        for (C0215ap apVar : hashSet) {
            this.f216a.mo4779d("CountdownManager", "Starting countdown: " + apVar.m206a() + " for generation " + incrementAndGet + "...");
            m198a(apVar, incrementAndGet);
        }
    }

    /* renamed from: a */
    public void mo3995a(String str, long j, C0214ao aoVar) {
        if (j <= 0) {
            throw new IllegalArgumentException("Invalid step specified.");
        } else if (this.f217b == null) {
            throw new IllegalArgumentException("No handler specified.");
        } else {
            this.f216a.mo4779d("CountdownManager", "Adding countdown: " + str);
            this.f218c.add(new C0215ap(str, j, aoVar, (C0213an) null));
        }
    }

    /* renamed from: b */
    public void mo3996b() {
        this.f216a.mo4779d("CountdownManager", "Removing all countdowns...");
        mo3997c();
        this.f218c.clear();
    }

    /* renamed from: c */
    public void mo3997c() {
        this.f216a.mo4779d("CountdownManager", "Stopping countdowns...");
        this.f219d.incrementAndGet();
        this.f217b.removeCallbacksAndMessages((Object) null);
    }
}
