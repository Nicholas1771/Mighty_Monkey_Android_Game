package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.al */
public class C0304al {

    /* renamed from: a */
    private final String f514a = "FileManager";

    /* renamed from: b */
    private final AppLovinSdkImpl f515b;

    /* renamed from: c */
    private final AppLovinLogger f516c;

    /* renamed from: d */
    private final Object f517d;

    C0304al(AppLovinSdk appLovinSdk) {
        this.f515b = (AppLovinSdkImpl) appLovinSdk;
        this.f516c = appLovinSdk.getLogger();
        this.f517d = new Object();
    }

    /* renamed from: a */
    private long m533a(long j) {
        return j / 1048576;
    }

    /* renamed from: a */
    private void m534a(long j, Context context) {
        long c = (long) m539c();
        if (c == -1) {
            this.f516c.mo4779d("FileManager", "Cache has no maximum size set; skipping drop...");
        } else if (m533a(j) > c) {
            this.f516c.mo4779d("FileManager", "Cache has exceeded maximum size; dropping...");
            m542g(context);
            this.f515b.mo4171b().mo4620a("cache_drop_count");
        } else {
            this.f516c.mo4779d("FileManager", "Cache is present but under size limit; not dropping...");
        }
    }

    /* renamed from: a */
    private boolean m535a() {
        return ((Boolean) this.f515b.get(C0387dn.f810aR)).booleanValue();
    }

