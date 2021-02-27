package com.applovin.impl.adview;

import android.content.Context;
import android.view.View;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.adview.ak */
public abstract class C0210ak extends View {

    /* renamed from: a */
    protected final AppLovinSdk f210a;

    /* renamed from: b */
    protected final Context f211b;

    C0210ak(AppLovinSdk appLovinSdk, Context context) {
        super(context);
        this.f211b = context;
        this.f210a = appLovinSdk;
    }

    /* renamed from: a */
    public static C0210ak m194a(AppLovinSdk appLovinSdk, Context context, C0211al alVar) {
        return alVar.equals(C0211al.Invisible) ? new C0259cf(appLovinSdk, context) : alVar.equals(C0211al.WhiteXOnTransparentGrey) ? new C0261ch(appLovinSdk, context) : new C0268co(appLovinSdk, context);
    }

    /* renamed from: a */
    public abstract void mo3993a(int i);
}
