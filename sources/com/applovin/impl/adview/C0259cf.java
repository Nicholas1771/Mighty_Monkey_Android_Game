package com.applovin.impl.adview;

import android.content.Context;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.adview.cf */
public class C0259cf extends C0210ak {

    /* renamed from: c */
    private float f338c = 30.0f;

    /* renamed from: d */
    private float f339d = 1.0f;

    public C0259cf(AppLovinSdk appLovinSdk, Context context) {
        super(appLovinSdk, context);
    }

    /* renamed from: a */
    public void mo4083a(float f) {
        this.f339d = f;
    }

    /* renamed from: a */
    public void mo3993a(int i) {
        mo4083a(((float) i) / this.f338c);
    }
}
