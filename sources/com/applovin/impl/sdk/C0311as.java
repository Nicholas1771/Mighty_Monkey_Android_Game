package com.applovin.impl.sdk;

import android.content.Context;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdk;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.as */
class C0311as implements AppLovinAdClickListener, AppLovinAdDisplayListener, AppLovinAdRewardListener, AppLovinAdVideoPlaybackListener {

    /* renamed from: a */
    final /* synthetic */ C0305am f542a;

    /* renamed from: b */
    private final Context f543b;

    /* renamed from: c */
    private final AppLovinAdDisplayListener f544c;

    /* renamed from: d */
    private final AppLovinAdClickListener f545d;

    /* renamed from: e */
    private final AppLovinAdVideoPlaybackListener f546e;

    /* renamed from: f */
    private final AppLovinAdRewardListener f547f;

    private C0311as(C0305am amVar, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        this.f542a = amVar;
        this.f544c = appLovinAdDisplayListener;
        this.f545d = appLovinAdClickListener;
        this.f546e = appLovinAdVideoPlaybackListener;
        this.f547f = appLovinAdRewardListener;
        this.f543b = context;
    }

    /* synthetic */ C0311as(C0305am amVar, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener, C0306an anVar) {
        this(amVar, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    /* renamed from: a */
    private void m583a(C0296ad adVar) {
        String str;
        int i;
        String b = this.f542a.mo4328b();
        if (!C0444fq.isValidString(b) || !this.f542a.f526i) {
            this.f542a.f525h.mo4717a(true);
            if (this.f542a.f526i) {
                str = "network_timeout";
                i = AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT;
            } else {
                str = "user_closed_video";
                i = AppLovinErrorCodes.INCENTIVIZED_USER_CLOSED_VIDEO;
            }
            C0376dc.m763a().mo4487a(adVar, str);
            if (this.f542a.f526i) {
                this.f542a.mo4326a(b, this.f543b);
            }
            C0330bk.m643a(this.f547f, (AppLovinAd) adVar, i, (AppLovinSdk) this.f542a.f518a);
        } else {
            this.f542a.mo4326a(b, this.f543b);
        }
        this.f542a.f518a.mo4169a().mo4681a((C0386dm) new C0433ff(adVar, this.f542a.f518a), C0416ep.BACKGROUND);
        this.f542a.m571e();
        C0330bk.m650b(this.f544c, adVar, this.f542a.f518a);
    }

    /* renamed from: a */
    private void m584a(C0345bz bzVar) {
        this.f542a.f518a.getLogger().mo4779d("IncentivizedAdController", "Handling ad hidden for mediated ad...");
        C0330bk.m650b(this.f544c, bzVar, this.f542a.f518a);
    }

    public void adClicked(AppLovinAd appLovinAd) {
        C0330bk.m641a(this.f545d, appLovinAd, (AppLovinSdk) this.f542a.f518a);
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        C0330bk.m642a(this.f544c, appLovinAd, (AppLovinSdk) this.f542a.f518a);
    }

    public void adHidden(AppLovinAd appLovinAd) {
        AppLovinAd b = appLovinAd instanceof C0299ag ? ((C0299ag) appLovinAd).mo4305b() : appLovinAd;
        if (b instanceof C0296ad) {
            m583a((C0296ad) b);
        } else if (b instanceof C0345bz) {
            m584a((C0345bz) b);
        } else {
            this.f542a.f518a.getLogger().mo4780e("IncentivizedAdController", "Something is terribly wrong. Received ad:wasHiddenIn: callback for invalid ad of type: " + b);
        }
    }

    public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
    }

    public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
        this.f542a.mo4325a("quota_exceeded");
        C0330bk.m651b(this.f547f, appLovinAd, map, (AppLovinSdk) this.f542a.f518a);
    }

    public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
        this.f542a.mo4325a("rejected");
        C0330bk.m653c(this.f547f, appLovinAd, map, (AppLovinSdk) this.f542a.f518a);
    }

    public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
        this.f542a.mo4325a("accepted");
        C0330bk.m645a(this.f547f, appLovinAd, map, (AppLovinSdk) this.f542a.f518a);
    }

    public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
        this.f542a.mo4325a("network_timeout");
        C0330bk.m643a(this.f547f, appLovinAd, i, (AppLovinSdk) this.f542a.f518a);
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        C0330bk.m647a(this.f546e, appLovinAd, (AppLovinSdk) this.f542a.f518a);
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        C0330bk.m646a(this.f546e, appLovinAd, d, z, this.f542a.f518a);
        boolean unused = this.f542a.f526i = z;
    }
}
