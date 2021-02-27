package com.applovin.sdk.unity;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;

public class TypeRememberingLoadListener implements AppLovinAdLoadListener {
    private UnityExtendedLoadListener callback;
    private AppLovinAdSize requestedSize;
    private AppLovinAdType requestedType;

    public TypeRememberingLoadListener(AppLovinAdSize requestedSize2, AppLovinAdType requestedType2, UnityExtendedLoadListener callback2) {
        this.requestedSize = requestedSize2;
        this.requestedType = requestedType2;
        this.callback = callback2;
    }

    public void adReceived(AppLovinAd ad) {
        if (this.callback != null) {
            this.callback.onAdReceived(ad);
        }
    }

    public void failedToReceiveAd(int errorCode) {
        if (this.callback != null) {
            this.callback.onAdLoadFailed(this.requestedSize, this.requestedType, errorCode);
        }
    }
}
