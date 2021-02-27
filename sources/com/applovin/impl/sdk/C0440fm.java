package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.fm */
class C0440fm extends C0384dk {

    /* renamed from: a */
    private final C0296ad f1113a;

    /* renamed from: b */
    private final AppLovinAdRewardListener f1114b;

    /* renamed from: g */
    private final Object f1115g = new Object();

    /* renamed from: h */
    private volatile boolean f1116h = false;

    public C0440fm(C0296ad adVar, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinSdkImpl appLovinSdkImpl) {
        super("TaskValidateReward", appLovinSdkImpl);
        this.f1113a = adVar;
        this.f1114b = appLovinAdRewardListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1135a(int i) {
        if (!mo4718c()) {
            String str = "network_timeout";
            if (i < 400 || i > 500) {
                this.f1114b.validationRequestFailed(this.f1113a, i);
            } else {
                this.f1114b.userRewardRejected(this.f1113a, new HashMap(0));
                str = "rejected";
            }
            C0376dc.m763a().mo4487a(this.f1113a, str);
        }
    }

    /* renamed from: a */
    private void m1138a(String str, Map<String, String> map) {
        if (!mo4718c()) {
            C0376dc a = C0376dc.m763a();
            a.mo4487a(this.f1113a, str);
            a.mo4488a(this.f1113a, map);
            if (str.equals("accepted")) {
                this.f1114b.userRewardVerified(this.f1113a, map);
            } else if (str.equals("quota_exceeded")) {
                this.f1114b.userOverQuota(this.f1113a, map);
            } else if (str.equals("rejected")) {
                this.f1114b.userRewardRejected(this.f1113a, map);
            } else {
                this.f1114b.validationRequestFailed(this.f1113a, AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1139a(JSONObject jSONObject) {
        Map hashMap;
        String str;
        if (!mo4718c()) {
            try {
                JSONObject a = C0466w.m1276a(jSONObject);
                C0466w.m1278a(a, this.f763d);
                try {
                    hashMap = C0329bj.m636a((JSONObject) a.get("params"));
                } catch (Throwable th) {
                    hashMap = new HashMap(0);
                }
                try {
                    str = a.getString("result");
                } catch (Throwable th2) {
                    str = "network_timeout";
                }
                m1138a(str, (Map<String, String>) hashMap);
            } catch (JSONException e) {
                this.f764e.mo4781e(this.f762c, "Unable to parse API response", e);
            }
        }
    }

    /* renamed from: a */
    public void mo4717a(boolean z) {
        synchronized (this.f1115g) {
            this.f1116h = z;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo4718c() {
        boolean z;
        synchronized (this.f1115g) {
            z = this.f1116h;
        }
        return z;
    }

    public void run() {
        String userIdentifier = this.f763d.getUserIdentifier();
        String l = this.f1113a.mo4291l();
        HashMap hashMap = new HashMap(2);
        if (AppLovinSdkUtils.isValidString(l)) {
            hashMap.put("clcode", l);
        } else {
            hashMap.put("clcode", "NO_CLCODE");
        }
        if (userIdentifier != null) {
            hashMap.put("user_id", userIdentifier);
        }
        mo4523a("vr", new JSONObject(hashMap), new C0441fn(this));
    }
}
