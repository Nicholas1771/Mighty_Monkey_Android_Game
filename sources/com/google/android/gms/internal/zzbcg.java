package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzj;
import java.util.Iterator;
import java.util.Map;

final class zzbcg extends zzbcn {
    final /* synthetic */ zzbcd zzaDp;
    private final Map<Api.zze, zzbcf> zzaDr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbcg(zzbcd zzbcd, Map<Api.zze, zzbcf> map) {
        super(zzbcd, (zzbce) null);
        this.zzaDp = zzbcd;
        this.zzaDr = map;
    }

    @WorkerThread
    public final void zzpV() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        int i = 0;
        Iterator<Api.zze> it = this.zzaDr.keySet().iterator();
        boolean z5 = true;
        boolean z6 = false;
        while (true) {
            if (!it.hasNext()) {
                z4 = z6;
                z = false;
                break;
            }
            Api.zze next = it.next();
            if (!next.zzpe()) {
                z3 = false;
                z2 = z6;
            } else if (!this.zzaDr.get(next).zzaCj) {
                z = true;
                break;
            } else {
                z3 = z5;
                z2 = true;
            }
            z6 = z2;
            z5 = z3;
        }
        if (z4) {
            i = this.zzaDp.zzaCF.isGooglePlayServicesAvailable(this.zzaDp.mContext);
        }
        if (i == 0 || (!z && !z5)) {
            if (this.zzaDp.zzaDj) {
                this.zzaDp.zzaDh.connect();
            }
            for (Api.zze next2 : this.zzaDr.keySet()) {
                zzj zzj = this.zzaDr.get(next2);
                if (!next2.zzpe() || i == 0) {
                    next2.zza(zzj);
                } else {
                    this.zzaDp.zzaCZ.zza((zzbcy) new zzbci(this, this.zzaDp, zzj));
                }
            }
            return;
        }
        this.zzaDp.zzaCZ.zza((zzbcy) new zzbch(this, this.zzaDp, new ConnectionResult(i, (PendingIntent) null)));
    }
}
