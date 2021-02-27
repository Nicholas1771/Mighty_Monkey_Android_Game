package com.applovin.impl.sdk;

import android.net.Uri;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.applovin.impl.sdk.dy */
abstract class C0398dy extends C0386dm {

    /* renamed from: a */
    private final C0296ad f1010a;

    /* renamed from: b */
    private AppLovinAdLoadListener f1011b;

    /* renamed from: g */
    private final C0304al f1012g;

    /* renamed from: h */
    private final Collection<Character> f1013h;

    C0398dy(String str, C0296ad adVar, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        super(str, appLovinSdkImpl);
        if (adVar == null) {
            throw new IllegalArgumentException("No ad specified.");
        }
        this.f1010a = adVar;
        this.f1011b = appLovinAdLoadListener;
        this.f1012g = appLovinSdkImpl.getFileManager();
        this.f1013h = m952e();
    }

    /* renamed from: a */
    private Uri m950a(Uri uri, String str) {
        if (uri != null) {
            String uri2 = uri.toString();
            if (AppLovinSdkUtils.isValidString(uri2)) {
                this.f764e.mo4779d(this.f762c, "Caching " + str + " image...");
                return mo4644b(uri2);
            }
            this.f764e.mo4779d(this.f762c, "Failed to cache " + str + " image");
        } else {
            this.f764e.mo4779d(this.f762c, "No " + str + " image to cache");
        }
        return null;
    }

    /* renamed from: a */
    private String m951a(String str, String str2) {
        String replace = str2.replace("/", "_");
        String H = this.f1010a.mo4265H();
        if (C0444fq.isValidString(H)) {
            replace = H + replace;
        }
        File a = this.f1012g.mo4311a(replace, this.f763d.getApplicationContext(), true);
        if (a == null) {
            return null;
        }
        if (a.exists()) {
            return "file://" + a.getAbsolutePath();
        }
        if (this.f1012g.mo4316a(a, str + str2, false)) {
            return "file://" + a.getAbsolutePath();
        }
        return null;
    }

