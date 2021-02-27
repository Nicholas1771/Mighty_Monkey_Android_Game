package com.applovin.impl.sdk;

import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.applovin.impl.sdk.di */
class C0382di {

    /* renamed from: a */
    private final int f753a;

    /* renamed from: b */
    private final Queue<C0344by> f754b;

    /* renamed from: c */
    private final Object f755c;

    C0382di(int i) {
        this.f753a = i > 25 ? 25 : i;
        this.f754b = new LinkedList();
        this.f755c = new Object();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo4510a() {
        int size;
        synchronized (this.f755c) {
            size = this.f754b.size();
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4511a(C0344by byVar) {
        synchronized (this.f755c) {
            if (mo4510a() <= 25) {
                this.f754b.offer(byVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo4512b() {
        return this.f753a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo4513c() {
        boolean z;
        synchronized (this.f755c) {
            z = mo4510a() >= this.f753a;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo4514d() {
        boolean z;
        synchronized (this.f755c) {
            z = mo4510a() == 0;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C0344by mo4515e() {
        C0344by poll;
        try {
            synchronized (this.f755c) {
                poll = !mo4514d() ? this.f754b.poll() : null;
            }
            return poll;
        } catch (Exception e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public C0344by mo4516f() {
        C0344by peek;
        synchronized (this.f755c) {
            peek = this.f754b.peek();
        }
        return peek;
    }
}
