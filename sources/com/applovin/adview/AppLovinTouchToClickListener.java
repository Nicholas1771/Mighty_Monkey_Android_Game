package com.applovin.adview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

public class AppLovinTouchToClickListener implements View.OnTouchListener {

    /* renamed from: a */
    private long f20a;

    /* renamed from: b */
    private float f21b;

    /* renamed from: c */
    private float f22c;

    /* renamed from: d */
    private Context f23d;

    /* renamed from: e */
    private View.OnClickListener f24e;

    public AppLovinTouchToClickListener(Context context, View.OnClickListener onClickListener) {
        this.f23d = context;
        this.f24e = onClickListener;
    }

    /* renamed from: a */
    private float m22a(float f) {
        return f / this.f23d.getResources().getDisplayMetrics().density;
    }

    /* renamed from: a */
    private float m23a(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return m22a((float) Math.sqrt((double) ((f5 * f5) + (f6 * f6))));
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f20a = System.currentTimeMillis();
                this.f21b = motionEvent.getX();
                this.f22c = motionEvent.getY();
                return true;
            case 1:
                if (System.currentTimeMillis() - this.f20a >= 1000 || m23a(this.f21b, this.f22c, motionEvent.getX(), motionEvent.getY()) >= 10.0f) {
                    return true;
                }
                this.f24e.onClick(view);
                return true;
            default:
                return true;
        }
    }
}
