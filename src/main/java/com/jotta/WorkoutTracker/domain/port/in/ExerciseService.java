package com.jotta.WorkoutTracker.domain.port.in;


import com.jotta.WorkoutTracker.domain.model.Exercise;

import java.util.List;

public interface ExerciseService {
    Exercise getById(Integer id);

    List<Exercise> getAll();
}
