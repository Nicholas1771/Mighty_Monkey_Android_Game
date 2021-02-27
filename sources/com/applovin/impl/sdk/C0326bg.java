package com.applovin.impl.sdk;

import android.app.AlertDialog;
import android.content.DialogInterface;

/* renamed from: com.applovin.impl.sdk.bg */
class C0326bg implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0321bb f580a;

    C0326bg(C0321bb bbVar) {
        this.f580a = bbVar;
    }

    public void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f580a.f574b);
        builder.setTitle((CharSequence) this.f580a.f573a.get(C0387dn.f827ai));
        builder.setMessage((CharSequence) this.f580a.f573a.get(C0387dn.f828aj));
        builder.setCancelable(false);
        builder.setPositiveButton((CharSequence) this.f580a.f573a.get(C0387dn.f830al), (DialogInterface.OnClickListener) null);
        builder.setNegativeButton((CharSequence) this.f580a.f573a.get(C0387dn.f829ak), new C0327bh(this));
        AlertDialog unused = this.f580a.f575c = builder.show();
    }
}
