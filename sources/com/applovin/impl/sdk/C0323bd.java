package com.applovin.impl.sdk;

import android.app.AlertDialog;

/* renamed from: com.applovin.impl.sdk.bd */
class C0323bd implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0321bb f577a;

    C0323bd(C0321bb bbVar) {
        this.f577a = bbVar;
    }

    public void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f577a.f574b);
        builder.setTitle((CharSequence) this.f577a.f573a.get(C0387dn.f822ad));
        builder.setMessage((CharSequence) this.f577a.f573a.get(C0387dn.f823ae));
        builder.setCancelable(false);
        builder.setPositiveButton((CharSequence) this.f577a.f573a.get(C0387dn.f825ag), new C0324be(this));
        builder.setNegativeButton((CharSequence) this.f577a.f573a.get(C0387dn.f824af), new C0325bf(this));
        AlertDialog unused = this.f577a.f575c = builder.show();
    }
}
