package com.applovin.impl.adview;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

/* renamed from: com.applovin.impl.adview.cm */
public class C0266cm extends WebViewClient {

    /* renamed from: a */
    private final AppLovinSdk f358a;

    /* renamed from: b */
    private final AppLovinLogger f359b;

    /* renamed from: c */
    private WeakReference<C0267cn> f360c;

    public C0266cm(AppLovinSdk appLovinSdk) {
        this.f358a = appLovinSdk;
        this.f359b = appLovinSdk.getLogger();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4105a(WebView webView, String str) {
        this.f359b.mo4782i("WebViewButtonClient", "Processing click on ad URL \"" + str + "\"");
        if (str != null && (webView instanceof C0265cl)) {
            C0265cl clVar = (C0265cl) webView;
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            String path = parse.getPath();
            C0267cn cnVar = (C0267cn) this.f360c.get();
            if (AppLovinSdk.URI_SCHEME.equalsIgnoreCase(scheme) && AppLovinSdk.URI_HOST.equalsIgnoreCase(host) && cnVar != null) {
                if ("/track_click".equals(path)) {
                    cnVar.mo4045a(clVar);
                } else if ("/close_ad".equals(path)) {
                    cnVar.mo4046b(clVar);
                } else if ("/skip_ad".equals(path)) {
                    cnVar.mo4047c(clVar);
                } else {
                    this.f359b.mo4785w("WebViewButtonClient", "Unknown URL: " + str);
                    this.f359b.mo4785w("WebViewButtonClient", "Path: " + path);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo4106a(WeakReference<C0267cn> weakReference) {
        this.f360c = weakReference;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        mo4105a(webView, str);
        return true;
    }
}
