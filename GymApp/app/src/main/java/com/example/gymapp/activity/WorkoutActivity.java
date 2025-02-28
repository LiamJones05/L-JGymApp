package com.example.gymapp.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gymapp.model.Workout;
import com.example.gymapp.network.RetrofitClient;
import com.example.gymapp.api.WorkoutAPI;
import com.example.gymapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorkoutActivity extends AppCompatActivity {

    private TextView workoutTextView;
    private Button addWorkoutButton;
    private WorkoutAPI workoutAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout); // Ensure activity_workout.xml exists

        workoutTextView = findViewById(R.id.workoutTextView); // Ensure this ID exists in activity_workout.xml
        addWorkoutButton = findViewById(R.id.addWorkoutButton); // Ensure this ID exists in activity_workout.xml

        workoutAPI = RetrofitClient.getInstance().create(WorkoutAPI.class);

        loadWorkouts();

        addWorkoutButton.setOnClickListener(v -> {
            // Replace with actual token retrieval method
            String token = "your_actual_token";

            Workout workout = new Workout("Morning Workout", "2025-02-25", new ArrayList<>()); // Ensure correct constructor
            workoutAPI.logWorkout("Bearer " + token, workout).enqueue(new Callback<Workout>() {
                @Override
                public void onResponse(Call<Workout> call, Response<Workout> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        loadWorkouts();
                    }
                }

                @Override
                public void onFailure(Call<Workout> call, Throwable t) {
                    // Handle failure
                }
            });
        });
    }

    private void loadWorkouts() {
        // Replace with actual token retrieval method
        String token = "your_actual_token";

        workoutAPI.getAllWorkouts("Bearer " + token).enqueue(new Callback<List<Workout>>() {
            @Override
            public void onResponse(Call<List<Workout>> call, Response<List<Workout>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Workout> workouts = response.body();
                    StringBuilder workoutDisplay = new StringBuilder();
                    for (Workout workout : workouts) {
                        workoutDisplay.append(workout.getName()).append("\n");
                    }
                    workoutTextView.setText(workoutDisplay.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Workout>> call, Throwable t) {
                // Handle failure
            }
        });
    }
}
