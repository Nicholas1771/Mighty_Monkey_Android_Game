package com.applovin.impl.sdk;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.p003a.C0180a;
import com.applovin.impl.p003a.C0185f;
import com.applovin.impl.p003a.C0188i;
import com.applovin.impl.p003a.C0189j;
import com.applovin.impl.p003a.C0197r;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.sdk.ee */
class C0405ee extends C0398dy {

    /* renamed from: a */
    private final C0180a f1026a;

    public C0405ee(C0180a aVar, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        super("TaskCacheVastAd", aVar, appLovinAdLoadListener, appLovinSdkImpl);
        this.f1026a = aVar;
    }

    /* renamed from: e */
    private void m982e() {
        if (this.f1026a.mo3859a((AppLovinSdk) this.f763d)) {
            C0185f e = this.f1026a.mo3865e();
            if (e != null) {
                C0188i b = e.mo3888b();
                if (b != null) {
                    try {
                        Uri b2 = b.mo3905b();
                        String uri = b2 != null ? b2.toString() : "";
                        String c = b.mo3906c();
                        if (!URLUtil.isValidUrl(uri) && !C0444fq.isValidString(c)) {
                            this.f764e.mo4785w(this.f762c, "Companion ad does not have any resources attached. Skipping...");
                        } else if (b.mo3902a() == C0189j.STATIC) {
                            this.f764e.mo4779d(this.f762c, "Caching static companion ad at " + uri + "...");
                            Uri b3 = mo4645b(uri, false);
                            if (b3 != null) {
                                b.mo3903a(b3);
                            } else {
                                this.f764e.mo4780e(this.f762c, "Failed to cache static companion ad");
                            }
                        } else if (b.mo3902a() == C0189j.HTML) {
                            if (C0444fq.isValidString(uri)) {
                                this.f764e.mo4779d(this.f762c, "Begin caching HTML companion ad. Fetching from " + uri + "...");
                                String c2 = mo4646c(uri);
                                if (C0444fq.isValidString(c2)) {
                                    this.f764e.mo4779d(this.f762c, "HTML fetched. Caching HTML now...");
                                    b.mo3904a(mo4643a(c2, this.f1026a.mo3869h()));
                                    return;
                                }
                                this.f764e.mo4780e(this.f762c, "Unable to load companion ad resources from " + uri);
                                return;
                            }
                            this.f764e.mo4779d(this.f762c, "Caching provided HTML for companion ad. No fetch required. HTML: " + c);
                            b.mo3904a(mo4643a(c, this.f1026a.mo3869h()));
                        } else if (b.mo3902a() == C0189j.IFRAME) {
                            this.f764e.mo4779d(this.f762c, "Skip caching of iFrame resource...");
                        }
                    } catch (Throwable th) {
                        this.f764e.mo4781e(this.f762c, "Failed to cache companion ad", th);
                    }
                } else {
                    this.f764e.mo4780e(this.f762c, "Failed to retrieve non-video resources from companion ad. Skipping...");
                }
            } else {
                this.f764e.mo4779d(this.f762c, "No companion ad provided. Skipping...");
            }
        } else {
            this.f764e.mo4779d(this.f762c, "Companion ad caching disabled. Skipping...");
        }
    }

    /* renamed from: f */
    private void m983f() {
        C0197r c;
        Uri b;
        if (!this.f1026a.mo3861b(this.f763d)) {
            this.f764e.mo4779d(this.f762c, "Video caching disabled. Skipping...");
        } else if (this.f1026a.mo3855a() != null && (c = this.f1026a.mo3862c()) != null && (b = c.mo3931b()) != null) {
            Uri a = mo4642a(b.toString(), false);
            if (a != null) {
                this.f764e.mo4779d(this.f762c, "Video file successfully cached into: " + a);
                c.mo3930a(a);
                return;
            }
            this.f764e.mo4780e(this.f762c, "Failed to cache video file: " + c);
        }
    }

    /* renamed from: g */
    private void m984g() {
        String i;
        if (this.f1026a.mo3872j() != null) {
            this.f764e.mo4779d(this.f762c, "Begin caching HTML template. Fetching from " + this.f1026a.mo3872j() + "...");
            i = mo4647c(this.f1026a.mo3872j().toString(), false);
        } else {
            i = this.f1026a.mo3871i();
        }
        if (C0444fq.isValidString(i)) {
            this.f1026a.mo3863c(mo4643a(i, this.f763d.getSettingsManager().mo4539b(C0387dn.f775J)));
            this.f764e.mo4779d(this.f762c, "Finish caching HTML template " + this.f1026a.mo3871i() + " for ad #" + this.f1026a.getAdIdNumber());
            return;
        }
        this.f764e.mo4779d(this.f762c, "Unable to load HTML template");
    }

    public void run() {
        this.f764e.mo4779d(this.f762c, "Begin caching for VAST ad #" + this.f1026a.getAdIdNumber() + "...");
        mo4648c();
        m982e();
        m983f();
        m984g();
        mo4649d();
        this.f764e.mo4779d(this.f762c, "Finished caching VAST ad #" + this.f1026a.getAdIdNumber());
    }
}
