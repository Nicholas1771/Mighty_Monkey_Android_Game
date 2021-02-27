package com.applovin.impl.sdk;

import android.text.TextUtils;

/* renamed from: com.applovin.impl.sdk.fe */
class C0432fe implements C0465v<T> {

    /* renamed from: a */
    final /* synthetic */ String f1099a;

    /* renamed from: b */
    final /* synthetic */ AppLovinSdkImpl f1100b;

    /* renamed from: c */
    final /* synthetic */ C0431fd f1101c;

    C0432fe(C0431fd fdVar, String str, AppLovinSdkImpl appLovinSdkImpl) {
        this.f1101c = fdVar;
        this.f1099a = str;
        this.f1100b = appLovinSdkImpl;
    }

    /* renamed from: a */
    public void mo4524a(int i) {
        boolean z = true;
        boolean z2 = i < 200 || i >= 500;
        if (i == -103) {
            z = false;
        }
        if (!z2 || !z) {
            this.f1101c.mo4524a(i);
        } else if (this.f1101c.f1095m > 0) {
            this.f1101c.f764e.mo4785w(this.f1099a, "Unable to send request due to server failure (code " + i + "). " + this.f1101c.f1095m + " attempts left, retrying in " + (((double) this.f1101c.f1096n) / 1000.0d) + " seconds...");
            int unused = this.f1101c.f1095m = this.f1101c.f1095m - 1;
            if (this.f1101c.f1095m == 0) {
                this.f1101c.m1101c(this.f1101c.f1097o);
                if (!TextUtils.isEmpty(this.f1101c.f1091i) && this.f1101c.f1091i.length() >= 4) {
                    String unused2 = this.f1101c.f1090h = this.f1101c.f1091i;
                    this.f1101c.f764e.mo4782i(this.f1101c.mo4527a(), "Switching to backup endpoint " + this.f1101c.f1091i);
                }
            }
            this.f1100b.mo4169a().mo4682a((C0386dm) this.f1101c, C0416ep.BACKGROUND, this.f1101c.f1096n);
        } else {
            if (this.f1101c.f1091i == null || !this.f1101c.f1091i.equals(this.f1101c.f1090h)) {
                this.f1101c.m1101c(this.f1101c.f1097o);
            } else {
                this.f1101c.m1101c(this.f1101c.f1098p);
            }
            this.f1101c.mo4524a(i);
        }
    }

    /* renamed from: a */
    public void mo4525a(T t, int i) {
        int unused = this.f1101c.f1095m = 0;
        this.f1101c.mo4525a(t, i);
    }
}
