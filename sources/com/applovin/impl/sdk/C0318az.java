package com.applovin.impl.sdk;

import android.content.DialogInterface;

/* renamed from: com.applovin.impl.sdk.az */
class C0318az implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0315aw f561a;

    C0318az(C0315aw awVar) {
        this.f561a = awVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f561a.f558a.f553b.mo4324a(this.f561a.f558a.f556e);
    }
}
