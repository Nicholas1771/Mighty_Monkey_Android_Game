package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.eb */
public class C0402eb extends C0403ec {
    public C0402eb(AppLovinSdkImpl appLovinSdkImpl, List<NativeAdImpl> list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super("TaskCacheNativeAdImages", appLovinSdkImpl, list, appLovinNativeAdLoadListener);
    }

    public C0402eb(AppLovinSdkImpl appLovinSdkImpl, List<NativeAdImpl> list, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        super("TaskCacheNativeAdImages", appLovinSdkImpl, list, appLovinNativeAdPrecacheListener);
    }

    /* renamed from: b */
    private boolean m968b(NativeAdImpl nativeAdImpl) {
        this.f764e.mo4785w("TaskCacheNativeAdImages", "Unable to cache image resource");
        mo4655a(nativeAdImpl, !C0466w.m1280a(this.f765f) ? AppLovinErrorCodes.NO_NETWORK : AppLovinErrorCodes.UNABLE_TO_PRECACHE_IMAGE_RESOURCES);
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4654a(NativeAdImpl nativeAdImpl) {
        if (this.f1023b != null) {
            this.f1023b.onNativeAdImagesPrecached(nativeAdImpl);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4655a(NativeAdImpl nativeAdImpl, int i) {
        if (this.f1023b != null) {
            this.f1023b.onNativeAdImagePrecachingFailed(nativeAdImpl, i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo4656a(NativeAdImpl nativeAdImpl, C0304al alVar) {
        this.f763d.getLogger().mo4779d("TaskCacheNativeAdImages", "Beginning slot image caching for ad " + nativeAdImpl.getAdId());
        if (((Boolean) this.f763d.get(C0387dn.f773H)).booleanValue()) {
            String a = mo4658a(nativeAdImpl.getSourceIconUrl(), alVar);
            if (a == null) {
                return m968b(nativeAdImpl);
            }
            nativeAdImpl.setIconUrl(a);
            String a2 = mo4658a(nativeAdImpl.getSourceImageUrl(), alVar);
            if (a2 == null) {
                return m968b(nativeAdImpl);
            }
            nativeAdImpl.setImageUrl(a2);
        } else {
            this.f763d.getLogger().mo4779d("TaskCacheNativeAdImages", "Resource caching is disabled, skipping...");
        }
        return true;
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }
}
