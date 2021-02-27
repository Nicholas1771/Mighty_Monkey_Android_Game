package com.applovin.impl.sdk;

import android.util.Log;
import com.applovin.sdk.AppLovinLogger;

/* renamed from: com.applovin.impl.sdk.q */
class C0460q implements AppLovinLogger {

    /* renamed from: a */
    private C0390dq f1174a;

    /* renamed from: b */
    private C0461r f1175b;

    C0460q() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4776a(C0390dq dqVar) {
        this.f1174a = dqVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4777a(C0461r rVar) {
        this.f1175b = rVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo4778a() {
        if (this.f1174a != null) {
            return ((Boolean) this.f1174a.mo4534a(C0387dn.f964i)).booleanValue();
        }
        return false;
    }

    /* renamed from: d */
    public void mo4779d(String str, String str2) {
        if (mo4778a()) {
            Log.d(AppLovinLogger.SDK_TAG, "[" + str + "] " + str2);
        }
        if (this.f1175b != null) {
            this.f1175b.mo4787a("DEBUG  [" + str + "] " + str2);
        }
    }

    /* renamed from: e */
    public void mo4780e(String str, String str2) {
        mo4781e(str, str2, (Throwable) null);
    }

    /* renamed from: e */
    public void mo4781e(String str, String str2, Throwable th) {
        if (mo4778a()) {
            Log.e(AppLovinLogger.SDK_TAG, "[" + str + "] " + str2, th);
        }
        if (this.f1175b != null) {
            this.f1175b.mo4787a("ERROR  [" + str + "] " + str2 + (th != null ? ": " + th.getMessage() : ""));
        }
    }

    /* renamed from: i */
    public void mo4782i(String str, String str2) {
        if (mo4778a()) {
            Log.i(AppLovinLogger.SDK_TAG, "[" + str + "] " + str2);
        }
        if (this.f1175b != null) {
            this.f1175b.mo4787a("INFO  [" + str + "] " + str2);
        }
    }

    public void userError(String str, String str2) {
        userError(str, str2, (Throwable) null);
    }

    public void userError(String str, String str2, Throwable th) {
        Log.e(AppLovinLogger.SDK_TAG, "[" + str + "] " + str2, th);
        if (this.f1175b != null) {
            this.f1175b.mo4787a("USER  [" + str + "] " + str2 + (th != null ? ": " + th.getMessage() : ""));
        }
    }

    /* renamed from: w */
    public void mo4785w(String str, String str2) {
        mo4786w(str, str2, (Throwable) null);
    }

    /* renamed from: w */
    public void mo4786w(String str, String str2, Throwable th) {
        if (mo4778a()) {
            Log.w(AppLovinLogger.SDK_TAG, "[" + str + "] " + str2, th);
        }
        if (this.f1175b != null) {
            this.f1175b.mo4787a("WARN  [" + str + "] " + str2);
        }
    }
}