    /* renamed from: b */
    private long m536b() {
        long longValue = ((Long) this.f515b.get(C0387dn.f811aS)).longValue();
        if (longValue < 0 || !m535a()) {
            return -1;
        }
        return longValue;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040 A[SYNTHETIC, Splitter:B:18:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0054 A[SYNTHETIC, Splitter:B:27:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005f A[SYNTHETIC, Splitter:B:34:0x005f] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:10:0x0031=Splitter:B:10:0x0031, B:36:0x0062=Splitter:B:36:0x0062} */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m537b(java.io.ByteArrayOutputStream r8, java.io.File r9) {
        /*
            r7 = this;
            com.applovin.sdk.AppLovinLogger r0 = r7.f516c
            java.lang.String r1 = "FileManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Writing resource to filesystem: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r9.getName()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.mo4779d(r1, r2)
            r2 = 0
            r3 = 0
            java.lang.Object r4 = r7.f517d
            monitor-enter(r4)
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0033, Throwable -> 0x0048 }
            r1.<init>(r9)     // Catch:{ IOException -> 0x0033, Throwable -> 0x0048 }
            r8.writeTo(r1)     // Catch:{ IOException -> 0x0070, Throwable -> 0x006d }
            r0 = 1
            if (r1 == 0) goto L_0x0031
            r1.close()     // Catch:{ Exception -> 0x0066 }
        L_0x0031:
            monitor-exit(r4)     // Catch:{ all -> 0x0063 }
            return r0
        L_0x0033:
            r0 = move-exception
            r1 = r2
        L_0x0035:
            com.applovin.sdk.AppLovinLogger r2 = r7.f516c     // Catch:{ all -> 0x006a }
            java.lang.String r5 = "FileManager"
            java.lang.String r6 = "Unable to write data to file."
            r2.mo4781e(r5, r6, r0)     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0043
            r1.close()     // Catch:{ Exception -> 0x0045 }
        L_0x0043:
            r0 = r3
            goto L_0x0031
        L_0x0045:
            r0 = move-exception
            r0 = r3
            goto L_0x0031
        L_0x0048:
            r0 = move-exception
        L_0x0049:
            com.applovin.sdk.AppLovinLogger r1 = r7.f516c     // Catch:{ all -> 0x005c }
            java.lang.String r5 = "FileManager"
            java.lang.String r6 = "Unknown failure to write file."
            r1.mo4781e(r5, r6, r0)     // Catch:{ all -> 0x005c }
            if (r2 == 0) goto L_0x0057
            r2.close()     // Catch:{ Exception -> 0x0059 }
        L_0x0057:
            r0 = r3
            goto L_0x0031
        L_0x0059:
            r0 = move-exception
            r0 = r3
            goto L_0x0031
        L_0x005c:
            r0 = move-exception
        L_0x005d:
            if (r2 == 0) goto L_0x0062
            r2.close()     // Catch:{ Exception -> 0x0068 }
        L_0x0062:
            throw r0     // Catch:{ all -> 0x0063 }
        L_0x0063:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0063 }
            throw r0
        L_0x0066:
            r1 = move-exception
            goto L_0x0031
        L_0x0068:
            r1 = move-exception
            goto L_0x0062
        L_0x006a:
            r0 = move-exception
            r2 = r1
            goto L_0x005d
        L_0x006d:
            r0 = move-exception
            r2 = r1
            goto L_0x0049
        L_0x0070:
            r0 = move-exception
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C0304al.m537b(java.io.ByteArrayOutputStream, java.io.File):boolean");
    }

    /* renamed from: b */
    private boolean m538b(File file) {
        boolean z;
        this.f516c.mo4779d("FileManager", "Removing file " + file.getName() + " from filesystem...");
        synchronized (this.f517d) {
            try {
                z = file.delete();
            } catch (Exception e) {
                this.f516c.mo4781e("FileManager", "Failed to remove file " + file.getName() + " from filesystem!", e);
                z = false;
            }
        }
        return z;
    }

    /* renamed from: c */
    private int m539c() {
        int intValue = ((Integer) this.f515b.get(C0387dn.f812aT)).intValue();
        if (intValue < 0 || !m535a()) {
            return -1;
        }
        return intValue;
    }

    /* renamed from: e */
    private File m540e(Context context) {
        return mo4314a(context) ? new File(context.getExternalFilesDir((String) null), "al") : new File(context.getCacheDir(), "al");
    }

    /* renamed from: f */
    private long m541f(Context context) {
        long j = 0;
        long b = m536b();
        boolean z = b != -1;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        synchronized (this.f517d) {
            for (File next : mo4318b(context)) {
                boolean z2 = false;
                if (z && seconds - TimeUnit.MILLISECONDS.toSeconds(next.lastModified()) > b) {
                    this.f516c.mo4779d("FileManager", "File " + next.getName() + " has expired, removing...");
                    m538b(next);
                    z2 = true;
                }
                if (z2) {
                    this.f515b.mo4171b().mo4620a("cached_files_expired");
                } else {
                    j += next.length();
                }
            }
        }
        return j;
    }

    /* renamed from: g */
    private void m542g(Context context) {
        synchronized (this.f517d) {
            for (File b : mo4318b(context)) {
                m538b(b);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0074 A[SYNTHETIC, Splitter:B:36:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009f A[SYNTHETIC, Splitter:B:45:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b2 A[SYNTHETIC, Splitter:B:54:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00bd A[SYNTHETIC, Splitter:B:61:0x00bd] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:51:0x00a7=Splitter:B:51:0x00a7, B:33:0x0058=Splitter:B:33:0x0058, B:42:0x007b=Splitter:B:42:0x007b} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:63:0x00c0=Splitter:B:63:0x00c0, B:47:0x00a2=Splitter:B:47:0x00a2, B:28:0x0053=Splitter:B:28:0x0053, B:56:0x00b5=Splitter:B:56:0x00b5, B:38:0x0077=Splitter:B:38:0x0077, B:19:0x0049=Splitter:B:19:0x0049} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.ByteArrayOutputStream mo4309a(java.io.File r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L_0x0004
        L_0x0003:
            return r0
        L_0x0004:
            com.applovin.sdk.AppLovinLogger r1 = r8.f516c
            java.lang.String r2 = "FileManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Reading resource from filesystem: "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = r9.getName()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.mo4779d(r2, r3)
            java.lang.Object r3 = r8.f517d
            monitor-enter(r3)
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0056, IOException -> 0x0079, Throwable -> 0x00a5, all -> 0x00b8 }
            r2.<init>(r9)     // Catch:{ FileNotFoundException -> 0x0056, IOException -> 0x0079, Throwable -> 0x00a5, all -> 0x00b8 }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x00d5, IOException -> 0x00d3, Throwable -> 0x00d1 }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x00d5, IOException -> 0x00d3, Throwable -> 0x00d1 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ FileNotFoundException -> 0x00d5, IOException -> 0x00d3, Throwable -> 0x00d1 }
        L_0x0033:
            r5 = 0
            int r6 = r4.length     // Catch:{ FileNotFoundException -> 0x00d5, IOException -> 0x00d3, Throwable -> 0x00d1 }
            int r5 = r2.read(r4, r5, r6)     // Catch:{ FileNotFoundException -> 0x00d5, IOException -> 0x00d3, Throwable -> 0x00d1 }
            if (r5 < 0) goto L_0x004e
            r6 = 0
            r1.write(r4, r6, r5)     // Catch:{ Exception -> 0x0040 }
            goto L_0x0033
        L_0x0040:
            r4 = move-exception
            r1.close()     // Catch:{ Exception -> 0x00c1 }
        L_0x0044:
            if (r2 == 0) goto L_0x0049
            r2.close()     // Catch:{ Exception -> 0x00c3 }
        L_0x0049:
            monitor-exit(r3)     // Catch:{ all -> 0x004b }
            goto L_0x0003
        L_0x004b:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x004b }
            throw r0
        L_0x004e:
            if (r2 == 0) goto L_0x0053
            r2.close()     // Catch:{ Exception -> 0x00c5 }
        L_0x0053:
            monitor-exit(r3)     // Catch:{ all -> 0x004b }
            r0 = r1
            goto L_0x0003
        L_0x0056:
            r1 = move-exception
            r2 = r0
        L_0x0058:
            com.applovin.sdk.AppLovinLogger r4 = r8.f516c     // Catch:{ all -> 0x00cf }
            java.lang.String r5 = "FileManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cf }
            r6.<init>()     // Catch:{ all -> 0x00cf }
            java.lang.String r7 = "File not found. "
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x00cf }
            java.lang.StringBuilder r1 = r6.append(r1)     // Catch:{ all -> 0x00cf }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00cf }
            r4.mo4782i(r5, r1)     // Catch:{ all -> 0x00cf }
            if (r2 == 0) goto L_0x0077
            r2.close()     // Catch:{ Exception -> 0x00c7 }
        L_0x0077:
            monitor-exit(r3)     // Catch:{ all -> 0x004b }
            goto L_0x0003
        L_0x0079:
            r1 = move-exception
            r2 = r0
        L_0x007b:
            com.applovin.sdk.AppLovinLogger r4 = r8.f516c     // Catch:{ all -> 0x00cf }
            java.lang.String r5 = "FileManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cf }
            r6.<init>()     // Catch:{ all -> 0x00cf }
            java.lang.String r7 = "Failed to read file: "
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x00cf }
            java.lang.String r7 = r9.getName()     // Catch:{ all -> 0x00cf }
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x00cf }
            java.lang.StringBuilder r1 = r6.append(r1)     // Catch:{ all -> 0x00cf }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00cf }
            r4.mo4779d(r5, r1)     // Catch:{ all -> 0x00cf }
            if (r2 == 0) goto L_0x00a2
            r2.close()     // Catch:{ Exception -> 0x00c9 }
        L_0x00a2:
            monitor-exit(r3)     // Catch:{ all -> 0x004b }
            goto L_0x0003
        L_0x00a5:
            r1 = move-exception
            r2 = r0
        L_0x00a7:
            com.applovin.sdk.AppLovinLogger r4 = r8.f516c     // Catch:{ all -> 0x00cf }
            java.lang.String r5 = "FileManager"
            java.lang.String r6 = "Unknown failure to read file."
            r4.mo4781e(r5, r6, r1)     // Catch:{ all -> 0x00cf }
            if (r2 == 0) goto L_0x00b5
            r2.close()     // Catch:{ Exception -> 0x00cb }
        L_0x00b5:
            monitor-exit(r3)     // Catch:{ all -> 0x004b }
            goto L_0x0003
        L_0x00b8:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x00bb:
            if (r2 == 0) goto L_0x00c0
            r2.close()     // Catch:{ Exception -> 0x00cd }
        L_0x00c0:
            throw r0     // Catch:{ all -> 0x004b }
        L_0x00c1:
            r1 = move-exception
            goto L_0x0044
        L_0x00c3:
            r1 = move-exception
            goto L_0x0049
        L_0x00c5:
            r0 = move-exception
            goto L_0x0053
        L_0x00c7:
            r1 = move-exception
            goto L_0x0077
        L_0x00c9:
            r1 = move-exception
            goto L_0x00a2
        L_0x00cb:
            r1 = move-exception
            goto L_0x00b5
        L_0x00cd:
            r1 = move-exception
            goto L_0x00c0
        L_0x00cf:
            r0 = move-exception
            goto L_0x00bb
        L_0x00d1:
            r1 = move-exception
            goto L_0x00a7
        L_0x00d3:
            r1 = move-exception
            goto L_0x007b
        L_0x00d5:
            r1 = move-exception
            goto L_0x0058
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C0304al.mo4309a(java.io.File):java.io.ByteArrayOutputStream");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0132 A[SYNTHETIC, Splitter:B:71:0x0132] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0137 A[SYNTHETIC, Splitter:B:74:0x0137] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x013c A[SYNTHETIC, Splitter:B:77:0x013c] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0147 A[SYNTHETIC, Splitter:B:83:0x0147] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x014c A[SYNTHETIC, Splitter:B:86:0x014c] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0151 A[SYNTHETIC, Splitter:B:89:0x0151] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.ByteArrayOutputStream mo4310a(java.lang.String r12, boolean r13) {
        /*
            r11 = this;
            r2 = 0
            if (r13 == 0) goto L_0x000d
            com.applovin.impl.sdk.AppLovinSdkImpl r0 = r11.f515b
            boolean r0 = com.applovin.impl.sdk.C0444fq.m1168a((com.applovin.sdk.AppLovinSdk) r0, (java.lang.String) r12)
            if (r0 != 0) goto L_0x000d
            r0 = r2
        L_0x000c:
            return r0
        L_0x000d:
            com.applovin.impl.sdk.AppLovinSdkImpl r0 = r11.f515b
            com.applovin.impl.sdk.dp<java.lang.Boolean> r1 = com.applovin.impl.sdk.C0387dn.f855bJ
            java.lang.Object r0 = r0.get(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x003a
            java.lang.String r0 = "https://"
            boolean r0 = r12.contains(r0)
            if (r0 != 0) goto L_0x003a
            com.applovin.impl.sdk.AppLovinSdkImpl r0 = r11.f515b
            com.applovin.sdk.AppLovinLogger r0 = r0.getLogger()
            java.lang.String r1 = "FileManager"
            java.lang.String r3 = "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting..."
            r0.mo4785w(r1, r3)
            java.lang.String r0 = "http://"
            java.lang.String r1 = "https://"
            java.lang.String r12 = r12.replace(r0, r1)
        L_0x003a:
            com.applovin.sdk.AppLovinLogger r0 = r11.f516c
            java.lang.String r1 = "FileManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Loading "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r12)
            java.lang.String r4 = "..."
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.mo4779d(r1, r3)
            r4 = 0
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0112, all -> 0x0142 }
            r3.<init>()     // Catch:{ IOException -> 0x0112, all -> 0x0142 }
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x018e, all -> 0x017c }
            r0.<init>(r12)     // Catch:{ IOException -> 0x018e, all -> 0x017c }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ IOException -> 0x018e, all -> 0x017c }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x018e, all -> 0x017c }
            com.applovin.impl.sdk.AppLovinSdkImpl r1 = r11.f515b     // Catch:{ IOException -> 0x0193, all -> 0x017f }
            com.applovin.impl.sdk.dp<java.lang.Integer> r5 = com.applovin.impl.sdk.C0387dn.f975t     // Catch:{ IOException -> 0x0193, all -> 0x017f }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ IOException -> 0x0193, all -> 0x017f }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ IOException -> 0x0193, all -> 0x017f }
            int r1 = r1.intValue()     // Catch:{ IOException -> 0x0193, all -> 0x017f }
            r0.setConnectTimeout(r1)     // Catch:{ IOException -> 0x0193, all -> 0x017f }
            com.applovin.impl.sdk.AppLovinSdkImpl r1 = r11.f515b     // Catch:{ IOException -> 0x0193, all -> 0x017f }
            com.applovin.impl.sdk.dp<java.lang.Integer> r5 = com.applovin.impl.sdk.C0387dn.f977v     // Catch:{ IOException -> 0x0193, all -> 0x017f }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ IOException -> 0x0193, all -> 0x017f }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ IOException -> 0x0193, all -> 0x017f }
            int r1 = r1.intValue()     // Catch:{ IOException -> 0x0193, all -> 0x017f }
            r0.setReadTimeout(r1)     // Catch:{ IOException -> 0x0193, all -> 0x017f }
            r1 = 1
            r0.setDefaultUseCaches(r1)     // Catch:{ IOException -> 0x0193, all -> 0x017f }
            r1 = 1
            r0.setUseCaches(r1)     // Catch:{ IOException -> 0x0193, all -> 0x017f }
            r1 = 0
            r0.setAllowUserInteraction(r1)     // Catch:{ IOException -> 0x0193, all -> 0x017f }
            r1 = 1
            r0.setInstanceFollowRedirects(r1)     // Catch:{ IOException -> 0x0193, all -> 0x017f }
            int r1 = r0.getResponseCode()     // Catch:{ IOException -> 0x0193, all -> 0x017f }
            r5 = 200(0xc8, float:2.8E-43)
            if (r1 < r5) goto L_0x00a9
            r5 = 300(0x12c, float:4.2E-43)
            if (r1 < r5) goto L_0x00bb
        L_0x00a9:
            if (r2 == 0) goto L_0x00ae
            r4.close()     // Catch:{ Exception -> 0x0155 }
        L_0x00ae:
            if (r3 == 0) goto L_0x00b3
            r3.close()     // Catch:{ Exception -> 0x0158 }
        L_0x00b3:
            if (r0 == 0) goto L_0x00b8
            r0.disconnect()     // Catch:{ Exception -> 0x015b }
        L_0x00b8:
            r0 = r2
            goto L_0x000c
        L_0x00bb:
            java.io.InputStream r4 = r0.getInputStream()     // Catch:{ IOException -> 0x0193, all -> 0x017f }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x019b, all -> 0x0184 }
        L_0x00c3:
            r5 = 0
            int r6 = r1.length     // Catch:{ IOException -> 0x019b, all -> 0x0184 }
            int r5 = r4.read(r1, r5, r6)     // Catch:{ IOException -> 0x019b, all -> 0x0184 }
            if (r5 < 0) goto L_0x00e6
            r6 = 0
            r3.write(r1, r6, r5)     // Catch:{ Exception -> 0x00d0 }
            goto L_0x00c3
        L_0x00d0:
            r1 = move-exception
            r3.close()     // Catch:{ Exception -> 0x015e }
        L_0x00d4:
            if (r4 == 0) goto L_0x00d9
            r4.close()     // Catch:{ Exception -> 0x0161 }
        L_0x00d9:
            if (r3 == 0) goto L_0x00de
            r3.close()     // Catch:{ Exception -> 0x0164 }
        L_0x00de:
            if (r0 == 0) goto L_0x00e3
            r0.disconnect()     // Catch:{ Exception -> 0x0167 }
        L_0x00e3:
            r0 = r2
            goto L_0x000c
        L_0x00e6:
            com.applovin.sdk.AppLovinLogger r1 = r11.f516c     // Catch:{ IOException -> 0x019b, all -> 0x0184 }
            java.lang.String r5 = "FileManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x019b, all -> 0x0184 }
            r6.<init>()     // Catch:{ IOException -> 0x019b, all -> 0x0184 }
            java.lang.String r7 = "Loaded resource at "
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ IOException -> 0x019b, all -> 0x0184 }
            java.lang.StringBuilder r6 = r6.append(r12)     // Catch:{ IOException -> 0x019b, all -> 0x0184 }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x019b, all -> 0x0184 }
            r1.mo4779d(r5, r6)     // Catch:{ IOException -> 0x019b, all -> 0x0184 }
            if (r4 == 0) goto L_0x0105
            r4.close()     // Catch:{ Exception -> 0x016a }
        L_0x0105:
            if (r3 == 0) goto L_0x010a
            r3.close()     // Catch:{ Exception -> 0x016c }
        L_0x010a:
            if (r0 == 0) goto L_0x010f
            r0.disconnect()     // Catch:{ Exception -> 0x016e }
        L_0x010f:
            r0 = r3
            goto L_0x000c
        L_0x0112:
            r0 = move-exception
            r1 = r2
            r3 = r2
            r4 = r2
        L_0x0116:
            com.applovin.sdk.AppLovinLogger r5 = r11.f516c     // Catch:{ all -> 0x018a }
            java.lang.String r6 = "FileManager"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x018a }
            r7.<init>()     // Catch:{ all -> 0x018a }
            java.lang.String r8 = "Error loading "
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x018a }
            java.lang.StringBuilder r7 = r7.append(r12)     // Catch:{ all -> 0x018a }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x018a }
            r5.mo4781e(r6, r7, r0)     // Catch:{ all -> 0x018a }
            if (r3 == 0) goto L_0x0135
            r3.close()     // Catch:{ Exception -> 0x0170 }
        L_0x0135:
            if (r4 == 0) goto L_0x013a
            r4.close()     // Catch:{ Exception -> 0x0172 }
        L_0x013a:
            if (r1 == 0) goto L_0x013f
            r1.disconnect()     // Catch:{ Exception -> 0x0174 }
        L_0x013f:
            r0 = r2
            goto L_0x000c
        L_0x0142:
            r0 = move-exception
            r1 = r2
            r3 = r2
        L_0x0145:
            if (r2 == 0) goto L_0x014a
            r2.close()     // Catch:{ Exception -> 0x0176 }
        L_0x014a:
            if (r3 == 0) goto L_0x014f
            r3.close()     // Catch:{ Exception -> 0x0178 }
        L_0x014f:
            if (r1 == 0) goto L_0x0154
            r1.disconnect()     // Catch:{ Exception -> 0x017a }
        L_0x0154:
            throw r0
        L_0x0155:
            r1 = move-exception
            goto L_0x00ae
        L_0x0158:
            r1 = move-exception
            goto L_0x00b3
        L_0x015b:
            r0 = move-exception
            goto L_0x00b8
        L_0x015e:
            r1 = move-exception
            goto L_0x00d4
        L_0x0161:
            r1 = move-exception
            goto L_0x00d9
        L_0x0164:
            r1 = move-exception
            goto L_0x00de
        L_0x0167:
            r0 = move-exception
            goto L_0x00e3
        L_0x016a:
            r1 = move-exception
            goto L_0x0105
        L_0x016c:
            r1 = move-exception
            goto L_0x010a
        L_0x016e:
            r0 = move-exception
            goto L_0x010f
        L_0x0170:
            r0 = move-exception
            goto L_0x0135
        L_0x0172:
            r0 = move-exception
            goto L_0x013a
        L_0x0174:
            r0 = move-exception
            goto L_0x013f
        L_0x0176:
            r2 = move-exception
            goto L_0x014a
        L_0x0178:
            r2 = move-exception
            goto L_0x014f
        L_0x017a:
            r1 = move-exception
            goto L_0x0154
        L_0x017c:
            r0 = move-exception
            r1 = r2
            goto L_0x0145
        L_0x017f:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
            goto L_0x0145
        L_0x0184:
            r1 = move-exception
            r2 = r4
            r9 = r0
            r0 = r1
            r1 = r9
            goto L_0x0145
        L_0x018a:
            r0 = move-exception
            r2 = r3
            r3 = r4
            goto L_0x0145
        L_0x018e:
            r0 = move-exception
            r1 = r2
            r4 = r3
            r3 = r2
            goto L_0x0116
        L_0x0193:
            r1 = move-exception
            r4 = r3
            r3 = r2
            r9 = r0
            r0 = r1
            r1 = r9
            goto L_0x0116
        L_0x019b:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
            r10 = r4
            r4 = r3
            r3 = r10
            goto L_0x0116
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C0304al.mo4310a(java.lang.String, boolean):java.io.ByteArrayOutputStream");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public File mo4311a(String str, Context context, boolean z) {
        File file;
        if (!C0444fq.isValidString(str)) {
            this.f515b.getLogger().mo4779d("FileManager", "Nothing to look up, skipping...");
            return null;
        }
        this.f516c.mo4779d("FileManager", "Looking up cached resource: " + str);
        if (!mo4314a(context) && !z) {
            return null;
        }
        if (str.contains("icon")) {
            str = str.replace("/", "_").replace(".", "_");
        }
        synchronized (this.f517d) {
            File e = m540e(context);
            file = new File(e, str);
            try {
                e.mkdirs();
            } catch (Exception e2) {
                return null;
            }
        }
        return file;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo4312a(Context context, String str, String str2, boolean z) throws MalformedURLException {
        return mo4313a(context, str, false, str2, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo4313a(Context context, String str, boolean z, String str2, boolean z2) throws MalformedURLException {
        if (!C0444fq.isValidString(str)) {
            this.f515b.getLogger().mo4779d("FileManager", "Nothing to cache, skipping...");
            return null;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        if (C0444fq.isValidString(lastPathSegment) && C0444fq.isValidString(str2)) {
            lastPathSegment = str2 + lastPathSegment;
        }
        File a = mo4311a(lastPathSegment, context, false);
        if (!mo4316a(a, str, z2)) {
            return null;
        }
        this.f516c.mo4779d("FileManager", "Caching succeeded for file " + lastPathSegment);
        return z ? Uri.fromFile(a).toString() : lastPathSegment;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo4314a(Context context) {
        if (C0463t.m1251a("android.permission.WRITE_EXTERNAL_STORAGE", context)) {
            return true;
        }
        if (C0463t.m1258f() && !((Boolean) this.f515b.get(C0387dn.f865bT)).booleanValue()) {
            return true;
        }
        this.f515b.getLogger().mo4785w("FileManager", "Application lacks required WRITE_EXTERNAL_STORAGE manifest permission.");
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo4315a(ByteArrayOutputStream byteArrayOutputStream, File file) {
        if (file == null) {
            return false;
        }
        this.f516c.mo4779d("FileManager", "Caching " + file.getAbsolutePath() + "...");
        if (byteArrayOutputStream == null || byteArrayOutputStream.size() <= 0) {
            this.f516c.mo4785w("FileManager", "No data for " + file.getAbsolutePath());
            return false;
        } else if (!m537b(byteArrayOutputStream, file)) {
            this.f516c.mo4780e("FileManager", "Unable to cache " + file.getAbsolutePath());
            return false;
        } else {
            this.f516c.mo4779d("FileManager", "Caching completed for " + file);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo4316a(File file, String str, boolean z) {
        if (file == null || !file.exists() || file.isDirectory()) {
            return mo4315a(mo4310a(str, z), file);
        }
        this.f515b.getLogger().mo4779d("FileManager", "File exists for " + str);
        return true;
    }

    /* renamed from: a */
    public boolean mo4317a(String str, Context context) {
        boolean b;
        synchronized (this.f517d) {
            b = mo4319b(str, context, false);
        }
        return b;
    }

    /* renamed from: b */
    public List<File> mo4318b(Context context) {
        List<File> asList;
        File e = m540e(context);
        if (!e.isDirectory()) {
            return new ArrayList(0);
        }
        synchronized (this.f517d) {
            asList = Arrays.asList(e.listFiles());
        }
        return asList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo4319b(String str, Context context, boolean z) {
        boolean z2;
        synchronized (this.f517d) {
            File a = mo4311a(str, context, z);
            z2 = a != null && a.exists() && !a.isDirectory();
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo4320c(Context context) {
        if (((Boolean) this.f515b.get(C0387dn.f866bU)).booleanValue()) {
            try {
                mo4311a(".nomedia", context, false);
                File file = new File(m540e(context), ".nomedia");
                if (file != null) {
                    if (file.exists()) {
                        return true;
                    }
                    this.f515b.getLogger().mo4779d("FileManager", "Dropping .nomedia file at " + file.getAbsolutePath());
                    return file.createNewFile();
                }
            } catch (Exception e) {
                this.f515b.getLogger().mo4786w("FileManager", "Failed to create nomedia file", e);
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4321d(android.content.Context r5) {
        /*
            r4 = this;
            boolean r0 = r4.m535a()     // Catch:{ Exception -> 0x0030 }
            if (r0 == 0) goto L_0x0017
            com.applovin.impl.sdk.AppLovinSdkImpl r0 = r4.f515b     // Catch:{ Exception -> 0x0030 }
            boolean r0 = r0.isEnabled()     // Catch:{ Exception -> 0x0030 }
            if (r0 == 0) goto L_0x0018
            com.applovin.sdk.AppLovinLogger r0 = r4.f516c     // Catch:{ Exception -> 0x0030 }
            java.lang.String r1 = "FileManager"
            java.lang.String r2 = "Cannot empty file cache after SDK has completed initialization and ad loads are in progress!"
            r0.mo4780e(r1, r2)     // Catch:{ Exception -> 0x0030 }
        L_0x0017:
            return
        L_0x0018:
            com.applovin.sdk.AppLovinLogger r0 = r4.f516c     // Catch:{ Exception -> 0x0030 }
            java.lang.String r1 = "FileManager"
            java.lang.String r2 = "Compacting cache..."
            r0.mo4779d(r1, r2)     // Catch:{ Exception -> 0x0030 }
            java.lang.Object r1 = r4.f517d     // Catch:{ Exception -> 0x0030 }
            monitor-enter(r1)     // Catch:{ Exception -> 0x0030 }
            long r2 = r4.m541f(r5)     // Catch:{ all -> 0x002d }
            r4.m534a((long) r2, (android.content.Context) r5)     // Catch:{ all -> 0x002d }
            monitor-exit(r1)     // Catch:{ all -> 0x002d }
            goto L_0x0017
        L_0x002d:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x002d }
            throw r0     // Catch:{ Exception -> 0x0030 }
        L_0x0030:
            r0 = move-exception
            com.applovin.sdk.AppLovinLogger r1 = r4.f516c
            java.lang.String r2 = "FileManager"
            java.lang.String r3 = "Caught exception while compacting cache!"
            r1.mo4781e(r2, r3, r0)
            com.applovin.impl.sdk.AppLovinSdkImpl r0 = r4.f515b
            com.applovin.impl.sdk.dq r0 = r0.getSettingsManager()
            com.applovin.impl.sdk.dp<java.lang.Boolean> r1 = com.applovin.impl.sdk.C0387dn.f810aR
            r2 = 0
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r0.mo4536a(r1, r2)
            com.applovin.impl.sdk.AppLovinSdkImpl r0 = r4.f515b
            com.applovin.impl.sdk.dq r0 = r0.getSettingsManager()
            r0.mo4535a()
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C0304al.mo4321d(android.content.Context):void");
    }
}
