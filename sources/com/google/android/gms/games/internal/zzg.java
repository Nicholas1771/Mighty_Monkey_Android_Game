package com.google.android.gms.games.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.zzc;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;

public abstract class zzg extends zzee implements zzf {
    public zzg() {
        attachInterface(this, "com.google.android.gms.games.internal.IGamesCallbacks");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 5001:
                zzg(parcel.readInt(), parcel.readString());
                break;
            case 5002:
                zzf((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 5003:
                zzh(parcel.readInt(), parcel.readString());
                break;
            case 5004:
                zzh((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 5005:
                zza((DataHolder) zzef.zza(parcel, DataHolder.CREATOR), (DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 5006:
                zzi((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 5007:
                zzj((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 5008:
                zzk((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 5009:
                zzl((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 5010:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case 5011:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case 5016:
                zzuq();
                break;
            case 5017:
                zzm((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 5018:
                zzu((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 5019:
                zzv((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 5020:
                onLeftRoom(parcel.readInt(), parcel.readString());
                break;
            case 5021:
                zzw((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 5022:
                zzx((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 5023:
                zzy((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 5024:
                zzz((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 5025:
                zzA((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 5026:
                zza((DataHolder) zzef.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                break;
            case 5027:
                zzb((DataHolder) zzef.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                break;
            case 5028:
                zzc((DataHolder) zzef.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                break;
            case 5029:
                zzd((DataHolder) zzef.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                break;
            case 5030:
                zze((DataHolder) zzef.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                break;
            case 5031:
                zzf((DataHolder) zzef.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                break;
            case 5032:
                onRealTimeMessageReceived((RealTimeMessage) zzef.zza(parcel, RealTimeMessage.CREATOR));
                break;
            case 5033:
                zzb(parcel.readInt(), parcel.readInt(), parcel.readString());
                break;
            case 5034:
                parcel.readInt();
                parcel.readString();
                zzef.zza(parcel);
                break;
            case 5035:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case 5036:
                parcel.readInt();
                break;
            case 5037:
                zzn((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 5038:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case 5039:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case 5040:
                parcel.readInt();
                break;
            case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER:
                onP2PConnected(parcel.readString());
                break;
            case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE:
                onP2PDisconnected(parcel.readString());
                break;
            case 8001:
                zzB((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 8002:
                zzb(parcel.readInt(), (Bundle) zzef.zza(parcel, Bundle.CREATOR));
                break;
            case 8003:
                zzp((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case ConnectionsStatusCodes.STATUS_CONNECTION_REJECTED /*8004*/:
                zzq((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case ConnectionsStatusCodes.STATUS_NOT_CONNECTED_TO_ENDPOINT /*8005*/:
                zzr((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 8006:
                zzs((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case ConnectionsStatusCodes.STATUS_BLUETOOTH_ERROR /*8007*/:
                zzi(parcel.readInt(), parcel.readString());
                break;
            case ConnectionsStatusCodes.STATUS_ALREADY_HAVE_ACTIVE_STRATEGY /*8008*/:
                zzt((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case ConnectionsStatusCodes.STATUS_OUT_OF_ORDER_API_CALL /*8009*/:
                onTurnBasedMatchRemoved(parcel.readString());
                break;
            case 8010:
                onInvitationRemoved(parcel.readString());
                break;
            case GamesStatusCodes.STATUS_VIDEO_UNSUPPORTED:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED:
                zzo((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED:
                onRequestRemoved(parcel.readString());
                break;
            case GamesActivityResultCodes.RESULT_LICENSE_FAILED:
                zzC((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case GamesActivityResultCodes.RESULT_APP_MISCONFIGURED:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case GamesActivityResultCodes.RESULT_LEFT_ROOM:
                zzc(parcel.readInt(), (Bundle) zzef.zza(parcel, Bundle.CREATOR));
                break;
            case GamesActivityResultCodes.RESULT_NETWORK_FAILURE:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case 11001:
                parcel.readInt();
                zzef.zza(parcel, Bundle.CREATOR);
                break;
            case 12001:
                zzD((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 12003:
                parcel.readInt();
                zzef.zza(parcel, Bundle.CREATOR);
                break;
            case 12004:
                zza((DataHolder) zzef.zza(parcel, DataHolder.CREATOR), (zzc) zzef.zza(parcel, zzc.CREATOR));
                break;
            case 12005:
                zzE((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 12006:
                zzF((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 12007:
                zzG((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 12008:
                zzI((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 12011:
                zzg((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 12012:
                zzj(parcel.readInt(), parcel.readString());
                break;
            case 12013:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case 12014:
                zzH((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 12015:
                parcel.readInt();
                zzef.zza(parcel, Bundle.CREATOR);
                break;
            case 12016:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case 12017:
                zza((DataHolder) zzef.zza(parcel, DataHolder.CREATOR), parcel.readString(), (zzc) zzef.zza(parcel, zzc.CREATOR), (zzc) zzef.zza(parcel, zzc.CREATOR), (zzc) zzef.zza(parcel, zzc.CREATOR));
                break;
            case 13001:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case 13002:
                parcel.readInt();
                break;
            case 14001:
                parcel.createTypedArray(DataHolder.CREATOR);
                break;
            case 15001:
                zzJ((DataHolder) zzef.zza(parcel, DataHolder.CREATOR));
                break;
            case 17001:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case 17002:
                parcel.readInt();
                break;
            case 19001:
                zza(parcel.readInt(), (VideoCapabilities) zzef.zza(parcel, VideoCapabilities.CREATOR));
                break;
            case 19002:
                zzh(parcel.readInt(), zzef.zza(parcel));
                break;
            case 19003:
                parcel.readInt();
                zzef.zza(parcel);
                zzef.zza(parcel);
                break;
            case 19004:
                parcel.readInt();
                break;
            case 19006:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case 19007:
                parcel.readInt();
                zzef.zza(parcel, Bundle.CREATOR);
                break;
            case 19008:
                parcel.readInt();
                break;
            case 19009:
                parcel.readInt();
                break;
            case 19010:
                parcel.readInt();
                break;
            case 20001:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case 20002:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case 20003:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case 20004:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case 20005:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case 20006:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case 20007:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case 20008:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case 20009:
                zzef.zza(parcel, DataHolder.CREATOR);
                break;
            case 20010:
                parcel.readInt();
                parcel.readString();
                parcel.readString();
                break;
            case 20011:
                parcel.readInt();
                parcel.readString();
                break;
            case 20012:
                zzef.zza(parcel, Status.CREATOR);
                break;
            case 20013:
                zzef.zza(parcel, Status.CREATOR);
                break;
            case 20014:
                zzef.zza(parcel, Status.CREATOR);
                break;
            case 20015:
                zzef.zza(parcel, Status.CREATOR);
                break;
            case 20016:
                parcel.readInt();
                break;
            case 20017:
                parcel.readInt();
                zzef.zza(parcel, Uri.CREATOR);
                break;
            case 20018:
                parcel.readInt();
                break;
            case 20019:
                onCaptureOverlayStateChanged(parcel.readInt());
                break;
            case 20020:
                zzd(parcel.readInt(), (Bundle) zzef.zza(parcel, Bundle.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
