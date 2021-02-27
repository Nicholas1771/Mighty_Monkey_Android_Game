package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.adview.InterstitialAdDialogCreator;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

public class MediatedInterstitialAdDialogCreatorImpl implements InterstitialAdDialogCreator {

    /* renamed from: a */
    private static final Object f160a = new Object();

    /* renamed from: b */
    private static WeakReference<C0260cg> f161b = new WeakReference<>((Object) null);

    /* renamed from: c */
    private static WeakReference<Context> f162c = new WeakReference<>((Object) null);

    public AppLovinInterstitialAdDialog createInterstitialAdDialog(AppLovinSdk appLovinSdk, Context context) {
        C0260cg cgVar;
        if (!(context instanceof Activity)) {
            throw new IllegalArgumentException("Specified context is not an activity");
        }
        if (appLovinSdk == null) {
            appLovinSdk = AppLovinSdk.getInstance(context);
        }
        synchronized (f160a) {
            cgVar = (C0260cg) f161b.get();
            if (cgVar == null || !cgVar.isShowing() || f162c.get() != context) {
                C0260cg cgVar2 = new C0260cg(appLovinSdk, (Activity) context);
                f161b = new WeakReference<>(cgVar2);
                f162c = new WeakReference<>(context);
                cgVar = cgVar2;
            } else {
                appLovinSdk.getLogger().mo4785w("InterstitialAdDialogCreator", "An interstitial dialog is already showing, returning it");
            }
        }
        return cgVar;
    }
}
