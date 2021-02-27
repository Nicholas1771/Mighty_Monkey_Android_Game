package com.applovin.impl.sdk;

import android.app.Activity;
import android.net.Uri;
import com.applovin.mediation.AppLovinMediationAdapterInfo;
import com.applovin.mediation.AppLovinMediationAdapterStats;
import com.applovin.mediation.AppLovinMediationAdapterStatus;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinMediationService;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.Collection;

public class MediationServiceImpl implements AppLovinMediationService {
    public static final String TAG = "MediationServiceImpl";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AppLovinSdkImpl f449a;

    /* renamed from: b */
    private final AppLovinLogger f450b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C0349cc f451c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Object f452d = new Object();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f453e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f454f = null;

    MediationServiceImpl(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f449a = appLovinSdkImpl;
        this.f450b = appLovinSdkImpl.getLogger();
        this.f451c = new C0349cc(appLovinSdkImpl);
    }

    /* renamed from: a */
    private void m451a(int i, C0345bz bzVar) {
        if (((Boolean) this.f449a.get(C0387dn.f957df)).booleanValue()) {
            m458a("err", i, bzVar);
        }
    }

    /* renamed from: a */
    private void m455a(C0345bz bzVar, int i, C0319b bVar) {
        bVar.mo4355b((AppLovinAd) bzVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m456a(C0345bz bzVar, int i, AppLovinAdLoadListener appLovinAdLoadListener) {
        m451a(i, bzVar);
        if (appLovinAdLoadListener == null) {
            return;
        }
        if (appLovinAdLoadListener instanceof C0302aj) {
            ((C0302aj) appLovinAdLoadListener).mo4308a(bzVar.mo4292m(), i);
        } else {
            appLovinAdLoadListener.failedToReceiveAd(i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m457a(AppLovinAd appLovinAd, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(appLovinAd);
        }
    }

    /* renamed from: a */
    private void m458a(String str, int i, C0345bz bzVar) {
        try {
            this.f449a.getPostbackService().dispatchPostbackAsync(Uri.parse((String) this.f449a.get(C0387dn.f967l)).buildUpon().appendQueryParameter("event", str).appendQueryParameter("ec", String.valueOf(i)).appendQueryParameter("clcode", bzVar.mo4291l()).appendQueryParameter("an", bzVar.mo4392c()).appendQueryParameter("ac", bzVar.mo4391b()).build().toString(), (AppLovinPostbackListener) null);
        } catch (Throwable th) {
            this.f450b.mo4781e(TAG, "Unable to create post-back URL for mediated '" + str + "'", th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m461b(C0345bz bzVar) {
        if (((Boolean) this.f449a.get(C0387dn.f955dd)).booleanValue()) {
            m458a("imp", 0, bzVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m463c(C0345bz bzVar) {
        if (((Boolean) this.f449a.get(C0387dn.f956de)).booleanValue()) {
            m458a("clk", 0, bzVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4219a() {
        this.f451c.mo4405a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4220a(C0345bz bzVar) {
        if (bzVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        }
        this.f450b.mo4779d(TAG, "Loading " + bzVar + "...");
        C0351ce a = this.f451c.mo4404a(bzVar.mo4392c(), bzVar.mo4391b(), bzVar.mo4394e());
        if (a != null) {
            a.mo4416a(bzVar);
        } else {
            this.f450b.mo4785w(TAG, "Failed to prepare" + bzVar + ": adapter not loaded");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4221a(C0345bz bzVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (bzVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        }
        this.f450b.mo4779d(TAG, "Loading " + bzVar + "...");
        C0351ce a = this.f451c.mo4404a(bzVar.mo4392c(), bzVar.mo4391b(), bzVar.mo4394e());
        if (a != null) {
            a.mo4417a(bzVar, (AppLovinAdLoadListener) new C0360cn(this, a, System.currentTimeMillis(), appLovinAdLoadListener, bzVar));
            return;
        }
        this.f450b.mo4785w(TAG, "Failed to load " + bzVar + ": adapter not loaded");
        m456a(bzVar, (int) AppLovinErrorCodes.MEDIATION_ADAPTER_LOAD_FAILED, appLovinAdLoadListener);
    }

    public Collection<AppLovinMediationAdapterInfo> getAdapterInfo() {
        Collection<String> b = this.f451c.mo4407b();
        Collection<C0351ce> c = this.f451c.mo4408c();
        ArrayList arrayList = new ArrayList(c.size());
        for (C0351ce next : c) {
            String a = next.mo4415a();
            String f = next.mo4425f();
            String e = next.mo4424e();
            if (b.contains(f)) {
                arrayList.add(new AppLovinMediationAdapterInfo(a, f, e, AppLovinMediationAdapterStatus.ERROR_LOAD));
            } else if (!next.mo4421b()) {
                arrayList.add(new AppLovinMediationAdapterInfo(a, f, e, AppLovinMediationAdapterStatus.ERROR_LOAD));
            } else if (next.mo4422c()) {
                arrayList.add(new AppLovinMediationAdapterInfo(a, f, e, AppLovinMediationAdapterStatus.READY, next.mo4423d(), next.mo4426g()));
            } else {
                arrayList.add(new AppLovinMediationAdapterInfo(a, f, e, AppLovinMediationAdapterStatus.ERROR_NOT_READY));
            }
        }
        return arrayList;
    }

    public AppLovinMediationAdapterStats getLastAdapterStats() {
        synchronized (this.f452d) {
            if (this.f454f == null) {
                return null;
            }
            AppLovinMediationAdapterStats appLovinMediationAdapterStats = new AppLovinMediationAdapterStats(this.f454f, this.f453e);
            return appLovinMediationAdapterStats;
        }
    }

    public void showAd(C0345bz bzVar, String str, Activity activity, C0319b bVar) {
        if (bzVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (bVar == null) {
            throw new IllegalArgumentException("No listeners specified");
        } else if (bzVar.mo3855a()) {
            C0351ce a = this.f451c.mo4404a(bzVar.mo4392c(), bzVar.mo4391b(), bzVar.mo4394e());
            if (a != null) {
                bVar.mo4357b((AppLovinAdDisplayListener) new C0361co(this, bzVar));
                bVar.mo4356b((AppLovinAdClickListener) new C0362cp(this, bzVar));
                a.mo4418a(bzVar, str, activity, bVar);
                return;
            }
            m455a(bzVar, (int) AppLovinErrorCodes.MEDIATION_ADAPTER_LOAD_FAILED_ON_RENDER, bVar);
            this.f450b.mo4785w(TAG, "Failed to show " + bzVar + ": adapter not loaded");
            this.f450b.userError(TAG, "There may be an integration problem with the mediated '" + bzVar.mo4392c() + "'. Please check if you have a supported version of that SDK integrated into your project.");
        } else {
            m455a(bzVar, (int) AppLovinErrorCodes.MEDIATION_ADAPTER_RENDER_NOT_READY_AD, bVar);
            this.f450b.mo4780e(TAG, "Ad " + bzVar + " was not ready when provided requestsed to show.");
        }
    }
}
