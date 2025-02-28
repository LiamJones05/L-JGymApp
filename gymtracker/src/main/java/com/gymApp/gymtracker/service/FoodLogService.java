package com.gymApp.gymtracker.service;

import com.example.gymtracker.model.FoodLog;
import com.example.gymtracker.repository.FoodLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodLogService {

    @Autowired
    private FoodLogRepository foodLogRepository;

    // Method to add a new food log entry
    public FoodLog addFoodLog(FoodLog foodLog) {
        return foodLogRepository.save(foodLog);
    }

    // Method to get all food logs for a specific user
    public List<FoodLog> getFoodLogsByUserId(Long userId) {
        return foodLogRepository.findByUserId(userId);
    }

    // Method to get a specific food log by ID
    public FoodLog getFoodLogById(Long id) {
        return foodLogRepository.findById(id).orElse(null);
    }
}
