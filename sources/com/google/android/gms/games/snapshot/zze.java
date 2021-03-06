package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.games.internal.zzc;

public final class zze extends zzc implements SnapshotMetadataChange {
    public static final Parcelable.Creator<zze> CREATOR = new zzd();
    private final String zzafa;
    private final Long zzbeA;
    private final Uri zzbeC;
    private final Long zzbeD;
    private BitmapTeleporter zzbeE;

    zze() {
        this((String) null, (Long) null, (BitmapTeleporter) null, (Uri) null, (Long) null);
    }

    zze(String str, Long l, BitmapTeleporter bitmapTeleporter, Uri uri, Long l2) {
        boolean z = true;
        this.zzafa = str;
        this.zzbeD = l;
        this.zzbeE = bitmapTeleporter;
        this.zzbeC = uri;
        this.zzbeA = l2;
        if (this.zzbeE != null) {
            zzbo.zza(this.zzbeC != null ? false : z, (Object) "Cannot set both a URI and an image");
        } else if (this.zzbeC != null) {
            zzbo.zza(this.zzbeE != null ? false : z, (Object) "Cannot set both a URI and an image");
        }
    }

    public final Bitmap getCoverImage() {
        if (this.zzbeE == null) {
            return null;
        }
        return this.zzbeE.zzqO();
    }

    public final String getDescription() {
        return this.zzafa;
    }

    public final Long getPlayedTimeMillis() {
        return this.zzbeD;
    }

    public final Long getProgressValue() {
        return this.zzbeA;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zza(parcel, 1, getDescription(), false);
        zzd.zza(parcel, 2, getPlayedTimeMillis(), false);
        zzd.zza(parcel, 4, (Parcelable) this.zzbeC, i, false);
        zzd.zza(parcel, 5, (Parcelable) this.zzbeE, i, false);
        zzd.zza(parcel, 6, getProgressValue(), false);
        zzd.zzI(parcel, zze);
    }

    public final BitmapTeleporter zzvv() {
        return this.zzbeE;
    }
}
