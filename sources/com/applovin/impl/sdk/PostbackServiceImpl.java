package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinPostbackService;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

public class PostbackServiceImpl implements AppLovinPostbackService {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AppLovinSdkImpl f475a;

    PostbackServiceImpl(AppLovinSdkImpl appLovinSdkImpl) {
        this.f475a = appLovinSdkImpl;
    }

    public void dispatchPostbackAsync(String str, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackAsync(str, (Map<String, String>) null, (String) null, appLovinPostbackListener);
    }

    public void dispatchPostbackAsync(String str, Map<String, String> map, String str2, int i, long j, int i2, AppLovinPostbackListener appLovinPostbackListener) {
        if (AppLovinSdkUtils.isValidString(str)) {
            C0408eh ehVar = new C0408eh(this.f475a, str, map, new C0380dg(this, appLovinPostbackListener));
            ehVar.mo4661a(i);
            ehVar.mo4662a(j);
            ehVar.mo4664b(i2);
            ehVar.mo4663a(str2);
            this.f475a.mo4169a().mo4681a((C0386dm) ehVar, C0416ep.POSTBACKS);
            return;
        }
        this.f475a.getLogger().mo4780e("PostbackService", "Requested a postback dispatch for an empty URL; nothing to do...");
        if (appLovinPostbackListener != null) {
            appLovinPostbackListener.onPostbackFailure(str, AppLovinErrorCodes.INVALID_URL);
        }
    }

    public void dispatchPostbackAsync(String str, Map<String, String> map, String str2, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackAsync(str, map, str2, ((Integer) this.f475a.get(C0387dn.f877bf)).intValue(), ((Long) this.f475a.get(C0387dn.f972q)).longValue(), ((Integer) this.f475a.get(C0387dn.f876be)).intValue(), appLovinPostbackListener);
    }
}
