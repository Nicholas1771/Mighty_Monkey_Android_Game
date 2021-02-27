package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinLogger;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.eo */
class C0415eo {

    /* renamed from: a */
    private final String f1049a = "TaskManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AppLovinSdkImpl f1050b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AppLovinLogger f1051c;

    /* renamed from: d */
    private final ScheduledThreadPoolExecutor f1052d;

    /* renamed from: e */
    private final ScheduledThreadPoolExecutor f1053e;

    /* renamed from: f */
    private final ScheduledThreadPoolExecutor f1054f;

    C0415eo(AppLovinSdkImpl appLovinSdkImpl) {
        this.f1050b = appLovinSdkImpl;
        this.f1051c = appLovinSdkImpl.getLogger();
        this.f1052d = m1040a("main");
        this.f1053e = m1040a("back");
        this.f1054f = m1040a("postbacks");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public long m1038a(C0416ep epVar) {
        if (epVar == C0416ep.MAIN) {
            return this.f1052d.getTaskCount() - this.f1052d.getCompletedTaskCount();
        }
        if (epVar == C0416ep.BACKGROUND) {
            return this.f1053e.getTaskCount() - this.f1053e.getCompletedTaskCount();
        }
        if (epVar == C0416ep.POSTBACKS) {
            return this.f1054f.getTaskCount() - this.f1054f.getCompletedTaskCount();
        }
        return 0;
    }

    /* renamed from: a */
    private ScheduledThreadPoolExecutor m1040a(String str) {
        return new ScheduledThreadPoolExecutor(1, new C0417eq(this, str));
    }

    /* renamed from: a */
    private static void m1041a(Runnable runnable, long j, ScheduledExecutorService scheduledExecutorService) {
        if (j > 0) {
            scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        } else {
            scheduledExecutorService.submit(runnable);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4680a(C0386dm dmVar) {
        if (dmVar != null) {
            try {
                this.f1051c.mo4782i("TaskManager", "Executing " + dmVar.mo4527a() + " immediately...");
                dmVar.run();
                this.f1051c.mo4782i("TaskManager", dmVar.mo4527a() + " finished executing...");
            } catch (Throwable th) {
                this.f1051c.mo4781e("TaskManager", "Task failed execution", th);
            }
        } else {
            this.f1051c.mo4780e("TaskManager", "Attempted to execute null task immediately");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4681a(C0386dm dmVar, C0416ep epVar) {
        mo4682a(dmVar, epVar, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4682a(C0386dm dmVar, C0416ep epVar, long j) {
        if (dmVar == null) {
            throw new IllegalArgumentException("No task specified");
        } else if (j < 0) {
            throw new IllegalArgumentException("Invalid delay specified: " + j);
        } else if (epVar == C0416ep.MAIN || epVar == C0416ep.BACKGROUND || epVar == C0416ep.POSTBACKS) {
            this.f1051c.mo4779d("TaskManager", "Scheduling " + dmVar.f762c + " on " + epVar + " queue in " + j + "ms with new queue size " + (m1038a(epVar) + 1));
            C0419es esVar = new C0419es(this, dmVar, epVar);
            if (epVar == C0416ep.MAIN) {
                m1041a((Runnable) esVar, j, (ScheduledExecutorService) this.f1052d);
            } else if (epVar == C0416ep.BACKGROUND) {
                m1041a((Runnable) esVar, j, (ScheduledExecutorService) this.f1053e);
            } else if (epVar == C0416ep.POSTBACKS) {
                m1041a((Runnable) esVar, j, (ScheduledExecutorService) this.f1054f);
            }
        } else {
            throw new IllegalArgumentException("Invalid queue specified");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4683a(C0413em emVar, long j) {
        if (emVar == null) {
            throw new IllegalArgumentException("No task specified");
        }
        m1041a((Runnable) emVar, j, (ScheduledExecutorService) this.f1052d);
    }
}
