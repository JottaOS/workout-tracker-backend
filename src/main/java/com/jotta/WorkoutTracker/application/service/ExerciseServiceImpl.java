package com.jotta.WorkoutTracker.application.service;

import com.jotta.WorkoutTracker.domain.exception.DomainError;
import com.jotta.WorkoutTracker.domain.exception.WorkoutTrackerException;
import com.jotta.WorkoutTracker.domain.model.Exercise;
import com.jotta.WorkoutTracker.domain.port.in.ExerciseService;
import com.jotta.WorkoutTracker.domain.port.out.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public Exercise getById(Integer id) {
        return exerciseRepository.findById(id)
                .orElseThrow(() -> new WorkoutTrackerException(DomainError.EXERCISE_NOT_FOUND));
    }

    public List<Exercise> getAll() {
        return exerciseRepository.findAll();
    }
}
