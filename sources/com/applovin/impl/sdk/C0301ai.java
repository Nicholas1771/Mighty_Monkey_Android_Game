package com.applovin.impl.sdk;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.ai */
class C0301ai implements C0407eg {

    /* renamed from: a */
    final /* synthetic */ C0383dj f512a;

    /* renamed from: b */
    final /* synthetic */ EventServiceImpl f513b;

    C0301ai(EventServiceImpl eventServiceImpl, C0383dj djVar) {
        this.f513b = eventServiceImpl;
        this.f512a = djVar;
    }

    /* renamed from: a */
    public void mo4307a(C0469z zVar) {
        try {
            HashMap a = this.f513b.m441a(this.f512a, zVar);
            this.f513b.f447a.getPersistentPostbackManager().mo4494a(this.f513b.m437a(this.f513b.m438a(), (Map<String, String>) a).toString(), this.f512a.mo4518b(), true, this.f513b.m437a(this.f513b.m445b(), (Map<String, String>) a).toString());
        } catch (Exception e) {
            this.f513b.f447a.getLogger().mo4781e("EventServiceImpl", "Unable to track event due to failure to convert event parameters into JSONObject for event: " + this.f512a, e);
        }
    }
}
