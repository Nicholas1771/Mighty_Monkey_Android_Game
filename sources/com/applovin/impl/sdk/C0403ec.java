package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinSdk;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.ec */
abstract class C0403ec extends C0386dm {

    /* renamed from: a */
    protected AppLovinNativeAdLoadListener f1022a;

    /* renamed from: b */
    protected AppLovinNativeAdPrecacheListener f1023b;

    /* renamed from: g */
    private List<NativeAdImpl> f1024g;

    /* renamed from: h */
    private int f1025h = 0;

    C0403ec(String str, AppLovinSdkImpl appLovinSdkImpl, List<NativeAdImpl> list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super(str, appLovinSdkImpl);
        this.f1022a = appLovinNativeAdLoadListener;
        this.f1024g = list;
    }

    C0403ec(String str, AppLovinSdkImpl appLovinSdkImpl, List<NativeAdImpl> list, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        super(str, appLovinSdkImpl);
        if (list == null) {
            throw new IllegalArgumentException("Slots cannot be null");
        }
        this.f1024g = list;
        this.f1023b = appLovinNativeAdPrecacheListener;
    }

    /* renamed from: a */
    private void m972a(int i) {
        if (this.f1022a != null) {
            this.f1022a.onNativeAdsFailedToLoad(i);
        }
    }

    /* renamed from: a */
    private void m973a(List<AppLovinNativeAd> list) {
        if (this.f1022a != null) {
            this.f1022a.onNativeAdsLoaded(list);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo4658a(String str, C0304al alVar) {
        if (!C0444fq.isValidString(str)) {
            this.f763d.getLogger().mo4779d(mo4527a(), "Asked to cache file with null/empty URL, nothing to do.");
            return null;
        } else if (!C0444fq.m1168a((AppLovinSdk) this.f763d, str)) {
            this.f763d.getLogger().mo4779d(mo4527a(), "Domain is not whitelisted, skipping precache for URL " + str);
            return null;
        } else {
            try {
                String a = alVar.mo4313a(this.f765f, str, true, (String) null, true);
                if (a != null) {
                    return a;
                }
                this.f764e.mo4785w(mo4527a(), "Unable to cache icon resource " + str);
                return null;
            } catch (Exception e) {
                this.f764e.mo4786w(mo4527a(), "Unable to cache icon resource " + str, e);
                return null;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo4654a(NativeAdImpl nativeAdImpl);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo4655a(NativeAdImpl nativeAdImpl, int i);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo4656a(NativeAdImpl nativeAdImpl, C0304al alVar);

    public void run() {
        for (NativeAdImpl next : this.f1024g) {
            C0304al fileManager = this.f763d.getFileManager();
            this.f763d.getLogger().mo4779d(mo4527a(), "Beginning resource caching phase...");
            if (mo4656a(next, fileManager)) {
                this.f1025h++;
                mo4654a(next);
            } else {
                this.f763d.getLogger().mo4780e(mo4527a(), "Unable to cache resources");
            }
        }
        try {
            if (this.f1025h == this.f1024g.size()) {
                m973a((List<AppLovinNativeAd>) this.f1024g);
            } else if (((Boolean) this.f763d.get(C0387dn.f884bm)).booleanValue()) {
                this.f763d.getLogger().mo4780e(mo4527a(), "Mismatch between successful populations and requested size");
                m972a(-6);
            } else {
                m973a((List<AppLovinNativeAd>) this.f1024g);
            }
        } catch (Throwable th) {
            this.f763d.getLogger().userError(mo4527a(), "Encountered exception while notifying publisher code", th);
        }
    }
}
