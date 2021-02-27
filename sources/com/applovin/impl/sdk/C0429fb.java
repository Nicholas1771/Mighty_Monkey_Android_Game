package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.fb */
class C0429fb extends C0386dm {

    /* renamed from: a */
    private final AppLovinNativeAdLoadListener f1083a;

    /* renamed from: b */
    private final JSONObject f1084b;

    C0429fb(JSONObject jSONObject, AppLovinSdkImpl appLovinSdkImpl, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super("TaskRenderNativeAd", appLovinSdkImpl);
        this.f1083a = appLovinNativeAdLoadListener;
        this.f1084b = jSONObject;
    }

    /* renamed from: a */
    private String m1087a(Map<String, String> map, String str) {
        String str2 = map.get("simp_url");
        if (AppLovinSdkUtils.isValidString(str2)) {
            return str2.replace("{CLCODE}", str);
        }
        throw new IllegalArgumentException("No impression URL available");
    }

    /* renamed from: a */
    private String m1088a(Map<String, String> map, String str, String str2) {
        String str3 = map.get("click_url");
        if (!AppLovinSdkUtils.isValidString(str3)) {
            throw new IllegalArgumentException("No impression URL available");
        }
        if (str2 == null) {
            str2 = "";
        }
        return str3.replace("{CLCODE}", str).replace("{EVENT_ID}", str2);
    }

    /* renamed from: a */
    private void m1089a(JSONObject jSONObject) throws JSONException, MalformedURLException {
        List<Map> a = C0329bj.m635a(jSONObject.getJSONArray("native_ads"));
        Map<String, String> a2 = C0329bj.m636a(jSONObject.getJSONObject("native_settings"));
        ArrayList arrayList = new ArrayList(a.size());
        for (Map map : a) {
            String str = (String) map.get("clcode");
            NativeAdImpl a3 = new C0364cr().mo4449e((String) map.get("title")).mo4450f((String) map.get("description")).mo4451g((String) map.get("caption")).mo4460p((String) map.get("cta")).mo4445a((String) map.get("icon_url")).mo4446b((String) map.get("image_url")).mo4448d((String) map.get("video_url")).mo4447c((String) map.get("star_rating_url")).mo4452h((String) map.get("icon_url")).mo4453i((String) map.get("image_url")).mo4454j((String) map.get("video_url")).mo4442a(Float.parseFloat((String) map.get("star_rating"))).mo4459o(str).mo4455k(m1087a(a2, str)).mo4456l(m1088a(a2, str, (String) map.get("event_id"))).mo4457m(m1090b(a2, str)).mo4458n(m1091c(a2, str)).mo4443a(Long.parseLong((String) map.get("ad_id"))).mo4444a(this.f763d).mo4441a();
            arrayList.add(a3);
            this.f763d.getLogger().mo4779d("TaskRenderNativeAd", "Prepared slot: " + a3.getAdId());
        }
        if (this.f1083a != null) {
            this.f1083a.onNativeAdsLoaded(arrayList);
        }
    }

    /* renamed from: b */
    private String m1090b(Map<String, String> map, String str) {
        String str2 = map.get("video_start_url");
        if (str2 != null) {
            return str2.replace("{CLCODE}", str);
        }
        return null;
    }

    /* renamed from: c */
    private String m1091c(Map<String, String> map, String str) {
        String str2 = map.get("video_end_url");
        if (str2 != null) {
            return str2.replace("{CLCODE}", str);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4696a(int i) {
        try {
            if (this.f1083a != null) {
                this.f1083a.onNativeAdsFailedToLoad(i);
            }
        } catch (Exception e) {
            this.f763d.getLogger().mo4781e("TaskRenderNativeAd", "Unable to notify listener about failure.", e);
        }
    }

    public void run() {
        try {
            if (this.f1084b == null || this.f1084b.length() == 0) {
                mo4696a((int) AppLovinErrorCodes.UNABLE_TO_PREPARE_NATIVE_AD);
            } else {
                m1089a(this.f1084b);
            }
        } catch (Exception e) {
            this.f763d.getLogger().mo4781e("TaskRenderNativeAd", "Unable to render widget.", e);
            mo4696a((int) AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES);
        }
    }
}
