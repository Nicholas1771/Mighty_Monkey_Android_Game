package com.unity3d.player;

import android.graphics.ImageFormat;
import android.hardware.Camera;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.unity3d.player.a */
final class C0544a {

    /* renamed from: a */
    Camera f1323a;

    /* renamed from: b */
    Camera.Parameters f1324b;

    /* renamed from: c */
    Camera.Size f1325c;

    /* renamed from: d */
    int f1326d;

    /* renamed from: e */
    int[] f1327e;

    /* renamed from: f */
    private final Object[] f1328f = new Object[0];

    /* renamed from: g */
    private final int f1329g;

    /* renamed from: h */
    private final int f1330h;

    /* renamed from: i */
    private final int f1331i;

    /* renamed from: j */
    private final int f1332j;

    /* renamed from: com.unity3d.player.a$a */
    interface C0546a {
        void onCameraFrame(C0544a aVar, byte[] bArr);
    }

    public C0544a(int i, int i2, int i3, int i4) {
        this.f1329g = i;
        this.f1330h = m1385a(i2, 640);
        this.f1331i = m1385a(i3, 480);
        this.f1332j = m1385a(i4, 24);
    }

    /* renamed from: a */
    private static final int m1385a(int i, int i2) {
        return i != 0 ? i : i2;
    }

    /* renamed from: a */
    private static void m1386a(Camera.Parameters parameters) {
        if (parameters.getSupportedColorEffects() != null) {
            parameters.setColorEffect("none");
        }
        if (parameters.getSupportedFocusModes().contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        }
    }

    /* renamed from: b */
    private void m1387b(final C0546a aVar) {
        synchronized (this.f1328f) {
            this.f1323a = Camera.open(this.f1329g);
            this.f1324b = this.f1323a.getParameters();
            this.f1325c = m1390f();
            this.f1327e = m1389e();
            this.f1326d = m1388d();
            m1386a(this.f1324b);
            this.f1324b.setPreviewSize(this.f1325c.width, this.f1325c.height);
            this.f1324b.setPreviewFpsRange(this.f1327e[0], this.f1327e[1]);
            this.f1323a.setParameters(this.f1324b);
            C05451 r0 = new Camera.PreviewCallback() {

                /* renamed from: a */
                long f1333a = 0;

                public final void onPreviewFrame(byte[] bArr, Camera camera) {
                    if (C0544a.this.f1323a == camera) {
                        aVar.onCameraFrame(C0544a.this, bArr);
                    }
                }
            };
            int i = (((this.f1325c.width * this.f1325c.height) * this.f1326d) / 8) + 4096;
            this.f1323a.addCallbackBuffer(new byte[i]);
            this.f1323a.addCallbackBuffer(new byte[i]);
            this.f1323a.setPreviewCallbackWithBuffer(r0);
        }
    }

    /* renamed from: d */
    private final int m1388d() {
        this.f1324b.setPreviewFormat(17);
        return ImageFormat.getBitsPerPixel(17);
    }

    /* renamed from: e */
    private final int[] m1389e() {
        int[] iArr;
        double d;
        double d2 = (double) (this.f1332j * 1000);
        List<int[]> supportedPreviewFpsRange = this.f1324b.getSupportedPreviewFpsRange();
        if (supportedPreviewFpsRange == null) {
            supportedPreviewFpsRange = new ArrayList<>();
        }
        int[] iArr2 = {this.f1332j * 1000, this.f1332j * 1000};
        double d3 = Double.MAX_VALUE;
        for (int[] iArr3 : supportedPreviewFpsRange) {
            double abs = Math.abs(Math.log(d2 / ((double) iArr3[0]))) + Math.abs(Math.log(d2 / ((double) iArr3[1])));
            if (abs < d3) {
                iArr = iArr3;
                d = abs;
            } else {
                double d4 = d3;
                iArr = iArr2;
                d = d4;
            }
            iArr2 = iArr;
            d3 = d;
        }
        return iArr2;
    }

    /* renamed from: f */
    private final Camera.Size m1390f() {
        Camera.Size size;
        double d;
        double d2 = (double) this.f1330h;
        double d3 = (double) this.f1331i;
        Camera.Size size2 = null;
        double d4 = Double.MAX_VALUE;
        for (Camera.Size next : this.f1324b.getSupportedPreviewSizes()) {
            double abs = Math.abs(Math.log(d2 / ((double) next.width))) + Math.abs(Math.log(d3 / ((double) next.height)));
            if (abs < d4) {
                double d5 = abs;
                size = next;
                d = d5;
            } else {
                size = size2;
                d = d4;
            }
            d4 = d;
            size2 = size;
        }
        return size2;
    }

    /* renamed from: a */
    public final int mo8673a() {
        return this.f1329g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo8674a(com.unity3d.player.C0544a.C0546a r4) {
        /*
            r3 = this;
            java.lang.Object[] r1 = r3.f1328f
            monitor-enter(r1)
            android.hardware.Camera r0 = r3.f1323a     // Catch:{ all -> 0x0021 }
            if (r0 != 0) goto L_0x000a
            r3.m1387b(r4)     // Catch:{ all -> 0x0021 }
        L_0x000a:
            boolean r0 = com.unity3d.player.C0561i.f1359a     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x001f
            com.unity3d.player.c r0 = com.unity3d.player.C0561i.f1364f     // Catch:{ all -> 0x0021 }
            android.hardware.Camera r2 = r3.f1323a     // Catch:{ all -> 0x0021 }
            boolean r0 = r0.mo8681a((android.hardware.Camera) r2)     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x001f
            android.hardware.Camera r0 = r3.f1323a     // Catch:{ all -> 0x0021 }
            r0.startPreview()     // Catch:{ all -> 0x0021 }
            monitor-exit(r1)     // Catch:{ all -> 0x0021 }
        L_0x001e:
            return
        L_0x001f:
            monitor-exit(r1)     // Catch:{ all -> 0x0021 }
            goto L_0x001e
        L_0x0021:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0021 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.C0544a.mo8674a(com.unity3d.player.a$a):void");
    }

    /* renamed from: a */
    public final void mo8675a(byte[] bArr) {
        synchronized (this.f1328f) {
            if (this.f1323a != null) {
                this.f1323a.addCallbackBuffer(bArr);
            }
        }
    }

    /* renamed from: b */
    public final Camera.Size mo8676b() {
        return this.f1325c;
    }

    /* renamed from: c */
    public final void mo8677c() {
        synchronized (this.f1328f) {
            if (this.f1323a != null) {
                this.f1323a.setPreviewCallbackWithBuffer((Camera.PreviewCallback) null);
                this.f1323a.stopPreview();
                this.f1323a.release();
                this.f1323a = null;
            }
        }
    }
}
