package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.nearby.connection.Connections;

@Deprecated
final class zzcku extends zzcmw {
    private final zzbdw<Connections.ConnectionResponseCallback> zzbwQ;

    public zzcku(zzbdw<Connections.ConnectionResponseCallback> zzbdw) {
        this.zzbwQ = (zzbdw) zzbo.zzu(zzbdw);
    }

    public final void zza(zzcns zzcns) {
        this.zzbwQ.zza(new zzckv(this, zzcns));
    }
}
