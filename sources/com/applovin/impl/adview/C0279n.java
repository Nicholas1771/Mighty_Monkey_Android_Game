package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.p003a.C0180a;
import com.applovin.impl.p003a.C0185f;
import com.applovin.impl.p003a.C0188i;
import com.applovin.impl.p003a.C0189j;
import com.applovin.impl.sdk.C0296ad;
import com.applovin.impl.sdk.C0300ah;
import com.applovin.impl.sdk.C0391dr;
import com.applovin.impl.sdk.C0444fq;
import com.applovin.impl.sdk.C0445fr;
import com.applovin.impl.sdk.C0450g;
import com.applovin.impl.sdk.C0463t;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.adview.n */
class C0279n extends WebView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AppLovinLogger f379a;

    /* renamed from: b */
    private final AppLovinSdk f380b;

    /* renamed from: c */
    private AppLovinAd f381c = null;

    /* renamed from: d */
    private String f382d = null;

    /* renamed from: e */
    private boolean f383e = false;

    C0279n(C0207ah ahVar, AppLovinSdk appLovinSdk, Context context) {
        super(context);
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        this.f380b = appLovinSdk;
        this.f379a = appLovinSdk.getLogger();
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        setWebViewClient(ahVar);
        setWebChromeClient(new C0278m(appLovinSdk));
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(33554432);
        setOnTouchListener(new C0280o(this));
        setOnLongClickListener(new C0291z(this));
    }

    /* renamed from: a */
    private String m393a(String str, String str2, String str3) {
        if (C0444fq.isValidString(str)) {
            return C0444fq.m1160a(str3, str).replace("{SOURCE}", str2);
        }
        return null;
    }

    /* renamed from: a */
    private void m394a(C0296ad adVar) {
        Boolean n;
        Integer a;
        try {
            if (new C0391dr(this.f380b).mo4548G() || adVar.mo4276S()) {
                m395a((Runnable) new C0200aa(this));
            }
            if (C0463t.m1257e()) {
                m395a((Runnable) new C0201ab(this, adVar));
            }
            if (C0463t.m1258f() && adVar.mo4278U()) {
                m395a((Runnable) new C0202ac(this));
            }
            C0445fr V = adVar.mo4279V();
            if (V != null) {
                WebSettings settings = getSettings();
                WebSettings.PluginState b = V.mo4722b();
                if (b != null) {
                    m395a((Runnable) new C0203ad(this, settings, b));
                }
                Boolean c = V.mo4723c();
                if (c != null) {
                    m395a((Runnable) new C0204ae(this, settings, c));
                }
                Boolean d = V.mo4724d();
                if (d != null) {
                    m395a((Runnable) new C0205af(this, settings, d));
                }
                Boolean e = V.mo4725e();
                if (e != null) {
                    m395a((Runnable) new C0206ag(this, settings, e));
                }
                Boolean f = V.mo4726f();
                if (f != null) {
                    m395a((Runnable) new C0281p(this, settings, f));
                }
                Boolean g = V.mo4727g();
                if (g != null) {
                    m395a((Runnable) new C0282q(this, settings, g));
                }
                Boolean h = V.mo4728h();
                if (h != null) {
                    m395a((Runnable) new C0283r(this, settings, h));
                }
                Boolean i = V.mo4729i();
                if (i != null) {
                    m395a((Runnable) new C0284s(this, settings, i));
                }
                Boolean j = V.mo4730j();
                if (j != null) {
                    m395a((Runnable) new C0285t(this, settings, j));
                }
                Boolean k = V.mo4731k();
                if (k != null) {
                    m395a((Runnable) new C0286u(this, settings, k));
                }
                if (C0463t.m1256d()) {
                    Boolean l = V.mo4732l();
                    if (l != null) {
                        m395a((Runnable) new C0287v(this, settings, l));
                    }
                    Boolean m = V.mo4733m();
                    if (m != null) {
                        m395a((Runnable) new C0288w(this, settings, m));
                    }
                }
                if (C0463t.m1259g() && (a = V.mo4721a()) != null) {
                    m395a((Runnable) new C0289x(this, settings, a));
                }
                if (C0463t.m1260h() && (n = V.mo4734n()) != null) {
                    m395a((Runnable) new C0290y(this, settings, n));
                }
            }
        } catch (Throwable th) {
            this.f379a.mo4781e("AdWebView", "Unable to apply WebView settings", th);
        }
    }

    /* renamed from: a */
    private void m395a(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            this.f379a.mo4781e("AdWebView", "Unable to apply WebView setting", th);
        }
    }

    /* renamed from: a */
    private void m396a(String str, String str2, String str3, String str4, AppLovinSdk appLovinSdk) {
        String a = m393a(str3, str, str4);
        if (C0444fq.isValidString(a)) {
            this.f379a.mo4779d("AdWebView", "Rendering webview for VAST ad with resourceContents : " + a);
            loadDataWithBaseURL(str2, a, "text/html", (String) null, "");
            return;
        }
        String a2 = m393a(new C0391dr(appLovinSdk).mo4563V(), str, str4);
        if (C0444fq.isValidString(a2)) {
            this.f379a.mo4779d("AdWebView", "Rendering webview for VAST ad with resourceContents : " + a2);
            loadDataWithBaseURL(str2, a2, "text/html", (String) null, "");
            return;
        }
        this.f379a.mo4779d("AdWebView", "Rendering webview for VAST ad with resourceURL : " + str);
        loadUrl(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AppLovinAd mo4130a() {
        return this.f381c;
    }

    /* renamed from: a */
    public void mo4131a(AppLovinAd appLovinAd, String str) {
        if (!this.f383e) {
            this.f381c = appLovinAd;
            this.f382d = str;
            try {
                if (appLovinAd instanceof C0300ah) {
                    loadDataWithBaseURL("/", ((C0300ah) appLovinAd).mo4306a(), "text/html", (String) null, "");
                    this.f379a.mo4779d("AdWebView", "Empty ad rendered");
                    return;
                }
                C0296ad adVar = (C0296ad) appLovinAd;
                m394a(adVar);
                if (appLovinAd instanceof C0450g) {
                    loadDataWithBaseURL(adVar.mo4277T(), C0444fq.m1160a(str, ((C0450g) appLovinAd).mo3855a()), "text/html", (String) null, "");
                    this.f379a.mo4779d("AdWebView", "AppLovinAd rendered");
                } else if (appLovinAd instanceof C0180a) {
                    C0180a aVar = (C0180a) appLovinAd;
                    C0185f e = aVar.mo3865e();
                    if (e != null) {
                        C0188i b = e.mo3888b();
                        Uri b2 = b.mo3905b();
                        String uri = b2 != null ? b2.toString() : "";
                        String c = b.mo3906c();
                        String i = aVar.mo3871i();
                        C0391dr drVar = new C0391dr(this.f380b);
                        if (!C0444fq.isValidString(uri) && !C0444fq.isValidString(c)) {
                            this.f379a.mo4780e("AdWebView", "Unable to load companion ad. No resources provided.");
                        } else if (b.mo3902a() == C0189j.STATIC) {
                            this.f379a.mo4779d("AdWebView", "Rendering WebView for static VAST ad");
                            loadDataWithBaseURL(adVar.mo4277T(), m393a(drVar.mo4562U(), uri, str), "text/html", (String) null, "");
                        } else if (b.mo3902a() == C0189j.HTML) {
                            if (C0444fq.isValidString(c)) {
                                String a = m393a(i, c, str);
                                if (!C0444fq.isValidString(a)) {
                                    a = c;
                                }
                                this.f379a.mo4779d("AdWebView", "Rendering WebView for HTML VAST ad with resourceContents: " + a);
                                loadDataWithBaseURL(adVar.mo4277T(), a, "text/html", (String) null, "");
                            } else if (C0444fq.isValidString(uri)) {
                                this.f379a.mo4779d("AdWebView", "Preparing to load HTML VAST ad resourceUri");
                                m396a(uri, adVar.mo4277T(), i, str, this.f380b);
                            }
                        } else if (b.mo3902a() != C0189j.IFRAME) {
                            this.f379a.mo4780e("AdWebView", "Failed to render VAST companion ad of invalid type");
                        } else if (C0444fq.isValidString(uri)) {
                            this.f379a.mo4779d("AdWebView", "Preparing to load iFrame VAST ad resourceUri");
                            m396a(uri, adVar.mo4277T(), i, str, this.f380b);
                        } else if (C0444fq.isValidString(c)) {
                            String a2 = m393a(i, c, str);
                            if (!C0444fq.isValidString(a2)) {
                                a2 = c;
                            }
                            this.f379a.mo4779d("AdWebView", "Rendering WebView for iFrame VAST ad with resourceContents: " + a2);
                            loadDataWithBaseURL(adVar.mo4277T(), a2, "text/html", (String) null, "");
                        }
                    } else {
                        this.f379a.mo4779d("AdWebView", "No companion ad provided.");
                    }
                }
            } catch (Throwable th) {
                this.f379a.mo4781e("AdWebView", "Unable to render AppLovinAd with placement = \"" + str + "\"", th);
            }
        } else {
            this.f379a.userError("AdWebView", "Ad can not be loaded in a destroyed webview");
        }
    }

    /* renamed from: a */
    public void mo4132a(String str) {
        mo4133a(str, (Runnable) null);
    }

    /* renamed from: a */
    public void mo4133a(String str, Runnable runnable) {
        try {
            this.f379a.mo4779d("AdWebView", "Forwarding \"" + str + "\" to ad template");
            loadUrl(str);
        } catch (Throwable th) {
            this.f379a.mo4781e("AdWebView", "Unable to forward to template", th);
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo4134b() {
        return this.f382d;
    }

    public void computeScroll() {
    }

    public void destroy() {
        this.f383e = true;
        try {
            super.destroy();
            this.f379a.mo4779d("AdWebView", "Web view destroyed");
        } catch (Throwable th) {
            if (this.f379a != null) {
                this.f379a.mo4781e("AdWebView", "destroy() threw exception", th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        try {
            super.onFocusChanged(z, i, rect);
        } catch (Exception e) {
            this.f379a.mo4781e("AdWebView", "onFocusChanged() threw exception", e);
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
    }

    public void onWindowFocusChanged(boolean z) {
        try {
            super.onWindowFocusChanged(z);
        } catch (Exception e) {
            this.f379a.mo4781e("AdWebView", "onWindowFocusChanged() threw exception", e);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        try {
            super.onWindowVisibilityChanged(i);
        } catch (Exception e) {
            this.f379a.mo4781e("AdWebView", "onWindowVisibilityChanged() threw exception", e);
        }
    }

    public boolean requestFocus(int i, Rect rect) {
        try {
            return super.requestFocus(i, rect);
        } catch (Exception e) {
            this.f379a.mo4781e("AdWebView", "requestFocus() threw exception", e);
            return false;
        }
    }

    public void scrollTo(int i, int i2) {
    }
}
