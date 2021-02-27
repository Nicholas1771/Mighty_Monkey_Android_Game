package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinAd;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.cs */
public class C0365cs extends C0381dh {
    public C0365cs(AppLovinSdkImpl appLovinSdkImpl) {
        super(appLovinSdkImpl);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0386dm mo4461a(C0451h hVar) {
        C0412el elVar = new C0412el(this.f746a, 1, this);
        elVar.mo4670a(true);
        return elVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0451h mo4462a(C0344by byVar) {
        return C0451h.f1142h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map<C0451h, C0382di> mo4463a() {
        HashMap hashMap = new HashMap(1);
        hashMap.put(C0451h.f1142h, new C0382di(((Integer) this.f746a.get(C0387dn.f888bq)).intValue()));
        return hashMap;
    }

    /* renamed from: a */
    public void mo4308a(C0451h hVar, int i) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4464a(Object obj, C0344by byVar) {
        AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = (AppLovinNativeAdLoadListener) obj;
        appLovinNativeAdLoadListener.onNativeAdsLoaded(Arrays.asList(new AppLovinNativeAd[]{(AppLovinNativeAd) byVar}));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4465a(Object obj, C0451h hVar, int i) {
        ((AppLovinNativeAdLoadListener) obj).onNativeAdsFailedToLoad(i);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo4466a(C0451h hVar, Object obj) {
        return super.mo4466a(hVar, obj);
    }

    public void adReceived(AppLovinAd appLovinAd) {
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ C0344by mo4467b(C0451h hVar) {
        return super.mo4467b(hVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Map<C0451h, C0382di> mo4468b() {
        return Collections.EMPTY_MAP;
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo4469b(C0451h hVar, Object obj) {
        super.mo4469b(hVar, obj);
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ C0344by mo4470c(C0451h hVar) {
        return super.mo4470c(hVar);
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ C0344by mo4471d(C0451h hVar) {
        return super.mo4471d(hVar);
    }

    /* renamed from: e */
    public /* bridge */ /* synthetic */ boolean mo4472e(C0451h hVar) {
        return super.mo4472e(hVar);
    }

    /* renamed from: f */
    public /* bridge */ /* synthetic */ void mo4473f(C0451h hVar) {
        super.mo4473f(hVar);
    }

    public void failedToReceiveAd(int i) {
    }

    /* renamed from: g */
    public /* bridge */ /* synthetic */ boolean mo4474g(C0451h hVar) {
        return super.mo4474g(hVar);
    }

    /* renamed from: h */
    public /* bridge */ /* synthetic */ void mo4475h(C0451h hVar) {
        super.mo4475h(hVar);
    }

    public void onNativeAdsFailedToLoad(int i) {
        mo4507b(C0451h.f1142h, i);
    }

    public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
        AppLovinNativeAd appLovinNativeAd = list.get(0);
        if (((Boolean) this.f746a.get(C0387dn.f867bV)).booleanValue()) {
            this.f746a.getNativeAdService().precacheResources(appLovinNativeAd, new C0366ct(this));
        } else {
            mo4508c((C0344by) appLovinNativeAd);
        }
    }
}
