package com.example.xnyl;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DauthApiService {
    @GET("/authorize")
    Call<AuthResponse> getAuthorization(@Query("client_id") String client_id,
                                        @Query("client_secret") String client_secret,
                                        @Query("grant_type") String grant_type,
                                        @Query("code") String code,
                                        @Query("redirect_uri") String redirect_uri);



}
