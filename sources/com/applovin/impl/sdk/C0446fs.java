package com.applovin.impl.sdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.fs */
public class C0446fs {

    /* renamed from: a */
    public static final C0446fs f1123a = new C0446fs();

    /* renamed from: b */
    protected String f1124b;

    /* renamed from: c */
    protected final List<C0446fs> f1125c;

    /* renamed from: d */
    private final C0446fs f1126d;

    /* renamed from: e */
    private final String f1127e;

    /* renamed from: f */
    private final Map<String, String> f1128f;

    private C0446fs() {
        this.f1126d = null;
        this.f1127e = "";
        this.f1128f = Collections.emptyMap();
        this.f1124b = "";
        this.f1125c = Collections.emptyList();
    }

    public C0446fs(String str, Map<String, String> map, C0446fs fsVar) {
        this.f1126d = fsVar;
        this.f1127e = str;
        this.f1128f = Collections.unmodifiableMap(map);
        this.f1125c = new ArrayList();
    }

    /* renamed from: a */
    public String mo4735a() {
        return this.f1127e;
    }

    /* renamed from: a */
    public List<C0446fs> mo4736a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        ArrayList arrayList = new ArrayList(this.f1125c.size());
        for (C0446fs next : this.f1125c) {
            if (str.equalsIgnoreCase(next.mo4735a())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public C0446fs mo4737b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        for (C0446fs next : this.f1125c) {
            if (str.equalsIgnoreCase(next.mo4735a())) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: b */
    public Map<String, String> mo4738b() {
        return this.f1128f;
    }

    /* renamed from: c */
    public C0446fs mo4739c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        if (this.f1125c.size() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this);
            while (!arrayList.isEmpty()) {
                C0446fs fsVar = (C0446fs) arrayList.get(0);
                arrayList.remove(0);
                if (str.equalsIgnoreCase(fsVar.mo4735a())) {
                    return fsVar;
                }
                arrayList.addAll(fsVar.mo4741d());
            }
        }
        return null;
    }

    /* renamed from: c */
    public String mo4740c() {
        return this.f1124b;
    }

    /* renamed from: d */
    public List<C0446fs> mo4741d() {
        return Collections.unmodifiableList(this.f1125c);
    }

    public String toString() {
        return "XmlNode{, elementName='" + this.f1127e + '\'' + ", text='" + this.f1124b + '\'' + ", attributes=" + this.f1128f + '}';
    }
}
