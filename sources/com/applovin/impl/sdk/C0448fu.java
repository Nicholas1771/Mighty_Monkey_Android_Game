package com.applovin.impl.sdk;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/* renamed from: com.applovin.impl.sdk.fu */
class C0448fu implements ContentHandler {

    /* renamed from: a */
    final /* synthetic */ C0447ft f1134a;

    C0448fu(C0447ft ftVar) {
        this.f1134a = ftVar;
    }

    public void characters(char[] cArr, int i, int i2) throws SAXException {
        String trim = new String(Arrays.copyOfRange(cArr, 0, i2)).trim();
        if (C0444fq.isValidString(trim)) {
            this.f1134a.f1131c.append(trim);
        }
    }

    public void endDocument() throws SAXException {
        this.f1134a.f1129a.mo4779d("XmlParser", "Finished parsing in " + (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - this.f1134a.f1132d) + " seconds");
    }

    public void endElement(String str, String str2, String str3) throws SAXException {
        C0449fv unused = this.f1134a.f1133e = (C0449fv) this.f1134a.f1130b.pop();
        this.f1134a.f1133e.mo4756d(this.f1134a.f1131c.toString().trim());
        this.f1134a.f1131c.setLength(0);
    }

    public void endPrefixMapping(String str) throws SAXException {
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
    }

    public void processingInstruction(String str, String str2) throws SAXException {
    }

    public void setDocumentLocator(Locator locator) {
    }

    public void skippedEntity(String str) throws SAXException {
    }

    public void startDocument() throws SAXException {
        this.f1134a.f1129a.mo4779d("XmlParser", "Begin parsing...");
        long unused = this.f1134a.f1132d = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        C0449fv fvVar = null;
        try {
            if (!this.f1134a.f1130b.isEmpty()) {
                fvVar = (C0449fv) this.f1134a.f1130b.peek();
            }
            C0449fv fvVar2 = new C0449fv(str2, this.f1134a.m1201a(attributes), fvVar);
            if (fvVar != null) {
                fvVar.mo4755a(fvVar2);
            }
            this.f1134a.f1130b.push(fvVar2);
        } catch (Exception e) {
            this.f1134a.f1129a.mo4781e("XmlParser", "Unable to process element <" + str2 + ">", e);
            throw new SAXException("Failed to start element", e);
        }
    }

    public void startPrefixMapping(String str, String str2) throws SAXException {
    }
}
