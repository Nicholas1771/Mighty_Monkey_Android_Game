package com.applovin.adview;

import android.content.DialogInterface;

/* renamed from: com.applovin.adview.a */
class C0177a implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinConfirmationActivity f25a;

    C0177a(AppLovinConfirmationActivity appLovinConfirmationActivity) {
        this.f25a = appLovinConfirmationActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f25a.finish();
    }
}
