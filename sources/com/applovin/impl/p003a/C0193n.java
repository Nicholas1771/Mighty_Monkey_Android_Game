package com.applovin.impl.p003a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.AppLovinSdkImpl;
import com.applovin.impl.sdk.C0444fq;
import com.applovin.impl.sdk.C0446fs;
import com.applovin.impl.sdk.C0451h;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdk;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.a.n */
public class C0193n {

    /* renamed from: a */
    private static DateFormat f102a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    /* renamed from: b */
    private static Random f103b = new Random(System.currentTimeMillis());

    /* renamed from: a */
    public static Uri m96a(String str, long j, Uri uri, C0187h hVar, AppLovinSdk appLovinSdk) {
        if (URLUtil.isValidUrl(str)) {
            try {
                String replace = str.replace("[ERRORCODE]", Integer.toString(hVar.mo3901a()));
                if (j >= 0) {
                    replace = replace.replace("[CONTENTPLAYHEAD]", m99a(j));
                }
                if (uri != null) {
                    replace = replace.replace("[ASSETURI]", uri.toString());
                }
                return Uri.parse(replace.replace("[CACHEBUSTING]", m98a()).replace("[TIMESTAMP]", m111b()));
            } catch (Throwable th) {
                appLovinSdk.getLogger().mo4781e("VastUtils", "Unable to replace macros in URL string " + str, th);
                return null;
            }
        } else {
            appLovinSdk.getLogger().mo4780e("VastUtils", "Unable to replace macros in invalid URL string.");
            return null;
        }
    }

    /* renamed from: a */
    public static C0187h m97a(C0180a aVar) {
        if (m112b(aVar) || m114c(aVar)) {
            return null;
        }
        return C0187h.GENERAL_WRAPPER_ERROR;
    }

    /* renamed from: a */
    private static String m98a() {
        return Integer.toString(10000000 + f103b.nextInt(89999999));
    }

    /* renamed from: a */
    private static String m99a(long j) {
        if (j <= 0) {
            return "00:00:00.000";
        }
        return String.format("%02d:%02d:%02d.000", new Object[]{Long.valueOf(TimeUnit.SECONDS.toHours(j)), Long.valueOf(TimeUnit.SECONDS.toMinutes(j) % TimeUnit.MINUTES.toSeconds(1)), Long.valueOf(j % TimeUnit.MINUTES.toSeconds(1))});
    }

    /* renamed from: a */
    public static String m100a(C0186g gVar) {
        C0446fs c;
        if (gVar == null) {
            throw new IllegalArgumentException("Unable to get resolution uri string for fetching the next wrapper or inline response in the chain");
        }
        List<C0446fs> b = gVar.mo3895b();
        int size = gVar.mo3895b().size();
        if (size <= 0 || (c = b.get(size - 1).mo4739c("VASTAdTagURI")) == null) {
            return null;
        }
        return c.mo4740c();
    }

    /* renamed from: a */
    public static String m101a(C0446fs fsVar, String str, String str2) {
        C0446fs b = fsVar.mo4737b(str);
        if (b == null) {
            return str2;
        }
        String c = b.mo4740c();
        return C0444fq.isValidString(c) ? c : str2;
    }

    /* renamed from: a */
    private static Set<C0191l> m102a(C0186g gVar, AppLovinSdk appLovinSdk) {
        if (gVar == null) {
            return null;
        }
        List<C0446fs> b = gVar.mo3895b();
        Set<C0191l> hashSet = new HashSet<>(b.size());
        Iterator<C0446fs> it = b.iterator();
        while (true) {
            Set<C0191l> set = hashSet;
            if (it.hasNext()) {
                C0446fs next = it.next();
                C0446fs c = next.mo4739c("Wrapper");
                if (c == null) {
                    c = next.mo4739c("InLine");
                }
                hashSet = c != null ? m103a(set, c.mo4736a("Error"), gVar, appLovinSdk) : m103a(set, next.mo4736a("Error"), gVar, appLovinSdk);
            } else {
                appLovinSdk.getLogger().mo4779d("VastUtils", "Retrieved " + set.size() + " top level error trackers: " + set);
                return set;
            }
        }
    }

    /* renamed from: a */
    private static Set<C0191l> m103a(Set<C0191l> set, List<C0446fs> list, C0186g gVar, AppLovinSdk appLovinSdk) {
        if (list != null) {
            for (C0446fs a : list) {
                C0191l a2 = C0191l.m92a(a, gVar, appLovinSdk);
                if (a2 != null) {
                    set.add(a2);
                }
            }
        }
        return set;
    }

