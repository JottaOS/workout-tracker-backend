package com.jotta.WorkoutTracker.infrastructure.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.List;


@Builder
public record WorkoutDto(
        Integer id,

        @NotBlank(message = "title cannot be blank")
        @Size(max = 255, message = "title cannot exceed 255 characters")
        String title,

        @Min(0)
        Integer volume,

        @Min(1)
        Short sets,

        @NotNull
        ZonedDateTime startedAt,

        @NotNull
        ZonedDateTime finishedAt,

        @Valid
        List<WorkoutExerciseDto> exercises
) {
}
