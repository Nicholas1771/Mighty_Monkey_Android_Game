package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.nativeAds.AppLovinNativeAdService;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.cu */
class C0367cu implements AppLovinNativeAdService {

    /* renamed from: a */
    private final AppLovinSdkImpl f708a;

    /* renamed from: b */
    private final Object f709b = new Object();

    C0367cu(AppLovinSdkImpl appLovinSdkImpl) {
        this.f708a = appLovinSdkImpl;
    }

    /* renamed from: a */
    private List<NativeAdImpl> m748a(AppLovinNativeAd appLovinNativeAd) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add((NativeAdImpl) appLovinNativeAd);
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m755a(AppLovinNativeAd appLovinNativeAd, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        if (appLovinNativeAd.isVideoPrecached()) {
            appLovinNativeAdPrecacheListener.onNativeAdVideoPreceached(appLovinNativeAd);
            return;
        }
        this.f708a.mo4169a().mo4681a((C0386dm) new C0404ed(this.f708a, m748a(appLovinNativeAd), (AppLovinNativeAdPrecacheListener) new C0370cx(this, appLovinNativeAdPrecacheListener)), C0416ep.MAIN);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m756a(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, int i) {
        if (appLovinNativeAdLoadListener != null) {
            try {
                appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(i);
            } catch (Exception e) {
                this.f708a.getLogger().userError("WidgetServiceImpl", "Encountered exception whilst notifying user callback", e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m757a(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, List<AppLovinNativeAd> list) {
        if (appLovinNativeAdLoadListener != null) {
            try {
                appLovinNativeAdLoadListener.onNativeAdsLoaded(list);
            } catch (Exception e) {
                this.f708a.getLogger().userError("WidgetServiceImpl", "Encountered exception whilst notifying user callback", e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m758a(AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener, AppLovinNativeAd appLovinNativeAd, int i, boolean z) {
        if (appLovinNativeAdPrecacheListener == null) {
            return;
        }
        if (z) {
            try {
                appLovinNativeAdPrecacheListener.onNativeAdVideoPrecachingFailed(appLovinNativeAd, i);
            } catch (Exception e) {
                this.f708a.getLogger().userError("WidgetServiceImpl", "Encountered exception whilst notifying user callback", e);
            }
        } else {
            appLovinNativeAdPrecacheListener.onNativeAdImagePrecachingFailed(appLovinNativeAd, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m759a(AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener, AppLovinNativeAd appLovinNativeAd, boolean z) {
        if (appLovinNativeAdPrecacheListener == null) {
            return;
        }
        if (z) {
            try {
                appLovinNativeAdPrecacheListener.onNativeAdVideoPreceached(appLovinNativeAd);
            } catch (Exception e) {
                this.f708a.getLogger().userError("WidgetServiceImpl", "Encountered exception whilst notifying user callback", e);
            }
        } else {
            appLovinNativeAdPrecacheListener.onNativeAdImagesPrecached(appLovinNativeAd);
        }
    }

    /* renamed from: b */
    private void m760b(List<NativeAdImpl> list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f708a.mo4169a().mo4681a((C0386dm) new C0402eb(this.f708a, list, (AppLovinNativeAdLoadListener) new C0374da(this, appLovinNativeAdLoadListener)), C0416ep.MAIN);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m761c(List<NativeAdImpl> list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f708a.mo4169a().mo4681a((C0386dm) new C0404ed(this.f708a, list, (AppLovinNativeAdLoadListener) new C0375db(this, appLovinNativeAdLoadListener)), C0416ep.MAIN);
    }

    /* renamed from: a */
    public void mo4482a(List<AppLovinNativeAd> list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        int intValue = ((Integer) this.f708a.get(C0387dn.f894bw)).intValue();
        if (intValue > 0) {
            List list2 = list;
            int size = list2.size();
            if (size != 0) {
                int min = Math.min(intValue, size);
                List subList = list2.subList(0, min);
                m760b(subList, new C0371cy(this, subList, appLovinNativeAdLoadListener, list2.subList(min, size)));
            } else if (appLovinNativeAdLoadListener != null) {
                appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(AppLovinErrorCodes.UNABLE_TO_PREPARE_NATIVE_AD);
            }
        } else if (appLovinNativeAdLoadListener != null) {
            appLovinNativeAdLoadListener.onNativeAdsLoaded(list);
        }
    }

    public void loadNativeAds(int i, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        AppLovinNativeAd appLovinNativeAd = null;
        synchronized (this.f709b) {
            if (i == 1) {
                if (this.f708a.mo4175d().mo4474g(C0451h.f1142h)) {
                    appLovinNativeAd = (AppLovinNativeAd) this.f708a.mo4175d().mo4471d(C0451h.f1142h);
                }
            }
        }
        if (appLovinNativeAd != null) {
            m757a(appLovinNativeAdLoadListener, (List<AppLovinNativeAd>) Arrays.asList(new AppLovinNativeAd[]{appLovinNativeAd}));
            return;
        }
        this.f708a.mo4169a().mo4681a((C0386dm) new C0412el(this.f708a, i, new C0368cv(this, appLovinNativeAdLoadListener)), C0416ep.MAIN);
    }

    public void precacheResources(AppLovinNativeAd appLovinNativeAd, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        if (appLovinNativeAd.isImagePrecached()) {
            appLovinNativeAdPrecacheListener.onNativeAdImagesPrecached(appLovinNativeAd);
            m755a(appLovinNativeAd, appLovinNativeAdPrecacheListener);
            return;
        }
        this.f708a.mo4169a().mo4681a((C0386dm) new C0402eb(this.f708a, m748a(appLovinNativeAd), (AppLovinNativeAdPrecacheListener) new C0369cw(this, appLovinNativeAdPrecacheListener)), C0416ep.MAIN);
    }
}
