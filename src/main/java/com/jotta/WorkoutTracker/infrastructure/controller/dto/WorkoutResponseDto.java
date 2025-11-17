package com.jotta.WorkoutTracker.infrastructure.controller.dto;

import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.List;


@Builder
public record WorkoutResponseDto(
        Integer id,

        String title,

        Integer volume,

        Short sets,

        ZonedDateTime startedAt,

        ZonedDateTime finishedAt,

        Boolean isTemplate,

        List<WorkoutExerciseDto> exercises
) {
}
