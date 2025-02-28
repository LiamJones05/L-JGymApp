package com.gymApp.gymtracker.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.yourcompany.gymtracker.model.LoginRequest;
import com.yourcompany.gymtracker.network.RetrofitClient;
import com.yourcompany.gymtracker.utils.SharedPrefManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPrefManager = new SharedPrefManager(this);

        // Sample login request
        LoginRequest loginRequest = new LoginRequest("user", "password");
        loginUser(loginRequest);
    }

    private void loginUser(LoginRequest loginRequest) {
        RetrofitClient.ApiService apiService = RetrofitClient.getRetrofitInstance().create(RetrofitClient.ApiService.class);
        Call<String> call = apiService.login(loginRequest);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String jwtToken = response.body();
                    sharedPrefManager.saveToken(jwtToken);
                    // Proceed to the next activity or dashboard
                } else {
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("LoginActivity", "Error: " + t.getMessage());
            }
        });
    }
}
