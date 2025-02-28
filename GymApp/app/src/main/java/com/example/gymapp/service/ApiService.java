package com.example.gymapp.service;

import com.example.gymapp.model.FoodLog;
import com.example.gymapp.model.Workout;
import com.example.gymapp.model.AuthResponse;
import com.example.gymapp.model.LoginRequest;
import com.example.gymapp.network.RetrofitClient;
import com.example.gymapp.api.FoodLogAPI;
import com.example.gymapp.api.WorkoutAPI;
import com.example.gymapp.api.UserAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiService {

    private static final String AUTH_HEADER = "Authorization: Bearer ";

    private FoodLogAPI foodLogAPI;
    private WorkoutAPI workoutAPI;
    private UserAPI userAPI;

    public ApiService() {
        foodLogAPI = RetrofitClient.getInstance().create(FoodLogAPI.class);
        workoutAPI = RetrofitClient.getInstance().create(WorkoutAPI.class);
        userAPI = RetrofitClient.getInstance().create(UserAPI.class);
    }

    // Login user and get the auth token
    public void loginUser(LoginRequest loginRequest, final ApiCallback<AuthResponse> callback) {
        Call<AuthResponse> call = userAPI.loginUser(loginRequest);  // Send login request to the backend
        call.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Handle the successful login, return the auth response (token)
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }

    // Get Food Logs
    public void getFoodLogs(String token, final ApiCallback<List<FoodLog>> callback) {
        // Pass the Authorization header with the Bearer token
        Call<List<FoodLog>> call = foodLogAPI.getAllFoodLogs(AUTH_HEADER + token);
        call.enqueue(new Callback<List<FoodLog>>() {
            @Override
            public void onResponse(Call<List<FoodLog>> call, Response<List<FoodLog>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<FoodLog>> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }

    // Get Workouts
    public void getWorkouts(String token, final ApiCallback<List<Workout>> callback) {
        // Pass the Authorization header with the Bearer token
        Call<List<Workout>> call = workoutAPI.getAllWorkouts(AUTH_HEADER + token);
        call.enqueue(new Callback<List<Workout>>() {
            @Override
            public void onResponse(Call<List<Workout>> call, Response<List<Workout>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Workout>> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }

    public interface ApiCallback<T> {
        void onSuccess(T data);
        void onFailure(String error);
    }
}
