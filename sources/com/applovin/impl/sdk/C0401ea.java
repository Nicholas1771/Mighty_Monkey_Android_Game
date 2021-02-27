package com.applovin.impl.sdk;

import android.net.Uri;
import com.applovin.sdk.AppLovinAdLoadListener;

/* renamed from: com.applovin.impl.sdk.ea */
public class C0401ea extends C0398dy {

    /* renamed from: a */
    private final C0450g f1020a;

    /* renamed from: b */
    private boolean f1021b;

    public C0401ea(C0450g gVar, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        super("TaskCacheAppLovinAd", gVar, appLovinAdLoadListener, appLovinSdkImpl);
        this.f1020a = gVar;
    }

    /* renamed from: e */
    private void m965e() {
        this.f764e.mo4779d(this.f762c, "Caching HTML resources...");
        this.f1020a.mo4758a(mo4643a(this.f1020a.mo3855a(), this.f763d.getSettingsManager().mo4539b(C0387dn.f775J)));
        this.f764e.mo4779d(this.f762c, "Finish caching non-video resources for ad #" + this.f1020a.getAdIdNumber());
        this.f764e.mo4779d(this.f762c, "Ad updated with cachedHTML = " + this.f1020a.mo3855a());
    }

    /* renamed from: f */
    private void m966f() {
        Uri a = mo4641a(this.f1020a.mo4760e());
        if (a != null) {
            this.f1020a.mo4759c();
            this.f1020a.mo4757a(a);
        }
    }

    /* renamed from: a */
    public void mo4652a(boolean z) {
        this.f1021b = z;
    }

    public void run() {
        if (this.f1020a.mo3860b()) {
            this.f764e.mo4779d(this.f762c, "Begin caching for streaming ad #" + this.f1020a.getAdIdNumber() + "...");
            mo4648c();
            if (this.f1021b) {
                this.f764e.mo4779d(this.f762c, "Calling back ad load immediately");
                mo4649d();
            }
            m965e();
            if (!this.f1021b) {
                this.f764e.mo4779d(this.f762c, "Calling back ad load AFTER caching endcard");
                mo4649d();
            }
            m966f();
            return;
        }
        this.f764e.mo4779d(this.f762c, "Begin processing for non-streaming ad #" + this.f1020a.getAdIdNumber() + "...");
        mo4648c();
        m965e();
        m966f();
        this.f764e.mo4779d(this.f762c, "Caching finished. Calling back ad load success...");
        mo4649d();
    }
}
