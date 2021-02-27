package org.fmod;

import android.media.AudioTrack;
import android.util.Log;
import java.nio.ByteBuffer;

public class FMODAudioDevice implements Runnable {

    /* renamed from: h */
    private static int f1408h = 0;

    /* renamed from: i */
    private static int f1409i = 1;

    /* renamed from: j */
    private static int f1410j = 2;

    /* renamed from: k */
    private static int f1411k = 3;

    /* renamed from: a */
    private volatile Thread f1412a = null;

    /* renamed from: b */
    private volatile boolean f1413b = false;

    /* renamed from: c */
    private AudioTrack f1414c = null;

    /* renamed from: d */
    private boolean f1415d = false;

    /* renamed from: e */
    private ByteBuffer f1416e = null;

    /* renamed from: f */
    private byte[] f1417f = null;

    /* renamed from: g */
    private volatile C0571a f1418g;

    private native int fmodGetInfo(int i);

    private native int fmodProcess(ByteBuffer byteBuffer);

    private void releaseAudioTrack() {
        if (this.f1414c != null) {
            if (this.f1414c.getState() == 1) {
                this.f1414c.stop();
            }
            this.f1414c.release();
            this.f1414c = null;
        }
        this.f1416e = null;
        this.f1417f = null;
        this.f1415d = false;
    }

    public synchronized void close() {
        stop();
    }

    /* access modifiers changed from: package-private */
    public native int fmodProcessMicData(ByteBuffer byteBuffer, int i);

    public boolean isRunning() {
        return this.f1412a != null && this.f1412a.isAlive();
    }

    public void run() {
        int i;
        int i2 = 3;
        while (this.f1413b) {
            if (this.f1415d || i2 <= 0) {
                i = i2;
            } else {
                releaseAudioTrack();
                int fmodGetInfo = fmodGetInfo(f1408h);
                int round = Math.round(((float) AudioTrack.getMinBufferSize(fmodGetInfo, 3, 2)) * 1.1f) & -4;
                int fmodGetInfo2 = fmodGetInfo(f1409i);
                int fmodGetInfo3 = fmodGetInfo(f1410j);
                if (fmodGetInfo2 * fmodGetInfo3 * 4 > round) {
                    round = fmodGetInfo3 * fmodGetInfo2 * 4;
                }
                this.f1414c = new AudioTrack(3, fmodGetInfo, 3, 2, round, 1);
                this.f1415d = this.f1414c.getState() == 1;
                if (this.f1415d) {
                    this.f1416e = ByteBuffer.allocateDirect(fmodGetInfo2 * 2 * 2);
                    this.f1417f = new byte[this.f1416e.capacity()];
                    this.f1414c.play();
                    i = 3;
                } else {
                    Log.e("FMOD", "AudioTrack failed to initialize (status " + this.f1414c.getState() + ")");
                    releaseAudioTrack();
                    i = i2 - 1;
                }
            }
            if (!this.f1415d) {
                i2 = i;
            } else if (fmodGetInfo(f1411k) == 1) {
                fmodProcess(this.f1416e);
                this.f1416e.get(this.f1417f, 0, this.f1416e.capacity());
                this.f1414c.write(this.f1417f, 0, this.f1416e.capacity());
                this.f1416e.position(0);
                i2 = i;
            } else {
                releaseAudioTrack();
                i2 = i;
            }
        }
        releaseAudioTrack();
    }

    public synchronized void start() {
        if (this.f1412a != null) {
            stop();
        }
        this.f1412a = new Thread(this, "FMODAudioDevice");
        this.f1412a.setPriority(10);
        this.f1413b = true;
        this.f1412a.start();
        if (this.f1418g != null) {
            this.f1418g.mo8756b();
        }
    }

    public synchronized int startAudioRecord(int i, int i2, int i3) {
        if (this.f1418g == null) {
            this.f1418g = new C0571a(this, i, i2);
            this.f1418g.mo8756b();
        }
        return this.f1418g.mo8755a();
    }

    public synchronized void stop() {
        while (this.f1412a != null) {
            this.f1413b = false;
            try {
                this.f1412a.join();
                this.f1412a = null;
            } catch (InterruptedException e) {
            }
        }
        if (this.f1418g != null) {
            this.f1418g.mo8757c();
        }
    }

    public synchronized void stopAudioRecord() {
        if (this.f1418g != null) {
            this.f1418g.mo8757c();
            this.f1418g = null;
        }
    }
}
