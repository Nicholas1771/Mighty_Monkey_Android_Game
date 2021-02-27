package com.applovin.impl.adview;

import android.content.res.Resources;

/* renamed from: com.applovin.impl.adview.aj */
class C0209aj {
    /* renamed from: a */
    public static float m192a(Resources resources, float f) {
        return (resources.getDisplayMetrics().density * f) + 0.5f;
    }

    /* renamed from: b */
    public static float m193b(Resources resources, float f) {
        return resources.getDisplayMetrics().scaledDensity * f;
    }
}
