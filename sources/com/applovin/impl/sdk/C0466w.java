package com.applovin.impl.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.p000v4.p002os.EnvironmentCompat;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.w */
public class C0466w {

    /* renamed from: a */
    private static final int[] f1179a = {7, 4, 2, 1, 11};

    /* renamed from: b */
    private static final int[] f1180b = {5, 6, 10, 3, 9, 8, 14};

    /* renamed from: c */
    private static final int[] f1181c = {15, 12, 13};

    /* renamed from: d */
    private static final String f1182d = C0466w.class.getSimpleName();

    /* renamed from: a */
    static String m1272a(AppLovinSdkImpl appLovinSdkImpl) {
        NetworkInfo b = m1281b(appLovinSdkImpl.getApplicationContext());
        if (b == null) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        int type = b.getType();
        int subtype = b.getSubtype();
        String str = type == 1 ? "wifi" : type == 0 ? m1279a(subtype, f1179a) ? "2g" : m1279a(subtype, f1180b) ? "3g" : m1279a(subtype, f1181c) ? "4g" : "mobile" : EnvironmentCompat.MEDIA_UNKNOWN;
        appLovinSdkImpl.getLogger().mo4779d(f1182d, "Network " + type + "/" + subtype + " resolved to " + str);
        return str;
    }

    /* renamed from: a */
    static String m1273a(InputStream inputStream, AppLovinSdkImpl appLovinSdkImpl) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[((Integer) appLovinSdkImpl.get(C0387dn.f912cN)).intValue()];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            appLovinSdkImpl.getLogger().mo4781e(f1182d, "Encountered error while reading stream", th);
            return null;
        }
    }

    /* renamed from: a */
    static String m1274a(String str, String str2, Map<String, String> map, AppLovinSdkImpl appLovinSdkImpl) {
        if (str == null || str.length() < 4) {
            throw new IllegalArgumentException("Invalid domain specified");
        } else if (str2 == null) {
            throw new IllegalArgumentException("No endpoint specified");
        } else if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else {
            StringBuilder sb = new StringBuilder(str + str2);
            if (map != null && map.size() > 0) {
                sb.append("?" + C0444fq.m1161a(map));
            }
            return sb.toString();
        }
    }

    /* renamed from: a */
    static String m1275a(String str, Map<String, String> map, AppLovinSdkImpl appLovinSdkImpl) {
        String str2 = (String) appLovinSdkImpl.get(C0387dn.f965j);
        String str3 = (String) appLovinSdkImpl.get(C0387dn.f960e);
        if (map == null) {
            map = m1283b(appLovinSdkImpl);
        } else {
            map.putAll(m1283b(appLovinSdkImpl));
        }
        return m1274a(str2, str, map, appLovinSdkImpl);
    }

    /* renamed from: a */
    static JSONObject m1276a(JSONObject jSONObject) throws JSONException {
        return (JSONObject) jSONObject.getJSONArray("results").get(0);
    }

    /* renamed from: a */
    static void m1277a(int i, AppLovinSdkImpl appLovinSdkImpl) {
        C0390dq settingsManager = appLovinSdkImpl.getSettingsManager();
        if (i == 401) {
            settingsManager.mo4536a(C0387dn.f898c, "");
            settingsManager.mo4536a(C0387dn.f960e, "");
            settingsManager.mo4535a();
        } else if (i == 418) {
            settingsManager.mo4536a(C0387dn.f792a, true);
            settingsManager.mo4535a();
        } else if (i >= 400 && i < 500) {
            appLovinSdkImpl.mo4202h();
        } else if (i == -1) {
            appLovinSdkImpl.mo4202h();
        }
    }

    /* renamed from: a */
    static void m1278a(JSONObject jSONObject, AppLovinSdkImpl appLovinSdkImpl) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else {
            try {
                if (jSONObject.has("settings")) {
                    C0390dq settingsManager = appLovinSdkImpl.getSettingsManager();
                    if (!jSONObject.isNull("settings")) {
                        settingsManager.mo4538a(jSONObject.getJSONObject("settings"));
                        settingsManager.mo4535a();
                        appLovinSdkImpl.getLogger().mo4779d(f1182d, "New settings processed");
                    }
                }
            } catch (JSONException e) {
                appLovinSdkImpl.getLogger().mo4781e(f1182d, "Unable to parse settings out of API response", e);
            }
        }
    }

    /* renamed from: a */
    private static boolean m1279a(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m1280a(Context context) {
        NetworkInfo b = m1281b(context);
        return b == null || b.isConnected();
    }

    /* renamed from: b */
    private static NetworkInfo m1281b(Context context) {
        ConnectivityManager connectivityManager;
        if (!C0467x.m1289a("android.permission.ACCESS_NETWORK_STATE", context) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    /* renamed from: b */
    static String m1282b(String str, Map<String, String> map, AppLovinSdkImpl appLovinSdkImpl) {
        return m1274a((String) appLovinSdkImpl.get(C0387dn.f966k), str, map, appLovinSdkImpl);
    }

    /* renamed from: b */
    private static Map<String, String> m1283b(AppLovinSdkImpl appLovinSdkImpl) {
        HashMap hashMap = new HashMap();
        String str = (String) appLovinSdkImpl.get(C0387dn.f960e);
        if (C0444fq.isValidString(str)) {
            hashMap.put("device_token", str);
        } else {
            hashMap.put("api_key", appLovinSdkImpl.getSdkKey());
        }
        return hashMap;
    }

    /* renamed from: b */
    static void m1284b(int i, AppLovinSdkImpl appLovinSdkImpl) {
        if (i == 418) {
            C0390dq settingsManager = appLovinSdkImpl.getSettingsManager();
            settingsManager.mo4536a(C0387dn.f792a, true);
            settingsManager.mo4535a();
        }
    }

    /* renamed from: c */
    static String m1285c(String str, Map<String, String> map, AppLovinSdkImpl appLovinSdkImpl) {
        String str2 = (String) appLovinSdkImpl.get(C0387dn.f969n);
        if (map == null) {
            map = m1283b(appLovinSdkImpl);
        } else {
            map.putAll(m1283b(appLovinSdkImpl));
        }
        return m1274a(str2, str, map, appLovinSdkImpl);
    }

    /* renamed from: d */
    static String m1286d(String str, Map<String, String> map, AppLovinSdkImpl appLovinSdkImpl) {
        return m1274a((String) appLovinSdkImpl.get(C0387dn.f970o), str, map, appLovinSdkImpl);
    }
}
