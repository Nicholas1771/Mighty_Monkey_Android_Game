package com.applovin.impl.adview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class AppLovinVideoView extends VideoView {

    /* renamed from: a */
    private int f154a = 0;

    /* renamed from: b */
    private int f155b = 0;

    /* renamed from: c */
    private float f156c = 0.0f;

    public AppLovinVideoView(Context context) {
        super(context, (AttributeSet) null, 0);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f154a <= 0 || this.f155b <= 0) {
            super.onMeasure(i, i2);
            return;
        }
        int defaultSize = getDefaultSize(this.f154a, i);
        int defaultSize2 = getDefaultSize(this.f155b, i2);
        int i3 = (int) (((float) defaultSize) / this.f156c);
        if (defaultSize2 <= i3) {
            i3 = defaultSize2;
        }
        int i4 = (int) (((float) i3) * this.f156c);
        if (defaultSize <= i4) {
            i4 = defaultSize;
        }
        setMeasuredDimension(i4, i3);
    }

    public void setVideoSize(int i, int i2) {
        this.f154a = i;
        this.f155b = i2;
        this.f156c = ((float) this.f154a) / ((float) this.f155b);
        try {
            getHolder().setFixedSize(i, i2);
            requestLayout();
            invalidate();
        } catch (Exception e) {
        }
    }
}
