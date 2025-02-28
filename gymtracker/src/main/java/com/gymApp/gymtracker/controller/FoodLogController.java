package com.gymApp.gymtracker.controller;

import com.example.gymtracker.model.FoodLog;
import com.example.gymtracker.service.FoodLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foodlogs")
public class FoodLogController {

    @Autowired
    private FoodLogService foodLogService;

    // Endpoint to add a new food log
    @PostMapping
    public FoodLog addFoodLog(@RequestBody FoodLog foodLog) {
        return foodLogService.addFoodLog(foodLog);
    }

    // Endpoint to get all food logs for a user
    @GetMapping("/user/{userId}")
    public List<FoodLog> getFoodLogsByUserId(@PathVariable Long userId) {
        return foodLogService.getFoodLogsByUserId(userId);
    }

    // Endpoint to get a specific food log by ID
    @GetMapping("/{id}")
    public FoodLog getFoodLogById(@PathVariable Long id) {
        return foodLogService.getFoodLogById(id);
    }
}
