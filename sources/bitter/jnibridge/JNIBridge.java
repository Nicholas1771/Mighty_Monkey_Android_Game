package bitter.jnibridge;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JNIBridge {

    /* renamed from: bitter.jnibridge.JNIBridge$a */
    private static class C0173a implements InvocationHandler {

        /* renamed from: a */
        private Object f13a = new Object[0];

        /* renamed from: b */
        private long f14b;

        public C0173a(long j) {
            this.f14b = j;
        }

        /* renamed from: a */
        public final void mo3781a() {
            synchronized (this.f13a) {
                this.f14b = 0;
            }
        }

        public final void finalize() {
            synchronized (this.f13a) {
                if (this.f14b != 0) {
                    JNIBridge.delete(this.f14b);
                }
            }
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            Object invoke;
            synchronized (this.f13a) {
                invoke = this.f14b == 0 ? null : JNIBridge.invoke(this.f14b, method.getDeclaringClass(), method, objArr);
            }
            return invoke;
        }
    }

    static native void delete(long j);

    static void disableInterfaceProxy(Object obj) {
        ((C0173a) Proxy.getInvocationHandler(obj)).mo3781a();
    }

    static native Object invoke(long j, Class cls, Method method, Object[] objArr);

    static Object newInterfaceProxy(long j, Class[] clsArr) {
        return Proxy.newProxyInstance(JNIBridge.class.getClassLoader(), clsArr, new C0173a(j));
    }
}
