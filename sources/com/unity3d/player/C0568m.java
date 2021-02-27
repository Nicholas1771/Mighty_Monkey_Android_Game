package com.unity3d.player;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.MediaController;
import java.io.FileInputStream;
import java.io.IOException;

/* renamed from: com.unity3d.player.m */
public final class C0568m extends FrameLayout implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback, MediaController.MediaPlayerControl {

    /* renamed from: a */
    private static boolean f1380a = false;

    /* renamed from: A */
    private volatile int f1381A = 0;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final UnityPlayer f1382b;

    /* renamed from: c */
    private final Context f1383c;

    /* renamed from: d */
    private final SurfaceView f1384d;

    /* renamed from: e */
    private final SurfaceHolder f1385e;

    /* renamed from: f */
    private final String f1386f;

    /* renamed from: g */
    private final int f1387g;

    /* renamed from: h */
    private final int f1388h;

    /* renamed from: i */
    private final boolean f1389i;

    /* renamed from: j */
    private final long f1390j;

    /* renamed from: k */
    private final long f1391k;

    /* renamed from: l */
    private final FrameLayout f1392l;

    /* renamed from: m */
    private final Display f1393m;

    /* renamed from: n */
    private int f1394n;

    /* renamed from: o */
    private int f1395o;

    /* renamed from: p */
    private int f1396p;

    /* renamed from: q */
    private int f1397q;

    /* renamed from: r */
    private MediaPlayer f1398r;

    /* renamed from: s */
    private MediaController f1399s;

    /* renamed from: t */
    private boolean f1400t = false;

    /* renamed from: u */
    private boolean f1401u = false;

    /* renamed from: v */
    private int f1402v = 0;

    /* renamed from: w */
    private boolean f1403w = false;

    /* renamed from: x */
    private int f1404x = 0;

    /* renamed from: y */
    private boolean f1405y;

    /* renamed from: z */
    private C0570a f1406z;

    /* renamed from: com.unity3d.player.m$a */
    public interface C0570a {
        /* renamed from: a */
        void mo8618a(int i);
    }

    protected C0568m(UnityPlayer unityPlayer, Context context, String str, int i, int i2, int i3, boolean z, long j, long j2, C0570a aVar) {
        super(context);
        this.f1406z = aVar;
        this.f1382b = unityPlayer;
        this.f1383c = context;
        this.f1392l = this;
        this.f1384d = new SurfaceView(context);
        this.f1385e = this.f1384d.getHolder();
        this.f1385e.addCallback(this);
        this.f1385e.setType(3);
        this.f1392l.setBackgroundColor(i);
        this.f1392l.addView(this.f1384d);
        this.f1393m = ((WindowManager) this.f1383c.getSystemService("window")).getDefaultDisplay();
        this.f1386f = str;
        this.f1387g = i2;
        this.f1388h = i3;
        this.f1389i = z;
        this.f1390j = j;
        this.f1391k = j2;
        if (f1380a) {
            m1440a("fileName: " + this.f1386f);
        }
        if (f1380a) {
            m1440a("backgroundColor: " + i);
        }
        if (f1380a) {
            m1440a("controlMode: " + this.f1387g);
        }
        if (f1380a) {
            m1440a("scalingMode: " + this.f1388h);
        }
        if (f1380a) {
            m1440a("isURL: " + this.f1389i);
        }
        if (f1380a) {
            m1440a("videoOffset: " + this.f1390j);
        }
        if (f1380a) {
            m1440a("videoLength: " + this.f1391k);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.f1405y = true;
    }

    /* renamed from: a */
    private void m1439a() {
        this.f1381A = 0;
        if (this.f1406z != null) {
            this.f1406z.mo8618a(this.f1381A);
        }
        doCleanUp();
        try {
            this.f1398r = new MediaPlayer();
            if (this.f1389i) {
                this.f1398r.setDataSource(this.f1383c, Uri.parse(this.f1386f));
            } else if (this.f1391k != 0) {
                FileInputStream fileInputStream = new FileInputStream(this.f1386f);
                this.f1398r.setDataSource(fileInputStream.getFD(), this.f1390j, this.f1391k);
                fileInputStream.close();
            } else {
                try {
                    AssetFileDescriptor openFd = getResources().getAssets().openFd(this.f1386f);
                    this.f1398r.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                    openFd.close();
                } catch (IOException e) {
                    FileInputStream fileInputStream2 = new FileInputStream(this.f1386f);
                    this.f1398r.setDataSource(fileInputStream2.getFD());
                    fileInputStream2.close();
                }
            }
            this.f1398r.setDisplay(this.f1385e);
            this.f1398r.setScreenOnWhilePlaying(true);
            this.f1398r.setOnBufferingUpdateListener(this);
            this.f1398r.setOnCompletionListener(this);
            this.f1398r.setOnPreparedListener(this);
            this.f1398r.setOnVideoSizeChangedListener(this);
            this.f1398r.setAudioStreamType(3);
            this.f1398r.prepare();
            if (this.f1387g == 0 || this.f1387g == 1) {
                this.f1399s = new MediaController(this.f1383c);
                this.f1399s.setMediaPlayer(this);
                this.f1399s.setAnchorView(this);
                this.f1399s.setEnabled(true);
                this.f1399s.show();
            }
        } catch (Exception e2) {
            if (f1380a) {
                m1440a("error: " + e2.getMessage() + e2);
            }
            onDestroy();
            this.f1381A = 2;
            if (this.f1406z != null) {
                this.f1406z.mo8618a(this.f1381A);
            }
        }
    }

    /* renamed from: a */
    private static void m1440a(String str) {
        Log.v("Video", "VideoPlayer: " + str);
    }

    /* renamed from: b */
    private void m1441b() {
        if (!isPlaying()) {
            this.f1381A = 1;
            if (this.f1406z != null) {
                this.f1406z.mo8618a(this.f1381A);
            }
            if (f1380a) {
                m1440a("startVideoPlayback");
            }
            updateVideoLayout();
            if (!this.f1403w) {
                start();
            }
        }
    }

    public final boolean canPause() {
        return true;
    }

    public final boolean canSeekBackward() {
        return true;
    }

    public final boolean canSeekForward() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void doCleanUp() {
        if (this.f1398r != null) {
            this.f1398r.release();
            this.f1398r = null;
        }
        this.f1396p = 0;
        this.f1397q = 0;
        this.f1401u = false;
        this.f1400t = false;
    }

    public final int getBufferPercentage() {
        if (this.f1389i) {
            return this.f1402v;
        }
        return 100;
    }

    public final int getCurrentPosition() {
        if (this.f1398r == null) {
            return 0;
        }
        return this.f1398r.getCurrentPosition();
    }

    public final int getDuration() {
        if (this.f1398r == null) {
            return 0;
        }
        return this.f1398r.getDuration();
    }

    public final boolean isPlaying() {
        boolean z = this.f1401u && this.f1400t;
        return this.f1398r == null ? !z : this.f1398r.isPlaying() || !z;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        if (f1380a) {
            m1440a("onBufferingUpdate percent:" + i);
        }
        this.f1402v = i;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (f1380a) {
            m1440a("onCompletion called");
        }
        onDestroy();
    }

    public final void onControllerHide() {
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        onPause();
        doCleanUp();
        UnityPlayer.m1343a((Runnable) new Runnable() {
            public final void run() {
                C0568m.this.f1382b.hideVideoPlayer();
            }
        });
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 && (this.f1387g != 2 || i == 0 || keyEvent.isSystem())) {
            return this.f1399s != null ? this.f1399s.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
        }
        onDestroy();
        return true;
    }

