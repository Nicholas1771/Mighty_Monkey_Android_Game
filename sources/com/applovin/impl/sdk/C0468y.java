package com.applovin.impl.sdk;

import android.webkit.WebView;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.applovin.impl.sdk.y */
class C0468y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AtomicReference f1190a;

    /* renamed from: b */
    final /* synthetic */ CountDownLatch f1191b;

    /* renamed from: c */
    final /* synthetic */ C0467x f1192c;

    C0468y(C0467x xVar, AtomicReference atomicReference, CountDownLatch countDownLatch) {
        this.f1192c = xVar;
        this.f1190a = atomicReference;
        this.f1191b = countDownLatch;
    }

    public void run() {
        try {
            this.f1190a.set(new WebView(this.f1192c.f1188c).getSettings().getUserAgentString());
        } catch (Throwable th) {
            this.f1192c.f1187b.mo4781e("DataCollector", "Unable to collect user agent string", th);
        } finally {
            this.f1191b.countDown();
        }
    }
}
