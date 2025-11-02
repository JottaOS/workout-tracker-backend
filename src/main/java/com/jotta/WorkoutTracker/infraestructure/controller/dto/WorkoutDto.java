package com.jotta.WorkoutTracker.infraestructure.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.List;


@Builder
public record WorkoutDto(
        @Min(1)
        Integer id,

        @NotBlank
        String title,

        @Min(0)
        Integer volume,

        @NotNull
        ZonedDateTime startedAt,

        @NotNull
        ZonedDateTime finishedAt,

        @Valid
        List<WorkoutExerciseDetailDto> details
) {
}
