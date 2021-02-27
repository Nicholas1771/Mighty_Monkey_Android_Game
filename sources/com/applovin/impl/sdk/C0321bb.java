package com.applovin.impl.sdk;

import android.app.AlertDialog;
import com.applovin.impl.adview.C0225az;

/* renamed from: com.applovin.impl.sdk.bb */
public class C0321bb {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AppLovinSdkImpl f573a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C0225az f574b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AlertDialog f575c;

    public C0321bb(AppLovinSdkImpl appLovinSdkImpl, C0225az azVar) {
        this.f573a = appLovinSdkImpl;
        this.f574b = azVar;
    }

    /* renamed from: a */
    public void mo4366a() {
        this.f574b.runOnUiThread(new C0322bc(this));
    }

    /* renamed from: b */
    public void mo4367b() {
        this.f574b.runOnUiThread(new C0323bd(this));
    }

    /* renamed from: c */
    public void mo4368c() {
        this.f574b.runOnUiThread(new C0326bg(this));
    }

    /* renamed from: d */
    public boolean mo4369d() {
        if (this.f575c != null) {
            return this.f575c.isShowing();
        }
        return false;
    }
}
