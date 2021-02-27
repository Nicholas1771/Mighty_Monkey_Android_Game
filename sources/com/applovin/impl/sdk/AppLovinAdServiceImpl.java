package com.applovin.impl.sdk;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdUpdateListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;

public class AppLovinAdServiceImpl implements AppLovinAdService {
    public static String URI_LOAD_URL = "/adservice/load_url";
    public static String URI_NO_OP = "/adservice/no_op";
    public static String URI_SKIP_AD = "/adservice/skip";
    public static String URI_TRACK_CLICK_IMMEDIATELY = "/adservice/track_click_now";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AppLovinSdkImpl f416a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AppLovinLogger f417b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Handler f418c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Map<C0451h, C0458o> f419d;

    AppLovinAdServiceImpl(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f416a = appLovinSdkImpl;
        this.f417b = appLovinSdkImpl.getLogger();
        this.f418c = new Handler(Looper.getMainLooper());
        this.f419d = new HashMap(5);
        this.f419d.put(C0451h.f1135a, new C0458o(C0451h.f1135a, (C0454k) null));
        this.f419d.put(C0451h.f1136b, new C0458o(C0451h.f1136b, (C0454k) null));
        this.f419d.put(C0451h.f1137c, new C0458o(C0451h.f1137c, (C0454k) null));
        this.f419d.put(C0451h.f1138d, new C0458o(C0451h.f1138d, (C0454k) null));
        this.f419d.put(C0451h.f1139e, new C0458o(C0451h.f1139e, (C0454k) null));
        this.f419d.put(C0451h.f1140f, new C0458o(C0451h.f1140f, (C0454k) null));
        this.f419d.put(C0451h.f1141g, new C0458o(C0451h.f1141g, (C0454k) null));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m403a(Uri uri, C0296ad adVar, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl) {
        if (appLovinAdView != null) {
            adViewControllerImpl.removeClickTrackingOverlay();
            expireAdLoadState(adVar);
            if (AppLovinSdkUtils.openUri(appLovinAdView.getContext(), uri, this.f416a)) {
                C0330bk.m652c(adViewControllerImpl.getAdViewEventListener(), (AppLovinAd) adVar, appLovinAdView, (AppLovinSdk) this.f416a);
            }
            adViewControllerImpl.dismissInterstitialIfRequired();
            return;
        }
        this.f417b.mo4780e("AppLovinAdService", "Unable to launch click - adView has been prematurely destroyed");
    }

    /* renamed from: a */
    private void m407a(C0296ad adVar, String str) {
        String b = adVar.mo4284b(str);
        if (AppLovinSdkUtils.isValidString(b)) {
            this.f416a.getPersistentPostbackManager().mo4492a(b, (Map<String, String>) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m408a(C0451h hVar, C0457n nVar) {
        AppLovinAd appLovinAd = (AppLovinAd) this.f416a.mo4172c().mo4471d(hVar);
        if (appLovinAd != null) {
            this.f417b.mo4779d("AppLovinAdService", "Using pre-loaded ad: " + appLovinAd + " for " + hVar);
            nVar.adReceived(appLovinAd);
        } else {
            this.f416a.mo4169a().mo4681a((C0386dm) new C0410ej(hVar, nVar, this.f416a), C0416ep.MAIN);
        }
        if (!C0444fq.m1166a(hVar, this.f416a) || appLovinAd != null) {
            this.f416a.mo4172c().mo4475h(hVar);
        }
    }

    /* renamed from: a */
    private void m409a(C0451h hVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        AppLovinAd appLovinAd;
        boolean z = true;
        if (hVar == null) {
            throw new IllegalArgumentException("No ad spec specified");
        } else if (appLovinAdLoadListener == null) {
            throw new IllegalArgumentException("No callback specified");
        } else if (C0466w.m1280a(this.f416a.getApplicationContext()) || ((Boolean) this.f416a.get(C0387dn.f943cs)).booleanValue()) {
            this.f416a.getLogger().mo4779d("AppLovinAdService", "Loading next ad " + hVar + "...");
            C0458o oVar = this.f419d.get(hVar);
            if (oVar == null) {
                throw new IllegalArgumentException("Ad not supported: " + hVar);
            }
            synchronized (oVar.f1166b) {
                if (System.currentTimeMillis() <= oVar.f1168d) {
                    z = false;
                }
                if (oVar.f1167c == null || z) {
                    oVar.f1171g.add(appLovinAdLoadListener);
                    if (!oVar.f1169e) {
                        this.f417b.mo4779d("AppLovinAdService", "Loading next ad...");
                        oVar.f1169e = true;
                        C0457n nVar = new C0457n(this, oVar, (C0454k) null);
                        if (!m413a(hVar)) {
                            this.f417b.mo4779d("AppLovinAdService", "Task merge not necessary.");
                            m408a(hVar, nVar);
                        } else if (this.f416a.mo4172c().mo4466a(hVar, (Object) nVar)) {
                            this.f417b.mo4779d("AppLovinAdService", "Attaching load listener to initial preload task...");
                        } else {
                            this.f417b.mo4779d("AppLovinAdService", "Skipped attach of initial preload callback.");
                            m408a(hVar, nVar);
                        }
                        appLovinAd = null;
                    } else {
                        this.f417b.mo4779d("AppLovinAdService", "Already waiting on an ad load...");
                        appLovinAd = null;
                    }
                } else {
                    appLovinAd = oVar.f1167c;
                }
            }
            if (appLovinAd != null) {
                appLovinAdLoadListener.adReceived(appLovinAd);
            }
        } else {
            this.f417b.userError("AppLovinAdService", "Failing ad load due to no internet connection.");
            appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.NO_NETWORK);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m410a() {
        return ((PowerManager) this.f416a.getApplicationContext().getSystemService("power")).isScreenOn();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.applovin.impl.sdk.dp, com.applovin.impl.sdk.dp<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m412a(com.applovin.impl.sdk.C0389dp<java.lang.String> r3, com.applovin.sdk.AppLovinAdSize r4) {
        /*
            r2 = this;
            com.applovin.impl.sdk.AppLovinSdkImpl r0 = r2.f416a
            java.lang.Object r0 = r0.get(r3)
            java.lang.String r0 = (java.lang.String) r0
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toUpperCase(r1)
            java.lang.String r1 = r4.getLabel()
            boolean r0 = r0.contains(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.AppLovinAdServiceImpl.m412a(com.applovin.impl.sdk.dp, com.applovin.sdk.AppLovinAdSize):boolean");
    }

    /* renamed from: a */
    private boolean m413a(C0451h hVar) {
        boolean z = true;
        if (!((Boolean) this.f416a.get(C0387dn.f772G)).booleanValue() || !m420c(hVar)) {
            return false;
        }
        if (hVar.mo4767c() == C0452i.DIRECT) {
            if (hVar.mo4766b().equals(AppLovinAdType.INCENTIVIZED)) {
                return ((Boolean) this.f416a.get(C0387dn.f813aU)).booleanValue() && ((Integer) this.f416a.get(C0387dn.f841aw)).intValue() > 0;
            } else if (hVar.mo4765a().equals(AppLovinAdSize.INTERSTITIAL)) {
                if (!((Boolean) this.f416a.get(C0387dn.f814aV)).booleanValue() || ((Integer) this.f416a.get(C0387dn.f837as)).intValue() <= 0) {
                    z = false;
                }
                return z;
            } else if (hVar.mo4765a().equals(AppLovinAdSize.BANNER)) {
                return ((Boolean) this.f416a.get(C0387dn.f815aW)).booleanValue();
            } else {
                if (hVar.mo4765a().equals(AppLovinAdSize.MREC)) {
                    return ((Boolean) this.f416a.get(C0387dn.f816aX)).booleanValue();
                }
                if (hVar.mo4765a().equals(AppLovinAdSize.LEADER)) {
                    return ((Boolean) this.f416a.get(C0387dn.f817aY)).booleanValue();
                }
                return false;
            }
        } else if (hVar.mo4767c() != C0452i.INDIRECT) {
            return false;
        } else {
            if (hVar.mo4766b().equals(AppLovinAdType.INCENTIVIZED)) {
                if (!((Boolean) this.f416a.get(C0387dn.f818aZ)).booleanValue() || ((Integer) this.f416a.get(C0387dn.f842ax)).intValue() <= 0) {
                    z = false;
                }
                return z;
            } else if (hVar.mo4765a().equals(AppLovinAdSize.INTERSTITIAL)) {
                if (!((Boolean) this.f416a.get(C0387dn.f872ba)).booleanValue() || ((Integer) this.f416a.get(C0387dn.f838at)).intValue() <= 0) {
                    z = false;
                }
                return z;
            } else if (hVar.mo4765a().equals(AppLovinAdSize.BANNER)) {
                return ((Boolean) this.f416a.get(C0387dn.f873bb)).booleanValue();
            } else {
                if (hVar.mo4765a().equals(AppLovinAdSize.MREC)) {
                    return ((Boolean) this.f416a.get(C0387dn.f874bc)).booleanValue();
                }
                if (hVar.mo4765a().equals(AppLovinAdSize.LEADER)) {
                    return ((Boolean) this.f416a.get(C0387dn.f875bd)).booleanValue();
                }
                return false;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m414a(AppLovinAdSize appLovinAdSize) {
        if (appLovinAdSize == AppLovinAdSize.BANNER) {
            return ((Boolean) this.f416a.get(C0387dn.f981z)).booleanValue();
        }
        if (appLovinAdSize == AppLovinAdSize.MREC) {
            return ((Boolean) this.f416a.get(C0387dn.f767B)).booleanValue();
        }
        if (appLovinAdSize == AppLovinAdSize.LEADER) {
            return ((Boolean) this.f416a.get(C0387dn.f769D)).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public long m416b(AppLovinAdSize appLovinAdSize) {
        if (appLovinAdSize == AppLovinAdSize.BANNER) {
            return ((Long) this.f416a.get(C0387dn.f766A)).longValue();
        }
        if (appLovinAdSize == AppLovinAdSize.MREC) {
            return ((Long) this.f416a.get(C0387dn.f768C)).longValue();
        }
        if (appLovinAdSize == AppLovinAdSize.LEADER) {
            return ((Long) this.f416a.get(C0387dn.f770E)).longValue();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m418b(C0451h hVar) {
        long b = m416b(hVar.mo4765a());
        if (b > 0) {
            this.f416a.mo4169a().mo4682a((C0386dm) new C0459p(this, hVar), C0416ep.MAIN, (b + 2) * 1000);
        }
    }

    /* renamed from: c */
    private boolean m420c(C0451h hVar) {
        try {
            if (hVar.mo4767c() == C0452i.DIRECT) {
                return hVar.mo4766b().equals(AppLovinAdType.INCENTIVIZED) ? ((Boolean) this.f416a.get(C0387dn.f778M)).booleanValue() : m412a(C0387dn.f776K, hVar.mo4765a());
            }
            if (hVar.mo4767c() == C0452i.INDIRECT) {
                return hVar.mo4766b().equals(AppLovinAdType.INCENTIVIZED) ? ((Boolean) this.f416a.get(C0387dn.f779N)).booleanValue() : m412a(C0387dn.f777L, hVar.mo4765a());
            }
            return false;
        } catch (Exception e) {
            this.f416a.getLogger().mo4781e("AppLovinAdService", "Unable to safely test preload merge capability", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4155a(AppLovinAdLoadListener appLovinAdLoadListener) {
        m409a(C0451h.f1140f, appLovinAdLoadListener);
    }

    public void addAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener) {
        addAdUpdateListener(appLovinAdUpdateListener, AppLovinAdSize.BANNER);
    }

    public void addAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener, AppLovinAdSize appLovinAdSize) {
        boolean z;
        if (appLovinAdUpdateListener == null) {
            throw new IllegalArgumentException("No ad listener specified");
        }
        C0451h hVar = new C0451h(AppLovinAdType.REGULAR, C0452i.DIRECT, appLovinAdSize);
        C0458o oVar = this.f419d.get(hVar);
        synchronized (oVar.f1166b) {
            if (oVar.f1168d <= 0 || oVar.f1170f.contains(appLovinAdUpdateListener)) {
                z = false;
            } else {
                oVar.f1170f.add(appLovinAdUpdateListener);
                z = true;
                this.f417b.mo4779d("AppLovinAdService", "Added update listener: " + appLovinAdUpdateListener);
            }
        }
        if (z) {
            this.f416a.mo4169a().mo4681a((C0386dm) new C0459p(this, hVar), C0416ep.MAIN);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4158b(AppLovinAdLoadListener appLovinAdLoadListener) {
        m409a(C0451h.f1141g, appLovinAdLoadListener);
    }

    public AppLovinAd dequeueAd(C0451h hVar) {
        AppLovinAd appLovinAd = (AppLovinAd) this.f416a.mo4172c().mo4470c(hVar);
        this.f417b.mo4779d("AppLovinAdService", "Dequeued ad: " + appLovinAd + " for spec: " + hVar + "...");
        return appLovinAd;
    }

    public void expireAdLoadState(AppLovinAd appLovinAd) {
        if (appLovinAd == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (!(appLovinAd instanceof C0453j)) {
            throw new IllegalArgumentException("Unknown ad type specified: " + appLovinAd.getClass().getName());
        } else {
            C0458o oVar = this.f419d.get(((C0453j) appLovinAd).mo4292m());
            synchronized (oVar.f1166b) {
                oVar.f1167c = null;
                oVar.f1168d = 0;
            }
        }
    }

    public boolean hasPreloadedAd(AppLovinAdSize appLovinAdSize) {
        return this.f416a.mo4172c().mo4474g(new C0451h(AppLovinAdType.REGULAR, C0452i.DIRECT, appLovinAdSize));
    }

    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        m409a(new C0451h(AppLovinAdType.REGULAR, C0452i.DIRECT, appLovinAdSize), appLovinAdLoadListener);
    }

    public void loadNextMediatedAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        m409a(new C0451h(AppLovinAdType.REGULAR, C0452i.INDIRECT, appLovinAdSize), appLovinAdLoadListener);
    }

    public void preloadAd(AppLovinAdSize appLovinAdSize) {
        this.f416a.mo4172c().mo4475h(new C0451h(AppLovinAdType.REGULAR, C0452i.DIRECT, appLovinAdSize));
    }

    public void removeAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener, AppLovinAdSize appLovinAdSize) {
        if (appLovinAdUpdateListener != null) {
            C0458o oVar = this.f419d.get(new C0451h(AppLovinAdType.REGULAR, C0452i.DIRECT, appLovinAdSize));
            synchronized (oVar.f1166b) {
                if (oVar.f1170f.contains(appLovinAdUpdateListener)) {
                    oVar.f1170f.remove(appLovinAdUpdateListener);
                    this.f417b.mo4779d("AppLovinAdService", "Removed update listener: " + appLovinAdUpdateListener);
                }
            }
        }
    }

    public void trackAndLaunchClick(AppLovinAd appLovinAd, String str, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl, Uri uri) {
        C0296ad adVar = (C0296ad) appLovinAd;
        m407a(adVar, str);
        m403a(uri, adVar, appLovinAdView, adViewControllerImpl);
    }

    public void trackAndLaunchForegroundClick(AppLovinAd appLovinAd, String str, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl, Uri uri) {
        if (appLovinAd == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        C0296ad adVar = (C0296ad) appLovinAd;
        this.f417b.mo4779d("AppLovinAdService", "Tracking foreground click on an ad...");
        int intValue = ((Integer) this.f416a.get(C0387dn.f860bO)).intValue();
        int intValue2 = ((Integer) this.f416a.get(C0387dn.f861bP)).intValue();
        int intValue3 = ((Integer) this.f416a.get(C0387dn.f862bQ)).intValue();
        this.f416a.getPostbackService().dispatchPostbackAsync(adVar.mo4284b(str), (Map<String, String>) null, (String) null, intValue, (long) intValue2, intValue3, new C0454k(this, adViewControllerImpl, uri, adVar, appLovinAdView));
    }

    public void trackAndLaunchVideoClick(AppLovinAd appLovinAd, String str, AppLovinAdView appLovinAdView, Uri uri) {
        m407a((C0296ad) appLovinAd, str);
        AppLovinSdkUtils.openUri(appLovinAdView.getContext(), uri, this.f416a);
    }
}
