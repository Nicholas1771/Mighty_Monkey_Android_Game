package com.applovin.impl.sdk;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.dc */
public class C0376dc {

    /* renamed from: d */
    private static C0376dc f728d;

    /* renamed from: a */
    private final Map<C0296ad, String> f729a = new HashMap(1);

    /* renamed from: b */
    private final Map<C0296ad, Map<String, String>> f730b = new HashMap(1);

    /* renamed from: c */
    private final Object f731c = new Object();

    private C0376dc() {
    }

    /* renamed from: a */
    public static synchronized C0376dc m763a() {
        C0376dc dcVar;
        synchronized (C0376dc.class) {
            if (f728d == null) {
                f728d = new C0376dc();
            }
            dcVar = f728d;
        }
        return dcVar;
    }

    /* renamed from: a */
    public Map<String, String> mo4486a(C0296ad adVar) {
        Map<String, String> remove;
        synchronized (this.f731c) {
            remove = this.f730b.remove(adVar);
        }
        return remove;
    }

    /* renamed from: a */
    public void mo4487a(C0296ad adVar, String str) {
        synchronized (this.f731c) {
            this.f729a.put(adVar, str);
        }
    }

    /* renamed from: a */
    public void mo4488a(C0296ad adVar, Map<String, String> map) {
        synchronized (this.f731c) {
            this.f730b.put(adVar, map);
        }
    }

    /* renamed from: b */
    public String mo4489b(C0296ad adVar) {
        String remove;
        synchronized (this.f731c) {
            remove = this.f729a.remove(adVar);
        }
        return remove;
    }
}
