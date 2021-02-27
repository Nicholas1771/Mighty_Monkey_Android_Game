package com.applovin.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ImageView;
import com.applovin.impl.sdk.C0444fq;
import com.google.android.gms.drive.DriveFile;
import java.io.File;

public class AppLovinSdkUtils {
    public static final String TAG = "AppLovinSdkUtils";

    /* renamed from: a */
    private static final Handler f1219a = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    private static boolean m1313a(Context context) {
        Bundle f = m1318f(context);
        return f != null && f.getBoolean("applovin.sdk.test_ads", false);
    }

    /* renamed from: b */
    private static boolean m1314b(Context context) {
        Bundle f = m1318f(context);
        return f != null && f.getBoolean("applovin.sdk.verbose_logging", false);
    }

    /* renamed from: c */
    private static long m1315c(Context context) {
        Bundle f = m1318f(context);
        if (f != null) {
            return (long) f.getInt("applovin.sdk.ad_refresh_seconds", -100);
        }
        return -100;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getString("applovin.sdk.auto_preload_ad_sizes");
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m1316d(android.content.Context r2) {
        /*
            android.os.Bundle r0 = m1318f(r2)
            if (r0 == 0) goto L_0x000f
            java.lang.String r1 = "applovin.sdk.auto_preload_ad_sizes"
            java.lang.String r0 = r0.getString(r1)
            if (r0 == 0) goto L_0x000f
        L_0x000e:
            return r0
        L_0x000f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.applovin.sdk.AppLovinAdSize r1 = com.applovin.sdk.AppLovinAdSize.INTERSTITIAL
            java.lang.String r1 = r1.getLabel()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ","
            java.lang.StringBuilder r0 = r0.append(r1)
            com.applovin.sdk.AppLovinAdSize r1 = com.applovin.sdk.AppLovinAdSize.BANNER
            java.lang.String r1 = r1.getLabel()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ","
            java.lang.StringBuilder r0 = r0.append(r1)
            com.applovin.sdk.AppLovinAdSize r1 = com.applovin.sdk.AppLovinAdSize.MREC
            java.lang.String r1 = r1.getLabel()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x000e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.sdk.AppLovinSdkUtils.m1316d(android.content.Context):java.lang.String");
    }

    public static int dpToPx(Context context, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getString("applovin.sdk.auto_preload_ad_types");
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m1317e(android.content.Context r2) {
        /*
            android.os.Bundle r0 = m1318f(r2)
            if (r0 == 0) goto L_0x000f
            java.lang.String r1 = "applovin.sdk.auto_preload_ad_types"
            java.lang.String r0 = r0.getString(r1)
            if (r0 == 0) goto L_0x000f
        L_0x000e:
            return r0
        L_0x000f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.applovin.sdk.AppLovinAdType r1 = com.applovin.sdk.AppLovinAdType.REGULAR
            java.lang.String r1 = r1.getLabel()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ","
            java.lang.StringBuilder r0 = r0.append(r1)
            com.applovin.sdk.AppLovinAdType r1 = com.applovin.sdk.AppLovinAdType.INCENTIVIZED
            java.lang.String r1 = r1.getLabel()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ","
            java.lang.StringBuilder r0 = r0.append(r1)
            com.applovin.sdk.AppLovinAdType r1 = com.applovin.sdk.AppLovinAdType.NATIVE
            java.lang.String r1 = r1.getLabel()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x000e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.sdk.AppLovinSdkUtils.m1317e(android.content.Context):java.lang.String");
    }

    /* renamed from: f */
    private static Bundle m1318f(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(AppLovinLogger.SDK_TAG, "Unable to retrieve application metadata", e);
            return null;
        }
    }

    public static boolean isLocalFile(Uri uri) {
        return uri != null && "file".equalsIgnoreCase(uri.getScheme());
    }

    public static boolean isValidString(String str) {
        return str != null && str.length() > 1;
    }

    public static boolean openUri(Context context, Uri uri, AppLovinSdk appLovinSdk) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!(context instanceof Activity)) {
                intent.setFlags(DriveFile.MODE_READ_ONLY);
            }
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            appLovinSdk.getLogger().mo4781e(TAG, "Unable to open \"" + uri + "\".", th);
            return false;
        }
    }

    public static boolean openUrl(Context context, String str, AppLovinSdk appLovinSdk) {
        return openUri(context, Uri.parse(str), appLovinSdk);
    }

    public static void recycleImageView(ImageView imageView) {
        Drawable drawable;
        if (imageView != null && (drawable = imageView.getDrawable()) != null && (drawable instanceof BitmapDrawable)) {
            ((BitmapDrawable) drawable).getBitmap().recycle();
        }
    }

    public static String retrieveSdkKey(Context context) {
        Bundle f = m1318f(context);
        if (f == null) {
            return null;
        }
        String string = f.getString("applovin.sdk.key");
        return string != null ? string : "";
    }

    public static AppLovinSdkSettings retrieveUserSettings(Context context) {
        AppLovinSdkSettings appLovinSdkSettings = new AppLovinSdkSettings();
        appLovinSdkSettings.setTestAdsEnabled(m1313a(context));
        appLovinSdkSettings.setVerboseLogging(m1314b(context));
        appLovinSdkSettings.setBannerAdRefreshSeconds(m1315c(context));
        appLovinSdkSettings.setAutoPreloadSizes(m1316d(context));
        appLovinSdkSettings.setAutoPreloadTypes(m1317e(context));
        return appLovinSdkSettings;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f1219a.post(runnable);
        }
    }

    public static void safePopulateImageView(Context context, ImageView imageView, int i, int i2) {
        recycleImageView(imageView);
        Bitmap a = C0444fq.m1154a(context, i, i2);
        if (a != null) {
            imageView.setImageBitmap(a);
        }
    }

    public static void safePopulateImageView(ImageView imageView, Bitmap bitmap) {
        recycleImageView(imageView);
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public static void safePopulateImageView(ImageView imageView, Uri uri, int i) {
        recycleImageView(imageView);
        Bitmap a = C0444fq.m1155a(new File(uri.getPath()), i);
        if (a != null) {
            imageView.setImageBitmap(a);
        }
    }
}
