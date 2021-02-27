package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/* renamed from: com.applovin.impl.sdk.h */
public class C0451h {

    /* renamed from: a */
    public static final C0451h f1135a = m1223a(AppLovinAdType.REGULAR, C0452i.DIRECT, AppLovinAdSize.BANNER);

    /* renamed from: b */
    public static final C0451h f1136b = m1223a(AppLovinAdType.REGULAR, C0452i.DIRECT, AppLovinAdSize.MREC);

    /* renamed from: c */
    public static final C0451h f1137c = m1223a(AppLovinAdType.REGULAR, C0452i.DIRECT, AppLovinAdSize.LEADER);

    /* renamed from: d */
    public static final C0451h f1138d = m1223a(AppLovinAdType.REGULAR, C0452i.DIRECT, AppLovinAdSize.INTERSTITIAL);

    /* renamed from: e */
    public static final C0451h f1139e = m1223a(AppLovinAdType.REGULAR, C0452i.INDIRECT, AppLovinAdSize.INTERSTITIAL);

    /* renamed from: f */
    public static final C0451h f1140f = m1223a(AppLovinAdType.INCENTIVIZED, C0452i.DIRECT, AppLovinAdSize.INTERSTITIAL);

    /* renamed from: g */
    public static final C0451h f1141g = m1223a(AppLovinAdType.INCENTIVIZED, C0452i.INDIRECT, AppLovinAdSize.INTERSTITIAL);

    /* renamed from: h */
    public static final C0451h f1142h = m1223a(AppLovinAdType.NATIVE, C0452i.DIRECT, AppLovinAdSize.NATIVE);

    /* renamed from: i */
    private static final Collection<C0451h> f1143i = new HashSet();

    /* renamed from: j */
    private final AppLovinAdSize f1144j;

    /* renamed from: k */
    private final AppLovinAdType f1145k;

    /* renamed from: l */
    private final C0452i f1146l;

    public C0451h(AppLovinAdType appLovinAdType, C0452i iVar, AppLovinAdSize appLovinAdSize) {
        if (appLovinAdSize == null) {
            throw new IllegalArgumentException("No size specified");
        } else if (appLovinAdType == null) {
            throw new IllegalArgumentException("No type specified");
        } else if (iVar == null) {
            throw new IllegalArgumentException("No mediation type specified");
        } else {
            this.f1144j = appLovinAdSize;
            this.f1145k = appLovinAdType;
            this.f1146l = iVar;
        }
    }

    /* renamed from: a */
    private static C0451h m1223a(AppLovinAdType appLovinAdType, C0452i iVar, AppLovinAdSize appLovinAdSize) {
        C0451h hVar = new C0451h(appLovinAdType, iVar, appLovinAdSize);
        f1143i.add(hVar);
        return hVar;
    }

    /* renamed from: d */
    public static Collection<C0451h> m1224d() {
        return Collections.unmodifiableCollection(f1143i);
    }

    /* renamed from: a */
    public AppLovinAdSize mo4765a() {
        return this.f1144j;
    }

    /* renamed from: b */
    public AppLovinAdType mo4766b() {
        return this.f1145k;
    }

    /* renamed from: c */
    public C0452i mo4767c() {
        return this.f1146l;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0451h hVar = (C0451h) obj;
        if (this.f1144j != null) {
            if (!this.f1144j.equals(hVar.f1144j)) {
                return false;
            }
        } else if (hVar.f1144j != null) {
            return false;
        }
        if (this.f1145k != null) {
            if (!this.f1145k.equals(hVar.f1145k)) {
                return false;
            }
        } else if (hVar.f1145k != null) {
            return false;
        }
        if (this.f1146l != hVar.f1146l) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f1145k != null ? this.f1145k.hashCode() : 0) + ((this.f1144j != null ? this.f1144j.hashCode() : 0) * 31)) * 31;
        if (this.f1146l != null) {
            i = this.f1146l.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "[" + this.f1145k.getLabel() + " " + this.f1146l + " " + this.f1144j.getLabel() + "]";
    }
}
