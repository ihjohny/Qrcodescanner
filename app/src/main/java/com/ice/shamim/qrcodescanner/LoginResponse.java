package com.ice.shamim.qrcodescanner;

public class LoginResponse {
    private Boolean isLogin;

    public LoginResponse(Boolean isLogin) {
        this.isLogin = isLogin;
    }

    public Boolean getLogin() {
        return isLogin;
    }
    
}
