package com.applovin.impl.adview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.ViewParent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.p003a.C0180a;
import com.applovin.impl.p003a.C0185f;
import com.applovin.impl.p003a.C0193n;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.AppLovinSdkImpl;
import com.applovin.impl.sdk.C0330bk;
import com.applovin.impl.sdk.C0391dr;
import com.applovin.impl.sdk.C0444fq;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.util.List;

/* renamed from: com.applovin.impl.adview.ah */
class C0207ah extends WebViewClient {

    /* renamed from: a */
    private final AppLovinSdk f180a;

    /* renamed from: b */
    private final AppLovinLogger f181b;

    /* renamed from: c */
    private final AdViewControllerImpl f182c;

    public C0207ah(AdViewControllerImpl adViewControllerImpl, AppLovinSdk appLovinSdk) {
        this.f180a = appLovinSdk;
        this.f181b = appLovinSdk.getLogger();
        this.f182c = adViewControllerImpl;
    }

    /* renamed from: a */
    private void m163a(Uri uri, C0279n nVar) {
        try {
            String queryParameter = uri.getQueryParameter("n");
            if (C0444fq.isValidString(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("load_type");
                if ("external".equalsIgnoreCase(queryParameter2)) {
                    this.f181b.mo4779d("AdWebViewClient", "Loading new page externally: " + queryParameter);
                    C0444fq.openUrl(nVar.getContext(), queryParameter, this.f180a);
                    C0330bk.m652c(this.f182c.getAdViewEventListener(), this.f182c.getCurrentAd(), this.f182c.getParentView(), this.f180a);
                } else if ("internal".equalsIgnoreCase(queryParameter2)) {
                    this.f181b.mo4779d("AdWebViewClient", "Loading new page in WebView: " + queryParameter);
                    nVar.loadUrl(queryParameter);
                    String queryParameter3 = uri.getQueryParameter("bg_color");
                    if (C0444fq.isValidString(queryParameter3)) {
                        nVar.setBackgroundColor(Color.parseColor(queryParameter3));
                    }
                } else {
                    this.f181b.mo4780e("AdWebViewClient", "Could not find load type in original uri");
                }
            } else {
                this.f181b.mo4780e("AdWebViewClient", "Could not find url to load from query in original uri");
            }
        } catch (Throwable th) {
            this.f181b.mo4780e("AdWebViewClient", "Failed to load new page from query in original uri");
        }
    }

    /* renamed from: a */
    private void m164a(C0279n nVar, Uri uri) {
        AppLovinAd a = nVar.mo4130a();
        String b = nVar.mo4134b();
        AppLovinAdView parentView = this.f182c.getParentView();
        if (parentView == null || a == null) {
            this.f181b.mo4780e("AdWebViewClient", "Attempting to track click that is null or not an ApplovinAdView instance for clickedUri = " + uri);
        } else {
            this.f182c.mo3941a(a, b, parentView, uri);
        }
    }

    /* renamed from: c */
    private void m165c(C0279n nVar) {
        this.f182c.expandAd();
    }

    /* renamed from: d */
    private void m166d(C0279n nVar) {
        this.f182c.contractAd();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3962a(C0279n nVar) {
        ViewParent parent = nVar.getParent();
        if (parent instanceof AppLovinAdView) {
            ((AppLovinAdView) parent).loadNextAd();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3963a(WebView webView, String str, boolean z) {
        this.f181b.mo4782i("AdWebViewClient", "Processing click on ad URL \"" + str + "\"");
        if (str != null && (webView instanceof C0279n)) {
            Uri parse = Uri.parse(str);
            C0279n nVar = (C0279n) webView;
            String scheme = parse.getScheme();
            String host = parse.getHost();
            String path = parse.getPath();
            AppLovinAd currentAd = this.f182c.getCurrentAd();
            if (!AppLovinSdk.URI_SCHEME.equals(scheme) || !AppLovinSdk.URI_HOST.equals(host)) {
                if (!z) {
                    return false;
                }
                m164a(nVar, parse);
            } else if (AppLovinAdService.URI_NEXT_AD.equals(path)) {
                mo3962a(nVar);
            } else if (AppLovinAdService.URI_CLOSE_AD.equals(path)) {
                mo3964b(nVar);
            } else if (AppLovinAdService.URI_EXPAND_AD.equals(path)) {
                m165c(nVar);
            } else if (AppLovinAdService.URI_CONTRACT_AD.equals(path)) {
                m166d(nVar);
            } else if (AppLovinAdServiceImpl.URI_NO_OP.equals(path)) {
                return true;
            } else {
                if (AppLovinAdServiceImpl.URI_LOAD_URL.equals(path)) {
                    m163a(parse, nVar);
                } else if (AppLovinAdServiceImpl.URI_TRACK_CLICK_IMMEDIATELY.equals(path)) {
                    if (currentAd instanceof C0180a) {
                        C0185f e = ((C0180a) currentAd).mo3865e();
                        if (e != null) {
                            C0193n.m109a(e.mo3889c(), (AppLovinSdkImpl) this.f182c.getSdk());
                            m164a(nVar, e.mo3887a());
                        }
                    } else {
                        m164a(nVar, Uri.parse(AppLovinAdServiceImpl.URI_TRACK_CLICK_IMMEDIATELY));
                    }
                } else if (path == null || !path.startsWith("/launch/")) {
                    this.f181b.mo4785w("AdWebViewClient", "Unknown URL: " + str);
                    this.f181b.mo4785w("AdWebViewClient", "Path: " + path);
                } else {
                    List<String> pathSegments = parse.getPathSegments();
                    if (pathSegments != null && pathSegments.size() > 1) {
                        String str2 = pathSegments.get(pathSegments.size() - 1);
                        try {
                            Context context = webView.getContext();
                            context.startActivity(context.getPackageManager().getLaunchIntentForPackage(str2));
                            m164a(nVar, (Uri) null);
                        } catch (Exception e2) {
                            this.f181b.mo4781e("AdWebViewClient", "Threw Exception Trying to Launch App for Package: " + str2, e2);
                        }
                    }
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3964b(C0279n nVar) {
        this.f182c.mo3938a();
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f182c.onAdHtmlLoaded(webView);
    }

    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        boolean hasGesture = new C0391dr(this.f180a).mo4577ai() ? webResourceRequest.hasGesture() : true;
        Uri url = webResourceRequest.getUrl();
        if (url != null) {
            return mo3963a(webView, url.toString(), hasGesture);
        }
        this.f181b.mo4780e("AdWebViewClient", "No url found for request");
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return mo3963a(webView, str, true);
    }
}
