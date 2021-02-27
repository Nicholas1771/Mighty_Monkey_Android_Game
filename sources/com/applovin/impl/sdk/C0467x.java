package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.applovin.sdk.AppLovinEventTypes;
import com.applovin.sdk.AppLovinLogger;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.applovin.impl.sdk.x */
class C0467x {

    /* renamed from: e */
    private static String f1183e;

    /* renamed from: f */
    private static String f1184f;

    /* renamed from: g */
    private static int f1185g;

    /* renamed from: a */
    private final AppLovinSdkImpl f1186a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AppLovinLogger f1187b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Context f1188c;

    /* renamed from: d */
    private final Map<Class, Object> f1189d;

    C0467x(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f1186a = appLovinSdkImpl;
        this.f1187b = appLovinSdkImpl.getLogger();
        this.f1188c = appLovinSdkImpl.getApplicationContext();
        this.f1189d = Collections.synchronizedMap(new HashMap());
    }

    /* renamed from: a */
    private C0295ac m1288a(C0295ac acVar) {
        if (acVar == null) {
            acVar = new C0295ac();
        }
        if (((Boolean) this.f1186a.get(C0387dn.f927cc)).booleanValue()) {
            acVar.f498o = m1294f();
        } else {
            acVar.f498o = null;
        }
        if (((Boolean) this.f1186a.get(C0387dn.f926cb)).booleanValue()) {
            acVar.f497n = m1296h();
        }
        try {
            AudioManager audioManager = (AudioManager) this.f1188c.getSystemService("audio");
            if (audioManager != null) {
                acVar.f499p = (int) (((float) audioManager.getStreamVolume(3)) * ((Float) this.f1186a.get(C0387dn.f933ci)).floatValue());
            }
        } catch (Throwable th) {
            this.f1187b.mo4781e("DataCollector", "Unable to collect volume", th);
        }
        if (((Boolean) this.f1186a.get(C0387dn.f936cl)).booleanValue()) {
            if (f1183e == null) {
                String l = m1300l();
                if (C0444fq.isValidString(l)) {
                    f1183e = l;
                } else {
                    f1183e = "";
                }
            }
            if (C0444fq.isValidString(f1183e)) {
                acVar.f500q = f1183e;
            }
        }
        String str = (String) this.f1186a.getSettingsManager().mo4534a(C0387dn.f871bZ);
        if (f1184f == null || !str.equalsIgnoreCase(f1184f)) {
            try {
                f1184f = str;
                PackageInfo packageInfo = this.f1188c.getPackageManager().getPackageInfo(str, 0);
                acVar.f496m = packageInfo.versionCode;
                f1185g = packageInfo.versionCode;
            } catch (Throwable th2) {
                f1185g = 0;
            }
        } else {
            acVar.f496m = f1185g;
        }
        return acVar;
    }

