package com.applovin.impl.adview;

import android.content.DialogInterface;

/* renamed from: com.applovin.impl.adview.c */
class C0253c implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ C0226b f328a;

    C0253c(C0226b bVar) {
        this.f328a = bVar;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f328a.f276a.contractAd();
    }
}
