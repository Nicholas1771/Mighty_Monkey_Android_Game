package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.f */
public class C0427f extends C0381dh {
    C0427f(AppLovinSdkImpl appLovinSdkImpl) {
        super(appLovinSdkImpl);
    }

    /* renamed from: a */
    private Map<C0451h, C0382di> m1065a(boolean z) {
        Collection<C0451h> d = C0451h.m1224d();
        HashMap hashMap = new HashMap(d.size() - 1);
        for (C0451h next : d) {
            if (!next.equals(C0451h.f1142h)) {
                hashMap.put(next, new C0382di(((Integer) this.f746a.get(z ? m1067k(next) : m1066j(next))).intValue()));
            }
        }
        return hashMap;
    }

    /* renamed from: j */
    private static C0389dp<Integer> m1066j(C0451h hVar) {
        AppLovinAdSize a = hVar.mo4765a();
        if (hVar.mo4766b() == AppLovinAdType.REGULAR) {
            if (a.equals(AppLovinAdSize.BANNER)) {
                if (hVar.mo4767c() == C0452i.DIRECT) {
                    return C0387dn.f833ao;
                }
                if (hVar.mo4767c() == C0452i.INDIRECT) {
                    return C0387dn.f834ap;
                }
            } else if (a.equals(AppLovinAdSize.MREC)) {
                if (hVar.mo4767c() == C0452i.DIRECT) {
                    return C0387dn.f835aq;
                }
                if (hVar.mo4767c() == C0452i.INDIRECT) {
                    return C0387dn.f836ar;
                }
            } else if (a.equals(AppLovinAdSize.INTERSTITIAL)) {
                if (hVar.mo4767c() == C0452i.DIRECT) {
                    return C0387dn.f837as;
                }
                if (hVar.mo4767c() == C0452i.INDIRECT) {
                    return C0387dn.f838at;
                }
            } else if (a.equals(AppLovinAdSize.LEADER)) {
                if (hVar.mo4767c() == C0452i.DIRECT) {
                    return C0387dn.f839au;
                }
                if (hVar.mo4767c() == C0452i.INDIRECT) {
                    return C0387dn.f840av;
                }
            }
        } else if (hVar.mo4766b() == AppLovinAdType.INCENTIVIZED) {
            if (hVar.mo4767c() == C0452i.DIRECT) {
                return C0387dn.f841aw;
            }
            if (hVar.mo4767c() == C0452i.INDIRECT) {
                return C0387dn.f842ax;
            }
        }
        return C0387dn.f833ao;
    }

    /* renamed from: k */
    private static C0389dp<Integer> m1067k(C0451h hVar) {
        AppLovinAdSize a = hVar.mo4765a();
        if (hVar.mo4766b() == AppLovinAdType.REGULAR) {
            if (a.equals(AppLovinAdSize.BANNER)) {
                if (hVar.mo4767c() == C0452i.DIRECT) {
                    return C0387dn.f843ay;
                }
                if (hVar.mo4767c() == C0452i.INDIRECT) {
                    return C0387dn.f844az;
                }
            } else if (a.equals(AppLovinAdSize.MREC)) {
                if (hVar.mo4767c() == C0452i.DIRECT) {
                    return C0387dn.f793aA;
                }
                if (hVar.mo4767c() == C0452i.INDIRECT) {
                    return C0387dn.f794aB;
                }
            } else if (a.equals(AppLovinAdSize.INTERSTITIAL)) {
                if (hVar.mo4767c() == C0452i.DIRECT) {
                    return C0387dn.f795aC;
                }
                if (hVar.mo4767c() == C0452i.INDIRECT) {
                    return C0387dn.f796aD;
                }
            } else if (a.equals(AppLovinAdSize.LEADER)) {
                if (hVar.mo4767c() == C0452i.DIRECT) {
                    return C0387dn.f797aE;
                }
                if (hVar.mo4767c() == C0452i.INDIRECT) {
                    return C0387dn.f798aF;
                }
            }
        } else if (hVar.mo4766b() == AppLovinAdType.INCENTIVIZED) {
            if (hVar.mo4767c() == C0452i.DIRECT) {
                return C0387dn.f799aG;
            }
            if (hVar.mo4767c() == C0452i.INDIRECT) {
                return C0387dn.f800aH;
            }
        }
        return C0387dn.f843ay;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0386dm mo4461a(C0451h hVar) {
        C0410ej ejVar = new C0410ej(hVar, this, this.f746a);
        ejVar.mo4670a(true);
        return ejVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0451h mo4462a(C0344by byVar) {
        return ((C0453j) byVar).mo4292m();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map<C0451h, C0382di> mo4463a() {
        return m1065a(false);
    }

    /* renamed from: a */
    public void mo4308a(C0451h hVar, int i) {
        mo4507b(hVar, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4464a(Object obj, C0344by byVar) {
        ((AppLovinAdLoadListener) obj).adReceived((AppLovinAd) byVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4465a(Object obj, C0451h hVar, int i) {
        if (obj instanceof C0302aj) {
            ((C0302aj) obj).mo4308a(hVar, i);
        }
        if (obj instanceof AppLovinAdLoadListener) {
            ((AppLovinAdLoadListener) obj).failedToReceiveAd(i);
        }
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo4466a(C0451h hVar, Object obj) {
        return super.mo4466a(hVar, obj);
    }

    public void adReceived(AppLovinAd appLovinAd) {
        mo4508c((C0344by) appLovinAd);
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ C0344by mo4467b(C0451h hVar) {
        return super.mo4467b(hVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Map<C0451h, C0382di> mo4468b() {
        return m1065a(true);
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
    }

    public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
    }
}
