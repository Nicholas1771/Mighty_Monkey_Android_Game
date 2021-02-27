package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.internal.zzed;
import com.google.android.gms.internal.zzef;

public final class zzu extends zzed implements zzt {
    zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void zza(zzr zzr, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzr);
        zzef.zza(zzZ, (Parcelable) googleSignInOptions);
        zzb(Quests.SELECT_COMPLETED_UNCLAIMED, zzZ);
    }

    public final void zzb(zzr zzr, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzr);
        zzef.zza(zzZ, (Parcelable) googleSignInOptions);
        zzb(Quests.SELECT_ENDING_SOON, zzZ);
    }

    public final void zzc(zzr zzr, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zzZ = zzZ();
        zzef.zza(zzZ, (IInterface) zzr);
        zzef.zza(zzZ, (Parcelable) googleSignInOptions);
        zzb(Quests.SELECT_RECENTLY_FAILED, zzZ);
    }
}
