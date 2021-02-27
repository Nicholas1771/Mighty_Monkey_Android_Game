package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeAdImpl implements C0303ak, C0344by {
    public static final String QUERY_PARAM_IS_FIRST_PLAY = "fp";
    public static final String QUERY_PARAM_VIDEO_PERCENT_VIEWED = "pv";

    /* renamed from: a */
    private final AppLovinSdkImpl f455a;

    /* renamed from: b */
    private String f456b;

    /* renamed from: c */
    private String f457c;

    /* renamed from: d */
    private String f458d;

    /* renamed from: e */
    private String f459e;

    /* renamed from: f */
    private String f460f;

    /* renamed from: g */
    private String f461g;

    /* renamed from: h */
    private String f462h;

    /* renamed from: i */
    private String f463i;

    /* renamed from: j */
    private String f464j;

    /* renamed from: k */
    private String f465k;

    /* renamed from: l */
    private float f466l;

    /* renamed from: m */
    private String f467m;

    /* renamed from: n */
    private String f468n;

    /* renamed from: o */
    private String f469o;

    /* renamed from: p */
    private String f470p;

    /* renamed from: q */
    private String f471q;

    /* renamed from: r */
    private String f472r;

    /* renamed from: s */
    private long f473s;

    /* renamed from: t */
    private AtomicBoolean f474t;

    private NativeAdImpl(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, float f, String str10, String str11, String str12, String str13, String str14, String str15, String str16, long j, AppLovinSdkImpl appLovinSdkImpl) {
        this.f474t = new AtomicBoolean();
        this.f456b = str;
        this.f457c = str2;
        this.f458d = str3;
        this.f459e = str4;
        this.f460f = str5;
        this.f461g = str6;
        this.f462h = str7;
        this.f464j = str8;
        this.f465k = str9;
        this.f466l = f;
        this.f467m = str10;
        this.f468n = str11;
        this.f469o = str12;
        this.f470p = str13;
        this.f471q = str14;
        this.f472r = str15;
        this.f463i = str16;
        this.f473s = j;
        this.f455a = appLovinSdkImpl;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NativeAdImpl nativeAdImpl = (NativeAdImpl) obj;
        if (this.f462h == null ? nativeAdImpl.f462h != null : !this.f462h.equals(nativeAdImpl.f462h)) {
            return false;
        }
        if (this.f472r == null ? nativeAdImpl.f472r != null : !this.f472r.equals(nativeAdImpl.f472r)) {
            return false;
        }
        if (this.f469o == null ? nativeAdImpl.f469o != null : !this.f469o.equals(nativeAdImpl.f469o)) {
            return false;
        }
        if (this.f463i == null ? nativeAdImpl.f463i != null : !this.f463i.equals(nativeAdImpl.f463i)) {
            return false;
        }
        if (this.f461g == null ? nativeAdImpl.f461g != null : !this.f461g.equals(nativeAdImpl.f461g)) {
            return false;
        }
        if (this.f468n == null ? nativeAdImpl.f468n != null : !this.f468n.equals(nativeAdImpl.f468n)) {
            return false;
        }
        if (this.f456b == null ? nativeAdImpl.f456b != null : !this.f456b.equals(nativeAdImpl.f456b)) {
            return false;
        }
        if (this.f457c == null ? nativeAdImpl.f457c != null : !this.f457c.equals(nativeAdImpl.f457c)) {
            return false;
        }
        if (this.f458d == null ? nativeAdImpl.f458d != null : !this.f458d.equals(nativeAdImpl.f458d)) {
            return false;
        }
        if (this.f459e == null ? nativeAdImpl.f459e != null : !this.f459e.equals(nativeAdImpl.f459e)) {
            return false;
        }
        if (this.f460f == null ? nativeAdImpl.f460f != null : !this.f460f.equals(nativeAdImpl.f460f)) {
            return false;
        }
        if (this.f471q == null ? nativeAdImpl.f471q != null : !this.f471q.equals(nativeAdImpl.f471q)) {
            return false;
        }
        if (this.f470p != null) {
            if (this.f470p.equals(nativeAdImpl.f470p)) {
                return true;
            }
        } else if (nativeAdImpl.f470p == null) {
            return true;
        }
        return false;
    }

    public long getAdId() {
        return this.f473s;
    }

    public String getCaptionText() {
        return this.f462h;
    }

    public String getClCode() {
        return this.f472r;
    }

    public String getClickUrl() {
        return this.f469o;
    }

    public String getCtaText() {
        return this.f463i;
    }

    public String getDescriptionText() {
        return this.f461g;
    }

    public String getIconUrl() {
        return this.f464j;
    }

    public String getImageUrl() {
        return this.f465k;
    }

    public String getImpressionTrackingUrl() {
        return this.f468n;
    }

    public String getSourceIconUrl() {
        return this.f456b;
    }

    public String getSourceImageUrl() {
        return this.f457c;
    }

    public String getSourceStarRatingImageUrl() {
        return this.f458d;
    }

    public String getSourceVideoUrl() {
        return this.f459e;
    }

    public float getStarRating() {
        return this.f466l;
    }

    public String getTitle() {
        return this.f460f;
    }

    public String getVideoEndTrackingUrl(int i, boolean z) {
        if (this.f471q == null) {
            return Uri.EMPTY.toString();
        }
        if (i < 0 || i > 100) {
            this.f455a.getLogger().userError("AppLovinNativeAd", "Invalid percent viewed supplied.", new IllegalArgumentException("Percent viewed must be an integer between 0 and 100."));
        }
        return Uri.parse(this.f471q).buildUpon().appendQueryParameter(QUERY_PARAM_VIDEO_PERCENT_VIEWED, Integer.toString(i)).appendQueryParameter(QUERY_PARAM_IS_FIRST_PLAY, Boolean.toString(z)).build().toString();
    }

    public String getVideoStartTrackingUrl() {
        return this.f470p;
    }

    public String getVideoUrl() {
        return this.f467m;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f471q != null ? this.f471q.hashCode() : 0) + (((this.f470p != null ? this.f470p.hashCode() : 0) + (((this.f469o != null ? this.f469o.hashCode() : 0) + (((this.f468n != null ? this.f468n.hashCode() : 0) + (((this.f463i != null ? this.f463i.hashCode() : 0) + (((this.f462h != null ? this.f462h.hashCode() : 0) + (((this.f461g != null ? this.f461g.hashCode() : 0) + (((this.f460f != null ? this.f460f.hashCode() : 0) + (((this.f459e != null ? this.f459e.hashCode() : 0) + (((this.f458d != null ? this.f458d.hashCode() : 0) + (((this.f457c != null ? this.f457c.hashCode() : 0) + ((this.f456b != null ? this.f456b.hashCode() : 0) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f472r != null) {
            i = this.f472r.hashCode();
        }
        return hashCode + i;
    }

    public boolean isImagePrecached() {
        return (this.f464j != null && !this.f464j.equals(this.f456b)) && (this.f465k != null && !this.f465k.equals(this.f457c));
    }

    public boolean isVideoPrecached() {
        return this.f467m != null && !this.f467m.equals(this.f459e);
    }

    public void launchClickTarget(Context context) {
        this.f455a.getPersistentPostbackManager().mo4491a(this.f469o);
        AppLovinSdkUtils.openUrl(context, this.f469o, this.f455a);
    }

    public void setIconUrl(String str) {
        this.f464j = str;
    }

    public void setImageUrl(String str) {
        this.f465k = str;
    }

    public void setStarRating(float f) {
        this.f466l = f;
    }

    public void setVideoUrl(String str) {
        this.f467m = str;
    }

    public String toString() {
        return "WidgetSlot{clCode='" + this.f472r + '\'' + ", sourceIconUrl='" + this.f456b + '\'' + ", sourceImageUrl='" + this.f457c + '\'' + ", sourceStarRatingImageUrl='" + this.f458d + '\'' + ", sourceVideoUrl='" + this.f459e + '\'' + ", title='" + this.f460f + '\'' + ", descriptionText='" + this.f461g + '\'' + ", captionText='" + this.f462h + '\'' + ", ctaText='" + this.f463i + '\'' + ", iconUrl='" + this.f464j + '\'' + ", imageUrl='" + this.f465k + '\'' + ", starRating='" + this.f466l + '\'' + ", videoUrl='" + this.f467m + '\'' + ", impressionTrackingUrl='" + this.f468n + '\'' + ", clickUrl='" + this.f469o + '\'' + ", videoStartTrackingUrl='" + this.f470p + '\'' + ", videoEndTrackingUrl='" + this.f471q + '\'' + '}';
    }

    public void trackImpression() {
        trackImpression((AppLovinPostbackListener) null);
    }

    public void trackImpression(AppLovinPostbackListener appLovinPostbackListener) {
        if (!this.f474t.getAndSet(true)) {
            this.f455a.getLogger().mo4779d("AppLovinNativeAd", "Tracking impression...");
            this.f455a.getPostbackService().dispatchPostbackAsync(this.f468n, appLovinPostbackListener);
        } else if (appLovinPostbackListener != null) {
            appLovinPostbackListener.onPostbackFailure(this.f468n, AppLovinErrorCodes.NATIVE_AD_IMPRESSION_ALREADY_TRACKED);
        }
    }
}
