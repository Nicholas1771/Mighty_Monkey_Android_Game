package com.google.games.bridge;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.games.Games;

public class TokenFragment extends Fragment implements GoogleApiClient.ConnectionCallbacks {
    private static final String FRAGMENT_TAG = "gpg.AuthTokenSupport";
    private static final int RC_ACCT = 9002;
    private static final String TAG = "TokenFragment";
    private static TokenFragment helperFragment;
    private static final Object lock = new Object();
    private static TokenRequest pendingTokenRequest;
    /* access modifiers changed from: private */
    public GoogleApiClient mGoogleApiClient;

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static com.google.android.gms.common.api.PendingResult fetchToken(android.app.Activity r14, boolean r15, boolean r16, boolean r17, java.lang.String r18, boolean r19, java.lang.String[] r20, boolean r21, java.lang.String r22) {
        /*
            com.google.games.bridge.TokenFragment$TokenRequest r0 = new com.google.games.bridge.TokenFragment$TokenRequest
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r11 = 0
            java.lang.Object r2 = lock
            monitor-enter(r2)
            com.google.games.bridge.TokenFragment$TokenRequest r1 = pendingTokenRequest     // Catch:{ all -> 0x005e }
            if (r1 != 0) goto L_0x001f
            pendingTokenRequest = r0     // Catch:{ all -> 0x005e }
            r11 = 1
        L_0x001f:
            monitor-exit(r2)     // Catch:{ all -> 0x005e }
            if (r11 != 0) goto L_0x0061
            java.lang.String r1 = "TokenFragment"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Already a pending token request (requested == ): "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
            java.lang.String r1 = "TokenFragment"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Already a pending token request: "
            java.lang.StringBuilder r2 = r2.append(r3)
            com.google.games.bridge.TokenFragment$TokenRequest r3 = pendingTokenRequest
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
            r1 = 10
            r0.setResult(r1)
            com.google.android.gms.common.api.PendingResult r1 = r0.getPendingResponse()
        L_0x005d:
            return r1
        L_0x005e:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x005e }
            throw r1
        L_0x0061:
            android.app.FragmentManager r1 = r14.getFragmentManager()
            java.lang.String r2 = "gpg.AuthTokenSupport"
            android.app.Fragment r9 = r1.findFragmentByTag(r2)
            com.google.games.bridge.TokenFragment r9 = (com.google.games.bridge.TokenFragment) r9
            if (r9 != 0) goto L_0x00be
            java.lang.String r1 = "TokenFragment"
            java.lang.String r2 = "Creating fragment"
            android.util.Log.d(r1, r2)     // Catch:{ Throwable -> 0x0091 }
            com.google.games.bridge.TokenFragment r10 = new com.google.games.bridge.TokenFragment     // Catch:{ Throwable -> 0x0091 }
            r10.<init>()     // Catch:{ Throwable -> 0x0091 }
            android.app.FragmentManager r1 = r14.getFragmentManager()     // Catch:{ Throwable -> 0x00c9 }
            android.app.FragmentTransaction r13 = r1.beginTransaction()     // Catch:{ Throwable -> 0x00c9 }
            java.lang.String r1 = "gpg.AuthTokenSupport"
            r13.add(r10, r1)     // Catch:{ Throwable -> 0x00c9 }
            r13.commit()     // Catch:{ Throwable -> 0x00c9 }
            r9 = r10
        L_0x008c:
            com.google.android.gms.common.api.PendingResult r1 = r0.getPendingResponse()
            goto L_0x005d
        L_0x0091:
            r12 = move-exception
        L_0x0092:
            java.lang.String r1 = "TokenFragment"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Cannot launch token fragment:"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r12.getMessage()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2, r12)
            r1 = 13
            r0.setResult(r1)
            java.lang.Object r2 = lock
            monitor-enter(r2)
            r1 = 0
            pendingTokenRequest = r1     // Catch:{ all -> 0x00bb }
            monitor-exit(r2)     // Catch:{ all -> 0x00bb }
            goto L_0x008c
        L_0x00bb:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00bb }
            throw r1
        L_0x00be:
            java.lang.String r1 = "TokenFragment"
            java.lang.String r2 = "Fragment exists.. calling processRequests"
            android.util.Log.d(r1, r2)
            r9.processRequest()
            goto L_0x008c
        L_0x00c9:
            r12 = move-exception
            r9 = r10
            goto L_0x0092
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.games.bridge.TokenFragment.fetchToken(android.app.Activity, boolean, boolean, boolean, java.lang.String, boolean, java.lang.String[], boolean, java.lang.String):com.google.android.gms.common.api.PendingResult");
    }

    public static void signOut(Activity activity) {
        TokenFragment fragment = (TokenFragment) activity.getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (fragment != null) {
            fragment.reset();
        }
        synchronized (lock) {
            pendingTokenRequest = null;
        }
    }

    private void reset() {
        if (this.mGoogleApiClient != null) {
            if (this.mGoogleApiClient.hasConnectedApi(Games.API)) {
                try {
                    Games.signOut(this.mGoogleApiClient);
                } catch (RuntimeException e) {
                    Log.w(TAG, "Caught exception when calling Games.signOut: " + e.getMessage(), e);
                }
                try {
                    Auth.GoogleSignInApi.signOut(this.mGoogleApiClient);
                } catch (RuntimeException e2) {
                    Log.w(TAG, "Caught exception when calling GoogleSignInAPI.signOut: " + e2.getMessage(), e2);
                }
            }
            this.mGoogleApiClient.disconnect();
            this.mGoogleApiClient = null;
        }
    }

    private void processRequest() {
        TokenRequest request;
        TokenRequest request2;
        synchronized (lock) {
            request = pendingTokenRequest;
        }
        if (request != null) {
            buildClient(request);
            synchronized (lock) {
                request2 = pendingTokenRequest;
            }
            if (request2 != null) {
                if (this.mGoogleApiClient.hasConnectedApi(Games.API)) {
                    Auth.GoogleSignInApi.silentSignIn(this.mGoogleApiClient).setResultCallback(new ResultCallback<GoogleSignInResult>() {
                        public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
                            if (googleSignInResult.isSuccess()) {
                                TokenFragment.this.onSignedIn(googleSignInResult.getStatus().getStatusCode(), googleSignInResult.getSignInAccount());
                            } else if (googleSignInResult.getStatus().getStatusCode() == 4) {
                                TokenFragment.this.startActivityForResult(Auth.GoogleSignInApi.getSignInIntent(TokenFragment.this.mGoogleApiClient), 9002);
                            } else {
                                Log.e(TokenFragment.TAG, "Error with silentSignIn: " + googleSignInResult.getStatus());
                                TokenFragment.this.onSignedIn(googleSignInResult.getStatus().getStatusCode(), (GoogleSignInAccount) null);
                            }
                        }
                    });
                } else {
                    Log.d(TAG, "No connected Games API,!!!!  Hoping for connection!");
                }
            }
            Log.d(TAG, "Done with processRequest!");
        }
    }

    private void buildClient(TokenRequest request) {
        Log.d(TAG, "Building client for: " + request);
        GoogleSignInOptions.Builder builder = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN);
        if (request.doAuthCode) {
            if (!request.getWebClientId().isEmpty()) {
                builder.requestServerAuthCode(request.getWebClientId(), request.getForceRefresh());
            } else {
                Log.e(TAG, "Web client ID is needed for Auth Code");
                request.setResult(10);
                synchronized (lock) {
                    pendingTokenRequest = null;
                }
                return;
            }
        }
        if (request.doEmail) {
            builder.requestEmail();
        }
        if (request.doIdToken) {
            if (!request.getWebClientId().isEmpty()) {
                builder.requestIdToken(request.getWebClientId());
            } else {
                Log.e(TAG, "Web client ID is needed for ID Token");
                request.setResult(10);
                synchronized (lock) {
                    pendingTokenRequest = null;
                }
                return;
            }
        }
        if (request.scopes != null) {
            for (String s : request.scopes) {
                builder.requestScopes(new Scope(s), new Scope[0]);
            }
        }
        if (request.hidePopups) {
            Log.d(TAG, "hiding popup views for games API");
            builder.addExtension(Games.GamesOptions.builder().setShowConnectingPopup(false).build());
        }
        if (request.accountName != null && !request.accountName.isEmpty()) {
            builder.setAccountName(request.accountName);
        }
        GoogleApiClient.Builder clientBuilder = new GoogleApiClient.Builder(getActivity()).addApi(Auth.GOOGLE_SIGN_IN_API, builder.build());
        clientBuilder.addApi(Games.API);
        clientBuilder.addConnectionCallbacks(this);
        if (request.hidePopups) {
            View invisible = new View(getActivity());
            invisible.setVisibility(4);
            invisible.setClickable(false);
            clientBuilder.setViewForPopups(invisible);
        }
        this.mGoogleApiClient = clientBuilder.build();
        this.mGoogleApiClient.connect(2);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 9002) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result != null && result.isSuccess()) {
                onSignedIn(result.getStatus().getStatusCode(), result.getSignInAccount());
            } else if (result != null) {
                onSignedIn(result.getStatus().getStatusCode(), (GoogleSignInAccount) null);
            } else {
                Log.e(TAG, "Google SignIn Result is null?");
                onSignedIn(13, (GoogleSignInAccount) null);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    /* access modifiers changed from: private */
    public void onSignedIn(int resultCode, GoogleSignInAccount acct) {
        TokenRequest request;
        synchronized (lock) {
            request = pendingTokenRequest;
            pendingTokenRequest = null;
        }
        if (request != null) {
            if (acct != null) {
                request.setAuthCode(acct.getServerAuthCode());
                request.setEmail(acct.getEmail());
                request.setIdToken(acct.getIdToken());
            }
            request.setResult(resultCode);
        }
    }

    public void onStart() {
        Log.d(TAG, "onStart()");
        super.onStart();
        if (this.mGoogleApiClient != null) {
            this.mGoogleApiClient.connect(2);
        }
    }

    public void onStop() {
        Log.d(TAG, "onStop()");
        super.onStop();
        if (this.mGoogleApiClient != null && this.mGoogleApiClient.isConnected()) {
            this.mGoogleApiClient.disconnect();
        }
    }

    public void onResume() {
        Log.d(TAG, "onResume called");
        super.onResume();
        if (helperFragment == null) {
            helperFragment = this;
        }
        processRequest();
    }

    public void onConnected(@Nullable Bundle bundle) {
        if (this.mGoogleApiClient != null) {
            if (this.mGoogleApiClient.hasConnectedApi(Games.API)) {
                Auth.GoogleSignInApi.silentSignIn(this.mGoogleApiClient).setResultCallback(new ResultCallback<GoogleSignInResult>() {
                    public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
                        if (googleSignInResult.isSuccess()) {
                            TokenFragment.this.onSignedIn(googleSignInResult.getStatus().getStatusCode(), googleSignInResult.getSignInAccount());
                            return;
                        }
                        Log.e(TokenFragment.TAG, "Error with silentSignIn: " + googleSignInResult.getStatus());
                        TokenFragment.this.onSignedIn(googleSignInResult.getStatus().getStatusCode(), googleSignInResult.getSignInAccount());
                    }
                });
            } else {
                startActivityForResult(Auth.GoogleSignInApi.getSignInIntent(this.mGoogleApiClient), 9002);
            }
        }
    }

