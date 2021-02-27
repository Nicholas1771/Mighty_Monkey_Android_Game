package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.p000v4.view.ViewCompat;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.adview.co */
public class C0268co extends C0210ak {

    /* renamed from: c */
    private float f361c = 30.0f;

    /* renamed from: d */
    private float f362d = 2.0f;

    /* renamed from: e */
    private float f363e = 10.0f;

    /* renamed from: f */
    private float f364f = 3.0f;

    /* renamed from: g */
    private float f365g = 1.0f;

    public C0268co(AppLovinSdk appLovinSdk, Context context) {
        super(appLovinSdk, context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo4108a() {
        return this.f361c * this.f365g;
    }

    /* renamed from: a */
    public void mo4109a(float f) {
        this.f365g = f;
    }

    /* renamed from: a */
    public void mo3993a(int i) {
        mo4109a(((float) i) / this.f361c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public float mo4110b() {
        return this.f363e * this.f365g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public float mo4111c() {
        return this.f364f * this.f365g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public float mo4112d() {
        return mo4108a() / 2.0f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public float mo4113e() {
        return this.f362d * this.f365g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public float mo4114f() {
        return mo4112d() - mo4113e();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float d = mo4112d();
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawCircle(d, d, d, paint);
        Paint paint2 = new Paint(1);
        paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawCircle(d, d, mo4114f(), paint2);
        Paint paint3 = new Paint(paint);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(mo4111c());
        float b = mo4110b();
        float a = mo4108a() - b;
        canvas.drawLine(b, b, a, a, paint3);
        canvas.drawLine(b, a, a, b, paint3);
    }
}
