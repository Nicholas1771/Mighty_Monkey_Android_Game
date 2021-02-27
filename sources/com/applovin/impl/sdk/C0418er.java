package com.applovin.impl.sdk;

import java.lang.Thread;

/* renamed from: com.applovin.impl.sdk.er */
class C0418er implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    final /* synthetic */ C0417eq f1061a;

    C0418er(C0417eq eqVar) {
        this.f1061a = eqVar;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        this.f1061a.f1059a.f1051c.mo4781e("TaskManager", "Caught unhandled exception", th);
    }
}
