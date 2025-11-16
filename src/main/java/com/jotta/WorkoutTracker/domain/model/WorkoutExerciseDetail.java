package com.jotta.WorkoutTracker.domain.model;

import com.jotta.WorkoutTracker.domain.exception.DomainError;
import com.jotta.WorkoutTracker.domain.exception.WorkoutTrackerException;
import com.jotta.WorkoutTracker.shared.SetType;
import static com.jotta.WorkoutTracker.shared.utils.ValidationUtils.isPositive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkoutExerciseDetail {
    private Exercise exercise;
    private Short item;
    private SetType type;
    private Short reps;
    private Short weight;
    private Integer distanceMeters;
    private Integer durationSeconds;

    public void validateSetData() {
        switch (exercise.getType()) {
            case BODYWEIGHT -> validateBodyweightSet();
            case WEIGHT -> validateWeightSet();
            case CARDIO -> validateCardioSet();
            case CARDIO_WITH_DISTANCE -> validateCardioWithDistanceSet();
        }
    }

    private void validateCardioWithDistanceSet() {
        if (!isPositive(durationSeconds) || !isPositive(distanceMeters)) {
            throw new WorkoutTrackerException(DomainError.INVALID_CARDIO_WITH_DISTANCE_SET);
        }
    }

    private void validateCardioSet() {
        if (!isPositive(durationSeconds)) {
            throw new WorkoutTrackerException(DomainError.INVALID_CARDIO_SET);
        }
    }

    private void validateWeightSet() {
        if (!isPositive(reps) || !isPositive(weight)) {
            throw new WorkoutTrackerException(DomainError.INVALID_BODYWEIGHT_SET);
        }
    }

    private void validateBodyweightSet() {
        if (!isPositive(reps)) {
            throw new WorkoutTrackerException(DomainError.INVALID_BODYWEIGHT_SET);
        }
    }

}
