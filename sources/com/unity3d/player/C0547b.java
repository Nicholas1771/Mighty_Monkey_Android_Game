package com.unity3d.player;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.view.View;

/* renamed from: com.unity3d.player.b */
public final class C0547b implements C0550c {

    /* renamed from: a */
    private static final SurfaceTexture f1336a = new SurfaceTexture(-1);

    /* renamed from: b */
    private static final int f1337b = (C0561i.f1361c ? 5894 : 1);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public volatile boolean f1338c;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1396a(final View view, int i) {
        Handler handler = view.getHandler();
        if (handler == null) {
            mo8680a(view, this.f1338c);
        } else {
            handler.postDelayed(new Runnable() {
                public final void run() {
                    C0547b.this.mo8680a(view, C0547b.this.f1338c);
                }
            }, 1000);
        }
    }

    /* renamed from: a */
    public final void mo8679a(final View view) {
        if (!C0561i.f1362d) {
            view.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                public final void onSystemUiVisibilityChange(int i) {
                    C0547b.this.m1396a(view, 1000);
                }
            });
        }
    }

    /* renamed from: a */
    public final void mo8680a(View view, boolean z) {
        this.f1338c = z;
        view.setSystemUiVisibility(this.f1338c ? view.getSystemUiVisibility() | f1337b : view.getSystemUiVisibility() & (f1337b ^ -1));
    }

    /* renamed from: a */
    public final boolean mo8681a(Camera camera) {
        try {
            camera.setPreviewTexture(f1336a);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: b */
    public final void mo8682b(View view) {
        if (!C0561i.f1361c && this.f1338c) {
            mo8680a(view, false);
            this.f1338c = true;
        }
        m1396a(view, 1000);
    }
}
