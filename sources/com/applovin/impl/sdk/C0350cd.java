package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinLogger;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.applovin.impl.sdk.cd */
class C0350cd {

    /* renamed from: a */
    private final String f652a;

    /* renamed from: b */
    private final String f653b;

    C0350cd(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified");
        } else if (str2 == null) {
            throw new IllegalArgumentException("No classname specified");
        } else {
            this.f652a = str.toLowerCase();
            this.f653b = str2;
        }
    }

    /* renamed from: a */
    static C0350cd m680a(String str, AppLovinLogger appLovinLogger) {
        if (!C0444fq.isValidString(str)) {
            return null;
        }
        if (str.contains(":")) {
            try {
                int indexOf = str.indexOf(58);
                if (indexOf > 0 && indexOf < str.length() - 1) {
                    return new C0350cd(str.substring(0, indexOf).toLowerCase(), str.substring(indexOf + 1, str.length()));
                }
                appLovinLogger.userError("MediationAdapterManager", "Unable to parse config '" + str + "': malformed string");
                return null;
            } catch (Throwable th) {
                appLovinLogger.userError("MediationAdapterManager", "Unable to parse config '" + str + "'", th);
                return null;
            }
        } else {
            String lowerCase = str.toLowerCase();
            if (C0349cc.f645a.containsKey(lowerCase)) {
                return new C0350cd(lowerCase, (String) C0349cc.f645a.get(lowerCase));
            }
            appLovinLogger.userError("MediationAdapterManager", "Unable to create config '" + str + "': unknown name");
            return null;
        }
    }

    /* renamed from: a */
    static String m681a(Collection<C0350cd> collection) {
        if (collection == null || collection.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (C0350cd c : collection) {
            sb.append(c.mo4411c());
            sb.append(',');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    /* renamed from: b */
    static Collection<C0350cd> m682b(String str, AppLovinLogger appLovinLogger) {
        if (appLovinLogger == null) {
            throw new IllegalArgumentException("No logger specified");
        }
        ArrayList arrayList = new ArrayList();
        for (String a : C0462s.m1246a(str)) {
            C0350cd a2 = m680a(a, appLovinLogger);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo4409a() {
        return this.f653b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo4410b() {
        return this.f652a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo4411c() {
        return this.f652a + ":" + this.f653b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0350cd cdVar = (C0350cd) obj;
        if (this.f652a == null ? cdVar.f652a != null : !this.f652a.equals(cdVar.f652a)) {
            return false;
        }
        return this.f653b != null ? this.f653b.equals(cdVar.f653b) : cdVar.f653b == null;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f652a != null ? this.f652a.hashCode() : 0) * 31;
        if (this.f653b != null) {
            i = this.f653b.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "[Adapter Spec: " + mo4411c() + "]";
    }
}
