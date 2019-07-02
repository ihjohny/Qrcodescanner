package com.ice.shamim.qrcodescanner;

public class UpdateResponse {

    private Boolean isLogin;
    private String percentage;

    public UpdateResponse(String percentage) {
        this.percentage = percentage;
    }

    public String getPercentage() {
        return percentage;
    }
}
