package com.gymApp.gymtracker.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    
    private static final String PREF_NAME = "gymTrackerPrefs";
    private static final String KEY_TOKEN = "jwt_token";

    private SharedPreferences sharedPreferences;

    public SharedPrefManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveToken(String token) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_TOKEN, token);
        editor.apply();
    }

    public String getToken() {
        return sharedPreferences.getString(KEY_TOKEN, null);
    }
}
