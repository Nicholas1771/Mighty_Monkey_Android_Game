package com.unity3d.player;

import android.app.Presentation;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* renamed from: com.unity3d.player.f */
public final class C0553f implements C0551d {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Object f1343a = new Object[0];
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Presentation f1344b;

    /* renamed from: c */
    private DisplayManager.DisplayListener f1345c;

    /* renamed from: a */
    public final void mo8685a(Context context) {
        DisplayManager displayManager;
        if (this.f1345c != null && (displayManager = (DisplayManager) context.getSystemService("display")) != null) {
            displayManager.unregisterDisplayListener(this.f1345c);
        }
    }

    /* renamed from: a */
    public final void mo8686a(final UnityPlayer unityPlayer, Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager != null) {
            displayManager.registerDisplayListener(new DisplayManager.DisplayListener() {
                public final void onDisplayAdded(int i) {
                    unityPlayer.displayChanged(-1, (Surface) null);
                }

                public final void onDisplayChanged(int i) {
                    unityPlayer.displayChanged(-1, (Surface) null);
                }

                public final void onDisplayRemoved(int i) {
                    unityPlayer.displayChanged(-1, (Surface) null);
                }
            }, (Handler) null);
        }
    }

    /* renamed from: a */
    public final boolean mo8687a(final UnityPlayer unityPlayer, final Context context, int i) {
        Display display;
        synchronized (this.f1343a) {
            if (this.f1344b != null && this.f1344b.isShowing() && (display = this.f1344b.getDisplay()) != null && display.getDisplayId() == i) {
                return true;
            }
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager == null) {
                return false;
            }
            final Display display2 = displayManager.getDisplay(i);
            if (display2 == null) {
                return false;
            }
            unityPlayer.mo8576b((Runnable) new Runnable() {
                public final void run() {
                    synchronized (C0553f.this.f1343a) {
                        if (C0553f.this.f1344b != null) {
                            C0553f.this.f1344b.dismiss();
                        }
                        Presentation unused = C0553f.this.f1344b = new Presentation(context, display2) {
                            /* access modifiers changed from: protected */
                            public final void onCreate(Bundle bundle) {
                                SurfaceView surfaceView = new SurfaceView(context);
                                surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
                                    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                                        unityPlayer.displayChanged(1, surfaceHolder.getSurface());
                                    }

                                    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                                        unityPlayer.displayChanged(1, surfaceHolder.getSurface());
                                    }

                                    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                                        unityPlayer.displayChanged(1, (Surface) null);
                                    }
                                });
                                setContentView(surfaceView);
                            }

                            public final void onDisplayRemoved() {
                                dismiss();
                                synchronized (C0553f.this.f1343a) {
                                    Presentation unused = C0553f.this.f1344b = null;
                                }
                            }
                        };
                        C0553f.this.f1344b.show();
                    }
                }
            });
            return true;
        }
    }
}
