package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.Log;
import com.applovin.nativeAds.AppLovinNativeAdService;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.List;

public class AppLovinSdkImpl extends AppLovinSdk {

    /* renamed from: A */
    private boolean f420A = false;

    /* renamed from: a */
    private String f421a;

    /* renamed from: b */
    private AppLovinSdkSettings f422b;

    /* renamed from: c */
    private Context f423c;

    /* renamed from: d */
    private WeakReference<Activity> f424d;

    /* renamed from: e */
    private long f425e;

    /* renamed from: f */
    private AppLovinLogger f426f;

    /* renamed from: g */
    private C0415eo f427g;

    /* renamed from: h */
    private C0390dq f428h;

    /* renamed from: i */
    private C0464u f429i;

    /* renamed from: j */
    private C0394du f430j;

    /* renamed from: k */
    private C0304al f431k;

    /* renamed from: l */
    private C0427f f432l;

    /* renamed from: m */
    private C0365cs f433m;

    /* renamed from: n */
    private C0467x f434n;

    /* renamed from: o */
    private C0393dt f435o;

    /* renamed from: p */
    private AppLovinAdServiceImpl f436p;

    /* renamed from: q */
    private C0367cu f437q;

    /* renamed from: r */
    private PostbackServiceImpl f438r;

    /* renamed from: s */
    private EventServiceImpl f439s;

    /* renamed from: t */
    private MediationServiceImpl f440t;

    /* renamed from: u */
    private C0377dd f441u;

    /* renamed from: v */
    private boolean f442v = true;

    /* renamed from: w */
    private boolean f443w = false;

    /* renamed from: x */
    private boolean f444x = false;

    /* renamed from: y */
    private boolean f445y = false;

    /* renamed from: z */
    private boolean f446z = false;

    /* renamed from: i */
    private static boolean m425i() {
        return !Build.VERSION.RELEASE.startsWith("1.") && !Build.VERSION.RELEASE.startsWith("2.0") && !Build.VERSION.RELEASE.startsWith("2.1");
    }

