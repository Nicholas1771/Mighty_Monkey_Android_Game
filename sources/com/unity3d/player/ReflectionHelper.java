package com.unity3d.player;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;

final class ReflectionHelper {
    protected static boolean LOG = false;
    protected static final boolean LOGV = false;

    /* renamed from: a */
    private static C0516a[] f1222a = new C0516a[4096];

    /* renamed from: com.unity3d.player.ReflectionHelper$a */
    private static class C0516a {

        /* renamed from: a */
        public volatile Member f1225a;

        /* renamed from: b */
        private final Class f1226b;

        /* renamed from: c */
        private final String f1227c;

        /* renamed from: d */
        private final String f1228d;

        /* renamed from: e */
        private final int f1229e = (((((this.f1226b.hashCode() + 527) * 31) + this.f1227c.hashCode()) * 31) + this.f1228d.hashCode());

        C0516a(Class cls, String str, String str2) {
            this.f1226b = cls;
            this.f1227c = str;
            this.f1228d = str2;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0516a)) {
                return false;
            }
            C0516a aVar = (C0516a) obj;
            return this.f1229e == aVar.f1229e && this.f1228d.equals(aVar.f1228d) && this.f1227c.equals(aVar.f1227c) && this.f1226b.equals(aVar.f1226b);
        }

        public final int hashCode() {
            return this.f1229e;
        }
    }

    ReflectionHelper() {
    }

    /* renamed from: a */
    private static float m1324a(Class cls, Class cls2) {
        if (cls.equals(cls2)) {
            return 1.0f;
        }
        if (!cls.isPrimitive() && !cls2.isPrimitive()) {
            try {
                if (cls.asSubclass(cls2) != null) {
                    return 0.5f;
                }
            } catch (ClassCastException e) {
            }
            try {
                if (cls2.asSubclass(cls) != null) {
                    return 0.1f;
                }
            } catch (ClassCastException e2) {
            }
        }
        return 0.0f;
    }

    /* renamed from: a */
    private static float m1325a(Class cls, Class[] clsArr, Class[] clsArr2) {
        int i = 0;
        if (clsArr2.length == 0) {
            return 0.1f;
        }
        if ((clsArr == null ? 0 : clsArr.length) + 1 != clsArr2.length) {
            return 0.0f;
        }
        float f = 1.0f;
        if (clsArr != null) {
            int length = clsArr.length;
            int i2 = 0;
            while (i < length) {
                f *= m1324a(clsArr[i], clsArr2[i2]);
                i++;
                i2++;
            }
        }
        return f * m1324a(cls, clsArr2[clsArr2.length - 1]);
    }

    /* renamed from: a */
    private static Class m1326a(String str, int[] iArr) {
        while (true) {
            if (iArr[0] >= str.length()) {
                break;
            }
            int i = iArr[0];
            iArr[0] = i + 1;
            char charAt = str.charAt(i);
            if (charAt != '(' && charAt != ')') {
                if (charAt == 'L') {
                    int indexOf = str.indexOf(59, iArr[0]);
                    if (indexOf != -1) {
                        String substring = str.substring(iArr[0], indexOf);
                        iArr[0] = indexOf + 1;
                        try {
                            return Class.forName(substring.replace('/', '.'));
                        } catch (ClassNotFoundException e) {
                        }
                    }
                } else if (charAt == 'Z') {
                    return Boolean.TYPE;
                } else {
                    if (charAt == 'I') {
                        return Integer.TYPE;
                    }
                    if (charAt == 'F') {
                        return Float.TYPE;
                    }
                    if (charAt == 'V') {
                        return Void.TYPE;
                    }
                    if (charAt == 'B') {
                        return Byte.TYPE;
                    }
                    if (charAt == 'S') {
                        return Short.TYPE;
                    }
                    if (charAt == 'J') {
                        return Long.TYPE;
                    }
                    if (charAt == 'D') {
                        return Double.TYPE;
                    }
                    if (charAt == '[') {
                        return Array.newInstance(m1326a(str, iArr), 0).getClass();
                    }
                    C0558g.Log(5, "! parseType; " + charAt + " is not known!");
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m1329a(C0516a aVar, Member member) {
        aVar.f1225a = member;
        f1222a[aVar.hashCode() & (f1222a.length - 1)] = aVar;
    }

    /* renamed from: a */
    private static boolean m1330a(C0516a aVar) {
        C0516a aVar2 = f1222a[aVar.hashCode() & (f1222a.length - 1)];
        if (!aVar.equals(aVar2)) {
            return false;
        }
        aVar.f1225a = aVar2.f1225a;
        return true;
    }

    /* renamed from: a */
    private static Class[] m1331a(String str) {
        Class a;
        int[] iArr = {0};
        ArrayList arrayList = new ArrayList();
        while (iArr[0] < str.length() && (a = m1326a(str, iArr)) != null) {
            arrayList.add(a);
        }
        Class[] clsArr = new Class[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            clsArr[i] = (Class) it.next();
            i++;
        }
        return clsArr;
    }

    protected static Constructor getConstructorID(Class cls, String str) {
        Constructor constructor;
        Constructor constructor2;
        Constructor constructor3;
        Constructor constructor4 = null;
        C0516a aVar = new C0516a(cls, "", str);
        if (m1330a(aVar)) {
            constructor2 = (Constructor) aVar.f1225a;
        } else {
            Class[] a = m1331a(str);
            float f = 0.0f;
            Constructor[] constructors = cls.getConstructors();
            int length = constructors.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    constructor = constructor4;
                    break;
                }
                constructor = constructors[i];
                float a2 = m1325a(Void.TYPE, constructor.getParameterTypes(), a);
                if (a2 > f) {
                    if (a2 == 1.0f) {
                        break;
                    }
                    constructor3 = constructor;
                } else {
                    a2 = f;
                    constructor3 = constructor4;
                }
                i++;
                constructor4 = constructor3;
                f = a2;
            }
            m1329a(aVar, (Member) constructor);
            constructor2 = constructor;
        }
        if (constructor2 != null) {
            return constructor2;
        }
        throw new NoSuchMethodError("<init>" + str + " in class " + cls.getName());
    }

    protected static Field getFieldID(Class cls, String str, String str2, boolean z) {
        Field field;
        float f;
        Field field2;
        C0516a aVar = new C0516a(cls, str, str2);
        if (m1330a(aVar)) {
            field = (Field) aVar.f1225a;
        } else {
            Class[] a = m1331a(str2);
            field = null;
            float f2 = 0.0f;
            while (cls != null) {
                Field[] declaredFields = cls.getDeclaredFields();
                int length = declaredFields.length;
                int i = 0;
                Field field3 = field;
                while (true) {
                    if (i >= length) {
                        field = field3;
                        break;
                    }
                    Field field4 = declaredFields[i];
                    if (z == Modifier.isStatic(field4.getModifiers()) && field4.getName().compareTo(str) == 0) {
                        f = m1325a((Class) field4.getType(), (Class[]) null, a);
                        if (f > f2) {
                            if (f == 1.0f) {
                                f2 = f;
                                field = field4;
                                break;
                            }
                            field2 = field4;
                            i++;
                            field3 = field2;
                            f2 = f;
                        }
                    }
                    f = f2;
                    field2 = field3;
                    i++;
                    field3 = field2;
                    f2 = f;
                }
                if (f2 == 1.0f || cls.isPrimitive() || cls.isInterface() || cls.equals(Object.class) || cls.equals(Void.TYPE)) {
                    break;
                }
                cls = cls.getSuperclass();
            }
            m1329a(aVar, (Member) field);
        }
        if (field != null) {
            return field;
        }
        Object[] objArr = new Object[4];
        objArr[0] = z ? "non-static" : "static";
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = cls.getName();
        throw new NoSuchFieldError(String.format("no %s field with name='%s' signature='%s' in class L%s;", objArr));
    }

    protected static Method getMethodID(Class cls, String str, String str2, boolean z) {
        Method method;
        float f;
        Method method2;
        C0516a aVar = new C0516a(cls, str, str2);
        if (m1330a(aVar)) {
            method = (Method) aVar.f1225a;
        } else {
            Class[] a = m1331a(str2);
            method = null;
            float f2 = 0.0f;
            while (cls != null) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length = declaredMethods.length;
                int i = 0;
                Method method3 = method;
                while (true) {
                    if (i >= length) {
                        method = method3;
                        break;
                    }
                    Method method4 = declaredMethods[i];
                    if (z == Modifier.isStatic(method4.getModifiers()) && method4.getName().compareTo(str) == 0) {
                        f = m1325a((Class) method4.getReturnType(), method4.getParameterTypes(), a);
                        if (f > f2) {
                            if (f == 1.0f) {
                                f2 = f;
                                method = method4;
                                break;
                            }
                            method2 = method4;
                            i++;
                            method3 = method2;
                            f2 = f;
                        }
                    }
                    f = f2;
                    method2 = method3;
                    i++;
                    method3 = method2;
                    f2 = f;
                }
                if (f2 == 1.0f || cls.isPrimitive() || cls.isInterface() || cls.equals(Object.class) || cls.equals(Void.TYPE)) {
                    break;
                }
                cls = cls.getSuperclass();
            }
            m1329a(aVar, (Member) method);
        }
        if (method != null) {
            return method;
        }
        Object[] objArr = new Object[4];
        objArr[0] = z ? "non-static" : "static";
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = cls.getName();
        throw new NoSuchMethodError(String.format("no %s method with name='%s' signature='%s' in class L%s;", objArr));
    }

    /* access modifiers changed from: private */
    public static native void nativeProxyFinalize(int i);

    /* access modifiers changed from: private */
    public static native Object nativeProxyInvoke(int i, String str, Object[] objArr);

    protected static Object newProxyInstance(int i, Class cls) {
        return newProxyInstance(i, new Class[]{cls});
    }

    protected static Object newProxyInstance(final int i, final Class[] clsArr) {
        return Proxy.newProxyInstance(ReflectionHelper.class.getClassLoader(), clsArr, new InvocationHandler() {
            /* access modifiers changed from: protected */
            public final void finalize() {
                try {
                    ReflectionHelper.nativeProxyFinalize(i);
                } finally {
                    super.finalize();
                }
            }

            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return ReflectionHelper.nativeProxyInvoke(i, method.getName(), objArr);
            }
        });
    }
}
