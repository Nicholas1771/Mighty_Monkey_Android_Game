package com.applovin.impl.adview;

import android.media.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.adview.bp */
class C0242bp implements MediaPlayer.OnPreparedListener {

    /* renamed from: a */
    final /* synthetic */ C0225az f298a;

    C0242bp(C0225az azVar) {
        this.f298a = azVar;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        WeakReference unused = this.f298a.f245E = new WeakReference(mediaPlayer);
        int i = this.f298a.m281j() ? 0 : 1;
        mediaPlayer.setVolume((float) i, (float) i);
        int videoWidth = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.f298a.computedLengthSeconds = (int) TimeUnit.MILLISECONDS.toSeconds((long) mediaPlayer.getDuration());
        this.f298a.videoView.setVideoSize(videoWidth, videoHeight);
        mediaPlayer.setDisplay(this.f298a.videoView.getHolder());
        mediaPlayer.setOnErrorListener(new C0243bq(this));
        if (this.f298a.f268s == 0) {
            this.f298a.m296r();
            this.f298a.m284l();
            this.f298a.m306w();
            this.f298a.m305v();
            this.f298a.playVideo();
        }
    }
}
