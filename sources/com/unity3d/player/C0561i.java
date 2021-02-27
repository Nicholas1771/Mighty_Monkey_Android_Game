package com.unity3d.player;

import android.os.Build;

/* renamed from: com.unity3d.player.i */
public final class C0561i {

    /* renamed from: a */
    static final boolean f1359a = (Build.VERSION.SDK_INT >= 11);

    /* renamed from: b */
    static final boolean f1360b = (Build.VERSION.SDK_INT >= 17);

    /* renamed from: c */
    static final boolean f1361c = (Build.VERSION.SDK_INT >= 19);

    /* renamed from: d */
    static final boolean f1362d = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: e */
    static final boolean f1363e;

    /* renamed from: f */
    static final C0550c f1364f = (f1359a ? new C0547b() : null);

    /* renamed from: g */
    static final C0551d f1365g = (f1360b ? new C0553f() : null);

    /* renamed from: h */
    static final C0552e f1366h;

    static {
        C0559h hVar = null;
        boolean z = true;
        if (Build.VERSION.SDK_INT < 23) {
            z = false;
        }
        f1363e = z;
        if (f1363e) {
            hVar = new C0559h();
        }
        f1366h = hVar;
    }
}
