package com.applovin.impl.sdk;

import android.content.Intent;
import android.net.Uri;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinEventTypes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class EventServiceImpl implements AppLovinEventService {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AppLovinSdkImpl f447a;

    /* renamed from: b */
    private final List<String> f448b;

    public EventServiceImpl(AppLovinSdk appLovinSdk) {
        this.f447a = (AppLovinSdkImpl) appLovinSdk;
        this.f448b = C0462s.m1246a((String) ((AppLovinSdkImpl) appLovinSdk).get(C0387dn.f853bH));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Uri m437a(String str, Map<String, String> map) {
        try {
            return Uri.parse(str).buildUpon().encodedQuery(C0444fq.m1161a(map)).build();
        } catch (Throwable th) {
            this.f447a.getLogger().mo4781e("EventServiceImpl", "Unable to create postback uri due to invalid endpoint", th);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m438a() {
        return (String) this.f447a.get(C0387dn.f968m);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public HashMap<String, String> m441a(C0383dj djVar, C0469z zVar) {
        C0467x dataCollector = this.f447a.getDataCollector();
        C0295ac a = dataCollector.mo4790a();
        C0293aa c = dataCollector.mo4793c();
        boolean contains = this.f448b.contains(djVar.mo4517a());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("event", contains ? djVar.mo4517a() : "postinstall");
        hashMap.put("ts", Long.toString(djVar.mo4519c()));
        hashMap.put("platform", "Android");
        hashMap.put("model", C0444fq.m1172c(a.f484a));
        hashMap.put("package_name", C0444fq.m1172c(c.f480c));
        hashMap.put("sdk_key", this.f447a.getSdkKey());
        hashMap.put("idfa", zVar.f1194b);
        hashMap.put("dnt", Boolean.toString(zVar.f1193a));
        hashMap.put("ia", Long.toString(c.f481d));
        hashMap.put("api_did", this.f447a.get(C0387dn.f898c));
        hashMap.put("brand", C0444fq.m1172c(a.f486c));
        hashMap.put("revision", C0444fq.m1172c(a.f487d));
        hashMap.put("sdk_version", AppLovinSdk.VERSION);
        hashMap.put("os", C0444fq.m1172c(a.f485b));
        hashMap.put("orientation_lock", a.f492i);
        hashMap.put("app_version", C0444fq.m1172c(this.f447a.getDataCollector().mo4793c().f479b));
        hashMap.put("country_code", C0444fq.m1172c(a.f489f));
        hashMap.put("carrier", C0444fq.m1172c(a.f490g));
        hashMap.put("tz_offset", String.valueOf(a.f495l));
        hashMap.put("adr", a.f497n ? "1" : "0");
        hashMap.put("volume", String.valueOf(a.f499p));
        hashMap.put("sim", a.f501r ? "1" : "0");
        hashMap.put("gy", String.valueOf(a.f502s));
        C0294ab abVar = a.f498o;
        if (abVar != null) {
            hashMap.put("act", String.valueOf(abVar.f482a));
            hashMap.put("acm", String.valueOf(abVar.f483b));
        }
        String str = a.f500q;
        if (AppLovinSdkUtils.isValidString(str)) {
            hashMap.put("ua", C0444fq.m1172c(str));
        }
        if (!contains) {
            hashMap.put("sub_event", djVar.mo4517a());
        }
        return hashMap;
    }

    /* renamed from: a */
    private Map<String, String> m442a(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                Object key = next.getKey();
                Object value = next.getValue();
                if (!(key instanceof String) || !(value instanceof String)) {
                    this.f447a.getLogger().mo4785w("EventServiceImpl", "Unexpected class type in trackEvent(); all keys and values passed as parameters must be String. Encountered " + key.getClass().getCanonicalName() + "/" + value.getClass().getCanonicalName() + "; will use toString() value instead, which may be unexpected...");
                    hashMap.put(key.toString(), value.toString());
                } else {
                    hashMap.put((String) key, (String) value);
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private void m443a(C0383dj djVar) {
        if (((Boolean) this.f447a.get(C0387dn.f854bI)).booleanValue()) {
            this.f447a.getLogger().mo4779d("EventServiceImpl", "Tracking event: " + djVar);
            m444a((C0407eg) new C0301ai(this, djVar));
        }
    }

    /* renamed from: a */
    private void m444a(C0407eg egVar) {
        this.f447a.mo4169a().mo4681a((C0386dm) new C0406ef(this.f447a, egVar), C0416ep.BACKGROUND);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m445b() {
        return (String) this.f447a.get(C0387dn.f971p);
    }

    public void trackCheckout(String str, Map<String, String> map) {
        HashMap hashMap = map != null ? new HashMap(map) : new HashMap(1);
        hashMap.put(AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER, str);
        trackEvent(AppLovinEventTypes.USER_COMPLETED_CHECKOUT, hashMap);
    }

    public void trackEvent(String str) {
        trackEvent(str, new HashMap());
    }

    public void trackEvent(String str, Map<String, String> map) {
        m443a(new C0383dj(str, m442a(map), System.currentTimeMillis(), C0444fq.m1170b(UUID.randomUUID().toString())));
    }

    public void trackInAppPurchase(Intent intent, Map<String, String> map) {
        HashMap hashMap = map != null ? new HashMap(map) : new HashMap();
        try {
            hashMap.put(AppLovinEventParameters.IN_APP_PURCHASE_DATA, intent.getStringExtra("INAPP_PURCHASE_DATA"));
            hashMap.put(AppLovinEventParameters.IN_APP_DATA_SIGNATURE, intent.getStringExtra("INAPP_DATA_SIGNATURE"));
        } catch (Exception e) {
            this.f447a.getLogger().userError("EventServiceImpl", "Unable to track in app purchase; invalid purchanse intent", e);
        }
        trackEvent(AppLovinEventTypes.USER_COMPLETED_IN_APP_PURCHASE, hashMap);
    }
}
