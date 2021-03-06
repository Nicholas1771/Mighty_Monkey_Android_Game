package com.google.android.gms.internal;

import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.zzb;
import com.google.android.gms.drive.metadata.internal.zzi;
import com.google.android.gms.drive.metadata.internal.zzo;
import com.google.android.gms.drive.metadata.internal.zzs;
import com.google.android.gms.drive.metadata.internal.zzt;
import com.google.android.gms.drive.metadata.internal.zzu;
import java.util.Collections;

public final class zzbrc {
    public static final MetadataField<DriveId> zzaPQ = zzbrw.zzaQO;
    public static final MetadataField<String> zzaPR = new zzt("alternateLink", 4300000);
    public static final zzbrf zzaPS = new zzbrf(5000000);
    public static final MetadataField<String> zzaPT = new zzt("description", 4300000);
    public static final MetadataField<String> zzaPU = new zzt("embedLink", 4300000);
    public static final MetadataField<String> zzaPV = new zzt("fileExtension", 4300000);
    public static final MetadataField<Long> zzaPW = new zzi("fileSize", 4300000);
    public static final MetadataField<String> zzaPX = new zzt("folderColorRgb", 7500000);
    public static final MetadataField<Boolean> zzaPY = new zzb("hasThumbnail", 4300000);
    public static final MetadataField<String> zzaPZ = new zzt("indexableText", 4300000);
    public static final MetadataField<String> zzaQA = new zzt("uniqueIdentifier", 5000000);
    public static final zzb zzaQB = new zzb("writersCanShare", 6000000);
    public static final MetadataField<String> zzaQC = new zzt("role", 6000000);
    public static final MetadataField<String> zzaQD = new zzt("md5Checksum", 7000000);
    public static final zzbrj zzaQE = new zzbrj(7000000);
    public static final MetadataField<String> zzaQF = new zzt("recencyReason", 8000000);
    public static final MetadataField<Boolean> zzaQG = new zzb("subscribed", 8000000);
    public static final MetadataField<Boolean> zzaQa = new zzb("isAppData", 4300000);
    public static final MetadataField<Boolean> zzaQb = new zzb("isCopyable", 4300000);
    public static final MetadataField<Boolean> zzaQc = new zzb("isEditable", 4100000);
    public static final MetadataField<Boolean> zzaQd = new zzbrd("isExplicitlyTrashed", Collections.singleton("trashed"), Collections.emptySet(), 7000000);
    public static final MetadataField<Boolean> zzaQe = new zzb("isLocalContentUpToDate", 7800000);
    public static final zzbrg zzaQf = new zzbrg("isPinned", 4100000);
    public static final MetadataField<Boolean> zzaQg = new zzb("isOpenable", 7200000);
    public static final MetadataField<Boolean> zzaQh = new zzb("isRestricted", 4300000);
    public static final MetadataField<Boolean> zzaQi = new zzb("isShared", 4300000);
    public static final MetadataField<Boolean> zzaQj = new zzb("isGooglePhotosFolder", 7000000);
    public static final MetadataField<Boolean> zzaQk = new zzb("isGooglePhotosRootFolder", 7000000);
    public static final MetadataField<Boolean> zzaQl = new zzb("isTrashable", 4400000);
    public static final MetadataField<Boolean> zzaQm = new zzb("isViewed", 4300000);
    public static final zzbrh zzaQn = new zzbrh(4100000);
    public static final MetadataField<String> zzaQo = new zzt("originalFilename", 4300000);
    public static final com.google.android.gms.drive.metadata.zzb<String> zzaQp = new zzs("ownerNames", 4300000);
    public static final zzu zzaQq = new zzu("lastModifyingUser", 6000000);
    public static final zzu zzaQr = new zzu("sharingUser", 6000000);
    public static final zzo zzaQs = new zzo(4100000);
    public static final zzbri zzaQt = new zzbri("quotaBytesUsed", 4300000);
    public static final zzbrk zzaQu = new zzbrk("starred", 4100000);
    public static final MetadataField<BitmapTeleporter> zzaQv = new zzbre("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000);
    public static final zzbrl zzaQw = new zzbrl("title", 4100000);
    public static final zzbrm zzaQx = new zzbrm("trashed", 4100000);
    public static final MetadataField<String> zzaQy = new zzt("webContentLink", 4300000);
    public static final MetadataField<String> zzaQz = new zzt("webViewLink", 4300000);
}
