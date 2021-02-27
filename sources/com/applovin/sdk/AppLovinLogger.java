package com.applovin.sdk;

public interface AppLovinLogger {
    public static final String SDK_TAG = "AppLovinSdk";

    /* renamed from: d */
    void mo4779d(String str, String str2);

    /* renamed from: e */
    void mo4780e(String str, String str2);

    /* renamed from: e */
    void mo4781e(String str, String str2, Throwable th);

    /* renamed from: i */
    void mo4782i(String str, String str2);

    void userError(String str, String str2);

    void userError(String str, String str2, Throwable th);

    /* renamed from: w */
    void mo4785w(String str, String str2);

    /* renamed from: w */
    void mo4786w(String str, String str2, Throwable th);
}
