package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdUpdateListener;
import java.util.HashSet;

/* renamed from: com.applovin.impl.sdk.n */
class C0457n implements AppLovinAdLoadListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinAdServiceImpl f1163a;

    /* renamed from: b */
    private final C0458o f1164b;

    private C0457n(AppLovinAdServiceImpl appLovinAdServiceImpl, C0458o oVar) {
        this.f1163a = appLovinAdServiceImpl;
        this.f1164b = oVar;
    }

    /* synthetic */ C0457n(AppLovinAdServiceImpl appLovinAdServiceImpl, C0458o oVar, C0454k kVar) {
        this(appLovinAdServiceImpl, oVar);
    }

    public void adReceived(AppLovinAd appLovinAd) {
        HashSet<AppLovinAdLoadListener> hashSet;
        HashSet<AppLovinAdUpdateListener> hashSet2;
        C0451h m = ((C0453j) appLovinAd).mo4292m();
        if (!(appLovinAd instanceof C0299ag) && C0444fq.m1166a(m, this.f1163a.f416a)) {
            this.f1163a.f416a.mo4172c().adReceived(appLovinAd);
            appLovinAd = new C0299ag(m, this.f1163a.f416a);
        }
        synchronized (this.f1164b.f1166b) {
            if (this.f1163a.m414a(this.f1164b.f1165a.mo4765a())) {
                long b = this.f1163a.m416b(this.f1164b.f1165a.mo4765a());
                if (b > 0) {
                    this.f1164b.f1168d = (b * 1000) + System.currentTimeMillis();
                } else if (b == 0) {
                    this.f1164b.f1168d = Long.MAX_VALUE;
                }
                this.f1164b.f1167c = appLovinAd;
            } else {
                this.f1164b.f1167c = null;
                this.f1164b.f1168d = 0;
            }
            hashSet = new HashSet<>(this.f1164b.f1171g);
            this.f1164b.f1171g.clear();
            hashSet2 = new HashSet<>(this.f1164b.f1170f);
            this.f1164b.f1169e = false;
        }
        this.f1163a.m418b(this.f1164b.f1165a);
        for (AppLovinAdLoadListener adReceived : hashSet) {
            try {
                adReceived.adReceived(appLovinAd);
            } catch (Throwable th) {
                this.f1163a.f417b.mo4781e("AppLovinAdService", "Unable to notify listener about a newly loaded ad", th);
            }
        }
        for (AppLovinAdUpdateListener adUpdated : hashSet2) {
            try {
                adUpdated.adUpdated(appLovinAd);
            } catch (Throwable th2) {
                this.f1163a.f417b.mo4781e("AppLovinAdService", "Unable to notify listener about an updated loaded ad", th2);
            }
        }
    }

    public void failedToReceiveAd(int i) {
        HashSet<AppLovinAdLoadListener> hashSet;
        synchronized (this.f1164b.f1166b) {
            hashSet = new HashSet<>(this.f1164b.f1171g);
            this.f1164b.f1171g.clear();
            this.f1164b.f1169e = false;
        }
        for (AppLovinAdLoadListener failedToReceiveAd : hashSet) {
            try {
                failedToReceiveAd.failedToReceiveAd(i);
            } catch (Throwable th) {
                this.f1163a.f417b.mo4781e("AppLovinAdService", "Unable to notify listener about ad load failure", th);
            }
        }
    }
}
