package com.example.gymapp.api;

import com.example.gymapp.model.LoginRequest;
import com.example.gymapp.model.AuthResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthAPI {
    @POST("/auth/login")
    Call<AuthResponse> login(@Body LoginRequest loginRequest);
}
