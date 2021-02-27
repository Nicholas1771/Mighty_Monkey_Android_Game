package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinLogger;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.u */
class C0464u {

    /* renamed from: a */
    private static final Object f1176a = new JSONObject();

    /* renamed from: b */
    private final AppLovinSdkImpl f1177b;

    /* renamed from: c */
    private final AppLovinLogger f1178c;

    C0464u(AppLovinSdkImpl appLovinSdkImpl) {
        this.f1177b = appLovinSdkImpl;
        this.f1178c = appLovinSdkImpl.getLogger();
    }

    /* renamed from: a */
    private int m1261a(Throwable th) {
        if (th instanceof UnknownHostException) {
            return AppLovinErrorCodes.NO_NETWORK;
        }
        if (th instanceof SocketTimeoutException) {
            return AppLovinErrorCodes.FETCH_AD_TIMEOUT;
        }
        if (!(th instanceof IOException)) {
            return th instanceof JSONException ? -104 : -1;
        }
        String message = th.getMessage();
        return (message == null || !message.toLowerCase(Locale.ENGLISH).contains("authentication challenge")) ? -100 : 401;
    }

    /* renamed from: a */
    private HttpURLConnection m1262a(String str, String str2, int i) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(i < 0 ? ((Integer) this.f1177b.get(C0387dn.f975t)).intValue() : i);
        if (i < 0) {
            i = ((Integer) this.f1177b.get(C0387dn.f977v)).intValue();
        }
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setAllowUserInteraction(false);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    /* renamed from: a */
    private static void m1263a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: T} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: T} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: T} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r6v3, types: [com.applovin.impl.sdk.fs] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> void m1264a(java.lang.String r6, int r7, java.lang.String r8, java.lang.String r9, T r10, com.applovin.impl.sdk.C0465v<T> r11) throws org.json.JSONException {
        /*
            r5 = this;
            com.applovin.sdk.AppLovinLogger r0 = r5.f1178c
            java.lang.String r1 = "ConnectionManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r3 = " received from from \""
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r3 = "\": "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r6)
            java.lang.String r2 = r2.toString()
            r0.mo4779d(r1, r2)
            r0 = 200(0xc8, float:2.8E-43)
            if (r7 < r0) goto L_0x00d0
            r0 = 300(0x12c, float:4.2E-43)
            if (r7 >= r0) goto L_0x00d0
            if (r6 == 0) goto L_0x0049
            int r0 = r6.length()
            r1 = 2
            if (r0 <= r1) goto L_0x0049
            r0 = 1
        L_0x003a:
            r1 = 204(0xcc, float:2.86E-43)
            if (r7 == r1) goto L_0x0045
            if (r0 == 0) goto L_0x0045
            boolean r0 = r10 instanceof java.lang.String     // Catch:{ JSONException -> 0x008b, SAXException -> 0x00ad }
            if (r0 == 0) goto L_0x004b
        L_0x0044:
            r10 = r6
        L_0x0045:
            r11.mo4525a(r10, r7)
        L_0x0048:
            return
        L_0x0049:
            r0 = 0
            goto L_0x003a
        L_0x004b:
            boolean r0 = r10 instanceof com.applovin.impl.sdk.C0446fs     // Catch:{ JSONException -> 0x008b, SAXException -> 0x00ad }
            if (r0 == 0) goto L_0x0056
            com.applovin.impl.sdk.AppLovinSdkImpl r0 = r5.f1177b     // Catch:{ JSONException -> 0x008b, SAXException -> 0x00ad }
            com.applovin.impl.sdk.fs r6 = com.applovin.impl.sdk.C0447ft.m1197a((java.lang.String) r6, (com.applovin.sdk.AppLovinSdk) r0)     // Catch:{ JSONException -> 0x008b, SAXException -> 0x00ad }
            goto L_0x0044
        L_0x0056:
            boolean r0 = r10 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x008b, SAXException -> 0x00ad }
            if (r0 == 0) goto L_0x0061
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x008b, SAXException -> 0x00ad }
            r0.<init>(r6)     // Catch:{ JSONException -> 0x008b, SAXException -> 0x00ad }
            r6 = r0
            goto L_0x0044
        L_0x0061:
            com.applovin.sdk.AppLovinLogger r0 = r5.f1178c     // Catch:{ JSONException -> 0x008b, SAXException -> 0x00ad }
            java.lang.String r1 = "ConnectionManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x008b, SAXException -> 0x00ad }
            r2.<init>()     // Catch:{ JSONException -> 0x008b, SAXException -> 0x00ad }
            java.lang.String r3 = "Unable to handle '"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ JSONException -> 0x008b, SAXException -> 0x00ad }
            java.lang.Class r3 = r10.getClass()     // Catch:{ JSONException -> 0x008b, SAXException -> 0x00ad }
            java.lang.String r3 = r3.getName()     // Catch:{ JSONException -> 0x008b, SAXException -> 0x00ad }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ JSONException -> 0x008b, SAXException -> 0x00ad }
            java.lang.String r3 = "'"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ JSONException -> 0x008b, SAXException -> 0x00ad }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x008b, SAXException -> 0x00ad }
            r0.mo4780e(r1, r2)     // Catch:{ JSONException -> 0x008b, SAXException -> 0x00ad }
            r6 = r10
            goto L_0x0044
        L_0x008b:
            r0 = move-exception
            com.applovin.sdk.AppLovinLogger r1 = r5.f1178c
            java.lang.String r2 = "ConnectionManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Invalid JSON returned from \""
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.String r4 = "\""
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.mo4781e(r2, r3, r0)
            goto L_0x0045
        L_0x00ad:
            r0 = move-exception
            com.applovin.sdk.AppLovinLogger r1 = r5.f1178c
            java.lang.String r2 = "ConnectionManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Invalid XML returned from \""
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.String r4 = "\""
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.mo4781e(r2, r3, r0)
            goto L_0x0045
        L_0x00d0:
            com.applovin.sdk.AppLovinLogger r0 = r5.f1178c
            java.lang.String r1 = "ConnectionManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r3 = " error received from \""
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r3 = "\""
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.mo4780e(r1, r2)
            r11.mo4524a(r7)
            goto L_0x0048
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C0464u.m1264a(java.lang.String, int, java.lang.String, java.lang.String, java.lang.Object, com.applovin.impl.sdk.v):void");
    }

    /* renamed from: a */
    private void m1265a(String str, String str2, int i, long j) {
        this.f1178c.mo4782i("ConnectionManager", "Successful " + str + " returned " + i + " in " + (((float) (System.currentTimeMillis() - j)) / 1000.0f) + " s over " + C0466w.m1272a(this.f1177b) + " to \"" + str2 + "\"");
    }

    /* renamed from: a */
    private void m1266a(String str, String str2, int i, long j, Throwable th) {
        this.f1178c.mo4781e("ConnectionManager", "Failed " + str + " returned " + i + " in " + (((float) (System.currentTimeMillis() - j)) / 1000.0f) + " s over " + C0466w.m1272a(this.f1177b) + " to \"" + str2 + "\"", th);
    }

    /* renamed from: a */
    private static void m1267a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4788a(String str, C0465v<String> vVar) {
        mo4789a(str, "GET", -1, (JSONObject) null, "", true, vVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public <T> void mo4789a(String str, String str2, int i, JSONObject jSONObject, T t, boolean z, C0465v<T> vVar) {
        String str3;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        Throwable th;
        InputStream inputStream;
        if (str == null) {
            throw new IllegalArgumentException("No endpoint specified");
        } else if (str2 == null) {
            throw new IllegalArgumentException("No method specified");
        } else if (vVar == null) {
            throw new IllegalArgumentException("No callback specified");
        } else if (!str.toLowerCase().startsWith("http")) {
            this.f1178c.userError("ConnectionManager", "Requested postback submission to non HTTP endpoint " + str + "; skipping...");
            vVar.mo4524a(AppLovinErrorCodes.INVALID_URL);
        } else {
            if (!((Boolean) this.f1177b.get(C0387dn.f855bJ)).booleanValue() || str.contains("https://")) {
                str3 = str;
            } else {
                this.f1177b.getLogger().mo4785w("ConnectionManager", "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting...");
                str3 = str.replace("http://", "https://");
            }
            long currentTimeMillis = System.currentTimeMillis();
            InputStream inputStream2 = null;
            try {
                this.f1178c.mo4782i("ConnectionManager", "Sending " + str2 + " request to \"" + str3 + "\"...");
                httpURLConnection2 = m1262a(str3, str2, i);
                if (jSONObject != null) {
                    try {
                        String jSONObject2 = jSONObject.toString();
                        this.f1178c.mo4779d("ConnectionManager", "Request to \"" + str3 + "\" is " + jSONObject2);
                        httpURLConnection2.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                        httpURLConnection2.setDoOutput(true);
                        httpURLConnection2.setFixedLengthStreamingMode(jSONObject2.getBytes(Charset.forName("UTF-8")).length);
                        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(httpURLConnection2.getOutputStream(), "UTF8"));
                        printWriter.print(jSONObject2);
                        printWriter.close();
                    } catch (Throwable th2) {
                        th = th2;
                        m1263a(inputStream2);
                        m1267a(httpURLConnection2);
                        throw th;
                    }
                }
                try {
                    int responseCode = httpURLConnection2.getResponseCode();
                    String contentType = httpURLConnection2.getContentType();
                    if (responseCode > 0) {
                        m1265a(str2, str3, responseCode, currentTimeMillis);
                        inputStream = httpURLConnection2.getInputStream();
                        if (z) {
                            try {
                                m1264a(C0466w.m1273a(inputStream, this.f1177b), httpURLConnection2.getResponseCode(), contentType, str3, t, vVar);
                            } catch (MalformedURLException e) {
                            }
                        } else {
                            vVar.mo4525a(t, responseCode);
                        }
                    } else {
                        m1266a(str2, str3, responseCode, currentTimeMillis, (Throwable) null);
                        vVar.mo4524a(responseCode);
                        inputStream = null;
                    }
                } catch (MalformedURLException e2) {
                    inputStream = null;
                    if (z) {
                        try {
                            vVar.mo4524a(-901);
                            m1263a(inputStream);
                            m1267a(httpURLConnection2);
                        } catch (Throwable th3) {
                            inputStream2 = inputStream;
                            th = th3;
                            m1263a(inputStream2);
                            m1267a(httpURLConnection2);
                            throw th;
                        }
                    } else {
                        vVar.mo4525a(t, -901);
                        m1263a(inputStream);
                        m1267a(httpURLConnection2);
                    }
                }
                m1263a(inputStream);
                m1267a(httpURLConnection2);
            } catch (Throwable th4) {
                httpURLConnection2 = null;
                th = th4;
                m1263a(inputStream2);
                m1267a(httpURLConnection2);
                throw th;
            }
        }
    }
}
