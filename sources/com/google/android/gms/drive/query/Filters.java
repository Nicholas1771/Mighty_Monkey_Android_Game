package com.google.android.gms.drive.query;

import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.query.internal.zzb;
import com.google.android.gms.drive.query.internal.zzd;
import com.google.android.gms.drive.query.internal.zzn;
import com.google.android.gms.drive.query.internal.zzp;
import com.google.android.gms.drive.query.internal.zzr;
import com.google.android.gms.drive.query.internal.zzv;
import com.google.android.gms.drive.query.internal.zzx;
import com.google.android.gms.drive.query.internal.zzz;

public class Filters {
    public static Filter and(Filter filter, Filter... filterArr) {
        return new zzr(zzx.zzaRz, filter, filterArr);
    }

    public static Filter and(Iterable<Filter> iterable) {
        return new zzr(zzx.zzaRz, iterable);
    }

    public static Filter contains(SearchableMetadataField<String> searchableMetadataField, String str) {
        return new zzb(zzx.zzaRC, searchableMetadataField, str);
    }

    /* renamed from: eq */
    public static Filter m1319eq(CustomPropertyKey customPropertyKey, String str) {
        zzbo.zzb(str != null, (Object) "Custom property value may not be null.");
        return new zzn(SearchableField.zzaQZ, new AppVisibleCustomProperties.zza().zza(customPropertyKey, str).zztm());
    }

    /* renamed from: eq */
    public static <T> Filter m1320eq(SearchableMetadataField<T> searchableMetadataField, T t) {
        return new zzb(zzx.zzaRu, searchableMetadataField, t);
    }

    public static <T extends Comparable<T>> Filter greaterThan(SearchableOrderedMetadataField<T> searchableOrderedMetadataField, T t) {
        return new zzb(zzx.zzaRx, searchableOrderedMetadataField, t);
    }

    public static <T extends Comparable<T>> Filter greaterThanEquals(SearchableOrderedMetadataField<T> searchableOrderedMetadataField, T t) {
        return new zzb(zzx.zzaRy, searchableOrderedMetadataField, t);
    }

    /* renamed from: in */
    public static <T> Filter m1321in(SearchableCollectionMetadataField<T> searchableCollectionMetadataField, T t) {
        return new zzp(searchableCollectionMetadataField, t);
    }

    public static <T extends Comparable<T>> Filter lessThan(SearchableOrderedMetadataField<T> searchableOrderedMetadataField, T t) {
        return new zzb(zzx.zzaRv, searchableOrderedMetadataField, t);
    }

    public static <T extends Comparable<T>> Filter lessThanEquals(SearchableOrderedMetadataField<T> searchableOrderedMetadataField, T t) {
        return new zzb(zzx.zzaRw, searchableOrderedMetadataField, t);
    }

    public static Filter not(Filter filter) {
        return new zzv(filter);
    }

    public static Filter openedByMe() {
        return new zzd((SearchableMetadataField<?>) SearchableField.LAST_VIEWED_BY_ME);
    }

    /* renamed from: or */
    public static Filter m1322or(Filter filter, Filter... filterArr) {
        return new zzr(zzx.zzaRA, filter, filterArr);
    }

    /* renamed from: or */
    public static Filter m1323or(Iterable<Filter> iterable) {
        return new zzr(zzx.zzaRA, iterable);
    }

    public static Filter ownedByMe() {
        return new zzz();
    }

    public static Filter sharedWithMe() {
        return new zzd((SearchableMetadataField<?>) SearchableField.zzaQY);
    }
}
