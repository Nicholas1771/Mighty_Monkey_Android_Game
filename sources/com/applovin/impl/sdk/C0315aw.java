package com.applovin.impl.sdk;

import android.app.AlertDialog;

/* renamed from: com.applovin.impl.sdk.aw */
class C0315aw implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0314av f558a;

    C0315aw(C0314av avVar) {
        this.f558a = avVar;
    }

    public void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f558a.f554c);
        builder.setTitle((CharSequence) this.f558a.f552a.get(C0387dn.f784S));
        builder.setMessage((CharSequence) this.f558a.f552a.get(C0387dn.f785T));
        builder.setCancelable(false);
        builder.setPositiveButton((CharSequence) this.f558a.f552a.get(C0387dn.f786U), new C0316ax(this));
        builder.setNegativeButton((CharSequence) this.f558a.f552a.get(C0387dn.f787V), new C0318az(this));
        builder.show();
    }
}
