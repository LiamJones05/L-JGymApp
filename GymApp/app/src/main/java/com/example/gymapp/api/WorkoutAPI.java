package com.example.gymapp.api;

import com.example.gymapp.model.Workout;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface WorkoutAPI {

    @GET("/workouts")
    Call<List<Workout>> getAllWorkouts(@Header("Authorization") String authorization);

    @POST("/workouts")
    Call<Workout> logWorkout(@Header("Authorization") String authorization, @Body Workout workout);
}