    /* renamed from: a */
    public static void m104a(C0186g gVar, C0451h hVar, AppLovinAdLoadListener appLovinAdLoadListener, C0187h hVar2, int i, AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("Unable to handle failure. No sdk specified.");
        }
        if (gVar != null) {
            hVar = gVar.mo3898e();
        }
        C0444fq.m1163a(appLovinAdLoadListener, hVar, i, appLovinSdkImpl);
        m108a(m102a(gVar, (AppLovinSdk) appLovinSdkImpl), hVar2, appLovinSdkImpl);
    }

    /* renamed from: a */
    public static void m105a(C0446fs fsVar, Map<String, Set<C0191l>> map, C0186g gVar, AppLovinSdk appLovinSdk) {
        List<C0446fs> a;
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("Unable to render event trackers. No sdk specified.");
        } else if (fsVar == null) {
            appLovinSdk.getLogger().mo4780e("VastUtils", "Unable to render event trackers; null node provided");
        } else if (map == null) {
            appLovinSdk.getLogger().mo4780e("VastUtils", "Unable to render event trackers; null event trackers provided");
        } else {
            C0446fs b = fsVar.mo4737b("TrackingEvents");
            if (b != null && (a = b.mo4736a("Tracking")) != null) {
                for (C0446fs next : a) {
                    String str = next.mo4738b().get("event");
                    if (C0444fq.isValidString(str)) {
                        C0191l a2 = C0191l.m92a(next, gVar, appLovinSdk);
                        if (a2 != null) {
                            Set set = map.get(str);
                            if (set != null) {
                                set.add(a2);
                            } else {
                                HashSet hashSet = new HashSet();
                                hashSet.add(a2);
                                map.put(str, hashSet);
                            }
                        }
                    } else {
                        appLovinSdk.getLogger().mo4780e("VastUtils", "Could not find event for tracking node = " + next);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m106a(List<C0446fs> list, Set<C0191l> set, C0186g gVar, AppLovinSdk appLovinSdk) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("Unable to render trackers. No sdk specified.");
        } else if (list == null) {
            appLovinSdk.getLogger().mo4780e("VastUtils", "Unable to render trackers; null nodes provided");
        } else if (set == null) {
            appLovinSdk.getLogger().mo4780e("VastUtils", "Unable to render trackers; null trackers provided");
        } else {
            for (C0446fs a : list) {
                C0191l a2 = C0191l.m92a(a, gVar, appLovinSdk);
                if (a2 != null) {
                    set.add(a2);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m107a(Set<C0191l> set, long j, Uri uri, C0187h hVar, AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("Unable to fire trackers. No sdk specified.");
        } else if (set != null && !set.isEmpty()) {
            for (C0191l b : set) {
                Uri a = m96a(b.mo3915b(), j, uri, hVar, (AppLovinSdk) appLovinSdkImpl);
                if (a != null) {
                    appLovinSdkImpl.getPersistentPostbackManager().mo4493a(a.toString(), (Map<String, String>) null, false);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m108a(Set<C0191l> set, C0187h hVar, AppLovinSdkImpl appLovinSdkImpl) {
        m107a(set, -1, (Uri) null, hVar, appLovinSdkImpl);
    }

    /* renamed from: a */
    public static void m109a(Set<C0191l> set, AppLovinSdkImpl appLovinSdkImpl) {
        m107a(set, -1, (Uri) null, C0187h.UNSPECIFIED, appLovinSdkImpl);
    }

    /* renamed from: a */
    public static boolean m110a(C0446fs fsVar) {
        if (fsVar != null) {
            return fsVar.mo4739c("Wrapper") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains a wrapper response");
    }

    /* renamed from: b */
    private static String m111b() {
        f102a.setTimeZone(TimeZone.getDefault());
        return f102a.format(new Date());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r1 = (r1 = r2.mo3855a()).mo3920a();
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m112b(com.applovin.impl.p003a.C0180a r2) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x0004
        L_0x0003:
            return r0
        L_0x0004:
            com.applovin.impl.a.o r1 = r2.mo3855a()
            if (r1 == 0) goto L_0x0003
            java.util.List r1 = r1.mo3920a()
            if (r1 == 0) goto L_0x0003
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0003
            r0 = 1
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.p003a.C0193n.m112b(com.applovin.impl.a.a):boolean");
    }

    /* renamed from: b */
    public static boolean m113b(C0446fs fsVar) {
        if (fsVar != null) {
            return fsVar.mo4739c("InLine") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains an inline response");
    }

    /* renamed from: c */
    public static boolean m114c(C0180a aVar) {
        C0185f e;
        C0188i b;
        if (aVar == null || (e = aVar.mo3865e()) == null || (b = e.mo3888b()) == null) {
            return false;
        }
        return b.mo3905b() != null || C0444fq.isValidString(b.mo3906c());
    }
}
