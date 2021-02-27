package com.unity3d.player;

/* renamed from: com.unity3d.player.l */
final class C0567l {

    /* renamed from: a */
    private static boolean f1375a = false;

    /* renamed from: b */
    private boolean f1376b;

    /* renamed from: c */
    private boolean f1377c;

    /* renamed from: d */
    private boolean f1378d;

    /* renamed from: e */
    private boolean f1379e;

    C0567l() {
        this.f1376b = !C0561i.f1363e;
        this.f1377c = false;
        this.f1378d = false;
        this.f1379e = true;
    }

    /* renamed from: a */
    static void m1428a() {
        f1375a = true;
    }

    /* renamed from: b */
    static void m1429b() {
        f1375a = false;
    }

    /* renamed from: c */
    static boolean m1430c() {
        return f1375a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo8713a(boolean z) {
        this.f1377c = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo8714b(boolean z) {
        this.f1379e = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo8715c(boolean z) {
        this.f1378d = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo8716d() {
        this.f1376b = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo8717e() {
        return this.f1379e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final boolean mo8718f() {
        return f1375a && this.f1377c && this.f1376b && !this.f1379e && !this.f1378d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final boolean mo8719g() {
        return this.f1378d;
    }

    public final String toString() {
        return super.toString();
    }
}
