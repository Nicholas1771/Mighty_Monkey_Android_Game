package com.applovin.impl.adview;

import android.view.View;

/* renamed from: com.applovin.impl.adview.aw */
class C0222aw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0217ar f238a;

    C0222aw(C0217ar arVar) {
        this.f238a = arVar;
    }

    public void onClick(View view) {
        if (this.f238a.f233h.isClickable()) {
            this.f238a.f233h.performClick();
        }
    }
}
