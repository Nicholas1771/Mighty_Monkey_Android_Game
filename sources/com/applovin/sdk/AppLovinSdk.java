package com.applovin.sdk;

import android.content.Context;
import android.util.Log;
import com.applovin.nativeAds.AppLovinNativeAdService;

public abstract class AppLovinSdk {
    public static final String URI_HOST = "com.applovin.sdk";
    public static final String URI_SCHEME = "applovin";
    public static final String VERSION = "7.4.1";
    public static final int VERSION_CODE = 741;

    /* renamed from: a */
    private static AppLovinSdk[] f1211a = new AppLovinSdk[0];

    /* renamed from: b */
    private static final Object f1212b = new Object();

    public static AppLovinSdk getInstance(Context context) {
        if (context != null) {
            return getInstance(AppLovinSdkUtils.retrieveSdkKey(context), AppLovinSdkUtils.retrieveUserSettings(context), context);
        }
        throw new IllegalArgumentException("No context specified");
    }

    public static AppLovinSdk getInstance(AppLovinSdkSettings appLovinSdkSettings, Context context) {
        if (context != null) {
            return getInstance(AppLovinSdkUtils.retrieveSdkKey(context), appLovinSdkSettings, context);
        }
        throw new IllegalArgumentException("No context specified");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r0 = new com.applovin.impl.sdk.AppLovinSdkImpl();
        r0.initialize(r7, r8, r9);
        r0.setInitializedInMainActivity(r0.checkCorrectInitialization(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r1 = new com.applovin.sdk.AppLovinSdk[(f1211a.length + 1)];
        java.lang.System.arraycopy(f1211a, 0, r1, 0, f1211a.length);
        r1[f1211a.length] = r0;
        f1211a = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0077, code lost:
        r0 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.applovin.sdk.AppLovinSdk getInstance(java.lang.String r7, com.applovin.sdk.AppLovinSdkSettings r8, android.content.Context r9) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x000b
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No userSettings specified"
            r0.<init>(r1)
            throw r0
        L_0x000b:
            if (r9 != 0) goto L_0x0015
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No context specified"
            r0.<init>(r1)
            throw r0
        L_0x0015:
            java.lang.Object r2 = f1212b
            monitor-enter(r2)
            com.applovin.sdk.AppLovinSdk[] r1 = f1211a     // Catch:{ all -> 0x0048 }
            int r1 = r1.length     // Catch:{ all -> 0x0048 }
            r3 = 1
            if (r1 != r3) goto L_0x0034
            com.applovin.sdk.AppLovinSdk[] r1 = f1211a     // Catch:{ all -> 0x0048 }
            r3 = 0
            r1 = r1[r3]     // Catch:{ all -> 0x0048 }
            java.lang.String r1 = r1.getSdkKey()     // Catch:{ all -> 0x0048 }
            boolean r1 = r1.equals(r7)     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x0034
            com.applovin.sdk.AppLovinSdk[] r0 = f1211a     // Catch:{ all -> 0x0048 }
            r1 = 0
            r0 = r0[r1]     // Catch:{ all -> 0x0048 }
            monitor-exit(r2)     // Catch:{ all -> 0x0048 }
        L_0x0033:
            return r0
        L_0x0034:
            com.applovin.sdk.AppLovinSdk[] r3 = f1211a     // Catch:{ all -> 0x0048 }
            int r4 = r3.length     // Catch:{ all -> 0x0048 }
            r1 = r0
        L_0x0038:
            if (r1 >= r4) goto L_0x004f
            r0 = r3[r1]     // Catch:{ all -> 0x0048 }
            java.lang.String r5 = r0.getSdkKey()     // Catch:{ all -> 0x0048 }
            boolean r5 = r5.equals(r7)     // Catch:{ all -> 0x0048 }
            if (r5 == 0) goto L_0x004b
            monitor-exit(r2)     // Catch:{ all -> 0x0048 }
            goto L_0x0033
        L_0x0048:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0048 }
            throw r0
        L_0x004b:
            int r0 = r1 + 1
            r1 = r0
            goto L_0x0038
        L_0x004f:
            com.applovin.impl.sdk.AppLovinSdkImpl r0 = new com.applovin.impl.sdk.AppLovinSdkImpl     // Catch:{ Throwable -> 0x0078 }
            r0.<init>()     // Catch:{ Throwable -> 0x0078 }
            r0.initialize(r7, r8, r9)     // Catch:{ Throwable -> 0x0078 }
            boolean r1 = r0.checkCorrectInitialization(r9)     // Catch:{ Throwable -> 0x0078 }
            r0.setInitializedInMainActivity(r1)     // Catch:{ Throwable -> 0x0078 }
            com.applovin.sdk.AppLovinSdk[] r1 = f1211a     // Catch:{ all -> 0x0048 }
            int r1 = r1.length     // Catch:{ all -> 0x0048 }
            int r1 = r1 + 1
            com.applovin.sdk.AppLovinSdk[] r1 = new com.applovin.sdk.AppLovinSdk[r1]     // Catch:{ all -> 0x0048 }
            com.applovin.sdk.AppLovinSdk[] r3 = f1211a     // Catch:{ all -> 0x0048 }
            r4 = 0
            r5 = 0
            com.applovin.sdk.AppLovinSdk[] r6 = f1211a     // Catch:{ all -> 0x0048 }
            int r6 = r6.length     // Catch:{ all -> 0x0048 }
            java.lang.System.arraycopy(r3, r4, r1, r5, r6)     // Catch:{ all -> 0x0048 }
            com.applovin.sdk.AppLovinSdk[] r3 = f1211a     // Catch:{ all -> 0x0048 }
            int r3 = r3.length     // Catch:{ all -> 0x0048 }
            r1[r3] = r0     // Catch:{ all -> 0x0048 }
            f1211a = r1     // Catch:{ all -> 0x0048 }
            monitor-exit(r2)     // Catch:{ all -> 0x0048 }
            goto L_0x0033
        L_0x0078:
            r0 = move-exception
            java.lang.String r1 = "AppLovinSdk"
            java.lang.String r3 = "Failed to build AppLovin SDK. Try cleaning application data and starting the application again."
            android.util.Log.e(r1, r3, r0)     // Catch:{ all -> 0x0048 }
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0048 }
            java.lang.String r1 = "Unable to build AppLovin SDK"
            r0.<init>(r1)     // Catch:{ all -> 0x0048 }
            throw r0     // Catch:{ all -> 0x0048 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.sdk.AppLovinSdk.getInstance(java.lang.String, com.applovin.sdk.AppLovinSdkSettings, android.content.Context):com.applovin.sdk.AppLovinSdk");
    }

    public static void initializeSdk(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        AppLovinSdk instance = getInstance(context);
        if (instance != null) {
            instance.initializeSdk();
        } else {
            Log.e(AppLovinLogger.SDK_TAG, "Unable to initialize AppLovin SDK: SDK object not created");
        }
    }

    public abstract AppLovinAdService getAdService();

    public abstract Context getApplicationContext();

    public abstract AppLovinEventService getEventService();

    public abstract AppLovinLogger getLogger();

    public abstract AppLovinMediationService getMediationService();

    public abstract AppLovinNativeAdService getNativeAdService();

    public abstract AppLovinPostbackService getPostbackService();

    public abstract String getSdkKey();

    public abstract AppLovinSdkSettings getSettings();

    public abstract String getUserIdentifier();

    public abstract boolean hasCriticalErrors();

    public abstract void initialize(String str, AppLovinSdkSettings appLovinSdkSettings, Context context);

    public abstract void initializeSdk();

    public abstract boolean isEnabled();

    public abstract void setPluginVersion(String str);

    public abstract void setUserIdentifier(String str);
}
