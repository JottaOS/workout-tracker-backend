package com.jotta.WorkoutTracker.infrastructure.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.List;


@Builder
public record WorkoutRequestDto(
        @NotBlank(message = "title cannot be blank")
        @Size(max = 255, message = "title cannot exceed 255 characters")
        String title,

        ZonedDateTime startedAt,

        ZonedDateTime finishedAt,

        @NotNull(message = "isTemplate cannot be null")
        Boolean isTemplate,

        @Valid
        List<WorkoutExerciseDto> exercises
) {
}
