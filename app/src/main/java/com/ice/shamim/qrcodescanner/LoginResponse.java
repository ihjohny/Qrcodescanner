package com.ice.shamim.qrcodescanner;

public class LoginResponse {
    private Boolean isLogin;
    private String token;

    public LoginResponse(Boolean isLogin,String token) {
        this.isLogin = isLogin;
        this.token = token;
    }

    public Boolean getLogin() {
        return isLogin;
    }

    public String getToken() {
        return token;
    }
}
