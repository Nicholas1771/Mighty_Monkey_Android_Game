package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.eh */
public class C0408eh extends C0386dm {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f1028a;

    /* renamed from: b */
    private final Map<String, String> f1029b;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final AppLovinPostbackListener f1030g;

    /* renamed from: h */
    private String f1031h;

    /* renamed from: i */
    private int f1032i;

    /* renamed from: j */
    private long f1033j;

    /* renamed from: k */
    private int f1034k = -1;

    public C0408eh(AppLovinSdkImpl appLovinSdkImpl, String str, Map<String, String> map, AppLovinPostbackListener appLovinPostbackListener) {
        super("TaskDispatchPostback", appLovinSdkImpl);
        this.f1028a = str;
        this.f1030g = appLovinPostbackListener;
        this.f1029b = map;
    }

    /* renamed from: a */
    public void mo4661a(int i) {
        this.f1032i = i;
    }

    /* renamed from: a */
    public void mo4662a(long j) {
        this.f1033j = j;
    }

    /* renamed from: a */
    public void mo4663a(String str) {
        this.f1031h = str;
    }

    /* renamed from: b */
    public void mo4664b(int i) {
        this.f1034k = i;
    }

    public void run() {
        if (!AppLovinSdkUtils.isValidString(this.f1028a)) {
            this.f763d.getLogger().mo4782i("TaskDispatchPostback", "Requested URL is not valid; nothing to do...");
            this.f1030g.onPostbackFailure(this.f1028a, AppLovinErrorCodes.INVALID_URL);
            return;
        }
        C0409ei eiVar = new C0409ei(this, this.f1029b == null ? "GET" : "POST", new JSONObject(), "RepeatTaskDispatchPostback", this.f763d);
        eiVar.mo4701a(this.f1028a);
        eiVar.mo4706b(this.f1031h);
        eiVar.mo4702a(this.f1029b == null ? null : new JSONObject(this.f1029b));
        eiVar.mo4699a(this.f1033j);
        eiVar.mo4707c(this.f1032i < 0 ? ((Integer) this.f763d.get(C0387dn.f877bf)).intValue() : this.f1032i);
        eiVar.mo4704b(this.f1034k < 0 ? ((Integer) this.f763d.get(C0387dn.f876be)).intValue() : this.f1034k);
        eiVar.mo4703a(false);
        eiVar.run();
    }
}
