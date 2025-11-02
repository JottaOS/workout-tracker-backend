package com.jotta.WorkoutTracker.infraestructure.controller.dto;

import com.jotta.WorkoutTracker.shared.SetType;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
public record WorkoutExerciseDetailDto(
        @NotNull
        SetType type,
        Short reps,
        Short weight,
        Integer distanceMeters,
        Integer durationSeconds
) {}
