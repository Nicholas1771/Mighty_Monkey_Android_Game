package com.applovin.impl.sdk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.a */
class C0292a {

    /* renamed from: a */
    private static final Object f476a = new Object();

    /* renamed from: b */
    private static final Map<String, Map<String, String>> f477b = new HashMap();

    /* renamed from: a */
    static Map<String, String> m468a(AppLovinSdkImpl appLovinSdkImpl) {
        Map<String, String> c;
        synchronized (f476a) {
            appLovinSdkImpl.getLogger().mo4779d("AdDataCache", "Reading cached device data...");
            c = m473c(appLovinSdkImpl);
        }
        return c;
    }

    /* renamed from: a */
    private static void m469a(String str, Map<String, String> map) {
        List<String> a = C0462s.m1247a(str, "=");
        if (a.size() == 2) {
            map.put(a.get(0), a.get(1));
        }
    }

    /* renamed from: a */
    static void m470a(Map<String, String> map, AppLovinSdkImpl appLovinSdkImpl) {
        m472b(map, appLovinSdkImpl);
    }

    /* renamed from: b */
    static void m471b(AppLovinSdkImpl appLovinSdkImpl) {
        synchronized (f476a) {
            appLovinSdkImpl.getLogger().mo4779d("AdDataCache", "Clearing old device data cache...");
            m470a((Map<String, String>) new HashMap(0), appLovinSdkImpl);
        }
    }

    /* renamed from: b */
    private static void m472b(Map<String, String> map, AppLovinSdkImpl appLovinSdkImpl) {
        if (map == null) {
            throw new IllegalArgumentException("No ad aata specified");
        } else if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else {
            try {
                synchronized (f477b) {
                    Map map2 = f477b.get("ad_data_cache");
                    if (map2 == null) {
                        map2 = new HashMap();
                    }
                    map2.clear();
                    map2.putAll(map);
                    f477b.put("ad_data_cache", map2);
                }
                appLovinSdkImpl.put(C0392ds.f995d, C0444fq.m1161a(map));
                appLovinSdkImpl.getLogger().mo4779d("AdDataCache", map.size() + " " + "ad_data_cache" + " entries saved in cache");
            } catch (Exception e) {
                appLovinSdkImpl.getLogger().mo4781e("AdDataCache", "Unable to save ad data entries", e);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0096  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Map<java.lang.String, java.lang.String> m473c(com.applovin.impl.sdk.AppLovinSdkImpl r6) {
        /*
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r1 = f477b
            monitor-enter(r1)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r0 = f477b     // Catch:{ all -> 0x0058 }
            java.lang.String r2 = "ad_data_cache"
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0058 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x0058 }
            monitor-exit(r1)     // Catch:{ all -> 0x0058 }
            if (r0 != 0) goto L_0x00a1
            com.applovin.impl.sdk.ds<java.lang.String> r1 = com.applovin.impl.sdk.C0392ds.f995d
            java.lang.Object r1 = r6.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "&"
            java.util.List r2 = com.applovin.impl.sdk.C0462s.m1247a(r1, r2)
            boolean r1 = r2.isEmpty()
            if (r1 != 0) goto L_0x00a1
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x009c }
            r1.<init>()     // Catch:{ Exception -> 0x009c }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x003d }
        L_0x002d:
            boolean r0 = r2.hasNext()     // Catch:{ Exception -> 0x003d }
            if (r0 == 0) goto L_0x005b
            java.lang.Object r0 = r2.next()     // Catch:{ Exception -> 0x003d }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x003d }
            m469a((java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.String>) r1)     // Catch:{ Exception -> 0x003d }
            goto L_0x002d
        L_0x003d:
            r0 = move-exception
        L_0x003e:
            com.applovin.sdk.AppLovinLogger r2 = r6.getLogger()
            java.lang.String r3 = "AdDataCache"
            java.lang.String r4 = "Unable to load ad data"
            r2.mo4781e(r3, r4, r0)
            com.applovin.impl.sdk.ds<java.lang.String> r0 = com.applovin.impl.sdk.C0392ds.f995d
            java.lang.String r2 = ""
            r6.put(r0, r2)
        L_0x0050:
            if (r1 == 0) goto L_0x0096
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>(r1)
        L_0x0057:
            return r0
        L_0x0058:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0058 }
            throw r0
        L_0x005b:
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r2 = f477b     // Catch:{ Exception -> 0x003d }
            monitor-enter(r2)     // Catch:{ Exception -> 0x003d }
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r0 = f477b     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = "ad_data_cache"
            r0.put(r3, r1)     // Catch:{ all -> 0x0093 }
            monitor-exit(r2)     // Catch:{ all -> 0x0093 }
            com.applovin.sdk.AppLovinLogger r0 = r6.getLogger()     // Catch:{ Exception -> 0x003d }
            java.lang.String r2 = "AdDataCache"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003d }
            r3.<init>()     // Catch:{ Exception -> 0x003d }
            int r4 = r1.size()     // Catch:{ Exception -> 0x003d }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x003d }
            java.lang.String r4 = " "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x003d }
            java.lang.String r4 = "ad_data_cache"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x003d }
            java.lang.String r4 = " entries loaded from cache"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x003d }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x003d }
            r0.mo4779d(r2, r3)     // Catch:{ Exception -> 0x003d }
            goto L_0x0050
        L_0x0093:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0093 }
            throw r0     // Catch:{ Exception -> 0x003d }
        L_0x0096:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            goto L_0x0057
        L_0x009c:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x003e
        L_0x00a1:
            r1 = r0
            goto L_0x0050
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C0292a.m473c(com.applovin.impl.sdk.AppLovinSdkImpl):java.util.Map");
    }
}