    /* renamed from: a */
    static boolean m1289a(String str, Context context) {
        if (str == null) {
            throw new IllegalArgumentException("No permission name specified");
        } else if (context != null) {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.applovin.impl.sdk.dp, com.applovin.impl.sdk.dp<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m1290a(java.lang.String r3, com.applovin.impl.sdk.C0389dp<java.lang.String> r4) {
        /*
            r2 = this;
            com.applovin.impl.sdk.AppLovinSdkImpl r0 = r2.f1186a
            java.lang.Object r0 = r0.get(r4)
            java.lang.String r0 = (java.lang.String) r0
            java.util.List r0 = com.applovin.impl.sdk.C0462s.m1246a(r0)
            java.util.Iterator r1 = r0.iterator()
        L_0x0010:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0024
            java.lang.Object r0 = r1.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r3.startsWith(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 1
        L_0x0023:
            return r0
        L_0x0024:
            r0 = 0
            goto L_0x0023
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C0467x.m1290a(java.lang.String, com.applovin.impl.sdk.dp):boolean");
    }

    /* renamed from: b */
    private String m1292b(String str) {
        int length = str.length();
        int[] iArr = {11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        int length2 = iArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = str.charAt(i);
            for (int i2 = length2 - 1; i2 >= 0; i2--) {
                cArr[i] = (char) (cArr[i] ^ iArr[i2]);
            }
        }
        String str2 = new String(cArr);
        return str2 != null ? str2 : "";
    }

    /* renamed from: e */
    private String m1293e() {
        try {
            int a = C0444fq.m1150a(this.f1188c);
            return a == 1 ? "portrait" : a == 2 ? "landscape" : "none";
        } catch (Throwable th) {
            this.f1186a.getLogger().mo4781e("DataCollector", "Encountered error while attempting to collect application orientation", th);
            return "none";
        }
    }

    /* renamed from: f */
    private C0294ab m1294f() {
        int i = -1;
        try {
            C0294ab abVar = new C0294ab();
            Intent registerReceiver = this.f1188c.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver != null ? registerReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1) : -1;
            int intExtra2 = registerReceiver != null ? registerReceiver.getIntExtra("scale", -1) : -1;
            if (intExtra <= 0 || intExtra2 <= 0) {
                abVar.f483b = -1;
            } else {
                abVar.f483b = (int) ((((float) intExtra) / ((float) intExtra2)) * 100.0f);
            }
            if (registerReceiver != null) {
                i = registerReceiver.getIntExtra("status", -1);
            }
            abVar.f482a = i;
            return abVar;
        } catch (Throwable th) {
            this.f1187b.mo4781e("DataCollector", "Unable to collect battery info", th);
            return null;
        }
    }

    /* renamed from: g */
    private double m1295g() {
        return ((double) Math.round((((double) TimeZone.getDefault().getOffset(new Date().getTime())) * 10.0d) / 3600000.0d)) / 10.0d;
    }

    /* renamed from: h */
    private boolean m1296h() {
        try {
            return m1297i() || m1298j();
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: i */
    private boolean m1297i() {
        String str = Build.TAGS;
        return str != null && str.contains(m1292b("lz}$blpz"));
    }

    /* renamed from: j */
    private boolean m1298j() {
        String[] strArr = {"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
        for (String b : strArr) {
            if (new File(m1292b(b)).exists()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: k */
    private boolean m1299k() {
        return m1290a(Build.DEVICE, C0387dn.f929ce) || m1290a(Build.HARDWARE, C0387dn.f928cd) || m1290a(Build.MANUFACTURER, C0387dn.f930cf) || m1290a(Build.MODEL, C0387dn.f931cg);
    }

    /* renamed from: l */
    private String m1300l() {
        AtomicReference atomicReference = new AtomicReference();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Handler(this.f1188c.getMainLooper()).post(new C0468y(this, atomicReference, countDownLatch));
        try {
            countDownLatch.await(((Long) this.f1186a.get(C0387dn.f937cm)).longValue(), TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
        }
        return (String) atomicReference.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0295ac mo4790a() {
        TelephonyManager telephonyManager;
        Object obj = this.f1189d.get(C0295ac.class);
        if (obj != null) {
            return m1288a((C0295ac) obj);
        }
        C0295ac acVar = new C0295ac();
        acVar.f491h = Locale.getDefault();
        acVar.f484a = Build.MODEL;
        acVar.f485b = Build.VERSION.RELEASE;
        acVar.f486c = Build.MANUFACTURER;
        acVar.f488e = Build.VERSION.SDK_INT;
        acVar.f487d = Build.DEVICE;
        acVar.f492i = m1293e();
        acVar.f495l = m1295g();
        acVar.f501r = m1299k();
        try {
            acVar.f502s = ((SensorManager) this.f1188c.getSystemService("sensor")).getDefaultSensor(4) != null;
        } catch (Throwable th) {
            this.f1187b.mo4781e("DataCollector", "Unable to retrieve gyroscope availability", th);
        }
        if (mo4791a("android.permission.READ_PHONE_STATE") && (telephonyManager = (TelephonyManager) this.f1188c.getSystemService("phone")) != null) {
            acVar.f489f = telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH);
            String networkOperatorName = telephonyManager.getNetworkOperatorName();
            try {
                acVar.f490g = URLEncoder.encode(networkOperatorName, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                acVar.f490g = networkOperatorName;
            }
        }
        try {
            DisplayMetrics displayMetrics = this.f1188c.getResources().getDisplayMetrics();
            acVar.f493j = displayMetrics.density;
            acVar.f494k = displayMetrics.densityDpi;
        } catch (Throwable th2) {
        }
        this.f1189d.put(C0295ac.class, acVar);
        return acVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo4791a(String str) {
        return m1289a(str, this.f1188c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0295ac mo4792b() {
        return m1288a((C0295ac) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C0293aa mo4793c() {
        Object obj = this.f1189d.get(C0293aa.class);
        if (obj != null) {
            return (C0293aa) obj;
        }
        ApplicationInfo applicationInfo = this.f1188c.getApplicationInfo();
        long lastModified = new File(applicationInfo.sourceDir).lastModified();
        PackageManager packageManager = this.f1188c.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = packageManager.getPackageInfo(this.f1188c.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
        }
        C0293aa aaVar = new C0293aa();
        aaVar.f480c = applicationInfo.packageName;
        aaVar.f481d = lastModified;
        aaVar.f478a = String.valueOf(packageManager.getApplicationLabel(applicationInfo));
        aaVar.f479b = packageInfo != null ? packageInfo.versionName : "";
        this.f1189d.put(C0293aa.class, aaVar);
        return aaVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C0469z mo4794d() {
        Object invoke;
        try {
            Class<?> cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            if (!(cls == null || (invoke = cls.getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke((Object) null, new Object[]{this.f1188c})) == null)) {
                Class<?> cls2 = invoke.getClass();
                Object invoke2 = cls2.getMethod("isLimitAdTrackingEnabled", (Class[]) null).invoke(invoke, (Object[]) null);
                Object invoke3 = cls2.getMethod("getId", (Class[]) null).invoke(invoke, (Object[]) null);
                C0469z zVar = new C0469z();
                String str = (String) invoke3;
                String str2 = str == null ? "" : str;
                zVar.f1193a = ((Boolean) invoke2).booleanValue();
                zVar.f1194b = str2;
                return zVar;
            }
        } catch (ClassNotFoundException e) {
            this.f1187b.userError("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", e);
        } catch (Throwable th) {
            this.f1187b.mo4781e("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", th);
        }
        C0469z zVar2 = new C0469z();
        zVar2.f1194b = "";
        zVar2.f1193a = false;
        return zVar2;
    }
}
