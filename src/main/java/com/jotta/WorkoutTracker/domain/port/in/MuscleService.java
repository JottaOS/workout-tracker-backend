package com.jotta.WorkoutTracker.domain.port.in;

import com.jotta.WorkoutTracker.domain.model.Muscle;

import java.util.List;

public interface MuscleService {
    Muscle getById(Integer id);

    List<Muscle> getAll();
}
