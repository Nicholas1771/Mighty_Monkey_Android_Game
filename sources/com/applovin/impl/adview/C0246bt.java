package com.applovin.impl.adview;

import android.media.MediaPlayer;

/* renamed from: com.applovin.impl.adview.bt */
class C0246bt implements MediaPlayer.OnErrorListener {

    /* renamed from: a */
    final /* synthetic */ C0225az f304a;

    C0246bt(C0225az azVar) {
        this.f304a = azVar;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f304a.f272w.post(new C0247bu(this, i, i2));
        return true;
    }
}
