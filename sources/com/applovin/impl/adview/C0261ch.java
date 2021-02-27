package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.adview.ch */
public class C0261ch extends C0210ak {

    /* renamed from: c */
    private float f340c = 30.0f;

    /* renamed from: d */
    private float f341d = 2.0f;

    /* renamed from: e */
    private float f342e = 8.0f;

    /* renamed from: f */
    private float f343f = 2.0f;

    /* renamed from: g */
    private float f344g = 1.0f;

    public C0261ch(AppLovinSdk appLovinSdk, Context context) {
        super(appLovinSdk, context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo4084a() {
        return this.f340c * this.f344g;
    }

    /* renamed from: a */
    public void mo4085a(float f) {
        this.f344g = f;
    }

    /* renamed from: a */
    public void mo3993a(int i) {
        mo4085a(((float) i) / this.f340c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public float mo4086b() {
        return this.f342e * this.f344g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public float mo4087c() {
        return this.f343f * this.f344g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public float mo4088d() {
        return mo4084a() / 2.0f;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float d = mo4088d();
        Paint paint = new Paint(1);
        paint.setARGB(80, 0, 0, 0);
        canvas.drawCircle(d, d, d, paint);
        Paint paint2 = new Paint(1);
        paint2.setColor(-1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(mo4087c());
        float b = mo4086b();
        float a = mo4084a() - b;
        canvas.drawLine(b, b, a, a, paint2);
        canvas.drawLine(b, a, a, b, paint2);
    }
}
