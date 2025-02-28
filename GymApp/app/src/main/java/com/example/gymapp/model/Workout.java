package com.example.gymapp.model;


import java.util.List;

public class Workout {
    private String name;
    private String date;
    private List<Exercise> exercises;

    public Workout(String name, String date, List<Exercise> exercises) {
        this.name = name;
        this.date = date;
        this.exercises = exercises;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
