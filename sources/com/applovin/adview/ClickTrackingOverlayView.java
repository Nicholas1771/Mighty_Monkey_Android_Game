package com.applovin.adview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.applovin.impl.sdk.C0391dr;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;

public class ClickTrackingOverlayView extends RelativeLayout {
    public ClickTrackingOverlayView(Context context, AppLovinSdk appLovinSdk) {
        super(context, (AttributeSet) null, new C0391dr(appLovinSdk).mo4544C());
        m24a(context, appLovinSdk);
    }

    /* renamed from: a */
    private void m24a(Context context, AppLovinSdk appLovinSdk) {
        RelativeLayout.LayoutParams layoutParams;
        C0391dr drVar = new C0391dr(appLovinSdk);
        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setIndeterminate(true);
        int B = drVar.mo4543B();
        if (B == -2 || B == -1) {
            layoutParams = new RelativeLayout.LayoutParams(B, B);
        } else {
            int dpToPx = AppLovinSdkUtils.dpToPx(context, B);
            layoutParams = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
        }
        layoutParams.addRule(13);
        progressBar.setLayoutParams(layoutParams);
        setBackgroundColor(Color.parseColor(drVar.mo4542A()));
        addView(progressBar);
    }
}
