package com.applovin.impl.sdk;

import android.app.Activity;
import com.applovin.mediation.AppLovinMediatedAdInfo;
import com.applovin.mediation.AppLovinMediationAdapter;
import com.applovin.mediation.AppLovinMediationAdapterConfig;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinLogger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.ce */
class C0351ce {

    /* renamed from: a */
    private final String f654a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AppLovinMediationAdapter f655b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AppLovinSdkImpl f656c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final AppLovinLogger f657d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C0348cb f658e;

    /* renamed from: f */
    private final AtomicBoolean f659f;

    C0351ce(String str, AppLovinMediationAdapter appLovinMediationAdapter, AppLovinSdkImpl appLovinSdkImpl) {
        if (str == null) {
            throw new IllegalArgumentException("No implementation name specified");
        } else if (appLovinMediationAdapter == null) {
            throw new IllegalArgumentException("No implementation specified");
        } else if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else {
            this.f654a = str;
            this.f655b = appLovinMediationAdapter;
            this.f656c = appLovinSdkImpl;
            this.f657d = appLovinSdkImpl.getLogger();
            this.f658e = new C0348cb(str, appLovinSdkImpl);
            this.f659f = new AtomicBoolean(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m687a(int i, C0358cl clVar) {
        if (clVar.f676c.compareAndSet(false, true) && clVar.f675b != null) {
            clVar.f675b.failedToReceiveAd(i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m691a(AppLovinMediatedAdInfo appLovinMediatedAdInfo, C0358cl clVar) {
        if (clVar.f676c.compareAndSet(false, true) && clVar.f675b != null) {
            clVar.f675b.adReceived(new C0345bz(clVar.f674a, true, appLovinMediatedAdInfo));
        }
    }

    /* renamed from: a */
    private void m692a(String str, Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException("No operation specified");
        }
        try {
            this.f657d.mo4779d("MediationAdapterWrapper", "Running implementation operation '" + str + "'...");
            runnable.run();
        } catch (Throwable th) {
            this.f657d.mo4781e("MediationAdapterWrapper", "Unable to implementation operation run " + str + ", marking " + this + " as disabled", th);
            mo4419a("fail_" + str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m694b(C0345bz bzVar) {
        Map<String, String> e = bzVar.mo4394e();
        if (e != null) {
            this.f658e.mo4398b(e);
        }
    }

    /* renamed from: a */
    public String mo4415a() {
        return this.f654a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4416a(C0345bz bzVar) {
        if (bzVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        } else if (!this.f659f.get()) {
            this.f657d.mo4785w("MediationAdapterWrapper", "Mediation implementation '" + mo4425f() + "' was disabled due to earlier failures. Preparing ads with this implementation is disabled.");
        } else if (!this.f655b.isReady()) {
            this.f657d.userError("MediationAdapterWrapper", "Mediation implementation '" + mo4425f() + "' is not ready.");
        } else {
            m692a("ad_prepare", (Runnable) new C0355ci(this, bzVar));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4417a(C0345bz bzVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (bzVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        } else if (!this.f659f.get()) {
            this.f657d.userError("MediationAdapterWrapper", "Mediation implementation '" + mo4425f() + "' was disabled due to earlier failures. Loading ads with this implementation is disabled.");
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.MEDIATION_ADAPTER_DISABLED);
            }
        } else if (!this.f655b.isReady()) {
            this.f657d.userError("MediationAdapterWrapper", "Mediation implementation '" + mo4425f() + "' is not ready.");
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.MEDIATION_ADAPTER_READY_AD);
            }
        } else {
            m692a("ad_load", (Runnable) new C0353cg(this, bzVar, new C0358cl(bzVar, appLovinAdLoadListener)));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4418a(C0345bz bzVar, String str, Activity activity, C0319b bVar) {
        if (bzVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        } else if (!bzVar.mo3855a()) {
            throw new IllegalArgumentException("Mediated ad is not ready");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (bVar == null) {
            throw new IllegalArgumentException("No listeners specified");
        } else {
            m692a("ad_render", (Runnable) new C0356cj(this, bVar, bzVar, str, activity));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4419a(String str) {
        this.f657d.mo4782i("MediationAdapterWrapper", "Marking " + mo4425f() + " as disabled due to: " + str);
        this.f659f.set(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4420a(Map<String, String> map) {
        m692a("init", (Runnable) new C0352cf(this, map));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo4421b() {
        return this.f659f.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo4422c() {
        return mo4421b() && this.f655b.isReady();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public AppLovinMediationAdapter mo4423d() {
        return this.f655b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo4424e() {
        if (this.f655b != null) {
            try {
                return this.f655b.getVersion();
            } catch (Throwable th) {
                this.f657d.mo4781e("MediationAdapterWrapper", "Unable to get implementation version, marking " + this + " as disabled", th);
                mo4419a("fail_version");
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo4425f() {
        return this.f655b.getClass().getName();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public AppLovinMediationAdapterConfig mo4426g() {
        return this.f658e;
    }

    public String toString() {
        return "[MediationAdapterWrapper implementation: " + mo4425f() + "]";
    }
}
