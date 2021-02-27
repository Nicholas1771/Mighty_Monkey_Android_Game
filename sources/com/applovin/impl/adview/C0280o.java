package com.applovin.impl.adview;

import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.applovin.impl.adview.o */
class C0280o implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ C0279n f384a;

    C0280o(C0279n nVar) {
        this.f384a = nVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.hasFocus()) {
            return false;
        }
        view.requestFocus();
        return false;
    }
}
