package com.applovin.impl.sdk;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.bk */
public class C0330bk {
    /* renamed from: a */
    public static void m640a(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinSdk appLovinSdk) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            C0444fq.runOnUiThread(new C0341bv(appLovinAdViewEventListener, appLovinAd, appLovinAdView, appLovinSdk));
        }
    }

    /* renamed from: a */
    public static void m641a(AppLovinAdClickListener appLovinAdClickListener, AppLovinAd appLovinAd, AppLovinSdk appLovinSdk) {
        if (appLovinAd != null && appLovinAdClickListener != null) {
            C0444fq.runOnUiThread(new C0338bs(appLovinAdClickListener, appLovinAd, appLovinSdk));
        }
    }

    /* renamed from: a */
    public static void m642a(AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAd appLovinAd, AppLovinSdk appLovinSdk) {
        if (appLovinAd != null && appLovinAdDisplayListener != null) {
            C0444fq.runOnUiThread(new C0331bl(appLovinAdDisplayListener, appLovinAd, appLovinSdk));
        }
    }

    /* renamed from: a */
    public static void m643a(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, int i, AppLovinSdk appLovinSdk) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            C0444fq.runOnUiThread(new C0335bp(appLovinAdRewardListener, appLovinAd, i, appLovinSdk));
        }
    }

    /* renamed from: a */
    public static void m644a(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, AppLovinSdk appLovinSdk) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            C0444fq.runOnUiThread(new C0336bq(appLovinAdRewardListener, appLovinAd, appLovinSdk));
        }
    }

    /* renamed from: a */
    public static void m645a(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map<String, String> map, AppLovinSdk appLovinSdk) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            C0444fq.runOnUiThread(new C0332bm(appLovinAdRewardListener, appLovinAd, map, appLovinSdk));
        }
    }

    /* renamed from: a */
    public static void m646a(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAd appLovinAd, double d, boolean z, AppLovinSdk appLovinSdk) {
        if (appLovinAd != null && appLovinAdVideoPlaybackListener != null) {
            C0444fq.runOnUiThread(new C0340bu(appLovinAdVideoPlaybackListener, appLovinAd, d, z, appLovinSdk));
        }
    }

    /* renamed from: a */
    public static void m647a(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAd appLovinAd, AppLovinSdk appLovinSdk) {
        if (appLovinAd != null && appLovinAdVideoPlaybackListener != null) {
            C0444fq.runOnUiThread(new C0339bt(appLovinAdVideoPlaybackListener, appLovinAd, appLovinSdk));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static AppLovinAd m648b(AppLovinAd appLovinAd) {
        C0453j jVar = (C0453j) appLovinAd;
        return jVar.mo4772n() != null ? jVar.mo4772n() : appLovinAd;
    }

    /* renamed from: b */
    public static void m649b(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinSdk appLovinSdk) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            C0444fq.runOnUiThread(new C0342bw(appLovinAdViewEventListener, appLovinAd, appLovinAdView, appLovinSdk));
        }
    }

    /* renamed from: b */
    public static void m650b(AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAd appLovinAd, AppLovinSdk appLovinSdk) {
        if (appLovinAd != null && appLovinAdDisplayListener != null) {
            C0444fq.runOnUiThread(new C0337br(appLovinAdDisplayListener, appLovinAd, appLovinSdk));
        }
    }

    /* renamed from: b */
    public static void m651b(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map<String, String> map, AppLovinSdk appLovinSdk) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            C0444fq.runOnUiThread(new C0333bn(appLovinAdRewardListener, appLovinAd, map, appLovinSdk));
        }
    }

    /* renamed from: c */
    public static void m652c(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinSdk appLovinSdk) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            C0444fq.runOnUiThread(new C0343bx(appLovinAdViewEventListener, appLovinAd, appLovinAdView, appLovinSdk));
        }
    }

    /* renamed from: c */
    public static void m653c(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map<String, String> map, AppLovinSdk appLovinSdk) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            C0444fq.runOnUiThread(new C0334bo(appLovinAdRewardListener, appLovinAd, map, appLovinSdk));
        }
    }
}
