package com.applovin.impl.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.StrictMode;
import android.view.Display;
import android.view.WindowManager;
import com.applovin.adview.AppLovinInterstitialActivity;

/* renamed from: com.applovin.impl.sdk.t */
public class C0463t {
    /* renamed from: a */
    static void m1248a() {
        try {
            if (Build.VERSION.SDK_INT >= 9) {
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public static boolean m1249a(Context context) {
        try {
            return C0444fq.m1164a(context.getPackageManager().getActivityInfo(new ComponentName(context, AppLovinInterstitialActivity.class.getCanonicalName()), 0).configChanges, 1024);
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m1250a(Class<?> cls, Context context) {
        return context.getPackageManager().resolveActivity(new Intent(context, cls), 0) != null;
    }

    /* renamed from: a */
    public static boolean m1251a(String str, Context context) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    /* renamed from: b */
    public static boolean m1252b() {
        return Build.VERSION.SDK_INT >= 11;
    }

    /* renamed from: b */
    public static boolean m1253b(Context context) {
        try {
            return C0444fq.m1164a(context.getPackageManager().getActivityInfo(new ComponentName(context, AppLovinInterstitialActivity.class.getCanonicalName()), 0).configChanges, 128);
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: c */
    public static Point m1254c(Context context) {
        Point point = new Point();
        point.x = 480;
        point.y = 320;
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                defaultDisplay.getSize(point);
            } else {
                point.x = defaultDisplay.getWidth();
                point.y = defaultDisplay.getHeight();
            }
        } catch (Throwable th) {
        }
        return point;
    }

    /* renamed from: c */
    public static boolean m1255c() {
        return Build.VERSION.SDK_INT >= 15;
    }

    /* renamed from: d */
    public static boolean m1256d() {
        return Build.VERSION.SDK_INT >= 16;
    }

    /* renamed from: e */
    public static boolean m1257e() {
        return Build.VERSION.SDK_INT >= 17;
    }

    /* renamed from: f */
    public static boolean m1258f() {
        return Build.VERSION.SDK_INT >= 19;
    }

    /* renamed from: g */
    public static boolean m1259g() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* renamed from: h */
    public static boolean m1260h() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
