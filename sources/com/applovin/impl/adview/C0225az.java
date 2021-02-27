package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinTouchToClickListener;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.AppLovinSdkImpl;
import com.applovin.impl.sdk.C0296ad;
import com.applovin.impl.sdk.C0298af;
import com.applovin.impl.sdk.C0300ah;
import com.applovin.impl.sdk.C0321bb;
import com.applovin.impl.sdk.C0330bk;
import com.applovin.impl.sdk.C0391dr;
import com.applovin.impl.sdk.C0392ds;
import com.applovin.impl.sdk.C0395dv;
import com.applovin.impl.sdk.C0444fq;
import com.applovin.impl.sdk.C0450g;
import com.applovin.impl.sdk.C0463t;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.adview.az */
public abstract class C0225az extends Activity implements C0216aq {
    public static final String KEY_WRAPPER_ID = "com.applovin.interstitial.wrapper_id";
    public static volatile C0252bz lastKnownWrapper = null;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public C0210ak f241A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public View f242B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public C0208ai f243C;

    /* renamed from: D */
    private ImageView f244D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public WeakReference<MediaPlayer> f245E = new WeakReference<>((Object) null);

    /* renamed from: F */
    private C0321bb f246F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public C0265cl f247G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public ProgressBar f248H;

    /* renamed from: I */
    private C0267cn f249I;

    /* renamed from: a */
    private AppLovinAdView f250a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C0252bz f251b;

    /* renamed from: c */
    private volatile boolean f252c = false;
    protected int computedLengthSeconds = 0;
    protected C0212am countdownManager;
    public volatile C0296ad currentAd;
    public String currentPlacement;

    /* renamed from: d */
    private C0395dv f253d;

    /* renamed from: e */
    private volatile boolean f254e = false;

    /* renamed from: f */
    private volatile boolean f255f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile boolean f256g = false;

    /* renamed from: h */
    private volatile boolean f257h = false;

    /* renamed from: i */
    private volatile boolean f258i = false;

    /* renamed from: j */
    private volatile boolean f259j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public volatile boolean f260k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public volatile boolean f261l = false;
    public AppLovinLogger logger;

    /* renamed from: m */
    private boolean f262m = false;

    /* renamed from: n */
    private volatile boolean f263n = false;

    /* renamed from: o */
    private boolean f264o = true;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f265p = false;
    protected volatile boolean poststitialWasDisplayed = false;

    /* renamed from: q */
    private boolean f266q = false;

    /* renamed from: r */
    private long f267r = 0;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public long f268s = 0;
    public AppLovinSdkImpl sdk;
    public C0391dr settingsProxy;

    /* renamed from: t */
    private int f269t = 0;

    /* renamed from: u */
    private AtomicBoolean f270u = new AtomicBoolean(false);

    /* renamed from: v */
    private Handler f271v;
    protected volatile boolean videoMuted = false;
    public AppLovinVideoView videoView;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public Handler f272w;

    /* renamed from: x */
    private FrameLayout f273x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public C0210ak f274y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public View f275z;

    /* renamed from: A */
    private boolean m226A() {
        return m232E() && !isFullyWatched() && this.settingsProxy.mo4546E() && this.f246F != null;
    }

    /* renamed from: B */
    private boolean m228B() {
        return m233F() && !m231D() && this.settingsProxy.mo4547F() && this.f246F != null;
    }

    /* renamed from: C */
    private int m229C() {
        if (!(this.currentAd instanceof C0450g)) {
            return 0;
        }
        float h = ((C0450g) this.currentAd).mo4761h();
        if (h <= 0.0f) {
            h = this.currentAd.mo4295q();
        }
        return (int) Math.min((C0444fq.m1148a(System.currentTimeMillis() - this.f267r) / ((double) h)) * 100.0d, 100.0d);
    }

    /* renamed from: D */
    private boolean m231D() {
        return m229C() >= this.currentAd.mo4268K();
    }

    /* renamed from: E */
    private boolean m232E() {
        return AppLovinAdType.INCENTIVIZED.equals(this.currentAd.getType());
    }

    /* renamed from: F */
    private boolean m233F() {
        return !this.currentAd.mo3867f() && m232E();
    }

