package com.applovin.impl.sdk;

import android.content.DialogInterface;

/* renamed from: com.applovin.impl.sdk.ax */
class C0316ax implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0315aw f559a;

    C0316ax(C0315aw awVar) {
        this.f559a = awVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f559a.f558a.f557f.schedule(new C0317ay(this), 200);
    }
}
