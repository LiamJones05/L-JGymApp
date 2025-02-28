package com.example.gymapp.model;


import java.util.List;

public class Exercise {
    private String name;
    private List<ExerciseSet> sets;

    public Exercise(String name, List<ExerciseSet> sets) {
        this.name = name;
        this.sets = sets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExerciseSet> getSets() {
        return sets;
    }

    public void setSets(List<ExerciseSet> sets) {
        this.sets = sets;
    }
}