    /* renamed from: G */
    private void m234G() {
        if (this.f252c && !this.f266q) {
            return;
        }
        if (this.f250a != null) {
            this.f250a.setAdDisplayListener(new C0239bm(this));
            this.f250a.setAdClickListener(new C0240bn(this));
            this.currentAd = (C0296ad) this.f251b.mo4069b();
            m250a(this.currentAd);
            m282k();
            this.f263n = this.currentAd.mo3860b();
            if (this.f263n) {
                this.logger.mo4779d("InterActivity", "Preparing stream for " + this.currentAd.mo3864d());
            } else {
                this.logger.mo4779d("InterActivity", "Preparing cached video playback for " + this.currentAd.mo3864d());
            }
            m245a(this.currentAd.mo3864d());
            this.f274y.bringToFront();
            if (m290o() && this.f275z != null) {
                this.f275z.bringToFront();
            }
            if (this.f241A != null) {
                this.f241A.bringToFront();
            }
            if (!this.currentAd.mo4274Q()) {
                this.f250a.renderAd(this.currentAd, this.currentPlacement);
            }
            this.f251b.mo4068a(true);
            if (!this.currentAd.mo3867f()) {
                if (m233F() && this.settingsProxy.mo4552K()) {
                    m269d((AppLovinAd) this.currentAd);
                }
                showPoststitial();
                return;
            }
            return;
        }
        exitWithError("AdView was null");
    }

    /* renamed from: H */
    private boolean m235H() {
        return this.videoMuted;
    }

    /* renamed from: I */
    private void m236I() {
        this.sdk.put(C0392ds.f999h, Integer.valueOf(this.videoView.getCurrentPosition()));
        this.sdk.put(C0392ds.f1000i, true);
        try {
            this.countdownManager.mo3997c();
        } catch (Throwable th) {
            this.logger.mo4781e("InterActivity", "Unable to pause countdown timers", th);
        }
        this.videoView.pause();
    }

    /* renamed from: J */
    private void m237J() {
        long max = Math.max(0, new C0391dr(this.sdk).mo4570ab());
        if (max > 0) {
            this.sdk.getLogger().mo4779d("InterActivity", "Resuming video with delay of " + max);
            this.f272w.postDelayed(new C0241bo(this), max);
            return;
        }
        this.sdk.getLogger().mo4779d("InterActivity", "Resuming video immediately");
        m238K();
    }

    /* access modifiers changed from: private */
    /* renamed from: K */
    public void m238K() {
        if (!this.poststitialWasDisplayed && this.videoView != null && !this.videoView.isPlaying()) {
            this.videoView.seekTo(((Integer) this.sdk.get(C0392ds.f999h, Integer.valueOf(this.videoView.getDuration()))).intValue());
            this.videoView.start();
            this.countdownManager.mo3994a();
        }
    }

    /* renamed from: L */
    private void m239L() {
        if (!this.f259j) {
            try {
                if (this.currentAd.mo3867f()) {
                    double videoPercentViewed = (double) getVideoPercentViewed();
                    String a = this.currentAd.mo4283a((int) videoPercentViewed, this.currentPlacement, this.f263n);
                    if (C0444fq.isValidString(a)) {
                        this.sdk.getPostbackService().dispatchPostbackAsync(a, (AppLovinPostbackListener) null);
                    } else {
                        this.logger.mo4780e("InterActivity", "Received invalid placement aware parameterized video completion url. No postback dispatched.");
                    }
                    m252a((AppLovinAd) this.currentAd, videoPercentViewed, isFullyWatched());
                } else if ((this.currentAd instanceof C0450g) && m233F() && this.settingsProxy.mo4552K()) {
                    int C = m229C();
                    this.logger.mo4779d("InterActivity", "Rewarded playable engaged at " + C + " percent");
                    m252a((AppLovinAd) this.currentAd, (double) C, C >= this.currentAd.mo4268K());
                }
            } catch (Throwable th) {
                if (this.logger != null) {
                    this.logger.mo4781e("InterActivity", "Failed to notify end listener.", th);
                }
            }
        }
    }

    /* renamed from: a */
    private int m240a(int i) {
        return AppLovinSdkUtils.dpToPx(this, i);
    }

