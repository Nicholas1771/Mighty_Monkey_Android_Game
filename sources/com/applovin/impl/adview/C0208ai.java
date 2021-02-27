package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: com.applovin.impl.adview.ai */
public class C0208ai extends View {

    /* renamed from: A */
    private final int f183A;

    /* renamed from: a */
    protected Paint f184a;

    /* renamed from: b */
    protected Paint f185b;

    /* renamed from: c */
    private Paint f186c;

    /* renamed from: d */
    private Paint f187d;

    /* renamed from: e */
    private RectF f188e;

    /* renamed from: f */
    private float f189f;

    /* renamed from: g */
    private int f190g;

    /* renamed from: h */
    private int f191h;

    /* renamed from: i */
    private int f192i;

    /* renamed from: j */
    private int f193j;

    /* renamed from: k */
    private int f194k;

    /* renamed from: l */
    private float f195l;

    /* renamed from: m */
    private int f196m;

    /* renamed from: n */
    private String f197n;

    /* renamed from: o */
    private String f198o;

    /* renamed from: p */
    private float f199p;

    /* renamed from: q */
    private String f200q;

    /* renamed from: r */
    private float f201r;

    /* renamed from: s */
    private final float f202s;

    /* renamed from: t */
    private final int f203t;

    /* renamed from: u */
    private final int f204u;

    /* renamed from: v */
    private final int f205v;

    /* renamed from: w */
    private final int f206w;

    /* renamed from: x */
    private final int f207x;

    /* renamed from: y */
    private final float f208y;

    /* renamed from: z */
    private final float f209z;

    public C0208ai(Context context) {
        this(context, (AttributeSet) null);
    }

