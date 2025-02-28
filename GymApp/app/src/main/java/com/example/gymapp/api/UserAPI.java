package com.example.gymapp.api;


import com.example.gymapp.model.AuthResponse;
import com.example.gymapp.model.LoginRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserAPI {

    // POST request for user login
    @POST("auth/login")  // Replace with your actual login endpoint
    Call<AuthResponse> loginUser(@Body LoginRequest loginRequest);
}