    /* renamed from: a */
    private int m241a(int i, boolean z) {
        if (z) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 9;
            }
            if (i == 2) {
                return 8;
            }
            if (i == 3) {
                return 1;
            }
        } else if (i == 0) {
            return 1;
        } else {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 9;
            }
            if (i == 3) {
                return 8;
            }
        }
        return -1;
    }

    /* renamed from: a */
    private static int m242a(Display display) {
        if (display.getWidth() == display.getHeight()) {
            return 3;
        }
        return display.getWidth() < display.getHeight() ? 1 : 2;
    }

    /* renamed from: a */
    private void m244a(long j, C0210ak akVar) {
        this.f272w.postDelayed(new C0232bf(this, akVar), j);
    }

    /* renamed from: a */
    private void m245a(Uri uri) {
        this.videoView = new AppLovinVideoView(this);
        if (uri != null) {
            this.videoView.setOnPreparedListener(new C0242bp(this));
            this.videoView.setOnCompletionListener(new C0245bs(this));
            this.videoView.setOnErrorListener(new C0246bt(this));
            this.videoView.setVideoURI(uri);
        }
        this.videoView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        this.videoView.setOnTouchListener(new AppLovinTouchToClickListener(this, new C0248bv(this)));
        this.f273x.addView(this.videoView);
        setContentView(this.f273x);
        m295q();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m246a(View view, boolean z, long j) {
        float f = 1.0f;
        float f2 = z ? 0.0f : 1.0f;
        if (!z) {
            f = 0.0f;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setAnimationListener(new C0238bl(this, view, z));
        view.startAnimation(alphaAnimation);
    }

    /* renamed from: a */
    private void m250a(C0296ad adVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.f273x = new FrameLayout(this);
        this.f273x.setLayoutParams(layoutParams);
        this.f273x.setBackgroundColor(adVar.mo4262E());
        this.f272w = new Handler();
        this.f271v = new Handler();
        this.countdownManager = new C0212am(this.f271v, this.sdk);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m251a(AppLovinAd appLovinAd) {
        C0330bk.m642a(this.f251b.mo4071d(), appLovinAd, (AppLovinSdk) this.sdk);
        this.f256g = true;
    }

    /* renamed from: a */
    private void m252a(AppLovinAd appLovinAd, double d, boolean z) {
        this.f259j = true;
        C0330bk.m646a(this.f251b.mo4070c(), appLovinAd, d, z, this.sdk);
    }

    /* renamed from: a */
    private void m253a(boolean z) {
        AppLovinSdkUtils.safePopulateImageView(this.f244D, z ? this.currentAd.mo4280W() : this.currentAd.mo4281X(), m240a(this.settingsProxy.mo4600s()));
    }

    /* renamed from: a */
    private boolean m254a() {
        int identifier = getResources().getIdentifier(this.settingsProxy.mo4554M(), "bool", "android");
        return identifier > 0 && getResources().getBoolean(identifier);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m256b() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* renamed from: b */
    private void m257b(int i, boolean z) {
        int i2 = 0;
        int i3 = 1;
        boolean J = this.settingsProxy.mo4551J();
        if (this.f251b.mo4073f() == C0298af.ACTIVITY_PORTRAIT) {
            if (z) {
                if (i != 1 && i != 3) {
                    this.f252c = true;
                    setRequestedOrientation(1);
                } else if (!J) {
                } else {
                    if (i == 1) {
                        setRequestedOrientation(9);
                    } else {
                        setRequestedOrientation(1);
                    }
                }
            } else if (i != 0 && i != 2) {
                this.f252c = true;
                setRequestedOrientation(1);
            } else if (J) {
                if (i != 0) {
                    i3 = 9;
                }
                setRequestedOrientation(i3);
            }
        } else if (this.f251b.mo4073f() != C0298af.ACTIVITY_LANDSCAPE) {
        } else {
            if (z) {
                if (i != 0 && i != 2) {
                    this.f252c = true;
                    setRequestedOrientation(0);
                } else if (J) {
                    setRequestedOrientation(i == 2 ? 8 : 0);
                }
            } else if (i != 1 && i != 3) {
                this.f252c = true;
                setRequestedOrientation(0);
            } else if (J) {
                if (i != 1) {
                    i2 = 8;
                }
                setRequestedOrientation(i2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m259b(AppLovinAd appLovinAd) {
        dismiss();
        m264c(appLovinAd);
    }

    /* renamed from: b */
    private void m260b(boolean z) {
        this.videoMuted = z;
        MediaPlayer mediaPlayer = (MediaPlayer) this.f245E.get();
        if (mediaPlayer != null) {
            int i = z ? 0 : 1;
            mediaPlayer.setVolume((float) i, (float) i);
        }
    }

    /* renamed from: c */
    private void m264c(AppLovinAd appLovinAd) {
        if (!this.f257h) {
            this.f257h = true;
            if (this.f251b != null) {
                C0330bk.m650b(this.f251b.mo4071d(), appLovinAd, this.sdk);
            }
        }
    }

    /* renamed from: c */
    private boolean m265c() {
        if (this.f251b == null || this.settingsProxy == null || this.settingsProxy.mo4568a()) {
            return true;
        }
        if (!this.settingsProxy.mo4584c() || !this.f260k) {
            return this.settingsProxy.mo4583b() && this.poststitialWasDisplayed;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m268d() {
        if (!this.currentAd.mo3874x() || this.currentAd.mo3868g() == null) {
            m272f();
            m274g();
            return;
        }
        this.sdk.getLogger().mo4779d("InterActivity", "Clicking through video...");
        clickThroughFromVideo();
    }

    /* renamed from: d */
    private void m269d(AppLovinAd appLovinAd) {
        if (!this.f258i) {
            this.f258i = true;
            C0330bk.m647a(this.f251b.mo4070c(), appLovinAd, (AppLovinSdk) this.sdk);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m270e() {
        if (this.f253d.mo4631b() == -1) {
            this.f253d.mo4632b(System.currentTimeMillis() - this.f267r);
        }
    }

    /* renamed from: f */
    private void m272f() {
        if (this.settingsProxy.mo4597p() && this.f243C != null && this.f243C.getVisibility() != 8) {
            m246a((View) this.f243C, this.f243C.getVisibility() == 4, 750);
        }
    }

    /* renamed from: g */
    private void m274g() {
        C0264ck w = this.currentAd.mo4301w();
        if (w != null && w.mo4095e() && !this.poststitialWasDisplayed && this.f247G != null) {
            m246a((View) this.f247G, this.f247G.getVisibility() == 4, w.mo4097f());
        }
    }

    /* renamed from: h */
    private void m276h() {
        if (this.sdk != null) {
            this.sdk.put(C0392ds.f1000i, false);
            this.sdk.put(C0392ds.f999h, 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m278i() {
        this.f255f = true;
        showPoststitial();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public boolean m281j() {
        return ((Integer) this.sdk.get(C0392ds.f999h, 0)).intValue() > 0 ? this.videoMuted : this.settingsProxy.mo4606y() ? this.sdk.getSettings().isMuted() : this.settingsProxy.mo4604w();
    }

    /* renamed from: k */
    private void m282k() {
        int i = 3;
        this.f274y = C0210ak.m194a(this.sdk, this, this.currentAd.mo4296r());
        this.f274y.setVisibility(8);
        this.f274y.setOnClickListener(new C0249bw(this));
        int a = m240a(this.currentAd.mo4269L());
        int i2 = (this.currentAd.mo4272O() ? 3 : 5) | 48;
        if (!this.currentAd.mo4273P()) {
            i = 5;
        }
        int i3 = i | 48;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a, a, i2 | 48);
        this.f274y.mo3993a(a);
        int a2 = m240a(this.currentAd.mo4270M());
        int a3 = m240a(this.currentAd.mo4271N());
        layoutParams.setMargins(a3, a2, a3, a2);
        this.f273x.addView(this.f274y, layoutParams);
        this.f241A = C0210ak.m194a(this.sdk, this, this.currentAd.mo4297s());
        this.f241A.setVisibility(8);
        this.f241A.setOnClickListener(new C0250bx(this));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a, a, i3);
        layoutParams2.setMargins(a3, a2, a3, a2);
        this.f241A.mo3993a(a);
        this.f273x.addView(this.f241A, layoutParams2);
        this.f241A.bringToFront();
        if (m290o()) {
            int a4 = m240a(new C0391dr(this.sdk).mo4592k());
            this.f275z = new View(this);
            this.f275z.setBackgroundColor(0);
            this.f275z.setVisibility(8);
            this.f242B = new View(this);
            this.f242B.setBackgroundColor(0);
            this.f242B.setVisibility(8);
            int i4 = a + a4;
            int a5 = a2 - m240a(5);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i4, i4, i2);
            layoutParams3.setMargins(a5, a5, a5, a5);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(i4, i4, i3);
            layoutParams4.setMargins(a5, a5, a5, a5);
            this.f275z.setOnClickListener(new C0251by(this));
            this.f242B.setOnClickListener(new C0228bb(this));
            this.f273x.addView(this.f275z, layoutParams3);
            this.f275z.bringToFront();
            this.f273x.addView(this.f242B, layoutParams4);
            this.f242B.bringToFront();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m284l() {
        if (this.f244D == null) {
            try {
                this.videoMuted = m281j();
                this.f244D = new ImageView(this);
                if (!m287m()) {
                    int a = m240a(this.settingsProxy.mo4600s());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a, a, this.settingsProxy.mo4601t());
                    this.f244D.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    int a2 = m240a(this.settingsProxy.mo4602u());
                    layoutParams.setMargins(a2, a2, a2, a2);
                    Uri W = this.videoMuted ? this.currentAd.mo4280W() : this.currentAd.mo4281X();
                    if (W != null) {
                        this.sdk.getLogger().mo4779d("InterActivity", "Added mute button with params: " + layoutParams);
                        m253a(this.videoMuted);
                        this.f244D.setClickable(true);
                        this.f244D.setOnClickListener(new C0229bc(this));
                        this.f273x.addView(this.f244D, layoutParams);
                        this.f244D.bringToFront();
                        return;
                    }
                    this.sdk.getLogger().mo4780e("InterActivity", "Attempting to add mute button but could not find uri = " + W);
                    return;
                }
                this.sdk.getLogger().mo4779d("InterActivity", "Mute button should be hidden");
            } catch (Exception e) {
                this.sdk.getLogger().mo4786w("InterActivity", "Failed to attach mute button", e);
            }
        }
    }

    /* renamed from: m */
    private boolean m287m() {
        if (!this.settingsProxy.mo4598q()) {
            return true;
        }
        if (!this.settingsProxy.mo4599r()) {
            return false;
        }
        if (m281j()) {
            return false;
        }
        return !this.settingsProxy.mo4605x();
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m289n() {
        runOnUiThread(new C0230bd(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public boolean m290o() {
        return this.settingsProxy.mo4592k() > 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m292p() {
        runOnUiThread(new C0231be(this));
    }

    /* renamed from: q */
    private void m295q() {
        if (this.currentAd.mo4294p() >= 0.0f) {
            m244a(C0444fq.m1171c(this.currentAd.mo4294p()), (!this.f262m || this.f241A == null) ? this.f274y : this.f241A);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m296r() {
        boolean z = this.settingsProxy.mo4589h() && m302u() > 0;
        if (this.f243C == null && z) {
            this.f243C = new C0208ai(this);
            int D = this.currentAd.mo4261D();
            this.f243C.mo3975c(D);
            this.f243C.mo3972b((float) this.settingsProxy.mo4588g());
            this.f243C.mo3977d(D);
            this.f243C.mo3969a((float) this.settingsProxy.mo4587f());
            this.f243C.mo3973b(m302u());
            this.f243C.mo3970a(m302u());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(m240a(this.settingsProxy.mo4586e()), m240a(this.settingsProxy.mo4586e()), this.settingsProxy.mo4596o());
            int a = m240a(this.settingsProxy.mo4595n());
            layoutParams.setMargins(a, a, a, a);
            this.f273x.addView(this.f243C, layoutParams);
            this.f243C.bringToFront();
            this.f243C.setVisibility(0);
            this.countdownManager.mo3995a("COUNTDOWN_CLOCK", 1000, (C0214ao) new C0233bg(this, m300t()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public boolean m299s() {
        return !this.f265p && !this.poststitialWasDisplayed && this.videoView.isPlaying();
    }

    /* renamed from: t */
    private long m300t() {
        return TimeUnit.SECONDS.toMillis((long) m302u());
    }

    /* renamed from: u */
    private int m302u() {
        int C = this.currentAd.mo4260C();
        return (C <= 0 && this.settingsProxy.mo4594m()) ? this.computedLengthSeconds + 1 : C;
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: v */
    public void m305v() {
        if (this.f248H == null && this.currentAd.mo4266I()) {
            this.logger.mo4782i("InterActivity", "Attaching video progress bar...");
            this.f248H = new ProgressBar(this, (AttributeSet) null, 16842872);
            this.f248H.setMax(this.settingsProxy.mo4572ad());
            this.f248H.setPadding(0, 0, 0, 0);
            if (C0463t.m1259g()) {
                try {
                    this.f248H.setProgressTintList(ColorStateList.valueOf(this.currentAd.mo4267J()));
                } catch (Throwable th) {
                    this.logger.mo4781e("InterActivity", "Unable to update progress bar color.", th);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.videoView.getWidth(), 20, 80);
            layoutParams.setMargins(0, 0, 0, this.settingsProxy.mo4573ae());
            this.f273x.addView(this.f248H, layoutParams);
            this.f248H.bringToFront();
            this.countdownManager.mo3995a("PROGRESS_BAR", this.settingsProxy.mo4571ac(), (C0214ao) new C0234bh(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public void m306w() {
        C0264ck w = this.currentAd.mo4301w();
        if (AppLovinSdkUtils.isValidString(this.currentAd.mo4300v()) && w != null && this.f247G == null) {
            this.logger.mo4782i("InterActivity", "Attaching video button...");
            this.f247G = m309x();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) ((((double) w.mo4091a()) / 100.0d) * ((double) this.videoView.getWidth())), (int) (((double) this.videoView.getHeight()) * (((double) w.mo4092b()) / 100.0d)), w.mo4094d());
            int a = m240a(w.mo4093c());
            layoutParams.setMargins(a, a, a, a);
            this.f273x.addView(this.f247G, layoutParams);
            this.f247G.bringToFront();
            if (w.mo4101i() > 0.0f) {
                this.f247G.setVisibility(4);
                this.f272w.postDelayed(new C0235bi(this, w), C0444fq.m1171c(w.mo4101i()));
            }
            if (w.mo4102j() > 0.0f) {
                this.f272w.postDelayed(new C0236bj(this, w), C0444fq.m1171c(w.mo4102j()));
            }
        }
    }

    /* renamed from: x */
    private C0265cl m309x() {
        this.logger.mo4779d("InterActivity", "Create video button with HTML = " + this.currentAd.mo4300v());
        C0266cm cmVar = new C0266cm(this.sdk);
        this.f249I = new C0237bk(this);
        cmVar.mo4106a(new WeakReference(this.f249I));
        C0265cl clVar = new C0265cl(cmVar, getApplicationContext());
        clVar.mo4104a(this.currentAd.mo4300v());
        return clVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m311y() {
        if (m226A()) {
            m236I();
            this.logger.mo4779d("InterActivity", "Prompting incentivized ad close warning");
            this.f246F.mo4367b();
            return;
        }
        skipVideo();
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public void m312z() {
        if (m228B()) {
            this.logger.mo4779d("InterActivity", "Prompting incentivized non-video ad close warning");
            this.f246F.mo4368c();
            return;
        }
        dismiss();
    }

    public void clickThroughFromVideo() {
        try {
            m270e();
            ((AppLovinAdServiceImpl) this.sdk.getAdService()).trackAndLaunchVideoClick(this.currentAd, this.currentPlacement, this.f250a, this.currentAd.mo3868g());
            C0330bk.m641a(this.f251b.mo4072e(), (AppLovinAd) this.currentAd, (AppLovinSdk) this.sdk);
        } catch (Throwable th) {
            this.sdk.getLogger().mo4781e("InterActivity", "Encountered error while clicking through video.", th);
        }
    }

    public void continueVideo() {
        m238K();
    }

    public void dismiss() {
        long currentTimeMillis = System.currentTimeMillis() - this.f267r;
        this.f253d.mo4629a(currentTimeMillis);
        this.logger.mo4782i("InterActivity", "Dismissing ad after " + currentTimeMillis + " milliseconds elapsed");
        ((AdViewControllerImpl) this.f250a.getAdViewController()).setIsForegroundClickInvalidated(true);
        m276h();
        m239L();
        if (this.f251b != null) {
            if (this.currentAd != null) {
                m264c((AppLovinAd) this.currentAd);
            }
            this.f251b.mo4068a(false);
            this.f251b.mo4075h();
        }
        finish();
    }

    public void exitWithError(String str) {
        try {
            Log.e("InterActivity", "Failed to properly render an Interstitial Activity, due to error: " + str, new Throwable("Initialized = " + C0252bz.f312d + "; CleanedUp = " + C0252bz.f313e));
            m264c((AppLovinAd) new C0300ah());
        } catch (Exception e) {
            Log.e("InterActivity", "Failed to show a video ad due to error:", e);
        }
        finish();
    }

    public boolean getPoststitialWasDisplayed() {
        return this.poststitialWasDisplayed;
    }

    public int getVideoPercentViewed() {
        if (this.f255f) {
            return 100;
        }
        if (this.videoView != null) {
            int duration = this.videoView.getDuration();
            return duration > 0 ? (int) ((((double) this.videoView.getCurrentPosition()) / ((double) duration)) * 100.0d) : this.f269t;
        }
        this.logger.mo4780e("InterActivity", "No video view detected on video end");
        return 0;
    }

    public void handleMediaError() {
        if (this.f270u.compareAndSet(false, true)) {
            if (this.settingsProxy.mo4591j()) {
                this.logger.mo4780e("InterActivity", "Handling media player error - Finishing activity...");
                finish();
            } else {
                this.logger.mo4780e("InterActivity", "Handling media player error - Showing poststitial...");
                showPoststitial();
            }
            this.logger.mo4780e("InterActivity", "Finished handling media player error.");
            return;
        }
        this.logger.mo4780e("InterActivity", "Already handled media player error. Doing nothing...");
    }

    /* access modifiers changed from: protected */
    public boolean isFullyWatched() {
        return getVideoPercentViewed() >= this.currentAd.mo4268K();
    }

    public void onBackPressed() {
        if (m265c()) {
            this.logger.mo4779d("InterActivity", "Back button was pressed; forwarding to Android for handling...");
            super.onBackPressed();
            return;
        }
        try {
            if (this.f262m && this.f241A != null && this.f241A.getVisibility() == 0 && this.f241A.getAlpha() > 0.0f && !this.f260k) {
                this.logger.mo4779d("InterActivity", "Back button was pressed; forwarding as a click to skip button.");
                this.f241A.performClick();
            } else if (this.f274y == null || this.f274y.getVisibility() != 0 || this.f274y.getAlpha() <= 0.0f) {
                this.logger.mo4779d("InterActivity", "Back button was pressed, but was not eligible for dismissal.");
            } else {
                this.logger.mo4779d("InterActivity", "Back button was pressed; forwarding as a click to close button.");
                this.f274y.performClick();
            }
        } catch (Exception e) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        try {
            String stringExtra = getIntent().getStringExtra(KEY_WRAPPER_ID);
            if (stringExtra == null || stringExtra.isEmpty()) {
                exitWithError("Wrapper ID is null");
                m276h();
                m234G();
            }
            this.f251b = C0252bz.m321a(stringExtra);
            if (this.f251b == null && lastKnownWrapper != null) {
                this.f251b = lastKnownWrapper;
            }
            if (this.f251b != null) {
                AppLovinAd b = this.f251b.mo4069b();
                this.sdk = (AppLovinSdkImpl) this.f251b.mo4065a();
                this.logger = this.f251b.mo4065a().getLogger();
                this.settingsProxy = new C0391dr(this.f251b.mo4065a());
                this.f253d = new C0395dv(this.sdk);
                this.currentPlacement = this.f251b.mo4074g();
                if (b != null) {
                    C0296ad adVar = (C0296ad) b;
                    View findViewById = findViewById(16908290);
                    if (findViewById != null) {
                        if (adVar.mo3867f()) {
                            findViewById.setBackgroundColor(adVar.mo4262E());
                        } else {
                            findViewById.setBackgroundColor(adVar.mo4263F());
                        }
                    }
                    this.f267r = System.currentTimeMillis();
                    this.f253d.mo4630a(b);
                    this.f253d.mo4632b(-1);
                    if (adVar.mo4302y()) {
                        getWindow().setFlags(16777216, 16777216);
                    }
                    Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
                    int a = m242a(defaultDisplay);
                    int rotation = defaultDisplay.getRotation();
                    boolean z = (a == 2 && rotation == 0) || (a == 2 && rotation == 2) || ((a == 1 && rotation == 1) || (a == 1 && rotation == 3));
                    if (adVar.mo4259B()) {
                        int a2 = m241a(rotation, z);
                        if (a2 != -1) {
                            this.logger.mo4779d("InterActivity", "Locking activity orientation to current orientation: " + a2);
                            setRequestedOrientation(a2);
                        } else {
                            this.logger.mo4780e("InterActivity", "Unable to detect current orientation. Locking to targeted orientation...");
                            m257b(rotation, z);
                        }
                    } else {
                        this.logger.mo4779d("InterActivity", "Locking activity orientation to targeted orientation...");
                        m257b(rotation, z);
                    }
                    this.f250a = new AppLovinAdView((AppLovinSdk) this.sdk, AppLovinAdSize.INTERSTITIAL, (Context) this);
                    this.f250a.setAutoDestroy(false);
                    this.f251b.mo4066a((C0216aq) this);
                    this.f262m = this.settingsProxy.mo4593l();
                    this.f266q = C0463t.m1249a(getApplicationContext()) || C0463t.m1249a(getApplicationContext());
                    this.f246F = new C0321bb(this.sdk, this);
                } else {
                    exitWithError("No current ad found.");
                }
            } else {
                exitWithError("Wrapper is null; initialized state: " + Boolean.toString(C0252bz.f312d));
            }
            m276h();
            m234G();
        } catch (Throwable th) {
            if (this.logger != null) {
                this.logger.mo4781e("InterActivity", "Encountered error during onCreate.", th);
            }
            exitWithError("An error was encountered during interstitial ad creation.");
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            if (this.f250a != null) {
                ViewParent parent = this.f250a.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(this.f250a);
                }
                this.f250a.destroy();
                this.f250a = null;
            }
            if (this.videoView != null) {
                this.videoView.pause();
                this.videoView.stopPlayback();
            }
            if (this.countdownManager != null) {
                this.countdownManager.mo3996b();
            }
            if (this.f272w != null) {
                this.f272w.removeCallbacksAndMessages((Object) null);
            }
            if (this.f271v != null) {
                this.f271v.removeCallbacksAndMessages((Object) null);
            }
            if (this.currentAd != null) {
                m239L();
                m264c((AppLovinAd) this.currentAd);
            }
        } catch (Throwable th) {
            if (this.currentAd != null) {
                m239L();
                m264c((AppLovinAd) this.currentAd);
            }
            throw th;
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.logger.mo4779d("InterActivity", "App paused...");
        this.f268s = System.currentTimeMillis();
        if (!this.f254e) {
            if (this.f266q) {
                m236I();
            } else if (!this.f252c) {
                m236I();
            }
        }
        this.f251b.mo4068a(false);
        this.f246F.mo4366a();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.logger.mo4779d("InterActivity", "App resumed...");
        this.f251b.mo4068a(true);
        if (!this.f264o) {
            this.f253d.mo4634c(System.currentTimeMillis() - this.f268s);
            if (!((Boolean) this.sdk.get(C0392ds.f1000i, false)).booleanValue() || this.f246F.mo4369d() || this.poststitialWasDisplayed) {
                boolean i = this.currentAd instanceof C0450g ? ((C0450g) this.currentAd).mo4762i() : false;
                if (this.currentAd != null && this.settingsProxy.mo4590i() && !this.currentAd.mo4303z() && this.poststitialWasDisplayed && this.f274y != null && !i) {
                    m244a(0, this.f274y);
                    return;
                }
                return;
            }
            m237J();
            if (this.currentAd != null && this.settingsProxy.mo4590i() && !this.currentAd.mo4258A() && !this.poststitialWasDisplayed && this.f262m && this.f241A != null) {
                m244a(0, this.f241A);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.logger.mo4779d("InterActivity", "Window gained focus");
            try {
                if (!C0463t.m1258f() || !this.settingsProxy.mo4545D() || !m254a()) {
                    getWindow().setFlags(1024, 1024);
                } else {
                    m256b();
                    if (this.settingsProxy.mo4555N() > 0) {
                        this.f272w.postDelayed(new C0227ba(this), this.settingsProxy.mo4555N());
                    }
                }
                if (this.settingsProxy.mo4553L() && !this.poststitialWasDisplayed) {
                    m237J();
                }
            } catch (Throwable th) {
                this.logger.mo4781e("InterActivity", "Setting window flags failed.", th);
            }
        } else {
            this.logger.mo4779d("InterActivity", "Window lost focus");
            if (this.settingsProxy.mo4553L() && !this.poststitialWasDisplayed) {
                m236I();
            }
        }
        this.f264o = false;
    }

    /* access modifiers changed from: protected */
    public void playVideo() {
        m269d((AppLovinAd) this.currentAd);
        this.videoView.start();
        this.countdownManager.mo3994a();
    }

    /* access modifiers changed from: protected */
    public boolean shouldContinueFullLengthVideoCountdown() {
        return !this.f255f && !this.poststitialWasDisplayed;
    }

    public void showPoststitial() {
        try {
            if (this.videoView != null) {
                this.f269t = getVideoPercentViewed();
                this.videoView.stopPlayback();
            }
            if (this.f250a != null) {
                ViewParent parent = this.f250a.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f250a);
                }
                FrameLayout frameLayout = new FrameLayout(this);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setBackgroundColor(this.currentAd.mo4263F());
                frameLayout.addView(this.f250a);
                if (this.currentAd.mo4274Q()) {
                    this.f250a.renderAd(this.currentAd, this.currentPlacement);
                }
                if (this.f273x != null) {
                    this.f273x.removeAllViewsInLayout();
                }
                if (m290o() && this.f275z != null) {
                    frameLayout.addView(this.f275z);
                    this.f275z.bringToFront();
                }
                if (this.f274y != null) {
                    ViewParent parent2 = this.f274y.getParent();
                    if (parent2 instanceof ViewGroup) {
                        ((ViewGroup) parent2).removeView(this.f274y);
                    }
                    frameLayout.addView(this.f274y);
                    this.f274y.bringToFront();
                }
                setContentView(frameLayout);
                if (this.settingsProxy.mo4549H()) {
                    this.f250a.setVisibility(4);
                    this.f250a.setVisibility(0);
                }
                C0279n adWebView = ((AdViewControllerImpl) this.f250a.getAdViewController()).getAdWebView();
                if (adWebView != null) {
                    adWebView.mo4132a("javascript:al_onPoststitialShow();");
                }
            }
            if (this.currentAd instanceof C0450g ? ((C0450g) this.currentAd).mo4762i() : false) {
                this.logger.mo4779d("InterActivity", "Skip showing of close button");
            } else if (this.currentAd.mo4295q() >= 0.0f) {
                m244a(C0444fq.m1171c(this.currentAd.mo4295q()), this.f274y);
            } else if (this.currentAd.mo4295q() == -2.0f) {
                this.f274y.setVisibility(0);
            } else {
                m244a(0, this.f274y);
            }
            this.poststitialWasDisplayed = true;
        } catch (Throwable th) {
            this.logger.mo4781e("InterActivity", "Encountered error while showing poststitial. Dismissing...", th);
            dismiss();
        }
    }

    public void skipVideo() {
        if (this.currentAd.mo4299u()) {
            dismiss();
        } else {
            showPoststitial();
        }
    }

    public void toggleMute() {
        boolean z = !m235H();
        try {
            m260b(z);
            m253a(z);
        } catch (Throwable th) {
            this.logger.mo4781e("InterActivity", "Unable to set volume to " + z, th);
        }
    }
}
