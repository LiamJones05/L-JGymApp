package com.example.gymapp.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://yourapiurl.com/"; // Replace with your Spring Boot API URL

    private RetrofitClient() {
        // Private constructor to prevent instantiation
    }

    public static Retrofit getInstance() {
        if (retrofit == null) {
            synchronized (RetrofitClient.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL) // Set your base API URL here
                            .addConverterFactory(GsonConverterFactory.create()) // Use Gson for JSON parsing
                            .build();
                }
            }
        }
        return retrofit;
    }
}