    public C0208ai(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0208ai(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f188e = new RectF();
        this.f192i = 0;
        this.f197n = "";
        this.f198o = "";
        this.f200q = "";
        this.f203t = Color.rgb(66, 145, 241);
        this.f204u = Color.rgb(66, 145, 241);
        this.f205v = Color.rgb(66, 145, 241);
        this.f206w = 0;
        this.f207x = 100;
        this.f208y = C0209aj.m193b(getResources(), 14.0f);
        this.f183A = (int) C0209aj.m192a(getResources(), 100.0f);
        this.f202s = C0209aj.m192a(getResources(), 4.0f);
        this.f209z = C0209aj.m193b(getResources(), 18.0f);
        mo3971b();
        mo3968a();
    }

    /* renamed from: e */
    private int m170e(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i2 = this.f183A;
        return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    /* renamed from: o */
    private float m171o() {
        return (((float) mo3976d()) / ((float) this.f193j)) * 360.0f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3968a() {
        this.f184a = new TextPaint();
        this.f184a.setColor(this.f190g);
        this.f184a.setTextSize(this.f189f);
        this.f184a.setAntiAlias(true);
        this.f185b = new TextPaint();
        this.f185b.setColor(this.f191h);
        this.f185b.setTextSize(this.f199p);
        this.f185b.setAntiAlias(true);
        this.f186c = new Paint();
        this.f186c.setColor(this.f194k);
        this.f186c.setStyle(Paint.Style.STROKE);
        this.f186c.setAntiAlias(true);
        this.f186c.setStrokeWidth(this.f195l);
        this.f187d = new Paint();
        this.f187d.setColor(this.f196m);
        this.f187d.setAntiAlias(true);
    }

    /* renamed from: a */
    public void mo3969a(float f) {
        this.f195l = f;
        invalidate();
    }

    /* renamed from: a */
    public void mo3970a(int i) {
        this.f192i = i;
        if (this.f192i > mo3978e()) {
            this.f192i %= mo3978e();
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo3971b() {
        this.f194k = this.f203t;
        this.f190g = this.f204u;
        this.f189f = this.f208y;
        mo3973b(100);
        mo3970a(0);
        this.f195l = this.f202s;
        this.f196m = 0;
        this.f199p = this.f209z;
        this.f191h = this.f205v;
    }

    /* renamed from: b */
    public void mo3972b(float f) {
        this.f189f = f;
        invalidate();
    }

    /* renamed from: b */
    public void mo3973b(int i) {
        if (i > 0) {
            this.f193j = i;
            invalidate();
        }
    }

    /* renamed from: c */
    public float mo3974c() {
        return this.f195l;
    }

    /* renamed from: c */
    public void mo3975c(int i) {
        this.f190g = i;
        invalidate();
    }

    /* renamed from: d */
    public int mo3976d() {
        return this.f192i;
    }

    /* renamed from: d */
    public void mo3977d(int i) {
        this.f194k = i;
        invalidate();
    }

    /* renamed from: e */
    public int mo3978e() {
        return this.f193j;
    }

    /* renamed from: f */
    public float mo3979f() {
        return this.f189f;
    }

    /* renamed from: g */
    public int mo3980g() {
        return this.f190g;
    }

    /* renamed from: h */
    public int mo3981h() {
        return this.f194k;
    }

    /* renamed from: i */
    public String mo3982i() {
        return this.f198o;
    }

    public void invalidate() {
        mo3968a();
        super.invalidate();
    }

    /* renamed from: j */
    public String mo3984j() {
        return this.f197n;
    }

    /* renamed from: k */
    public int mo3985k() {
        return this.f196m;
    }

    /* renamed from: l */
    public String mo3986l() {
        return this.f200q;
    }

    /* renamed from: m */
    public float mo3987m() {
        return this.f199p;
    }

    /* renamed from: n */
    public int mo3988n() {
        return this.f191h;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.f195l;
        this.f188e.set(f, f, ((float) getWidth()) - f, ((float) getHeight()) - f);
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, ((((float) getWidth()) - this.f195l) + this.f195l) / 2.0f, this.f187d);
        canvas.drawArc(this.f188e, 270.0f, -m171o(), false, this.f186c);
        String str = this.f197n + this.f192i + this.f198o;
        if (!TextUtils.isEmpty(str)) {
            canvas.drawText(str, (((float) getWidth()) - this.f184a.measureText(str)) / 2.0f, (((float) getWidth()) - (this.f184a.descent() + this.f184a.ascent())) / 2.0f, this.f184a);
        }
        if (!TextUtils.isEmpty(mo3986l())) {
            this.f185b.setTextSize(this.f199p);
            canvas.drawText(mo3986l(), (((float) getWidth()) - this.f185b.measureText(mo3986l())) / 2.0f, (((float) getHeight()) - this.f201r) - ((this.f184a.descent() + this.f184a.ascent()) / 2.0f), this.f185b);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(m170e(i), m170e(i2));
        this.f201r = (float) (getHeight() - ((getHeight() * 3) / 4));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f190g = bundle.getInt("text_color");
            this.f189f = bundle.getFloat("text_size");
            this.f199p = bundle.getFloat("inner_bottom_text_size");
            this.f200q = bundle.getString("inner_bottom_text");
            this.f191h = bundle.getInt("inner_bottom_text_color");
            this.f194k = bundle.getInt("finished_stroke_color");
            this.f195l = bundle.getFloat("finished_stroke_width");
            this.f196m = bundle.getInt("inner_background_color");
            mo3968a();
            mo3973b(bundle.getInt("max"));
            mo3970a(bundle.getInt("progress"));
            this.f197n = bundle.getString("prefix");
            this.f198o = bundle.getString("suffix");
            super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", mo3980g());
        bundle.putFloat("text_size", mo3979f());
        bundle.putFloat("inner_bottom_text_size", mo3987m());
        bundle.putFloat("inner_bottom_text_color", (float) mo3988n());
        bundle.putString("inner_bottom_text", mo3986l());
        bundle.putInt("inner_bottom_text_color", mo3988n());
        bundle.putInt("finished_stroke_color", mo3981h());
        bundle.putInt("max", mo3978e());
        bundle.putInt("progress", mo3976d());
        bundle.putString("suffix", mo3982i());
        bundle.putString("prefix", mo3984j());
        bundle.putFloat("finished_stroke_width", mo3974c());
        bundle.putInt("inner_background_color", mo3985k());
        return bundle;
    }
}
