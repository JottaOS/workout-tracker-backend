package com.jotta.WorkoutTracker.application.service;

import com.jotta.WorkoutTracker.domain.exception.DomainError;
import com.jotta.WorkoutTracker.domain.exception.WorkoutTrackerException;
import com.jotta.WorkoutTracker.domain.model.Muscle;
import com.jotta.WorkoutTracker.domain.port.out.MuscleRepository;
import com.jotta.WorkoutTracker.domain.port.in.MuscleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MuscleServiceImpl implements MuscleService {
    private final MuscleRepository muscleRepository;

    public Muscle getById(Integer id) {
        return muscleRepository.findById(id)
                .orElseThrow(() -> new WorkoutTrackerException(DomainError.MUSCLE_NOT_FOUND));
    }

    public List<Muscle> getAll() {
        return muscleRepository.findAll();
    }
}
