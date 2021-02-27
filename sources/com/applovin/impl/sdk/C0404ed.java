package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.ed */
public class C0404ed extends C0403ec {
    public C0404ed(AppLovinSdkImpl appLovinSdkImpl, List<NativeAdImpl> list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super("TaskCacheNativeAdVideos", appLovinSdkImpl, list, appLovinNativeAdLoadListener);
    }

    public C0404ed(AppLovinSdkImpl appLovinSdkImpl, List<NativeAdImpl> list, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        super("TaskCacheNativeAdVideos", appLovinSdkImpl, list, appLovinNativeAdPrecacheListener);
    }

    /* renamed from: b */
    private boolean m978b(NativeAdImpl nativeAdImpl) {
        this.f764e.mo4785w("TaskCacheNativeAdVideos", "Unable to cache video resource " + nativeAdImpl.getSourceVideoUrl());
        mo4655a(nativeAdImpl, !C0466w.m1280a(this.f765f) ? AppLovinErrorCodes.NO_NETWORK : AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4654a(NativeAdImpl nativeAdImpl) {
        if (this.f1023b != null) {
            this.f1023b.onNativeAdVideoPreceached(nativeAdImpl);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4655a(NativeAdImpl nativeAdImpl, int i) {
        if (this.f1023b != null) {
            this.f1023b.onNativeAdVideoPrecachingFailed(nativeAdImpl, i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo4656a(NativeAdImpl nativeAdImpl, C0304al alVar) {
        if (!AppLovinSdkUtils.isValidString(nativeAdImpl.getSourceVideoUrl())) {
            this.f763d.getLogger().mo4779d("TaskCacheNativeAdVideos", "No video attached to ad, nothing to cache...");
            return true;
        }
        this.f763d.getLogger().mo4779d("TaskCacheNativeAdVideos", "Beginning slot video caching for ad " + nativeAdImpl.getAdId());
        if (((Boolean) this.f763d.get(C0387dn.f773H)).booleanValue()) {
            String a = mo4658a(nativeAdImpl.getSourceVideoUrl(), alVar);
            if (a == null) {
                return m978b(nativeAdImpl);
            }
            nativeAdImpl.setVideoUrl(a);
        } else {
            this.f763d.getLogger().mo4779d("TaskCacheNativeAdVideos", "Resource caching is disabled, skipping...");
        }
        return true;
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }
}
