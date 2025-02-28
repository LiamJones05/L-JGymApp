package com.example.gymapp;

import android.os.Bundle;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gymapp.model.AuthResponse;
import com.example.gymapp.model.LoginRequest;
import com.example.gymapp.service.ApiService;
import com.example.gymapp.service.ApiService.ApiCallback;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button loginButton;
    private TextView signupText;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        signupText = findViewById(R.id.signupText);
        apiService = new ApiService();

        loginButton.setOnClickListener(view -> attemptLogin());

        signupText.setOnClickListener(view ->{
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void attemptLogin(){
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
        }

        LoginRequest loginRequest = new LoginRequest(email,password);
        apiService.loginUser(loginRequest, new ApiCallback<AuthResponse>() {
            @Override
            public void onSuccess(AuthResponse data) {
                Toast.makeText(MainActivity.this, "Login Successful",Toast.LENGTH_SHORT).show();
                saveToken(data.getToken());

                Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(String error) {
                Toast.makeText(MainActivity.this, "Login failed: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveToken(String token) {
        getSharedPreferences("GymAppPrefs", MODE_PRIVATE)
                .edit()
                .putString("auth_token", token)
                .apply();
    }
}