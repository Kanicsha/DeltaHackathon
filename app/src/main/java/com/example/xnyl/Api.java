package com.example.xnyl;

import java.util.Date;

import retrofit2.http.Body;
import retrofit2.http.GET;

public interface Api {

    @GET("/events/")
    Call<List<EventsResponse>> getEvents(@Body Date date)


     @GET("/")
}