    /* renamed from: j */
    private void m426j() {
        try {
            if (((Integer) get(C0392ds.f994c, 0)).intValue() < 741) {
                Log.i("AppLovinSdkImpl", "SDK has been updated since last run. Continuing...");
                getSettingsManager().mo4541c();
                getSettingsManager().mo4535a();
            } else {
                Log.d("AppLovinSdkImpl", "SDK has not been updated since last run. Continuing...");
            }
        } catch (Exception e) {
            getLogger().mo4781e("AppLovinSdkImpl", "Unable to check for SDK update", e);
        } finally {
            put(C0392ds.f994c, Integer.valueOf(AppLovinSdk.VERSION_CODE));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0415eo mo4169a() {
        return this.f427g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4170a(boolean z) {
        this.f442v = false;
        this.f443w = z;
        this.f444x = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0394du mo4171b() {
        return this.f430j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C0427f mo4172c() {
        return this.f432l;
    }

    public boolean checkCorrectInitialization(Context context) {
        try {
            getLogger().mo4779d(AppLovinLogger.SDK_TAG, "Checking if SDK is initialized in main activity or application context...");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(context.getPackageName());
            String stackTraceString = Log.getStackTraceString(new Throwable());
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null) {
                getLogger().mo4779d(AppLovinLogger.SDK_TAG, "Found " + queryIntentActivities.size() + " main activities for this application");
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (stackTraceString.contains(resolveInfo.activityInfo.name)) {
                        return true;
                    }
                }
            }
            if (stackTraceString.contains(getApplicationContext().getClass().getName())) {
                getLogger().mo4779d(AppLovinLogger.SDK_TAG, "SDK initialized in application context");
                return true;
            }
            getLogger().mo4785w(AppLovinLogger.SDK_TAG, "AppLovin SDK was initialized too late in session; SDK should always be initialized within main activity, application context, and/or any relevant entry points");
            getLogger().mo4785w(AppLovinLogger.SDK_TAG, "Initialization instead happened from: " + stackTraceString);
            return false;
        } catch (Throwable th) {
            getLogger().mo4781e(AppLovinLogger.SDK_TAG, "Error checking if SDK is initialized in main activity or application context...", th);
        }
    }

    public void clear(SharedPreferences sharedPreferences) {
        this.f435o.mo4612a(sharedPreferences);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C0365cs mo4175d() {
        return this.f433m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo4176e() {
        return this.f442v;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo4177f() {
        return this.f444x;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo4178g() {
        this.f442v = true;
        this.f427g.mo4683a(new C0413em(this), 0);
    }

    public <T> T get(C0389dp<T> dpVar) {
        return this.f428h.mo4534a(dpVar);
    }

    public <T> T get(C0392ds<T> dsVar) {
        return get(dsVar, (Object) null);
    }

    public <T> T get(C0392ds<T> dsVar, T t) {
        return this.f435o.mo4617b(dsVar, t);
    }

    public <T> T get(C0392ds<T> dsVar, T t, SharedPreferences sharedPreferences) {
        return this.f435o.mo4618b(dsVar, t, sharedPreferences);
    }

    public <T> T get(String str, T t, Class cls, SharedPreferences sharedPreferences) {
        return this.f435o.mo4611a(str, t, cls, sharedPreferences);
    }

    public AppLovinAdService getAdService() {
        return this.f436p;
    }

    public Context getApplicationContext() {
        return this.f423c;
    }

    public List<String> getAsList(C0389dp dpVar) {
        return this.f428h.mo4539b(dpVar);
    }

    public C0464u getConnectionManager() {
        return this.f429i;
    }

    public C0467x getDataCollector() {
        return this.f434n;
    }

    public AppLovinEventService getEventService() {
        return this.f439s;
    }

    public C0304al getFileManager() {
        return this.f431k;
    }

    public Activity getInitializationActivity() {
        if (this.f424d != null) {
            return (Activity) this.f424d.get();
        }
        return null;
    }

    public long getInitializedTimeMillis() {
        return this.f425e;
    }

    public AppLovinLogger getLogger() {
        return this.f426f;
    }

    public MediationServiceImpl getMediationService() {
        return this.f440t;
    }

    public AppLovinNativeAdService getNativeAdService() {
        return this.f437q;
    }

    public C0377dd getPersistentPostbackManager() {
        return this.f441u;
    }

    public PostbackServiceImpl getPostbackService() {
        return this.f438r;
    }

    public String getSdkKey() {
        return this.f421a;
    }

    public AppLovinSdkSettings getSettings() {
        return this.f422b;
    }

    public C0390dq getSettingsManager() {
        return this.f428h;
    }

    public String getUserIdentifier() {
        return C0443fp.m1146a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo4202h() {
        this.f428h.mo4541c();
        this.f428h.mo4535a();
        this.f430j.mo4619a();
    }

    public boolean hasCriticalErrors() {
        return this.f445y || this.f446z;
    }

    public void initialize(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        this.f421a = str;
        this.f422b = appLovinSdkSettings;
        this.f425e = System.currentTimeMillis();
        if (context instanceof Activity) {
            this.f424d = new WeakReference<>((Activity) context);
        }
        this.f423c = context.getApplicationContext();
        try {
            C0460q qVar = new C0460q();
            this.f426f = qVar;
            this.f435o = new C0393dt(this);
            this.f428h = new C0390dq(this);
            this.f427g = new C0415eo(this);
            this.f429i = new C0464u(this);
            this.f430j = new C0394du(this);
            this.f431k = new C0304al(this);
            this.f434n = new C0467x(this);
            this.f436p = new AppLovinAdServiceImpl(this);
            this.f437q = new C0367cu(this);
            this.f438r = new PostbackServiceImpl(this);
            this.f439s = new EventServiceImpl(this);
            this.f440t = new MediationServiceImpl(this);
            this.f441u = new C0377dd(this);
            this.f432l = new C0427f(this);
            this.f433m = new C0365cs(this);
            if (!m425i()) {
                this.f445y = true;
                Log.e(AppLovinLogger.SDK_TAG, "Unable to initalize AppLovin SDK: Android SDK version has to be at least level 8");
            }
            if (str == null || str.length() < 1) {
                this.f446z = true;
                Log.e(AppLovinLogger.SDK_TAG, "Unable to find AppLovin SDK key. Please add     meta-data android:name=\"applovin.sdk.key\" android:value=\"YOUR_SDK_KEY_HERE\" into AndroidManifest.xml.");
                StringWriter stringWriter = new StringWriter();
                new Throwable("").printStackTrace(new PrintWriter(stringWriter));
                Log.e(AppLovinLogger.SDK_TAG, "Called with an invalid SDK key from: " + stringWriter.toString());
            }
            if (!hasCriticalErrors()) {
                qVar.mo4776a(this.f428h);
                if (appLovinSdkSettings instanceof C0328bi) {
                    qVar.mo4777a(((C0328bi) appLovinSdkSettings).mo4376a());
                }
                m426j();
                this.f428h.mo4540b();
                if (((Boolean) this.f428h.mo4534a(C0387dn.f845b)).booleanValue()) {
                    this.f428h.mo4537a(appLovinSdkSettings);
                    this.f428h.mo4535a();
                }
                mo4178g();
                return;
            }
            mo4170a(false);
        } catch (Throwable th) {
            Log.e(AppLovinLogger.SDK_TAG, "Failed to load AppLovin SDK, ad serving will be disabled", th);
            mo4170a(false);
        }
    }

    public void initializeSdk() {
    }

    public boolean isEnabled() {
        return this.f443w;
    }

    public boolean isInitializedInMainActivity() {
        return this.f420A;
    }

    public <T> void put(C0392ds<T> dsVar, T t) {
        this.f435o.mo4614a(dsVar, t);
    }

    public <T> void put(C0392ds<T> dsVar, T t, SharedPreferences sharedPreferences) {
        this.f435o.mo4615a(dsVar, t, sharedPreferences);
    }

    public <T> void put(String str, T t, SharedPreferences sharedPreferences) {
        this.f435o.mo4616a(str, t, sharedPreferences);
    }

    public <T> void remove(C0392ds<T> dsVar) {
        this.f435o.mo4613a(dsVar);
    }

    public void setInitializedInMainActivity(boolean z) {
        this.f420A = z;
    }

    public void setPluginVersion(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No version specified");
        }
        this.f428h.mo4536a(C0387dn.f771F, str);
        this.f428h.mo4535a();
    }

    public void setUserIdentifier(String str) {
        C0443fp.m1147a(str);
    }
}
