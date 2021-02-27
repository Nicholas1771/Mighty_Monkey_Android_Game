package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinLogger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.dh */
abstract class C0381dh implements C0302aj, AppLovinNativeAdLoadListener {

    /* renamed from: a */
    protected final AppLovinSdkImpl f746a;

    /* renamed from: b */
    protected final AppLovinLogger f747b;

    /* renamed from: c */
    protected final Object f748c = new Object();

    /* renamed from: d */
    protected final Map<C0451h, C0382di> f749d = mo4463a();

    /* renamed from: e */
    protected final Map<C0451h, C0382di> f750e = mo4468b();

    /* renamed from: f */
    protected final Map<C0451h, Object> f751f = new HashMap();

    /* renamed from: g */
    protected final Set<C0451h> f752g = new HashSet();

    C0381dh(AppLovinSdkImpl appLovinSdkImpl) {
        this.f746a = appLovinSdkImpl;
        this.f747b = appLovinSdkImpl.getLogger();
    }

    /* renamed from: j */
    private C0382di m791j(C0451h hVar) {
        return this.f749d.get(hVar);
    }

    /* renamed from: k */
    private C0382di m792k(C0451h hVar) {
        C0382di diVar = this.f750e.get(hVar);
        if (diVar != null) {
            return diVar;
        }
        throw new IllegalArgumentException("Unable to retrieve extended ad queue. Invalid ad spec: " + hVar);
    }

    /* renamed from: l */
    private C0382di m793l(C0451h hVar) {
        C0382di k;
        synchronized (this.f748c) {
            k = m792k(hVar);
            if (k.mo4510a() <= 0) {
                k = m791j(hVar);
            }
        }
        return k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract C0386dm mo4461a(C0451h hVar);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract C0451h mo4462a(C0344by byVar);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract Map<C0451h, C0382di> mo4463a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo4464a(Object obj, C0344by byVar);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo4465a(Object obj, C0451h hVar, int i);

    /* renamed from: a */
    public boolean mo4466a(C0451h hVar, Object obj) {
        boolean z;
        synchronized (this.f748c) {
            if (!mo4509i(hVar)) {
                mo4469b(hVar, obj);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: b */
    public C0344by mo4467b(C0451h hVar) {
        C0344by f;
        synchronized (this.f748c) {
            f = m793l(hVar).mo4516f();
        }
        return f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract Map<C0451h, C0382di> mo4468b();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4506b(C0344by byVar) {
        mo4475h(mo4462a(byVar));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4507b(C0451h hVar, int i) {
        Object remove;
        this.f747b.mo4779d("PreloadManager", "Failed to pre-load an ad of spec " + hVar + ", error code " + i);
        synchronized (this.f748c) {
            remove = this.f751f.remove(hVar);
            this.f752g.add(hVar);
        }
        if (remove != null) {
            try {
                mo4465a(remove, hVar, i);
            } catch (Throwable th) {
                this.f746a.getLogger().userError("PreloadManager", "Encountered exception while invoking user callback", th);
            }
        }
    }

    /* renamed from: b */
    public void mo4469b(C0451h hVar, Object obj) {
        synchronized (this.f748c) {
            if (this.f751f.containsKey(hVar)) {
                this.f747b.mo4785w("PreloadManager", "Possibly missing prior registered preload callback.");
            }
            this.f751f.put(hVar, obj);
        }
    }

    /* renamed from: c */
    public C0344by mo4470c(C0451h hVar) {
        C0344by e;
        synchronized (this.f748c) {
            e = m793l(hVar).mo4515e();
        }
        return e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo4508c(C0344by byVar) {
        Object obj;
        C0451h a = mo4462a(byVar);
        boolean a2 = C0444fq.m1166a(a, this.f746a);
        synchronized (this.f748c) {
            obj = this.f751f.get(a);
            this.f751f.remove(a);
            this.f752g.add(a);
            if (obj == null || a2) {
                m791j(a).mo4511a(byVar);
                this.f747b.mo4779d("PreloadManager", "Ad enqueued: " + byVar);
            } else {
                this.f747b.mo4779d("PreloadManager", "Additional callback found or dummy ads are enabled; skipping enqueue...");
            }
        }
        if (obj != null) {
            this.f747b.mo4779d("PreloadManager", "Called additional callback regarding " + byVar);
            if (a2) {
                try {
                    mo4464a(obj, (C0344by) new C0299ag(a, this.f746a));
                } catch (Throwable th) {
                    this.f746a.getLogger().userError("PreloadManager", "Encountered throwable while notifying user callback", th);
                }
            } else {
                mo4464a(obj, byVar);
                mo4506b(byVar);
            }
        }
        this.f747b.mo4779d("PreloadManager", "Pulled ad from network and saved to preload cache: " + byVar);
    }

    /* renamed from: d */
    public C0344by mo4471d(C0451h hVar) {
        C0344by e;
        synchronized (this.f748c) {
            C0382di j = m791j(hVar);
            if (C0444fq.m1166a(hVar, this.f746a)) {
                C0382di k = m792k(hVar);
                if (k.mo4513c()) {
                    e = new C0299ag(hVar, this.f746a);
                } else if (j.mo4510a() > 0) {
                    k.mo4511a(j.mo4515e());
                    e = new C0299ag(hVar, this.f746a);
                } else {
                    e = (k.mo4510a() <= 0 || !((Boolean) this.f746a.get(C0387dn.f906cH)).booleanValue()) ? null : new C0299ag(hVar, this.f746a);
                }
            } else {
                e = j.mo4515e();
            }
        }
        if (e != null) {
            this.f747b.mo4779d("PreloadManager", "Retrieved ad of spec " + hVar + "...");
        } else {
            this.f747b.mo4779d("PreloadManager", "Unable to retrieve ad of spec " + hVar + "...");
        }
        return e;
    }

    /* renamed from: e */
    public boolean mo4472e(C0451h hVar) {
        boolean c;
        synchronized (this.f748c) {
            c = m791j(hVar).mo4513c();
        }
        return c;
    }

    /* renamed from: f */
    public void mo4473f(C0451h hVar) {
        int b;
        if (hVar != null) {
            synchronized (this.f748c) {
                C0382di j = m791j(hVar);
                b = j != null ? j.mo4512b() - j.mo4510a() : 0;
            }
            if (b > 0) {
                for (int i = 0; i < b; i++) {
                    mo4475h(hVar);
                }
            }
        }
    }

    /* renamed from: g */
    public boolean mo4474g(C0451h hVar) {
        boolean z;
        synchronized (this.f748c) {
            z = !m791j(hVar).mo4514d();
        }
        return z;
    }

    /* renamed from: h */
    public void mo4475h(C0451h hVar) {
        if (((Boolean) this.f746a.get(C0387dn.f772G)).booleanValue() && !mo4472e(hVar)) {
            this.f747b.mo4779d("PreloadManager", "Preloading ad for spec " + hVar + "...");
            this.f746a.mo4169a().mo4682a(mo4461a(hVar), C0416ep.MAIN, 500);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo4509i(C0451h hVar) {
        boolean contains;
        synchronized (this.f748c) {
            contains = this.f752g.contains(hVar);
        }
        return contains;
    }
}
