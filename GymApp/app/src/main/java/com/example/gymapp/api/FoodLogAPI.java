package com.example.gymapp.api;

import com.example.gymapp.model.FoodLog;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Body;
import retrofit2.http.Header;

import java.util.List;

public interface FoodLogAPI {
    @Headers("Authorization: Bearer {your_token}")
    @GET("/foodlogs")
    Call<List<FoodLog>> getAllFoodLogs(@Header("Authorization") String authorization);

    @Headers("Authorization: Bearer {your_token}")
    @POST("/foodlogs")
    Call<FoodLog> logFood(@Body FoodLog foodLog);
}