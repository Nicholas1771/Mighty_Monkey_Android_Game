package com.applovin.impl.sdk;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.applovin.impl.sdk.eq */
class C0417eq implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ C0415eo f1059a;

    /* renamed from: b */
    private final String f1060b;

    public C0417eq(C0415eo eoVar, String str) {
        this.f1059a = eoVar;
        this.f1060b = str;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "AppLovinSdk:" + this.f1060b + ":" + C0444fq.m1157a(this.f1059a.f1050b.getSdkKey()));
        thread.setDaemon(true);
        thread.setPriority(10);
        thread.setUncaughtExceptionHandler(new C0418er(this));
        return thread;
    }
}
