package com.jotta.WorkoutTracker.application.service;

import com.jotta.WorkoutTracker.domain.exception.DomainError;
import com.jotta.WorkoutTracker.domain.exception.WorkoutTrackerException;
import com.jotta.WorkoutTracker.domain.model.Exercise;
import com.jotta.WorkoutTracker.domain.model.Workout;
import com.jotta.WorkoutTracker.domain.port.in.ExerciseService;
import com.jotta.WorkoutTracker.domain.port.in.WorkoutService;
import com.jotta.WorkoutTracker.domain.port.out.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutServiceImpl implements WorkoutService {
    /*
        TODOs:
            1. validar datos del usuario en el workout al insertar / actualizar
     */
    private final WorkoutRepository workoutRepository;
    private final ExerciseService exerciseService;

    public Workout getWorkout(Integer workoutId) {
        return workoutRepository.getById(workoutId)
                .orElseThrow(() -> new WorkoutTrackerException(DomainError.WORKOUT_NOT_FOUND));
    }

    public List<Workout> getAllWorkouts(Boolean isTemplate) {
        return workoutRepository.getAll(isTemplate);
    }

    public Workout createWorkout(Workout workout) {
        validateWorkout(workout);
        return workoutRepository.save(workout);
    }

    public Workout updateWorkout(Integer workoutId, Workout workout) {
        final var savedWorkout = getWorkout(workoutId);
        workout.setId(savedWorkout.getId());
        validateWorkout(workout);
        return workoutRepository.save(workout);
    }

    public void deleteWorkout(Integer workoutId) {
        getWorkout(workoutId);
        workoutRepository.deleteById(workoutId);
    }


    private void validateWorkout(Workout workout) {
        workout.validateTimePeriod();

        if (workout.getExercises().isEmpty()) {
            throw new WorkoutTrackerException(DomainError.EMPTY_WORKOUT_EXERCISES);
        }

        workout.checkRepeatedExercises();

        workout.calculateTotalSets();
        workout.calculateTotalVolume();
        workout.getExercises().forEach(exercise -> {
                    final Exercise workoutExercise = exerciseService.getById(exercise.getExerciseId());
                    exercise.getDetails().forEach(detail -> {
                        detail.setExercise(workoutExercise);
                        detail.validateSetData();
                    });
                }
        );
    }
}
