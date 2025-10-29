package com.jotta.WorkoutTracker.domain.repository;

import com.jotta.WorkoutTracker.domain.model.Muscle;

import java.util.List;
import java.util.Optional;

public interface MuscleRepository {
    Optional<Muscle> findById(Integer id);

    List<Muscle> findAll();
}
