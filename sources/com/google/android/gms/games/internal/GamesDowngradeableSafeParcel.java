package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.DowngradeableSafeParcel;

public abstract class GamesDowngradeableSafeParcel extends DowngradeableSafeParcel {
    /* access modifiers changed from: protected */
    public static boolean zze(Integer num) {
        return num != null && num.intValue() >= 3200000;
    }
}
