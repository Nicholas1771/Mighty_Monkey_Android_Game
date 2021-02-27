package com.applovin.impl.sdk;

import android.util.Xml;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/* renamed from: com.applovin.impl.sdk.ft */
class C0447ft {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AppLovinLogger f1129a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Stack<C0449fv> f1130b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public StringBuilder f1131c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f1132d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C0449fv f1133e;

    C0447ft(AppLovinSdk appLovinSdk) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        this.f1129a = appLovinSdk.getLogger();
    }

    /* renamed from: a */
    static C0446fs m1197a(String str, AppLovinSdk appLovinSdk) throws SAXException {
        return new C0447ft(appLovinSdk).mo4743a(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, String> m1201a(Attributes attributes) {
        if (attributes == null) {
            return Collections.emptyMap();
        }
        int length = attributes.getLength();
        HashMap hashMap = new HashMap(length);
        for (int i = 0; i < length; i++) {
            hashMap.put(attributes.getQName(i), attributes.getValue(i));
        }
        return hashMap;
    }

    /* renamed from: a */
    public C0446fs mo4743a(String str) throws SAXException {
        if (str == null) {
            throw new IllegalArgumentException("Unable to parse. No XML specified.");
        }
        this.f1131c = new StringBuilder();
        this.f1130b = new Stack<>();
        this.f1133e = null;
        Xml.parse(str, new C0448fu(this));
        if (this.f1133e != null) {
            return this.f1133e;
        }
        throw new SAXException("Unable to parse XML into node");
    }
}
