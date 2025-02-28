package com.gymApp.gymtracker.network;

import com.yourcompany.gymtracker.model.LoginRequest;
import com.yourcompany.gymtracker.model.Workout;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class RetrofitClient {

    private static final String BASE_URL = "http://your-api-url/api/";

    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public interface ApiService {

        @POST("auth/login")
        Call<String> login(@Body LoginRequest loginRequest);

        // Add other API endpoints for workouts, exercises, food logs, etc.
    }
}
