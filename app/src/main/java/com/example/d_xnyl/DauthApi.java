package com.example.d_xnyl;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/*
public class DauthApi {
    public static DauthApi api;
    static String apiUrl = "http://10.0.2.2:8000";

    public static DauthApi getClient() {
        if (api == null) {

            api = new Retrofit.Builder()
                    .baseUrl(apiUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getClient())
                    .build()
                    .create(DauthApiService.class);
        }
        return api;
}
*/