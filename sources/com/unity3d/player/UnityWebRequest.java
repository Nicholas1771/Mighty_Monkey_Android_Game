package com.unity3d.player;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

class UnityWebRequest implements Runnable {

    /* renamed from: e */
    private static final String[] f1312e = {"TLSv1.2", "TLSv1.1"};

    /* renamed from: f */
    private static volatile SSLSocketFactory f1313f;

    /* renamed from: a */
    private long f1314a;

    /* renamed from: b */
    private String f1315b;

    /* renamed from: c */
    private String f1316c;

    /* renamed from: d */
    private Map f1317d;

    UnityWebRequest(long j, String str, Map map, String str2) {
        this.f1314a = j;
        this.f1315b = str2;
        this.f1316c = str;
        this.f1317d = map;
    }

    private static native void contentLengthCallback(long j, int i);

    private static native boolean downloadCallback(long j, ByteBuffer byteBuffer, int i);

    private static native void errorCallback(long j, int i, String str);

    private static SSLSocketFactory getSSLSocketFactory() {
        if (C0561i.f1362d) {
            return null;
        }
        if (f1313f != null) {
            return f1313f;
        }
        synchronized (f1312e) {
            String[] strArr = f1312e;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                try {
                    SSLContext instance = SSLContext.getInstance(str);
                    instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
                    SSLSocketFactory socketFactory = instance.getSocketFactory();
                    f1313f = socketFactory;
                    return socketFactory;
                } catch (Exception e) {
                    C0558g.Log(5, "UnityWebRequest: No support for " + str + " (" + e.getMessage() + ")");
                    i++;
                }
            }
            return null;
        }
    }

    private static native void headerCallback(long j, String str, String str2);

    private static native void responseCodeCallback(long j, int i);

    private static native int uploadCallback(long j, ByteBuffer byteBuffer);

    /* access modifiers changed from: protected */
    public void badProtocolCallback(String str) {
        errorCallback(this.f1314a, 4, str);
    }

    /* access modifiers changed from: protected */
    public void contentLengthCallback(int i) {
        contentLengthCallback(this.f1314a, i);
    }

    /* access modifiers changed from: protected */
    public boolean downloadCallback(ByteBuffer byteBuffer, int i) {
        return downloadCallback(this.f1314a, byteBuffer, i);
    }

    /* access modifiers changed from: protected */
    public void errorCallback(String str) {
        errorCallback(this.f1314a, 2, str);
    }

    /* access modifiers changed from: protected */
    public void headerCallback(String str, String str2) {
        headerCallback(this.f1314a, str, str2);
    }

    /* access modifiers changed from: protected */
    public void headerCallback(Map map) {
        if (map != null && map.size() != 0) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    str = "Status";
                }
                for (String headerCallback : (List) entry.getValue()) {
                    headerCallback(str, headerCallback);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void malformattedUrlCallback(String str) {
        errorCallback(this.f1314a, 5, str);
    }

    /* access modifiers changed from: protected */
    public void responseCodeCallback(int i) {
        responseCodeCallback(this.f1314a, i);
    }

    public void run() {
        int i;
        InputStream inputStream;
        SSLSocketFactory sSLSocketFactory;
        try {
            URL url = new URL(this.f1315b);
            URLConnection openConnection = url.openConnection();
            if ((openConnection instanceof HttpsURLConnection) && (sSLSocketFactory = getSSLSocketFactory()) != null) {
                ((HttpsURLConnection) openConnection).setSSLSocketFactory(sSLSocketFactory);
            }
            if (url.getProtocol().equalsIgnoreCase("file") && !url.getHost().isEmpty()) {
                malformattedUrlCallback("file:// must use an absolute path");
            } else if (openConnection instanceof JarURLConnection) {
                badProtocolCallback("A URL Connection to a Java ARchive (JAR) file or an entry in a JAR file is not supported");
            } else {
                if (openConnection instanceof HttpURLConnection) {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                        httpURLConnection.setRequestMethod(this.f1316c);
                        httpURLConnection.setInstanceFollowRedirects(false);
                    } catch (ProtocolException e) {
                        badProtocolCallback(e.toString());
                        return;
                    }
                }
                if (this.f1317d != null) {
                    for (Map.Entry entry : this.f1317d.entrySet()) {
                        openConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                int uploadCallback = uploadCallback((ByteBuffer) null);
                if (uploadCallback > 0) {
                    openConnection.setDoOutput(true);
                    try {
                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(Math.min(uploadCallback, 1428));
                        OutputStream outputStream = openConnection.getOutputStream();
                        int uploadCallback2 = uploadCallback(allocateDirect);
                        while (uploadCallback2 > 0) {
                            outputStream.write(allocateDirect.array(), allocateDirect.arrayOffset(), uploadCallback2);
                            uploadCallback2 = uploadCallback(allocateDirect);
                        }
                    } catch (Exception e2) {
                        errorCallback(e2.toString());
                        return;
                    }
                }
                if (openConnection instanceof HttpURLConnection) {
                    try {
                        responseCodeCallback(((HttpURLConnection) openConnection).getResponseCode());
                    } catch (UnknownHostException e3) {
                        unknownHostCallback(e3.toString());
                    } catch (IOException e4) {
                        errorCallback(e4.toString());
                        return;
                    }
                }
                Map<String, List<String>> headerFields = openConnection.getHeaderFields();
                headerCallback(headerFields);
                if ((headerFields == null || !headerFields.containsKey("content-length")) && openConnection.getContentLength() != -1) {
                    headerCallback("content-length", String.valueOf(openConnection.getContentLength()));
                }
                if ((headerFields == null || !headerFields.containsKey("content-type")) && openConnection.getContentType() != null) {
                    headerCallback("content-type", openConnection.getContentType());
                }
                int contentLength = openConnection.getContentLength();
                if (contentLength > 0) {
                    contentLengthCallback(contentLength);
                }
                if (url.getProtocol().equalsIgnoreCase("file")) {
                    i = contentLength == 0 ? 32768 : Math.min(contentLength, 32768);
                } else {
                    i = 1428;
                }
                try {
                    if (openConnection instanceof HttpURLConnection) {
                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) openConnection;
                        responseCodeCallback(httpURLConnection2.getResponseCode());
                        inputStream = httpURLConnection2.getErrorStream();
                    } else {
                        inputStream = null;
                    }
                    if (inputStream == null) {
                        inputStream = openConnection.getInputStream();
                    }
                    ReadableByteChannel newChannel = Channels.newChannel(inputStream);
                    ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(i);
                    int read = newChannel.read(allocateDirect2);
                    while (read != -1 && downloadCallback(allocateDirect2, read)) {
                        allocateDirect2.clear();
                        read = newChannel.read(allocateDirect2);
                    }
                    newChannel.close();
                } catch (UnknownHostException e5) {
                    unknownHostCallback(e5.toString());
                } catch (SSLHandshakeException e6) {
                    sslCannotConnectCallback(e6.toString());
                } catch (Exception e7) {
                    errorCallback(e7.toString());
                }
            }
        } catch (MalformedURLException e8) {
            malformattedUrlCallback(e8.toString());
        } catch (IOException e9) {
            errorCallback(e9.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void sslCannotConnectCallback(String str) {
        errorCallback(this.f1314a, 16, str);
    }

    /* access modifiers changed from: protected */
    public void unknownHostCallback(String str) {
        errorCallback(this.f1314a, 7, str);
    }

    /* access modifiers changed from: protected */
    public int uploadCallback(ByteBuffer byteBuffer) {
        return uploadCallback(this.f1314a, byteBuffer);
    }
}
