package com.applovin.impl.sdk;

import android.content.Intent;
import com.applovin.adview.AppLovinConfirmationActivity;

/* renamed from: com.applovin.impl.sdk.au */
class C0313au implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0312at f551a;

    C0313au(C0312at atVar) {
        this.f551a = atVar;
    }

    public void run() {
        String str = (String) this.f551a.f548a.get(C0387dn.f788W);
        String b = this.f551a.mo4343b();
        String str2 = (String) this.f551a.f548a.get(C0387dn.f820ab);
        if (C0463t.m1250a((Class<?>) AppLovinConfirmationActivity.class, this.f551a.f550c)) {
            try {
                Intent intent = new Intent(this.f551a.f550c, AppLovinConfirmationActivity.class);
                intent.putExtra("dialog_title", str);
                intent.putExtra("dialog_body", b);
                intent.putExtra("dialog_button_text", str2);
                this.f551a.f550c.startActivity(intent);
            } catch (Throwable th) {
                this.f551a.mo4342a(b, th);
            }
        } else {
            this.f551a.mo4342a(b, (Throwable) null);
        }
    }
}
