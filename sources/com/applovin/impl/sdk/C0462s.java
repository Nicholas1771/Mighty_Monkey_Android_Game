package com.applovin.impl.sdk;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.s */
public class C0462s {
    /* renamed from: a */
    public static List<String> m1246a(String str) {
        return m1247a(str, ",\\s*");
    }

    /* renamed from: a */
    public static List<String> m1247a(String str, String str2) {
        return TextUtils.isEmpty(str) ? Collections.emptyList() : Arrays.asList(str.split(str2));
    }
}
