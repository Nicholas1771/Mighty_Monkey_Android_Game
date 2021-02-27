package com.unity3d.player;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

class WWW extends Thread {

    /* renamed from: a */
    private int f1318a = 0;

    /* renamed from: b */
    private int f1319b;

    /* renamed from: c */
    private String f1320c;

    /* renamed from: d */
    private byte[] f1321d;

    /* renamed from: e */
    private Map f1322e;

    WWW(int i, String str, byte[] bArr, Map map) {
        this.f1319b = i;
        this.f1320c = str;
        this.f1321d = bArr;
        this.f1322e = map;
        start();
    }

    private static native void doneCallback(int i);

    private static native void errorCallback(int i, String str);

    private static native boolean headerCallback(int i, String str);

    private static native void progressCallback(int i, float f, float f2, double d, int i2);

    private static native boolean readCallback(int i, byte[] bArr, int i2);

    /* access modifiers changed from: protected */
    public boolean headerCallback(String str, String str2) {
        return headerCallback(this.f1319b, str + ": " + str2 + "\n\r");
    }

    /* access modifiers changed from: protected */
    public boolean headerCallback(Map map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            for (String append : (List) entry.getValue()) {
                sb.append((String) entry.getKey());
                sb.append(": ");
                sb.append(append);
                sb.append("\r\n");
            }
            if (entry.getKey() == null) {
                for (String append2 : (List) entry.getValue()) {
                    sb.append("Status: ");
                    sb.append(append2);
                    sb.append("\r\n");
                }
            }
        }
        return headerCallback(this.f1319b, sb.toString());
    }

    /* access modifiers changed from: protected */
    public void progressCallback(int i, int i2, int i3, int i4, long j, long j2) {
        float f;
        float f2;
        double d;
        if (i4 > 0) {
            f = ((float) i3) / ((float) i4);
            f2 = 1.0f;
            double max = ((double) Math.max(i4 - i3, 0)) / ((1000.0d * ((double) i3)) / Math.max((double) (j - j2), 0.1d));
            if (Double.isInfinite(max) || Double.isNaN(max)) {
                max = 0.0d;
            }
            d = max;
        } else if (i2 > 0) {
            f = 0.0f;
            f2 = (float) (i / i2);
            d = 0.0d;
        } else {
            return;
        }
        progressCallback(this.f1319b, f2, f, d, i4);
    }

    /* access modifiers changed from: protected */
    public boolean readCallback(byte[] bArr, int i) {
        return readCallback(this.f1319b, bArr, i);
    }

    public void run() {
        try {
            runSafe();
        } catch (Throwable th) {
            errorCallback(this.f1319b, "Error: " + th.toString());
        }
    }

    public void runSafe() {
        String str;
        InputStream inputStream;
        InputStream inputStream2;
        boolean z;
        List list;
        int i = this.f1318a + 1;
        this.f1318a = i;
        if (i > 5) {
            errorCallback(this.f1319b, "Too many redirects");
            return;
        }
        try {
            URL url = new URL(this.f1320c);
            URLConnection openConnection = url.openConnection();
            if (!url.getProtocol().equalsIgnoreCase("file") || url.getHost() == null || url.getHost().length() == 0) {
                if (this.f1322e != null) {
                    for (Map.Entry entry : this.f1322e.entrySet()) {
                        openConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                if (this.f1321d != null) {
                    openConnection.setDoOutput(true);
                    try {
                        OutputStream outputStream = openConnection.getOutputStream();
                        int i2 = 0;
                        while (i2 < this.f1321d.length) {
                            int min = Math.min(1428, this.f1321d.length - i2);
                            outputStream.write(this.f1321d, i2, min);
                            i2 += min;
                            progressCallback(i2, this.f1321d.length, 0, 0, 0, 0);
                        }
                    } catch (Exception e) {
                        errorCallback(this.f1319b, e.toString());
                        return;
                    }
                }
                if (openConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    try {
                        int responseCode = httpURLConnection.getResponseCode();
                        Map headerFields = httpURLConnection.getHeaderFields();
                        if (headerFields != null && ((responseCode == 301 || responseCode == 302) && (list = (List) headerFields.get("Location")) != null && !list.isEmpty())) {
                            httpURLConnection.disconnect();
                            this.f1320c = (String) list.get(0);
                            run();
                            return;
                        }
                    } catch (IOException e2) {
                        errorCallback(this.f1319b, e2.toString());
                        return;
                    }
                }
                Map<String, List<String>> headerFields2 = openConnection.getHeaderFields();
                boolean headerCallback = headerCallback(headerFields2);
                if ((headerFields2 == null || !headerFields2.containsKey("content-length")) && openConnection.getContentLength() != -1) {
                    headerCallback = headerCallback || headerCallback("content-length", String.valueOf(openConnection.getContentLength()));
                }
                if ((headerFields2 == null || !headerFields2.containsKey("content-type")) && openConnection.getContentType() != null) {
                    headerCallback = headerCallback || headerCallback("content-type", openConnection.getContentType());
                }
                if (headerCallback) {
                    errorCallback(this.f1319b, this.f1320c + " aborted");
                    return;
                }
                int contentLength = openConnection.getContentLength() > 0 ? openConnection.getContentLength() : 0;
                int min2 = (url.getProtocol().equalsIgnoreCase("file") || url.getProtocol().equalsIgnoreCase("jar")) ? contentLength == 0 ? 32768 : Math.min(contentLength, 32768) : 1428;
                int i3 = 0;
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    byte[] bArr = new byte[min2];
                    if (openConnection instanceof HttpURLConnection) {
                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) openConnection;
                        str = httpURLConnection2.getResponseCode() + ": " + httpURLConnection2.getResponseMessage();
                        inputStream = httpURLConnection2.getErrorStream();
                    } else {
                        str = "";
                        inputStream = null;
                    }
                    if (inputStream == null) {
                        z = false;
                        inputStream2 = openConnection.getInputStream();
                    } else {
                        inputStream2 = inputStream;
                        z = true;
                    }
                    for (int i4 = 0; i4 != -1; i4 = inputStream2.read(bArr)) {
                        if (readCallback(bArr, i4)) {
                            errorCallback(this.f1319b, this.f1320c + " aborted");
                            return;
                        }
                        if (!z) {
                            i3 += i4;
                            progressCallback(0, 0, i3, contentLength, System.currentTimeMillis(), currentTimeMillis);
                        }
                    }
                    if (z) {
                        errorCallback(this.f1319b, str);
                    }
                    progressCallback(0, 0, i3, i3, 0, 0);
                    doneCallback(this.f1319b);
                } catch (Exception e3) {
                    errorCallback(this.f1319b, e3.toString());
                }
            } else {
                errorCallback(this.f1319b, url.getHost() + url.getFile() + " is not an absolute path!");
            }
        } catch (MalformedURLException e4) {
            errorCallback(this.f1319b, e4.toString());
        } catch (IOException e5) {
            errorCallback(this.f1319b, e5.toString());
        }
    }
}
