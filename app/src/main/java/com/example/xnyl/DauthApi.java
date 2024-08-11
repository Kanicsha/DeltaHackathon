package com.example.xnyl;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DauthApi {
    public static DauthApiService api;
    static String apiUrl = "https://auth.delta.nitt.edu/";

    public static DauthApiService getClient() {
        if (api == null) {

            api = new Retrofit.Builder()
                    .baseUrl(apiUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(DauthApiService.class);
        }
        return api;
    }
}
