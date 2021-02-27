package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdUpdateListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

/* renamed from: com.applovin.impl.adview.k */
class C0276k implements AppLovinAdLoadListener, AppLovinAdUpdateListener {

    /* renamed from: a */
    private final WeakReference<AdViewControllerImpl> f375a;

    /* renamed from: b */
    private final AppLovinAdService f376b;

    /* renamed from: c */
    private final AppLovinLogger f377c;

    C0276k(AdViewControllerImpl adViewControllerImpl, AppLovinSdk appLovinSdk) {
        if (adViewControllerImpl == null) {
            throw new IllegalArgumentException("No view specified");
        } else if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else {
            this.f375a = new WeakReference<>(adViewControllerImpl);
            this.f377c = appLovinSdk.getLogger();
            this.f376b = appLovinSdk.getAdService();
        }
    }

    public void adReceived(AppLovinAd appLovinAd) {
        AdViewControllerImpl adViewControllerImpl = (AdViewControllerImpl) this.f375a.get();
        if (adViewControllerImpl != null) {
            adViewControllerImpl.mo3940a(appLovinAd);
        } else {
            this.f377c.userError("AppLovinAdView", "Ad view has been garbage collected by the time an ad was recieved");
        }
    }

    public void adUpdated(AppLovinAd appLovinAd) {
        AdViewControllerImpl adViewControllerImpl = (AdViewControllerImpl) this.f375a.get();
        if (adViewControllerImpl != null) {
            adViewControllerImpl.mo3940a(appLovinAd);
            return;
        }
        this.f376b.removeAdUpdateListener(this, appLovinAd.getSize());
        this.f377c.userError("AppLovinAdView", "Ad view has been garbage collected by the time an ad was updated");
    }

    public void failedToReceiveAd(int i) {
        AdViewControllerImpl adViewControllerImpl = (AdViewControllerImpl) this.f375a.get();
        if (adViewControllerImpl != null) {
            adViewControllerImpl.mo3939a(i);
        }
    }

    public String toString() {
        return "[AdViewController listener: " + hashCode() + "]";
    }
}