    /* renamed from: e */
    private Collection<Character> m952e() {
        HashSet hashSet = new HashSet();
        for (char valueOf : ((String) this.f763d.get(C0387dn.f802aJ)).toCharArray()) {
            hashSet.add(Character.valueOf(valueOf));
        }
        hashSet.add('\"');
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Uri mo4641a(String str) {
        return mo4642a(str, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Uri mo4642a(String str, boolean z) {
        try {
            if (AppLovinSdkUtils.isValidString(str)) {
                this.f764e.mo4779d(this.f762c, "Caching video " + str + "...");
                String a = this.f1012g.mo4312a(this.f765f, str, this.f1010a.mo4265H(), z);
                if (AppLovinSdkUtils.isValidString(a)) {
                    File a2 = this.f763d.getFileManager().mo4311a(a, this.f765f, false);
                    if (a2 != null) {
                        Uri fromFile = Uri.fromFile(a2);
                        if (fromFile != null) {
                            this.f764e.mo4779d(this.f762c, "Finish caching video for ad #" + this.f1010a.getAdIdNumber() + ". Updating ad with cachedVideoFilename = " + a);
                            return fromFile;
                        }
                        this.f764e.mo4780e(this.f762c, "Unable to create URI from cached video file = " + a2);
                    } else {
                        this.f764e.mo4780e(this.f762c, "Unable to cache video = " + str + "Video file was missing or null - please make sure your app has the WRITE_EXTERNAL_STORAGE permission!");
                    }
                } else if (((Boolean) this.f763d.get(C0387dn.f774I)).booleanValue()) {
                    this.f764e.mo4780e(this.f762c, "Failed to cache video");
                    C0444fq.m1163a(this.f1011b, this.f1010a.mo4292m(), AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES, this.f763d);
                    this.f1011b = null;
                } else {
                    this.f764e.mo4780e(this.f762c, "Failed to cache video, but not failing ad load");
                }
            }
        } catch (Exception e) {
            this.f764e.mo4781e(this.f762c, "Encountered exception while attempting to cache video.", e);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo4643a(String str, List<String> list) {
        if (!C0444fq.isValidString(str)) {
            return str;
        }
        if (!((Boolean) this.f763d.get(C0387dn.f773H)).booleanValue()) {
            this.f764e.mo4779d(this.f762c, "Resource caching is disabled, skipping cache...");
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            int i = 0;
            int i2 = 0;
            while (i2 < sb.length() && (i2 = sb.indexOf(next, i)) != -1) {
                int length = sb.length();
                i = i2;
                while (!this.f1013h.contains(Character.valueOf(sb.charAt(i))) && i < length) {
                    i++;
                }
                if (i <= i2 || i == length) {
                    this.f764e.mo4780e(this.f762c, "Unable to cache resource; ad HTML is invalid.");
                    return str;
                }
                String substring = sb.substring(next.length() + i2, i);
                if (C0444fq.isValidString(substring)) {
                    String a = m951a(next, substring);
                    if (a != null) {
                        sb.replace(i2, i, a);
                    }
                } else {
                    this.f764e.mo4779d(this.f762c, "Skip caching of non-resource " + substring);
                }
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Uri mo4644b(String str) {
        return mo4645b(str, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Uri mo4645b(String str, boolean z) {
        try {
            String a = this.f1012g.mo4312a(this.f765f, str, this.f1010a.mo4265H(), z);
            if (AppLovinSdkUtils.isValidString(a)) {
                File a2 = this.f763d.getFileManager().mo4311a(a, this.f765f, false);
                if (a2 != null) {
                    Uri fromFile = Uri.fromFile(a2);
                    if (fromFile != null) {
                        return fromFile;
                    }
                    this.f764e.mo4780e(this.f762c, "Unable to extract Uri from image file");
                } else {
                    this.f764e.mo4780e(this.f762c, "Unable to retrieve File from cached image filename = " + a);
                }
            }
        } catch (MalformedURLException e) {
            this.f764e.mo4781e(this.f762c, "Failed to cache image at url = " + str, e);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo4646c(String str) {
        if (!C0444fq.isValidString(str)) {
            return null;
        }
        AtomicReference atomicReference = new AtomicReference((Object) null);
        this.f763d.getConnectionManager().mo4788a(str, new C0399dz(this, atomicReference, str));
        return (String) atomicReference.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo4647c(String str, boolean z) {
        if (!C0444fq.isValidString(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        if (parse == null) {
            this.f764e.mo4779d(this.f762c, "Nothing to cache, skipping...");
            return null;
        }
        String lastPathSegment = parse.getLastPathSegment();
        if (C0444fq.isValidString(this.f1010a.mo4265H())) {
            lastPathSegment = this.f1010a.mo4265H() + lastPathSegment;
        }
        File a = this.f1012g.mo4311a(lastPathSegment, this.f765f, true);
        ByteArrayOutputStream a2 = (a == null || !a.exists()) ? null : this.f1012g.mo4309a(a);
        if (a2 == null) {
            a2 = this.f1012g.mo4310a(str, z);
            this.f1012g.mo4315a(a2, a);
        }
        try {
            return a2.toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            this.f764e.mo4781e(this.f762c, "UTF-8 encoding not supported.", e);
            return null;
        } catch (Throwable th) {
            this.f764e.mo4781e(this.f762c, "String resource at " + str + " failed to load.", th);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo4648c() {
        this.f764e.mo4779d(this.f762c, "Caching mute images...");
        Uri a = m950a(this.f1010a.mo4280W(), "mute");
        if (a != null) {
            this.f1010a.mo4285b(a);
        }
        Uri a2 = m950a(this.f1010a.mo4281X(), "unmute");
        if (a2 != null) {
            this.f1010a.mo4286c(a2);
        }
        this.f764e.mo4779d(this.f762c, "Ad updated with muteImageFilename = " + this.f1010a.mo4280W() + ", unmuteImageFilename = " + this.f1010a.mo4281X());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo4649d() {
        if (this.f1011b != null) {
            this.f763d.getLogger().mo4779d(mo4527a(), "Rendered new ad:" + this.f1010a);
            this.f1011b.adReceived(this.f1010a);
            this.f1011b = null;
        }
    }
}
