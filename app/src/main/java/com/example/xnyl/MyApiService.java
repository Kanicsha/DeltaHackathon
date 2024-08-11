package com.example.xnyl;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApiService {

        public static MyApiService api;
        static String apiUrl = "https://auth.delta.nitt.edu/";

        public static MyApiService getClient() {
            if (api == null) {

                api = new Retrofit.Builder()
                        .baseUrl(apiUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(MyApiService.class);
            }
            return api;
        }
    }

