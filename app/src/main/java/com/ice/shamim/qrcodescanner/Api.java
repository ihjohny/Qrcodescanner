package com.ice.shamim.qrcodescanner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    String BASE_URL = "http://miltonbhowmick.pythonanywhere.com/";
    @FormUrlEncoded
    @POST("api-login/")
    Call<LoginResponse> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );

}