    public void onConnectionSuspended(int cause) {
        Log.d(TAG, "onConnectionSuspended() called: " + cause);
    }

    private static class TokenRequest {
        /* access modifiers changed from: private */
        public String accountName;
        /* access modifiers changed from: private */
        public boolean doAuthCode;
        /* access modifiers changed from: private */
        public boolean doEmail;
        /* access modifiers changed from: private */
        public boolean doIdToken;
        private boolean forceRefresh;
        /* access modifiers changed from: private */
        public boolean hidePopups;
        private TokenPendingResult pendingResponse = new TokenPendingResult();
        /* access modifiers changed from: private */
        public String[] scopes;
        private String webClientId;

        public TokenRequest(boolean fetchAuthCode, boolean fetchEmail, boolean fetchIdToken, String webClientId2, boolean forceRefresh2, String[] oAuthScopes, boolean hidePopups2, String accountName2) {
            this.doAuthCode = fetchAuthCode;
            this.doEmail = fetchEmail;
            this.doIdToken = fetchIdToken;
            this.webClientId = webClientId2;
            this.forceRefresh = forceRefresh2;
            if (oAuthScopes == null || oAuthScopes.length <= 0) {
                this.scopes = null;
            } else {
                this.scopes = new String[oAuthScopes.length];
                System.arraycopy(oAuthScopes, 0, this.scopes, 0, oAuthScopes.length);
            }
            this.hidePopups = hidePopups2;
            this.accountName = accountName2;
        }

        public PendingResult<TokenResult> getPendingResponse() {
            return this.pendingResponse;
        }

        public void setResult(int code) {
            this.pendingResponse.setStatus(code);
        }

        public void setEmail(String email) {
            this.pendingResponse.setEmail(email);
        }

        public void cancel() {
            this.pendingResponse.cancel();
        }

        public void setAuthCode(String authCode) {
            this.pendingResponse.setAuthCode(authCode);
        }

        public void setIdToken(String idToken) {
            this.pendingResponse.setIdToken(idToken);
        }

        public String getEmail() {
            return this.pendingResponse.result.getEmail();
        }

        public String getIdToken() {
            return this.pendingResponse.result.getIdToken();
        }

        public String getAuthCode() {
            return this.pendingResponse.result.getAuthCode();
        }

        public String toString() {
            return Integer.toHexString(hashCode()) + " (a:" + this.doAuthCode + " e:" + this.doEmail + " i:" + this.doIdToken + " wc: " + this.webClientId + " f: " + this.forceRefresh + ")";
        }

        public String getWebClientId() {
            return this.webClientId == null ? "" : this.webClientId;
        }

        public boolean getForceRefresh() {
            return this.forceRefresh;
        }
    }
}
