package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;

public final class zzcpd extends zza {
    public static final Parcelable.Creator<zzcpd> CREATOR = new zzcpe();

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof zzcpd);
    }

    public final int hashCode() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zzd.zzI(parcel, zzd.zze(parcel));
    }
}
