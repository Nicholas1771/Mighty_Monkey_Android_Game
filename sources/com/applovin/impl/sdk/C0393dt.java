package com.applovin.impl.sdk;

import android.content.SharedPreferences;
import com.applovin.sdk.AppLovinLogger;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.dt */
public final class C0393dt {

    /* renamed from: a */
    final AppLovinSdkImpl f1003a;

    /* renamed from: b */
    final AppLovinLogger f1004b;

    /* renamed from: c */
    final SharedPreferences f1005c;

    C0393dt(AppLovinSdkImpl appLovinSdkImpl) {
        this.f1003a = appLovinSdkImpl;
        this.f1004b = appLovinSdkImpl.getLogger();
        this.f1005c = appLovinSdkImpl.getApplicationContext().getSharedPreferences("com.applovin.sdk.preferences." + appLovinSdkImpl.getSdkKey(), 0);
    }

    /* renamed from: a */
    private static <T> T m915a(String str, T t, Class cls, SharedPreferences sharedPreferences, AppLovinSdkImpl appLovinSdkImpl) {
        T t2;
        try {
            if (Boolean.class.equals(cls)) {
                t2 = Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) t).booleanValue()));
            } else if (Float.class.equals(cls)) {
                t2 = Float.valueOf(sharedPreferences.getFloat(str, ((Float) t).floatValue()));
            } else if (Integer.class.equals(cls)) {
                t2 = Integer.valueOf(sharedPreferences.getInt(str, ((Integer) t).intValue()));
            } else if (Long.class.equals(cls)) {
                t2 = Long.valueOf(sharedPreferences.getLong(str, ((Long) t).longValue()));
            } else if (String.class.equals(cls)) {
                t2 = sharedPreferences.getString(str, (String) t);
            } else if (!Set.class.isAssignableFrom(cls)) {
                t2 = t;
            } else if (C0463t.m1252b()) {
                t2 = sharedPreferences.getStringSet(str, (Set) t);
            } else {
                appLovinSdkImpl.getLogger().mo4780e("SharedPreferencesManager", "Attempting to get string set on older Android version for key: " + str);
                t2 = t;
            }
            return t2 != null ? cls.cast(t2) : t;
        } catch (Throwable th) {
            appLovinSdkImpl.getLogger().mo4781e("SharedPreferencesManager", "Error getting value for key: " + str, th);
            return t;
        }
    }

    /* renamed from: a */
    private static void m916a(SharedPreferences.Editor editor, AppLovinSdkImpl appLovinSdkImpl) {
        if (((Boolean) appLovinSdkImpl.get(C0387dn.f913cO)).booleanValue()) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    /* renamed from: a */
    private static <T> void m917a(String str, T t, SharedPreferences sharedPreferences, AppLovinSdkImpl appLovinSdkImpl) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        boolean z = true;
        if (t instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) t).booleanValue());
        } else if (t instanceof Float) {
            edit.putFloat(str, ((Float) t).floatValue());
        } else if (t instanceof Integer) {
            edit.putInt(str, ((Integer) t).intValue());
        } else if (t instanceof Long) {
            edit.putLong(str, ((Long) t).longValue());
        } else if (t instanceof String) {
            edit.putString(str, (String) t);
        } else if (!(t instanceof Set)) {
            appLovinSdkImpl.getLogger().mo4780e("SharedPreferencesManager", "Unable to put default value of invalid type: " + t);
            z = false;
        } else if (C0463t.m1252b()) {
            edit.putStringSet(str, (Set) t);
        } else {
            appLovinSdkImpl.getLogger().mo4780e("SharedPreferencesManager", "Attempting to put string set on older Android version for key: " + str + " and value: " + t);
            z = false;
        }
        if (z) {
            m916a(edit, appLovinSdkImpl);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public <T> T mo4611a(String str, T t, Class cls, SharedPreferences sharedPreferences) {
        return m915a(str, t, cls, sharedPreferences, this.f1003a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4612a(SharedPreferences sharedPreferences) {
        m916a(sharedPreferences.edit().clear(), this.f1003a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public <T> void mo4613a(C0392ds<T> dsVar) {
        m916a(this.f1005c.edit().remove(dsVar.mo4608a()), this.f1003a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public <T> void mo4614a(C0392ds<T> dsVar, T t) {
        mo4615a(dsVar, t, this.f1005c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public <T> void mo4615a(C0392ds<T> dsVar, T t, SharedPreferences sharedPreferences) {
        mo4616a(dsVar.mo4608a(), t, sharedPreferences);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public <T> void mo4616a(String str, T t, SharedPreferences sharedPreferences) {
        m917a(str, t, sharedPreferences, this.f1003a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public <T> T mo4617b(C0392ds<T> dsVar, T t) {
        return mo4618b(dsVar, t, this.f1005c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public <T> T mo4618b(C0392ds<T> dsVar, T t, SharedPreferences sharedPreferences) {
        return mo4611a(dsVar.mo4608a(), t, (Class) dsVar.mo4609b(), sharedPreferences);
    }
}
