package com.google.games.bridge;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class TokenResult implements Result {
    private String authCode;
    private String email;
    private String idToken;
    private Status status;

    public TokenResult() {
    }

    TokenResult(String authCode2, String email2, String idToken2, int resultCode) {
        this.status = new Status(resultCode);
        this.authCode = authCode2;
        this.idToken = idToken2;
        this.email = email2;
    }

    public String toString() {
        return "Status: " + this.status + " email: " + (this.email == null ? "<null>" : this.email) + " id:" + (this.idToken == null ? "<null>" : this.idToken) + " access: " + (this.authCode == null ? "<null>" : this.authCode);
    }

    public Status getStatus() {
        return this.status;
    }

    public int getStatusCode() {
        return this.status.getStatusCode();
    }

    public String getAuthCode() {
        return this.authCode == null ? "" : this.authCode;
    }

    public String getIdToken() {
        return this.idToken == null ? "" : this.idToken;
    }

    public String getEmail() {
        return this.email == null ? "" : this.email;
    }

    public void setStatus(int status2) {
        this.status = new Status(status2);
    }

    public void setEmail(String email2) {
        this.email = email2;
    }

    public void setAuthCode(String authCode2) {
        this.authCode = authCode2;
    }

    public void setIdToken(String idToken2) {
        this.idToken = idToken2;
    }
}
