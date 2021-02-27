package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.fq */
public class C0444fq extends AppLovinSdkUtils {

    /* renamed from: a */
    private static final char[] f1119a = "0123456789abcdef".toCharArray();

    /* renamed from: b */
    private static final char[] f1120b = "-'".toCharArray();

    /* renamed from: a */
    public static double m1148a(long j) {
        return ((double) j) / 1000.0d;
    }

    /* renamed from: a */
    public static float m1149a(float f) {
        return 1000.0f * f;
    }

    /* renamed from: a */
    public static int m1150a(Context context) {
        Resources resources;
        Configuration configuration;
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            return 0;
        }
        return configuration.orientation;
    }

    /* renamed from: a */
    public static int m1151a(String str, int i) {
        return m1173d(str) ? Integer.parseInt(str) : i;
    }

    /* renamed from: a */
    public static int m1152a(JSONObject jSONObject) {
        int a = C0329bj.m630a(jSONObject, "video_completion_percent", -1, (AppLovinSdk) null);
        if (a < 0 || a > 100) {
            return 95;
        }
        return a;
    }

    /* renamed from: a */
    public static Activity m1153a(View view, AppLovinSdk appLovinSdk) {
        if (view == null) {
            return null;
        }
        int i = 0;
        while (i < 1000) {
            int i2 = i + 1;
            try {
                Context context = view.getContext();
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                ViewParent parent = view.getParent();
                if (!(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
                i = i2;
            } catch (Throwable th) {
                appLovinSdk.getLogger().mo4781e("AppLovinUtils", "Encountered error while retrieving activity from view", th);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Bitmap m1154a(Context context, int i, int i2) {
        int i3 = 1;
        Bitmap bitmap = null;
        FileInputStream fileInputStream = null;
        FileInputStream fileInputStream2 = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(context.getResources(), i);
            if (options.outHeight > i2 || options.outWidth > i2) {
                i3 = (int) Math.pow(2.0d, (double) ((int) Math.ceil(Math.log(((double) i2) / ((double) Math.max(options.outHeight, options.outWidth))) / Math.log(0.5d))));
            }
            new BitmapFactory.Options().inSampleSize = i3;
            bitmap = BitmapFactory.decodeResource(context.getResources(), i);
            try {
                fileInputStream.close();
                fileInputStream2.close();
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            try {
                fileInputStream.close();
                fileInputStream2.close();
            } catch (Exception e3) {
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
                fileInputStream2.close();
            } catch (Exception e4) {
            }
            throw th;
        }
        return bitmap;
    }

    /* renamed from: a */
    public static Bitmap m1155a(File file, int i) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3;
        int i2 = 1;
        FileInputStream fileInputStream4 = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            fileInputStream = new FileInputStream(file);
            try {
                BitmapFactory.decodeStream(fileInputStream, (Rect) null, options);
                fileInputStream.close();
                if (options.outHeight > i || options.outWidth > i) {
                    i2 = (int) Math.pow(2.0d, (double) ((int) Math.ceil(Math.log(((double) i) / ((double) Math.max(options.outHeight, options.outWidth))) / Math.log(0.5d))));
                }
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = i2;
                FileInputStream fileInputStream5 = new FileInputStream(file);
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream5, (Rect) null, options2);
                    fileInputStream5.close();
                    try {
                        fileInputStream.close();
                        fileInputStream5.close();
                        return decodeStream;
                    } catch (Exception e) {
                        return decodeStream;
                    }
                } catch (Exception e2) {
                    fileInputStream3 = fileInputStream5;
                    fileInputStream2 = fileInputStream;
                    try {
                        fileInputStream2.close();
                        fileInputStream3.close();
                    } catch (Exception e3) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream4 = fileInputStream5;
                    try {
                        fileInputStream.close();
                        fileInputStream4.close();
                    } catch (Exception e4) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                fileInputStream3 = null;
                fileInputStream2 = fileInputStream;
                fileInputStream2.close();
                fileInputStream3.close();
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream.close();
                fileInputStream4.close();
                throw th;
            }
        } catch (Exception e6) {
            fileInputStream3 = null;
            fileInputStream2 = null;
            fileInputStream2.close();
            fileInputStream3.close();
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            fileInputStream.close();
            fileInputStream4.close();
            throw th;
        }
    }

    /* renamed from: a */
    public static AppLovinAd m1156a(AppLovinAd appLovinAd, AppLovinSdk appLovinSdk) {
        if (!(appLovinAd instanceof C0299ag)) {
            return appLovinAd;
        }
        C0299ag agVar = (C0299ag) appLovinAd;
        AppLovinAd dequeueAd = ((AppLovinAdServiceImpl) appLovinSdk.getAdService()).dequeueAd(agVar.mo4292m());
        appLovinSdk.getLogger().mo4779d("AppLovinUtils", "Dequeued ad for dummy ad: " + dequeueAd);
        if (dequeueAd == null) {
            return dequeueAd;
        }
        agVar.mo4304a(dequeueAd);
        ((C0453j) dequeueAd).mo4771a(agVar);
        return dequeueAd;
    }

    /* renamed from: a */
    public static String m1157a(String str) {
        return (str == null || str.length() <= 4) ? "NOKEY" : str.substring(str.length() - 4);
    }

    /* renamed from: a */
    public static String m1158a(String str, AppLovinSdkImpl appLovinSdkImpl) {
        return m1159a(str, (Integer) appLovinSdkImpl.get(C0387dn.f974s), (String) appLovinSdkImpl.get(C0387dn.f973r));
    }

    /* renamed from: a */
    private static String m1159a(String str, Integer num, String str2) {
        if (str2 == null) {
            throw new IllegalArgumentException("No algorithm specified");
        } else if (str == null || str.length() < 1) {
            return "";
        } else {
            if (str2.length() < 1 || "none".equals(str2)) {
                return str;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance(str2);
                instance.update(str.getBytes("UTF-8"));
                String a = m1162a(instance.digest());
                return (a == null || num.intValue() <= 0) ? a : a.substring(0, Math.min(num.intValue(), a.length()));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("Unknown algorithm \"" + str2 + "\"", e);
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException("Programming error: UTF-8 is not know encoding", e2);
            }
        }
    }

    /* renamed from: a */
    public static String m1160a(String str, String str2) {
        if (str == null) {
            str = "";
        }
        return str2.replace("{PLACEMENT}", m1172c(str));
    }

    /* renamed from: a */
    static String m1161a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(next.getKey()).append('=').append(next.getValue());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m1162a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("No data specified");
        }
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            cArr[i * 2] = f1119a[(bArr[i] & 240) >>> 4];
            cArr[(i * 2) + 1] = f1119a[bArr[i] & 15];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static void m1163a(AppLovinAdLoadListener appLovinAdLoadListener, C0451h hVar, int i, AppLovinSdk appLovinSdk) {
        if (appLovinAdLoadListener != null) {
            try {
                if (appLovinAdLoadListener instanceof C0302aj) {
                    ((C0302aj) appLovinAdLoadListener).mo4308a(hVar, i);
                } else {
                    appLovinAdLoadListener.failedToReceiveAd(i);
                }
            } catch (Throwable th) {
                appLovinSdk.getLogger().mo4781e("AppLovinUtils", "Unable process a failure to receive an ad", th);
            }
        }
    }

    /* renamed from: a */
    public static boolean m1164a(int i, int i2) {
        return (i & i2) != 0;
    }

    /* renamed from: a */
    public static boolean m1165a(C0296ad adVar, Context context, AppLovinSdkImpl appLovinSdkImpl) {
        return adVar != null && (adVar.mo3860b() || adVar.mo3864d() == null || appLovinSdkImpl.getFileManager().mo4317a(adVar.mo3864d().getLastPathSegment(), context));
    }

    /* renamed from: a */
    public static boolean m1166a(C0451h hVar, AppLovinSdkImpl appLovinSdkImpl) {
        return appLovinSdkImpl.getAsList(C0387dn.f905cG).contains(hVar.mo4765a().getLabel());
    }

    /* renamed from: a */
    public static boolean m1167a(AppLovinAd appLovinAd, AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinAd == null) {
            appLovinSdkImpl.getLogger().userError("AppLovinUtils", "Failing ad display - ad is null.");
            return false;
        }
        if (((C0453j) appLovinAd).f1151a.mo4767c() == C0452i.INDIRECT) {
            return true;
        }
        if (C0466w.m1280a(appLovinSdkImpl.getApplicationContext()) || ((Boolean) appLovinSdkImpl.get(C0387dn.f944ct)).booleanValue()) {
            return true;
        }
        appLovinSdkImpl.getLogger().userError("AppLovinUtils", "Failing ad display due to no internet connection.");
        return false;
    }

    /* renamed from: a */
    public static boolean m1168a(AppLovinSdk appLovinSdk, String str) {
        for (String startsWith : ((AppLovinSdkImpl) appLovinSdk).getAsList(C0387dn.f775J)) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static long m1169b(float f) {
        return (long) Math.round(f);
    }

    /* renamed from: b */
    public static String m1170b(String str) {
        return m1159a(str, (Integer) -1, "SHA-1");
    }

    /* renamed from: c */
    public static long m1171c(float f) {
        return m1169b(m1149a(f));
    }

    /* renamed from: c */
    public static String m1172c(String str) {
        if (!isValidString(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    /* renamed from: d */
    public static boolean m1173d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char charAt = str.charAt(0);
        int i = (charAt == '-' || charAt == '+') ? 1 : 0;
        int length = str.length();
        if (i == 1 && length == 1) {
            return false;
        }
        while (i < length) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* renamed from: e */
    public static int m1174e(String str) {
        return m1151a(str, 0);
    }
}
