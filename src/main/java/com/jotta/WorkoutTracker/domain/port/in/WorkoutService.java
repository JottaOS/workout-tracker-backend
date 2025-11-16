package com.jotta.WorkoutTracker.domain.port.in;

import com.jotta.WorkoutTracker.domain.model.Workout;

import java.util.List;

public interface WorkoutService {
    Workout getWorkout(Integer workoutId);

    List<Workout> getAllWorkouts(Boolean isTemplate);

    Workout createWorkout(Workout workout);

    Workout updateWorkout(Integer workoutId, Workout workout);

    void deleteWorkout(Integer workoutId);
}
