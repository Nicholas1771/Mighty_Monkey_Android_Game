package com.unity3d.player;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.AttributeSet;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.unity3d.player.C0544a;
import com.unity3d.player.C0568m;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class UnityPlayer extends FrameLayout implements C0544a.C0546a {
    public static Activity currentActivity = null;

    /* renamed from: j */
    private static boolean f1230j;

    /* renamed from: a */
    C0541b f1231a = new C0541b(this, (byte) 0);

    /* renamed from: b */
    C0562j f1232b = null;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f1233c = false;

    /* renamed from: d */
    private boolean f1234d = true;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C0567l f1235e = new C0567l();

    /* renamed from: f */
    private final ConcurrentLinkedQueue f1236f = new ConcurrentLinkedQueue();

    /* renamed from: g */
    private BroadcastReceiver f1237g = null;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ContextWrapper f1238h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public SurfaceView f1239i;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f1240k;

    /* renamed from: l */
    private Bundle f1241l = new Bundle();

    /* renamed from: m */
    private List f1242m = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: n */
    public C0568m f1243n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public ProgressBar f1244o = null;

    /* renamed from: p */
    private Runnable f1245p = new Runnable() {
        public final void run() {
            int k = UnityPlayer.this.nativeActivityIndicatorStyle();
            if (k >= 0) {
                if (UnityPlayer.this.f1244o == null) {
                    ProgressBar unused = UnityPlayer.this.f1244o = new ProgressBar(UnityPlayer.this.f1238h, (AttributeSet) null, new int[]{16842874, 16843401, 16842873, 16843400}[k]);
                    UnityPlayer.this.f1244o.setIndeterminate(true);
                    UnityPlayer.this.f1244o.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 51));
                    UnityPlayer.this.addView(UnityPlayer.this.f1244o);
                }
                UnityPlayer.this.f1244o.setVisibility(0);
                UnityPlayer.this.bringChildToFront(UnityPlayer.this.f1244o);
            }
        }
    };

    /* renamed from: q */
    private Runnable f1246q = new Runnable() {
        public final void run() {
            if (UnityPlayer.this.f1244o != null) {
                UnityPlayer.this.f1244o.setVisibility(8);
                UnityPlayer.this.removeView(UnityPlayer.this.f1244o);
                ProgressBar unused = UnityPlayer.this.f1244o = null;
            }
        }
    };

    /* renamed from: com.unity3d.player.UnityPlayer$4 */
    class C05344 extends BroadcastReceiver {

        /* renamed from: a */
        final /* synthetic */ UnityPlayer f1283a;

        public void onReceive(Context context, Intent intent) {
            this.f1283a.m1346b();
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$a */
    enum C0540a {
        PAUSE,
        RESUME,
        QUIT,
        FOCUS_GAINED,
        FOCUS_LOST,
        NEXT_FRAME
    }

    /* renamed from: com.unity3d.player.UnityPlayer$b */
    private class C0541b extends Thread {

        /* renamed from: a */
        Handler f1307a;

        /* renamed from: b */
        boolean f1308b;

        private C0541b() {
            this.f1308b = false;
        }

        /* synthetic */ C0541b(UnityPlayer unityPlayer, byte b) {
            this();
        }

        /* renamed from: a */
        private void m1379a(C0540a aVar) {
            Message.obtain(this.f1307a, 2269, aVar).sendToTarget();
        }

        /* renamed from: a */
        public final void mo8637a() {
            m1379a(C0540a.QUIT);
        }

        /* renamed from: a */
        public final void mo8638a(boolean z) {
            m1379a(z ? C0540a.FOCUS_GAINED : C0540a.FOCUS_LOST);
        }

        /* renamed from: b */
        public final void mo8639b() {
            m1379a(C0540a.RESUME);
        }

        /* renamed from: c */
        public final void mo8640c() {
            m1379a(C0540a.PAUSE);
        }

        public final void run() {
            setName("UnityMain");
            Looper.prepare();
            this.f1307a = new Handler(new Handler.Callback() {
                public final boolean handleMessage(Message message) {
                    if (message.what != 2269) {
                        return false;
                    }
                    C0540a aVar = (C0540a) message.obj;
                    if (aVar == C0540a.QUIT) {
                        Looper.myLooper().quit();
                    } else if (aVar == C0540a.RESUME) {
                        C0541b.this.f1308b = true;
                    } else if (aVar == C0540a.PAUSE) {
                        C0541b.this.f1308b = false;
                        UnityPlayer.this.executeGLThreadJobs();
                    } else if (aVar == C0540a.FOCUS_LOST) {
                        if (!C0541b.this.f1308b) {
                            UnityPlayer.this.executeGLThreadJobs();
                        }
                    } else if (aVar == C0540a.NEXT_FRAME) {
                        UnityPlayer.this.executeGLThreadJobs();
                        if (!UnityPlayer.this.isFinishing() && !UnityPlayer.this.nativeRender()) {
                            UnityPlayer.this.m1346b();
                        }
                    }
                    if (C0541b.this.f1308b) {
                        Message.obtain(C0541b.this.f1307a, 2269, C0540a.NEXT_FRAME).sendToTarget();
                    }
                    return true;
                }
            });
            Looper.loop();
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$c */
    private abstract class C0543c implements Runnable {
        private C0543c() {
        }

        /* synthetic */ C0543c(UnityPlayer unityPlayer, byte b) {
            this();
        }

        /* renamed from: a */
        public abstract void mo8616a();

        public final void run() {
            if (!UnityPlayer.this.isFinishing()) {
                mo8616a();
            }
        }
    }

    static {
        new C0566k().mo8711a();
        f1230j = false;
        f1230j = loadLibraryStatic("main");
    }

    public UnityPlayer(ContextWrapper contextWrapper) {
        super(contextWrapper);
        if (contextWrapper instanceof Activity) {
            currentActivity = (Activity) contextWrapper;
        }
        this.f1238h = contextWrapper;
        m1335a();
        if (C0561i.f1363e) {
            if (currentActivity != null) {
                C0561i.f1366h.mo8688a(currentActivity, new Runnable() {
                    public final void run() {
                        UnityPlayer.this.mo8576b((Runnable) new Runnable() {
                            public final void run() {
                                UnityPlayer.this.f1235e.mo8716d();
                                UnityPlayer.this.m1358g();
                            }
                        });
                    }
                });
            } else {
                this.f1235e.mo8716d();
            }
        }
        if (C0561i.f1359a) {
            C0561i.f1364f.mo8679a((View) this);
        }
        setFullscreen(true);
        m1337a(this.f1238h.getApplicationInfo());
        if (!C0567l.m1430c()) {
            AlertDialog create = new AlertDialog.Builder(this.f1238h).setTitle("Failure to initialize!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    UnityPlayer.this.m1346b();
                }
            }).setMessage("Your hardware does not support this application, sorry!").create();
            create.setCancelable(false);
            create.show();
            return;
        }
        initJni(contextWrapper);
        nativeFile(this.f1238h.getPackageCodePath());
        m1364j();
        this.f1239i = new SurfaceView(contextWrapper);
        this.f1239i.getHolder().setFormat(2);
        this.f1239i.getHolder().addCallback(new SurfaceHolder.Callback() {
            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                UnityPlayer.this.m1336a(0, surfaceHolder.getSurface());
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                UnityPlayer.this.m1336a(0, surfaceHolder.getSurface());
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                UnityPlayer.this.m1336a(0, (Surface) null);
            }
        });
        this.f1239i.setFocusable(true);
        this.f1239i.setFocusableInTouchMode(true);
        addView(this.f1239i);
        this.f1240k = false;
        nativeInitWWW(WWW.class);
        nativeInitWebRequest(UnityWebRequest.class);
        if (C0561i.f1360b) {
            C0561i.f1365g.mo8686a(this, this.f1238h);
        }
        m1367k();
        this.f1231a.start();
    }

    public static void UnitySendMessage(String str, String str2, String str3) {
        if (!C0567l.m1430c()) {
            C0558g.Log(5, "Native libraries not loaded - dropping message for " + str + "." + str2);
        } else {
            nativeUnitySendMessage(str, str2, str3);
        }
    }

    /* renamed from: a */
    private static String m1334a(String str) {
        byte[] bArr;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(str);
            long length = new File(str).length();
            fileInputStream.skip(length - Math.min(length, 65558));
            byte[] bArr2 = new byte[1024];
            for (int i = 0; i != -1; i = fileInputStream.read(bArr2)) {
                instance.update(bArr2, 0, i);
            }
            bArr = instance.digest();
        } catch (FileNotFoundException e) {
            bArr = null;
        } catch (IOException e2) {
            bArr = null;
        } catch (NoSuchAlgorithmException e3) {
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(Integer.toString((b & 255) + 256, 16).substring(1));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private void m1335a() {
        try {
            File file = new File(this.f1238h.getPackageCodePath(), "assets/bin/Data/settings.xml");
            InputStream fileInputStream = file.exists() ? new FileInputStream(file) : this.f1238h.getAssets().open("bin/Data/settings.xml");
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            newPullParser.setInput(fileInputStream, (String) null);
            String str = null;
            String str2 = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    str2 = newPullParser.getName();
                    String str3 = str;
                    for (int i = 0; i < newPullParser.getAttributeCount(); i++) {
                        if (newPullParser.getAttributeName(i).equalsIgnoreCase("name")) {
                            str3 = newPullParser.getAttributeValue(i);
                        }
                    }
                    str = str3;
                } else if (eventType == 3) {
                    str2 = null;
                } else if (eventType == 4 && str != null) {
                    if (str2.equalsIgnoreCase("integer")) {
                        this.f1241l.putInt(str, Integer.parseInt(newPullParser.getText()));
                    } else if (str2.equalsIgnoreCase("string")) {
                        this.f1241l.putString(str, newPullParser.getText());
                    } else if (str2.equalsIgnoreCase("bool")) {
                        this.f1241l.putBoolean(str, Boolean.parseBoolean(newPullParser.getText()));
                    } else if (str2.equalsIgnoreCase("float")) {
                        this.f1241l.putFloat(str, Float.parseFloat(newPullParser.getText()));
                    }
                    str = null;
                }
            }
        } catch (Exception e) {
            C0558g.Log(6, "Unable to locate player settings. " + e.getLocalizedMessage());
            m1346b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1336a(int i, Surface surface) {
        if (!this.f1233c) {
            m1348b(0, surface);
        }
    }

    /* renamed from: a */
    private static void m1337a(ApplicationInfo applicationInfo) {
        if (f1230j && NativeLoader.load(applicationInfo.nativeLibraryDir)) {
            C0567l.m1428a();
        }
    }

    /* renamed from: a */
    private void m1338a(C0543c cVar) {
        if (!isFinishing()) {
            m1351c((Runnable) cVar);
        }
    }

    /* renamed from: a */
    static void m1343a(Runnable runnable) {
        new Thread(runnable).start();
    }

    /* renamed from: a */
    private static String[] m1345a(Context context) {
        String packageName = context.getPackageName();
        Vector vector = new Vector();
        try {
            int i = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
            if (Environment.getExternalStorageState().equals("mounted")) {
                File file = new File(Environment.getExternalStorageDirectory().toString() + "/Android/obb/" + packageName);
                if (file.exists()) {
                    if (i > 0) {
                        String str = file + File.separator + "main." + i + "." + packageName + ".obb";
                        if (new File(str).isFile()) {
                            vector.add(str);
                        }
                    }
                    if (i > 0) {
                        String str2 = file + File.separator + "patch." + i + "." + packageName + ".obb";
                        if (new File(str2).isFile()) {
                            vector.add(str2);
                        }
                    }
                }
            }
            String[] strArr = new String[vector.size()];
            vector.toArray(strArr);
            return strArr;
        } catch (PackageManager.NameNotFoundException e) {
            return new String[0];
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1346b() {
        if ((this.f1238h instanceof Activity) && !((Activity) this.f1238h).isFinishing()) {
            ((Activity) this.f1238h).finish();
        }
    }

    /* renamed from: b */
    private boolean m1348b(int i, Surface surface) {
        if (!C0567l.m1430c()) {
            return false;
        }
        nativeRecreateGfxState(i, surface);
        return true;
    }

    /* renamed from: c */
    private void m1350c() {
        for (C0544a c : this.f1242m) {
            c.mo8677c();
        }
    }

    /* renamed from: c */
    private void m1351c(Runnable runnable) {
        if (C0567l.m1430c()) {
            if (Thread.currentThread() == this.f1231a) {
                runnable.run();
            } else {
                this.f1236f.add(runnable);
            }
        }
    }

    /* renamed from: d */
    private void m1352d() {
        for (C0544a aVar : this.f1242m) {
            try {
                aVar.mo8674a((C0544a.C0546a) this);
            } catch (Exception e) {
                C0558g.Log(6, "Unable to initialize camera: " + e.getMessage());
                aVar.mo8677c();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m1354e() {
        reportSoftInputStr((String) null, 1, true);
        if (this.f1235e.mo8719g()) {
            if (C0567l.m1430c()) {
                final Semaphore semaphore = new Semaphore(0);
                if (isFinishing()) {
                    m1351c((Runnable) new Runnable() {
                        public final void run() {
                            UnityPlayer.this.m1357f();
                            semaphore.release();
                        }
                    });
                } else {
                    m1351c((Runnable) new Runnable() {
                        public final void run() {
                            if (UnityPlayer.this.nativePause()) {
                                boolean unused = UnityPlayer.this.f1240k = true;
                                UnityPlayer.this.m1357f();
                                semaphore.release(2);
                                return;
                            }
                            semaphore.release();
                        }
                    });
                }
                try {
                    if (!semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                        C0558g.Log(5, "Timeout while trying to pause the Unity Engine.");
                    }
                } catch (InterruptedException e) {
                    C0558g.Log(5, "UI thread got interrupted while trying to pause the Unity Engine.");
                }
                if (semaphore.drainPermits() > 0) {
                    quit();
                }
            }
            this.f1235e.mo8715c(false);
            this.f1235e.mo8714b(true);
            m1350c();
            this.f1231a.mo8640c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m1357f() {
        nativeDone();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m1358g() {
        if (this.f1235e.mo8718f()) {
            if (this.f1243n != null) {
                this.f1243n.onResume();
                return;
            }
            this.f1235e.mo8715c(true);
            m1352d();
            if (C0567l.m1430c()) {
                m1364j();
            }
            m1351c((Runnable) new Runnable() {
                public final void run() {
                    UnityPlayer.this.nativeResume();
                }
            });
            this.f1231a.mo8639b();
        }
    }

    /* renamed from: h */
    private static void m1360h() {
        if (C0567l.m1430c()) {
            if (!NativeLoader.unload()) {
                throw new UnsatisfiedLinkError("Unable to unload libraries from libmain.so");
            }
            C0567l.m1429b();
        }
    }

    /* renamed from: i */
    private boolean m1362i() {
        if (!C0561i.f1359a) {
            return false;
        }
        return this.f1238h.getPackageManager().hasSystemFeature("android.hardware.camera") || this.f1238h.getPackageManager().hasSystemFeature("android.hardware.camera.front");
    }

    private final native void initJni(Context context);

    /* renamed from: j */
    private void m1364j() {
        if (this.f1241l.getBoolean("useObb")) {
            for (String str : m1345a((Context) this.f1238h)) {
                String a = m1334a(str);
                if (this.f1241l.getBoolean(a)) {
                    nativeFile(str);
                }
                this.f1241l.remove(a);
            }
        }
    }

    /* renamed from: k */
    private void m1367k() {
        if (this.f1238h instanceof Activity) {
            ((Activity) this.f1238h).getWindow().setFlags(1024, 1024);
        }
    }

    protected static boolean loadLibraryStatic(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError e) {
            C0558g.Log(6, "Unable to find " + str);
            return false;
        } catch (Exception e2) {
            C0558g.Log(6, "Unknown error " + e2);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final native int nativeActivityIndicatorStyle();

    private final native void nativeDone();

    private final native void nativeFile(String str);

    /* access modifiers changed from: private */
    public final native void nativeFocusChanged(boolean z);

    private final native void nativeInitWWW(Class cls);

    private final native void nativeInitWebRequest(Class cls);

    private final native boolean nativeInjectEvent(InputEvent inputEvent);

    /* access modifiers changed from: private */
    public final native boolean nativePause();

    private final native void nativeRecreateGfxState(int i, Surface surface);

    /* access modifiers changed from: private */
    public final native boolean nativeRender();

    /* access modifiers changed from: private */
    public final native void nativeResume();

    /* access modifiers changed from: private */
    public final native void nativeSetInputCanceled(boolean z);

    /* access modifiers changed from: private */
    public final native void nativeSetInputString(String str);

    /* access modifiers changed from: private */
    public final native void nativeSoftInputClosed();

    private static native void nativeUnitySendMessage(String str, String str2, String str3);

    /* access modifiers changed from: private */
    public final native void nativeVideoFrameCallback(int i, byte[] bArr, int i2, int i3);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo8576b(Runnable runnable) {
        if (this.f1238h instanceof Activity) {
            ((Activity) this.f1238h).runOnUiThread(runnable);
        } else {
            C0558g.Log(5, "Not running Unity from an Activity; ignored...");
        }
    }

    /* access modifiers changed from: protected */
    public void closeCamera(int i) {
        for (C0544a aVar : this.f1242m) {
            if (aVar.mo8673a() == i) {
                aVar.mo8677c();
                this.f1242m.remove(aVar);
                return;
            }
        }
    }

    public void configurationChanged(Configuration configuration) {
        if (this.f1239i instanceof SurfaceView) {
            this.f1239i.getHolder().setSizeFromLayout();
        }
        if (this.f1243n != null) {
            this.f1243n.updateVideoLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void disableLogger() {
        C0558g.f1354a = true;
    }

    public boolean displayChanged(int i, Surface surface) {
        if (i == 0) {
            this.f1233c = surface != null;
            mo8576b((Runnable) new Runnable() {
                public final void run() {
                    if (UnityPlayer.this.f1233c) {
                        UnityPlayer.this.removeView(UnityPlayer.this.f1239i);
                    } else {
                        UnityPlayer.this.addView(UnityPlayer.this.f1239i);
                    }
                }
            });
        }
        return m1348b(i, surface);
    }

    /* access modifiers changed from: protected */
    public void executeGLThreadJobs() {
        while (true) {
            Runnable runnable = (Runnable) this.f1236f.poll();
            if (runnable != null) {
                runnable.run();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getCameraOrientation(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        return cameraInfo.orientation;
    }

    /* access modifiers changed from: protected */
    public int getNumCameras() {
        if (!m1362i()) {
            return 0;
        }
        return Camera.getNumberOfCameras();
    }

    public Bundle getSettings() {
        return this.f1241l;
    }

    /* access modifiers changed from: protected */
    public int getSplashMode() {
        return this.f1241l.getInt("splash_mode");
    }

    public View getView() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void hideSoftInput() {
        final C05377 r0 = new Runnable() {
            public final void run() {
                if (UnityPlayer.this.f1232b != null) {
                    UnityPlayer.this.f1232b.dismiss();
                    UnityPlayer.this.f1232b = null;
                }
            }
        };
        if (C0561i.f1362d) {
            m1338a((C0543c) new C0543c() {
                /* renamed from: a */
                public final void mo8616a() {
                    UnityPlayer.this.mo8576b(r0);
                }
            });
        } else {
            mo8576b((Runnable) r0);
        }
    }

    /* access modifiers changed from: protected */
    public void hideVideoPlayer() {
        mo8576b((Runnable) new Runnable() {
            public final void run() {
                if (UnityPlayer.this.f1243n != null) {
                    if (UnityPlayer.this.f1239i.getParent() == null) {
                        UnityPlayer.this.addView(UnityPlayer.this.f1239i);
                    }
                    UnityPlayer.this.removeView(UnityPlayer.this.f1243n);
                    C0568m unused = UnityPlayer.this.f1243n = null;
                    UnityPlayer.this.resume();
                }
            }
        });
    }

    public void init(int i, boolean z) {
    }

    /* access modifiers changed from: protected */
    public int[] initCamera(int i, int i2, int i3, int i4) {
        C0544a aVar = new C0544a(i, i2, i3, i4);
        try {
            aVar.mo8674a((C0544a.C0546a) this);
            this.f1242m.add(aVar);
            Camera.Size b = aVar.mo8676b();
            return new int[]{b.width, b.height};
        } catch (Exception e) {
            C0558g.Log(6, "Unable to initialize camera: " + e.getMessage());
            aVar.mo8677c();
            return null;
        }
    }

    public boolean injectEvent(InputEvent inputEvent) {
        return nativeInjectEvent(inputEvent);
    }

    /* access modifiers changed from: protected */
    public boolean installPresentationDisplay(int i) {
        if (C0561i.f1360b) {
            return C0561i.f1365g.mo8687a(this, this.f1238h, i);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isCameraFrontFacing(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        return cameraInfo.facing == 1;
    }

    /* access modifiers changed from: protected */
    public boolean isFinishing() {
        if (!this.f1240k) {
            boolean z = (this.f1238h instanceof Activity) && ((Activity) this.f1238h).isFinishing();
            this.f1240k = z;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void kill() {
        Process.killProcess(Process.myPid());
    }

    /* access modifiers changed from: protected */
    public boolean loadLibrary(String str) {
        return loadLibraryStatic(str);
    }

    public void onCameraFrame(C0544a aVar, byte[] bArr) {
        final int a = aVar.mo8673a();
        final Camera.Size b = aVar.mo8676b();
        final byte[] bArr2 = bArr;
        final C0544a aVar2 = aVar;
        m1338a((C0543c) new C0543c() {
            /* renamed from: a */
            public final void mo8616a() {
                UnityPlayer.this.nativeVideoFrameCallback(a, bArr2, b.width, b.height);
                aVar2.mo8675a(bArr2);
            }
        });
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return injectEvent(motionEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return injectEvent(motionEvent);
    }

    public void pause() {
        if (this.f1243n != null) {
            this.f1243n.onPause();
        } else {
            m1354e();
        }
    }

    public void quit() {
        this.f1240k = true;
        if (!this.f1235e.mo8717e()) {
            pause();
        }
        this.f1231a.mo8637a();
        try {
            this.f1231a.join(4000);
        } catch (InterruptedException e) {
            this.f1231a.interrupt();
        }
        if (this.f1237g != null) {
            this.f1238h.unregisterReceiver(this.f1237g);
        }
        this.f1237g = null;
        if (C0567l.m1430c()) {
            removeAllViews();
        }
        if (C0561i.f1360b) {
            C0561i.f1365g.mo8685a(this.f1238h);
        }
        kill();
        m1360h();
    }

    /* access modifiers changed from: protected */
    public void reportSoftInputStr(final String str, final int i, final boolean z) {
        if (i == 1) {
            hideSoftInput();
        }
        m1338a((C0543c) new C0543c() {
            /* renamed from: a */
            public final void mo8616a() {
                if (z) {
                    UnityPlayer.this.nativeSetInputCanceled(true);
                } else if (str != null) {
                    UnityPlayer.this.nativeSetInputString(str);
                }
                if (i == 1) {
                    UnityPlayer.this.nativeSoftInputClosed();
                }
            }
        });
    }

    public void resume() {
        if (C0561i.f1359a) {
            C0561i.f1364f.mo8682b(this);
        }
        this.f1235e.mo8714b(false);
        m1358g();
    }

    /* access modifiers changed from: protected */
    public void setFullscreen(final boolean z) {
        this.f1234d = z;
        if (C0561i.f1359a) {
            mo8576b((Runnable) new Runnable() {
                public final void run() {
                    C0561i.f1364f.mo8680a(UnityPlayer.this, z);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void setSoftInputStr(final String str) {
        mo8576b((Runnable) new Runnable() {
            public final void run() {
                if (UnityPlayer.this.f1232b != null && str != null) {
                    UnityPlayer.this.f1232b.mo8700a(str);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void showSoftInput(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2) {
        final String str3 = str;
        final int i2 = i;
        final boolean z5 = z;
        final boolean z6 = z2;
        final boolean z7 = z3;
        final boolean z8 = z4;
        final String str4 = str2;
        mo8576b((Runnable) new Runnable() {
            public final void run() {
                UnityPlayer.this.f1232b = new C0562j(UnityPlayer.this.f1238h, this, str3, i2, z5, z6, z7, str4);
                UnityPlayer.this.f1232b.show();
            }
        });
    }

    /* access modifiers changed from: protected */
    public boolean showVideoPlayer(String str, int i, int i2, int i3, boolean z, int i4, int i5) {
        final Semaphore semaphore = new Semaphore(0);
        final AtomicInteger atomicInteger = new AtomicInteger(-1);
        final String str2 = str;
        final int i6 = i;
        final int i7 = i2;
        final int i8 = i3;
        final boolean z2 = z;
        final int i9 = i4;
        final int i10 = i5;
        mo8576b((Runnable) new Runnable() {
            public final void run() {
                if (UnityPlayer.this.f1243n != null) {
                    C0558g.Log(5, "Video already playing");
                    atomicInteger.set(2);
                    semaphore.release();
                    return;
                }
                C0568m unused = UnityPlayer.this.f1243n = new C0568m(UnityPlayer.this, UnityPlayer.this.f1238h, str2, i6, i7, i8, z2, (long) i9, (long) i10, new C0568m.C0570a() {
                    /* renamed from: a */
                    public final void mo8618a(int i) {
                        atomicInteger.set(i);
                        if (i != 0) {
                            semaphore.release();
                        }
                    }
                });
                UnityPlayer.this.addView(UnityPlayer.this.f1243n);
            }
        });
        boolean z3 = false;
        try {
            if (!semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                C0558g.Log(5, "Timeout waiting for video");
            } else {
                z3 = atomicInteger.get() != 2;
            }
        } catch (InterruptedException e) {
        }
        if (z3) {
            mo8576b((Runnable) new Runnable() {
                public final void run() {
                    UnityPlayer.this.m1354e();
                    UnityPlayer.this.f1243n.requestFocus();
                    UnityPlayer.this.removeView(UnityPlayer.this.f1239i);
                }
            });
        }
        return z3;
    }

    /* access modifiers changed from: protected */
    public void startActivityIndicator() {
        mo8576b(this.f1245p);
    }

    /* access modifiers changed from: protected */
    public void stopActivityIndicator() {
        mo8576b(this.f1246q);
    }

    public void windowFocusChanged(final boolean z) {
        this.f1235e.mo8713a(z);
        if (z && this.f1232b != null) {
            reportSoftInputStr((String) null, 1, false);
        }
        if (C0561i.f1359a && z) {
            C0561i.f1364f.mo8682b(this);
        }
        m1351c((Runnable) new Runnable() {
            public final void run() {
                UnityPlayer.this.nativeFocusChanged(z);
            }
        });
        this.f1231a.mo8638a(z);
        m1358g();
    }
}
