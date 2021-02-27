package com.applovin.impl.sdk;

import android.text.TextUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.fd */
abstract class C0431fd<T> extends C0386dm implements C0465v<T> {

    /* renamed from: a */
    private final String f1087a;

    /* renamed from: b */
    private final T f1088b;

    /* renamed from: g */
    private final C0465v<T> f1089g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f1090h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f1091i;

    /* renamed from: j */
    private JSONObject f1092j;

    /* renamed from: k */
    private int f1093k;

    /* renamed from: l */
    private boolean f1094l = true;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f1095m = 1;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public long f1096n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C0389dp<String> f1097o = null;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public C0389dp<String> f1098p = null;

    C0431fd(String str, T t, String str2, AppLovinSdkImpl appLovinSdkImpl) {
        super(str2, appLovinSdkImpl);
        this.f1087a = str;
        this.f1088b = t;
        this.f1093k = ((Integer) appLovinSdkImpl.get(C0387dn.f975t)).intValue();
        this.f1096n = ((Long) appLovinSdkImpl.get(C0387dn.f972q)).longValue();
        this.f1089g = new C0432fe(this, str2, appLovinSdkImpl);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public <T> void m1101c(C0389dp<T> dpVar) {
        if (dpVar != null) {
            C0390dq settingsManager = this.f763d.getSettingsManager();
            settingsManager.mo4536a(dpVar, dpVar.mo4532c());
            settingsManager.mo4535a();
        }
    }

    /* renamed from: a */
    public void mo4524a(int i) {
    }

    /* renamed from: a */
    public void mo4699a(long j) {
        this.f1096n = j;
    }

    /* renamed from: a */
    public void mo4700a(C0389dp<String> dpVar) {
        this.f1097o = dpVar;
    }

    /* renamed from: a */
    public void mo4525a(T t, int i) {
    }

    /* renamed from: a */
    public void mo4701a(String str) {
        this.f1090h = str;
    }

    /* renamed from: a */
    public void mo4702a(JSONObject jSONObject) {
        this.f1092j = jSONObject;
    }

    /* renamed from: a */
    public void mo4703a(boolean z) {
        this.f1094l = z;
    }

    /* renamed from: b */
    public void mo4704b(int i) {
        this.f1093k = i;
    }

    /* renamed from: b */
    public void mo4705b(C0389dp<String> dpVar) {
        this.f1098p = dpVar;
    }

    /* renamed from: b */
    public void mo4706b(String str) {
        this.f1091i = str;
    }

    /* renamed from: c */
    public void mo4707c(int i) {
        this.f1095m = i;
    }

    public void run() {
        C0464u connectionManager = this.f763d.getConnectionManager();
        if (TextUtils.isEmpty(this.f1090h) || this.f1090h.length() < 4) {
            this.f764e.mo4780e(mo4527a(), "Task has an invalid or null request endpoint.");
            mo4524a((int) AppLovinErrorCodes.INVALID_URL);
            return;
        }
        String str = this.f1087a;
        if (TextUtils.isEmpty(str)) {
            str = this.f1092j == null ? "GET" : "POST";
        }
        connectionManager.mo4789a(this.f1090h, str, this.f1093k, this.f1092j, this.f1088b, this.f1094l, this.f1089g);
    }
}
