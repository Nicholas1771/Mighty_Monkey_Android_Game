package com.applovin.impl.sdk;

import android.content.Context;
import android.widget.Toast;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.sdk.at */
public class C0312at {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AppLovinSdkImpl f548a;

    /* renamed from: b */
    private final String f549b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Context f550c;

    public C0312at(AppLovinSdkImpl appLovinSdkImpl, Context context, String str) {
        this.f548a = appLovinSdkImpl;
        this.f549b = str;
        this.f550c = context;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4341a() {
        AppLovinSdkUtils.runOnUiThread(new C0313au(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4342a(String str, Throwable th) {
        this.f548a.getLogger().userError("IncentivizedConfirmationManager", "Unable to show incentivized ad reward dialog. Have you defined com.applovin.adview.AppLovinConfirmationActivity in your manifest?", th);
        Toast.makeText(this.f550c, str, 1).show();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo4343b() {
        return this.f549b.equals("accepted") ? (String) this.f548a.get(C0387dn.f789X) : this.f549b.equals("quota_exceeded") ? (String) this.f548a.get(C0387dn.f790Y) : this.f549b.equals("rejected") ? (String) this.f548a.get(C0387dn.f791Z) : (String) this.f548a.get(C0387dn.f819aa);
    }
}
