package com.applovin.impl.adview;

import android.view.View;

/* renamed from: com.applovin.impl.adview.z */
class C0291z implements View.OnLongClickListener {

    /* renamed from: a */
    final /* synthetic */ C0279n f415a;

    C0291z(C0279n nVar) {
        this.f415a = nVar;
    }

    public boolean onLongClick(View view) {
        this.f415a.f379a.mo4779d("AdWebView", "Received a LongClick event.");
        return true;
    }
}
