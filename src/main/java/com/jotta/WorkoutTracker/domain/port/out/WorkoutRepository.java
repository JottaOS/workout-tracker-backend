package com.jotta.WorkoutTracker.domain.port.out;

import com.jotta.WorkoutTracker.domain.model.Workout;

import java.util.List;
import java.util.Optional;

public interface WorkoutRepository {
    Optional<Workout> getById(Integer workoutId);

    List<Workout> getAll(Boolean isTemplate);

    Workout save(Workout workout);

    void deleteById(Integer workoutId);

}
