package com.google.android.gms.nearby.messages.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.Strategy;

final class zzal extends Api.zza<zzah, MessagesOptions> {
    zzal() {
    }

    public final int getPriority() {
        return Strategy.TTL_SECONDS_INFINITE;
    }

    public final /* synthetic */ Api.zze zza(Context context, Looper looper, zzq zzq, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzah(context, looper, connectionCallbacks, onConnectionFailedListener, zzq, (MessagesOptions) obj);
    }
}
