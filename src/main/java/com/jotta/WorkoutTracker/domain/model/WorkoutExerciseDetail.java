package com.jotta.WorkoutTracker.domain.model;

import com.jotta.WorkoutTracker.domain.exception.DomainError;
import com.jotta.WorkoutTracker.domain.exception.WorkoutTrackerException;
import com.jotta.WorkoutTracker.shared.SetType;
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
        if(this.durationSeconds <= 0 || this.distanceMeters <= 0) {
            throw new WorkoutTrackerException(DomainError.INVALID_CARDIO_WITH_DISTANCE_SET);
        }
    }

    private void validateCardioSet() {
        if(this.durationSeconds <= 0) {
            throw new WorkoutTrackerException(DomainError.INVALID_CARDIO_SET);
        }
    }

    private void validateWeightSet() {
        if(this.reps <= 0 || this.weight <= 0) {
            throw new WorkoutTrackerException(DomainError.INVALID_BODYWEIGHT_SET);
        }
    }

    private void validateBodyweightSet() {
        if(this.reps <= 0) {
            throw new WorkoutTrackerException(DomainError.INVALID_BODYWEIGHT_SET);
        }
    }

}
