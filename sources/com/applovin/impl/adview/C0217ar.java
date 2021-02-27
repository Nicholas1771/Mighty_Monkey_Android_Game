package com.applovin.impl.adview;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.applovin.impl.sdk.C0391dr;
import com.applovin.impl.sdk.C0450g;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.adview.ar */
class C0217ar extends Dialog implements C0216aq {

    /* renamed from: a */
    private final Activity f226a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AppLovinSdk f227b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AppLovinLogger f228c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C0279n f229d;

    /* renamed from: e */
    private final C0450g f230e;

    /* renamed from: f */
    private final String f231f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public RelativeLayout f232g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C0210ak f233h;

    C0217ar(C0450g gVar, String str, C0279n nVar, Activity activity, AppLovinSdk appLovinSdk) {
        super(activity, 16973840);
        if (gVar == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (nVar == null) {
            throw new IllegalArgumentException("No main view specified");
        } else if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else {
            this.f227b = appLovinSdk;
            this.f228c = appLovinSdk.getLogger();
            this.f226a = activity;
            this.f229d = nVar;
            this.f230e = gVar;
            this.f231f = str;
            requestWindowFeature(1);
            setCancelable(false);
        }
    }

    /* renamed from: a */
    private int m212a(int i) {
        return AppLovinSdkUtils.dpToPx(this.f226a, i);
    }

    /* renamed from: a */
    private void m214a(C0211al alVar) {
        int i = 9;
        if (this.f233h != null) {
            this.f228c.mo4785w("ExpandedAdDialog", "Attempting to create duplicate close button");
            return;
        }
        this.f233h = C0210ak.m194a(this.f227b, getContext(), alVar);
        this.f233h.setVisibility(8);
        this.f233h.setOnClickListener(new C0221av(this));
        this.f233h.setClickable(false);
        C0391dr drVar = new C0391dr(this.f227b);
        int a = m212a(drVar.mo4557P());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a, a);
        layoutParams.addRule(10);
        layoutParams.addRule(drVar.mo4560S() ? 9 : 11);
        this.f233h.mo3993a(a);
        int a2 = m212a(drVar.mo4559R());
        int a3 = m212a(drVar.mo4558Q());
        layoutParams.setMargins(a3, a2, a3, 0);
        this.f232g.addView(this.f233h, layoutParams);
        this.f233h.bringToFront();
        int a4 = m212a(drVar.mo4561T());
        View view = new View(this.f226a);
        view.setBackgroundColor(0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a + a4, a + a4);
        layoutParams2.addRule(10);
        if (!drVar.mo4560S()) {
            i = 11;
        }
        layoutParams2.addRule(i);
        layoutParams2.setMargins(a3 - m212a(5), a2 - m212a(5), a3 - m212a(5), 0);
        view.setOnClickListener(new C0222aw(this));
        this.f232g.addView(view, layoutParams2);
        view.bringToFront();
    }

    /* renamed from: b */
    private void m216b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f229d.setLayoutParams(layoutParams);
        this.f232g = new RelativeLayout(this.f226a);
        this.f232g.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f232g.setBackgroundColor(-1157627904);
        this.f232g.addView(this.f229d);
        if (!this.f230e.mo4763j()) {
            m214a(this.f230e.mo4764k());
            m219d();
        }
        setContentView(this.f232g);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m217c() {
        this.f229d.mo4133a("javascript:al_onCloseTapped();", (Runnable) new C0218as(this));
    }

    /* renamed from: d */
    private void m219d() {
        this.f226a.runOnUiThread(new C0223ax(this));
    }

    /* renamed from: a */
    public C0450g mo4005a() {
        return this.f230e;
    }

    public void dismiss() {
        this.f226a.runOnUiThread(new C0220au(this));
    }

    public void onBackPressed() {
        this.f229d.mo4133a("javascript:al_onBackPressed();", (Runnable) new C0219at(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m216b();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        try {
            Window window = getWindow();
            if (window != null) {
                window.setFlags(this.f226a.getWindow().getAttributes().flags, this.f226a.getWindow().getAttributes().flags);
                if (this.f230e.mo4302y()) {
                    window.addFlags(16777216);
                    return;
                }
                return;
            }
            this.f228c.mo4780e("ExpandedAdDialog", "Unable to turn on hardware acceleration - window is null");
        } catch (Throwable th) {
            this.f228c.mo4781e("ExpandedAdDialog", "Setting window flags failed.", th);
        }
    }
}
