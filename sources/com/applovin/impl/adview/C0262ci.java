package com.applovin.impl.adview;

import android.net.Uri;
import android.os.Bundle;
import com.applovin.impl.p003a.C0180a;
import com.applovin.impl.p003a.C0184e;
import com.applovin.impl.p003a.C0187h;
import com.applovin.impl.p003a.C0191l;
import com.applovin.impl.p003a.C0192m;
import com.applovin.impl.p003a.C0193n;
import com.applovin.impl.p003a.C0197r;
import com.applovin.impl.sdk.C0444fq;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.adview.ci */
public class C0262ci extends C0225az {

    /* renamed from: a */
    private final Set<C0191l> f345a = new HashSet();

    /* renamed from: a */
    private void m355a() {
        if (isFullyWatched() && !this.f345a.isEmpty()) {
            this.logger.mo4785w("InterstitialActivity", "Firing " + this.f345a.size() + " un-fired video progress trackers when video was completed.");
            m360a(this.f345a);
        }
    }

    /* renamed from: a */
    private void m356a(C0184e eVar) {
        m357a(eVar, C0187h.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m357a(C0184e eVar, C0187h hVar) {
        m359a(eVar, "", hVar);
    }

    /* renamed from: a */
    private void m358a(C0184e eVar, String str) {
        m359a(eVar, str, C0187h.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m359a(C0184e eVar, String str, C0187h hVar) {
        if (m362b()) {
            m361a(((C0180a) this.currentAd).mo3857a(eVar, str), hVar);
        }
    }

    /* renamed from: a */
    private void m360a(Set<C0191l> set) {
        m361a(set, C0187h.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m361a(Set<C0191l> set, C0187h hVar) {
        if (m362b() && set != null && !set.isEmpty()) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds((long) this.videoView.getCurrentPosition());
            C0197r c = m363c().mo3862c();
            Uri a = c != null ? c.mo3929a() : null;
            this.logger.mo4779d("InterstitialActivity", "Firing " + set.size() + " tracker(s): " + set);
            C0193n.m107a(set, seconds, a, hVar, this.sdk);
        }
    }

    /* renamed from: b */
    private boolean m362b() {
        return this.currentAd instanceof C0180a;
    }

    /* renamed from: c */
    private C0180a m363c() {
        if (this.currentAd instanceof C0180a) {
            return (C0180a) this.currentAd;
        }
        return null;
    }

    public void clickThroughFromVideo() {
        super.clickThroughFromVideo();
        m356a(C0184e.VIDEO_CLICK);
    }

    public void dismiss() {
        if (m362b()) {
            m358a(C0184e.VIDEO, "close");
            m358a(C0184e.COMPANION, "close");
        }
        super.dismiss();
    }

    public void handleCountdownStep() {
        if (m362b()) {
            long seconds = ((long) this.computedLengthSeconds) - TimeUnit.MILLISECONDS.toSeconds((long) (this.videoView.getDuration() - this.videoView.getCurrentPosition()));
            HashSet hashSet = new HashSet();
            for (C0191l lVar : new HashSet(this.f345a)) {
                if (lVar.mo3914a(seconds, getVideoPercentViewed())) {
                    hashSet.add(lVar);
                    this.f345a.remove(lVar);
                }
            }
            m360a((Set<C0191l>) hashSet);
        }
    }

    public void handleMediaError() {
        m357a(C0184e.ERROR, C0187h.MEDIA_FILE_ERROR);
        super.handleMediaError();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (m362b()) {
            String a = m363c().mo3856a(this.currentPlacement);
            if (C0444fq.isValidString(a)) {
                this.logger.mo4779d("InterstitialActivity", "Firing AppLovin impression...");
                this.sdk.getPersistentPostbackManager().mo4493a(a, (Map<String, String>) null, false);
            }
            this.f345a.addAll(m363c().mo3858a(C0184e.VIDEO, C0192m.f101a));
            m356a(C0184e.IMPRESSION);
            m358a(C0184e.VIDEO, "creativeView");
        }
    }

    public void playVideo() {
        this.countdownManager.mo3995a("PROGRESS_TRACKING", this.settingsProxy.mo4565X(), (C0214ao) new C0263cj(this));
        super.playVideo();
    }

    public void showPoststitial() {
        if (m362b()) {
            m355a();
            if (!C0193n.m114c(m363c())) {
                dismiss();
            } else if (!this.poststitialWasDisplayed) {
                m358a(C0184e.COMPANION, "creativeView");
                super.showPoststitial();
            }
        } else {
            super.showPoststitial();
        }
    }

    public void skipVideo() {
        m358a(C0184e.VIDEO, "skip");
        super.skipVideo();
    }

    public void toggleMute() {
        super.toggleMute();
        if (this.videoMuted) {
            m358a(C0184e.VIDEO, "mute");
        } else {
            m358a(C0184e.VIDEO, "unmute");
        }
    }
}
