package com.jotta.WorkoutTracker.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WorkoutExercise {
    private Integer workoutId;
    private Integer exerciseId;
    private Integer restSeconds;
    private String notes;
    private List<WorkoutExerciseDetail> details;
}
