package com.jotta.WorkoutTracker.domain.model;

import com.jotta.WorkoutTracker.domain.exception.DomainError;
import com.jotta.WorkoutTracker.domain.exception.WorkoutTrackerException;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class Workout {
    private Integer id;
    private String title;
    private Integer volume;
    private Short sets;
    private ZonedDateTime startedAt;
    private ZonedDateTime finishedAt;
    private Boolean isTemplate;
    private List<WorkoutExercise> exercises;

    public void validateTimePeriod() {
        // If a workout is a template, then it should never have a starting and finishing time.
        if (isTemplate) {
            startedAt = null;
            finishedAt = null;
            return;
        }


        if (startedAt == null
                || finishedAt == null
                || finishedAt.isBefore(startedAt)
                || finishedAt.isEqual(startedAt)
                || ZonedDateTime.now().isBefore(startedAt)
        ) {
            throw new WorkoutTrackerException(DomainError.INVALID_WORKOUT_TIME_PERIOD);
        }
    }

    public void checkRepeatedExercises() {
        Set<Integer> exerciseIds = new HashSet<>(exercises.stream()
                .map(WorkoutExercise::getExerciseId)
                .toList()
        );

        if (exerciseIds.size() != exercises.size()) {
            throw new WorkoutTrackerException(DomainError.REPEATING_WORKOUT_EXERCISES);
        }
    }
}