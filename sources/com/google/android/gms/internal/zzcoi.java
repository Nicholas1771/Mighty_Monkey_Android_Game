package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.internal.zzbe;
import java.util.Arrays;

public final class zzcoi extends zza {
    public static final Parcelable.Creator<zzcoi> CREATOR = new zzcoj();
    private final int zzbxu;

    public zzcoi(int i) {
        this.zzbxu = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcoi) {
            return zzbe.equal(Integer.valueOf(this.zzbxu), Integer.valueOf(((zzcoi) obj).zzbxu));
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzbxu)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.zzbxu);
        zzd.zzI(parcel, zze);
    }
}