    /* access modifiers changed from: protected */
    public final void onPause() {
        if (f1380a) {
            m1440a("onPause called");
        }
        if (!this.f1403w) {
            pause();
            this.f1403w = false;
        }
        if (this.f1398r != null) {
            this.f1404x = this.f1398r.getCurrentPosition();
        }
        this.f1405y = false;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        if (f1380a) {
            m1440a("onPrepared called");
        }
        this.f1401u = true;
        if (this.f1401u && this.f1400t) {
            m1441b();
        }
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        if (f1380a) {
            m1440a("onResume called");
        }
        if (!this.f1405y && !this.f1403w) {
            start();
        }
        this.f1405y = true;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (this.f1387g != 2 || action != 0) {
            return this.f1399s != null ? this.f1399s.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
        }
        onDestroy();
        return true;
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        if (f1380a) {
            m1440a("onVideoSizeChanged called " + i + "x" + i2);
        }
        if (i != 0 && i2 != 0) {
            this.f1400t = true;
            this.f1396p = i;
            this.f1397q = i2;
            if (this.f1401u && this.f1400t) {
                m1441b();
            }
        } else if (f1380a) {
            m1440a("invalid video width(" + i + ") or height(" + i2 + ")");
        }
    }

    public final void pause() {
        if (this.f1398r != null) {
            this.f1398r.pause();
            this.f1403w = true;
        }
    }

    public final void seekTo(int i) {
        if (this.f1398r != null) {
            this.f1398r.seekTo(i);
        }
    }

    public final void start() {
        if (this.f1398r != null) {
            this.f1398r.start();
            this.f1403w = false;
        }
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (f1380a) {
            m1440a("surfaceChanged called " + i + " " + i2 + "x" + i3);
        }
        if (this.f1394n != i2 || this.f1395o != i3) {
            this.f1394n = i2;
            this.f1395o = i3;
            updateVideoLayout();
        }
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (f1380a) {
            m1440a("surfaceCreated called");
        }
        m1439a();
        seekTo(this.f1404x);
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (f1380a) {
            m1440a("surfaceDestroyed called");
        }
        doCleanUp();
    }

    /* access modifiers changed from: protected */
    public final void updateVideoLayout() {
        if (f1380a) {
            m1440a("updateVideoLayout");
        }
        if (this.f1394n == 0 || this.f1395o == 0) {
            WindowManager windowManager = (WindowManager) this.f1383c.getSystemService("window");
            this.f1394n = windowManager.getDefaultDisplay().getWidth();
            this.f1395o = windowManager.getDefaultDisplay().getHeight();
        }
        int i = this.f1394n;
        int i2 = this.f1395o;
        float f = ((float) this.f1396p) / ((float) this.f1397q);
        float f2 = ((float) this.f1394n) / ((float) this.f1395o);
        if (this.f1388h == 1) {
            if (f2 <= f) {
                i2 = (int) (((float) this.f1394n) / f);
            } else {
                i = (int) (((float) this.f1395o) * f);
            }
        } else if (this.f1388h == 2) {
            if (f2 >= f) {
                i2 = (int) (((float) this.f1394n) / f);
            } else {
                i = (int) (((float) this.f1395o) * f);
            }
        } else if (this.f1388h == 0) {
            i = this.f1396p;
            i2 = this.f1397q;
        }
        if (f1380a) {
            m1440a("frameWidth = " + i + "; frameHeight = " + i2);
        }
        this.f1392l.updateViewLayout(this.f1384d, new FrameLayout.LayoutParams(i, i2, 17));
    }
}
