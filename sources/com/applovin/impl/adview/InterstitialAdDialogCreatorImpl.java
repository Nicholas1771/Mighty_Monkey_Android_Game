package com.applovin.impl.adview;

import android.content.Context;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.adview.InterstitialAdDialogCreator;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

public class InterstitialAdDialogCreatorImpl implements InterstitialAdDialogCreator {

    /* renamed from: a */
    private static final Object f157a = new Object();

    /* renamed from: b */
    private static WeakReference<C0252bz> f158b = new WeakReference<>((Object) null);

    /* renamed from: c */
    private static WeakReference<Context> f159c = new WeakReference<>((Object) null);

    public AppLovinInterstitialAdDialog createInterstitialAdDialog(AppLovinSdk appLovinSdk, Context context) {
        C0252bz bzVar;
        if (appLovinSdk == null) {
            appLovinSdk = AppLovinSdk.getInstance(context);
        }
        synchronized (f157a) {
            bzVar = (C0252bz) f158b.get();
            if (bzVar == null || !bzVar.isShowing() || f159c.get() != context) {
                bzVar = new C0252bz(appLovinSdk, context);
                f158b = new WeakReference<>(bzVar);
                f159c = new WeakReference<>(context);
            } else {
                appLovinSdk.getLogger().mo4785w("InterstitialAdDialogCreator", "An interstitial dialog is already showing, returning it");
            }
        }
        return bzVar;
    }
}
