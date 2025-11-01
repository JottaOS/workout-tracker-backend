package com.jotta.WorkoutTracker.domain.port.out;

import com.jotta.WorkoutTracker.domain.model.Exercise;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository {
    Optional<Exercise> findById(Integer id);

    List<Exercise> findAll();
}
