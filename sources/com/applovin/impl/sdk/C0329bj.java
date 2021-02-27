package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinSdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.bj */
public class C0329bj {
    /* renamed from: a */
    public static float m629a(JSONObject jSONObject, String str, float f, AppLovinSdk appLovinSdk) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return f;
        }
        try {
            double d = jSONObject.getDouble(str);
            return (-3.4028234663852886E38d >= d || d >= 3.4028234663852886E38d) ? f : (float) d;
        } catch (JSONException e) {
            if (appLovinSdk == null) {
                return f;
            }
            appLovinSdk.getLogger().mo4780e("JsonUtils", "Failed to retrieve float property for key = " + str);
            return f;
        }
    }

    /* renamed from: a */
    public static int m630a(JSONObject jSONObject, String str, int i, AppLovinSdk appLovinSdk) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return i;
        }
        try {
            return jSONObject.getInt(str);
        } catch (JSONException e) {
            if (appLovinSdk == null) {
                return i;
            }
            appLovinSdk.getLogger().mo4780e("JsonUtils", "Failed to retrieve int property for key = " + str);
            return i;
        }
    }

    /* renamed from: a */
    public static long m631a(JSONObject jSONObject, String str, long j, AppLovinSdk appLovinSdk) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return j;
        }
        try {
            return jSONObject.getLong(str);
        } catch (JSONException e) {
            if (appLovinSdk == null) {
                return j;
            }
            appLovinSdk.getLogger().mo4780e("JsonUtils", "Failed to retrieve int property for key = " + str);
            return j;
        }
    }

    /* renamed from: a */
    public static Boolean m632a(JSONObject jSONObject, String str, Boolean bool, AppLovinSdk appLovinSdk) {
        boolean z = true;
        if (jSONObject == null || !jSONObject.has(str)) {
            return bool;
        }
        try {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        } catch (JSONException e) {
            if (appLovinSdk != null) {
                appLovinSdk.getLogger().mo4785w("JsonUtils", "Unable to parse boolean for key = " + str + "... Attempting to parse it as an int");
            }
            if (m630a(jSONObject, str, bool.booleanValue() ? 1 : 0, appLovinSdk) <= 0) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    /* renamed from: a */
    private static Object m633a(Object obj) throws JSONException {
        if (obj == JSONObject.NULL) {
            return null;
        }
        return obj instanceof JSONObject ? m636a((JSONObject) obj) : obj instanceof JSONArray ? m635a((JSONArray) obj) : obj;
    }

    /* renamed from: a */
    public static String m634a(JSONObject jSONObject, String str, String str2, AppLovinSdk appLovinSdk) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return str2;
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException e) {
            if (appLovinSdk == null) {
                return str2;
            }
            appLovinSdk.getLogger().mo4780e("JsonUtils", "Failed to retrieve string property for key = " + str);
            return str2;
        }
    }

    /* renamed from: a */
    public static List m635a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m633a(jSONArray.get(i)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static Map<String, String> m636a(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, m633a(jSONObject.get(next)).toString());
        }
        return hashMap;
    }

    /* renamed from: a */
    static JSONObject m637a(Map<String, String> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : map.entrySet()) {
            jSONObject.put((String) next.getKey(), next.getValue());
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static JSONObject m638a(JSONObject jSONObject, String str, JSONObject jSONObject2, AppLovinSdk appLovinSdk) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return jSONObject2;
        }
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException e) {
            if (appLovinSdk == null) {
                return jSONObject2;
            }
            appLovinSdk.getLogger().mo4780e("JsonUtils", "Failed to retrieve JSON property for key = " + str);
            return jSONObject2;
        }
    }
}
