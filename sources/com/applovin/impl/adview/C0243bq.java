package com.applovin.impl.adview;

import android.media.MediaPlayer;

/* renamed from: com.applovin.impl.adview.bq */
class C0243bq implements MediaPlayer.OnErrorListener {

    /* renamed from: a */
    final /* synthetic */ C0242bp f299a;

    C0243bq(C0242bp bpVar) {
        this.f299a = bpVar;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f299a.f298a.f272w.post(new C0244br(this, i, i2));
        return true;
    }
}
