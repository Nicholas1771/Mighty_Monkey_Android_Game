package com.google.android.gms.internal;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: com.google.android.gms.internal.hj */
final class C0501hj extends ContentObserver {
    C0501hj(Handler handler) {
        super((Handler) null);
    }

    public final void onChange(boolean z) {
        C0500hi.zzbUd.set(true);
    }
}
