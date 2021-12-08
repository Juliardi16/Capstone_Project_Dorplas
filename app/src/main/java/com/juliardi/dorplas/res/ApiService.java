package com.juliardi.dorplas.res;

import com.juliardi.dorplas.model.login.LoginResponse;
import com.juliardi.dorplas.model.profile.ProfileResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("login/employe")
    Call<LoginResponse> loginEmploye
            (@Field("email_employes") String email,
             @Field("password_employes")String password);

    @POST("e/profile")
    Call<ProfileResponse> profileEmploye
            (@Header("Authorization") String token);
}
