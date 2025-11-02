package com.jotta.WorkoutTracker.infrastructure.controller.mapper;

import com.jotta.WorkoutTracker.domain.model.Exercise;
import com.jotta.WorkoutTracker.infrastructure.controller.dto.ExerciseDto;

public class ExerciseMapper {

    public static ExerciseDto toDto(Exercise exercise) {
        return ExerciseDto.builder()
                .id(exercise.getId())
                .name(exercise.getName())
                .imageUrl(exercise.getImageUrl())
                .type(exercise.getType())
                .muscle(ExerciseDto.Muscle.builder()
                        .id(exercise.getMuscle().getId())
                        .name(exercise.getMuscle().getName())
                        .build()
                )
                .build();
    }
}
