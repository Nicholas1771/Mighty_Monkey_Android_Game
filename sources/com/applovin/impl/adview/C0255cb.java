package com.applovin.impl.adview;

import android.content.Context;

/* renamed from: com.applovin.impl.adview.cb */
class C0255cb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f331a;

    /* renamed from: b */
    final /* synthetic */ C0252bz f332b;

    C0255cb(C0252bz bzVar, Context context) {
        this.f332b = bzVar;
        this.f331a = context;
    }

    public void run() {
        this.f332b.m324a(this.f331a);
    }
}
