package com.jotta.WorkoutTracker.infraestructure.persistence.mapper;

import com.jotta.WorkoutTracker.domain.model.Exercise;
import com.jotta.WorkoutTracker.infraestructure.persistence.entity.ExerciseEntity;

public class ExerciseMapper {

    public static Exercise toDomain(ExerciseEntity exerciseEntity) {
        return Exercise.builder()
                .id(exerciseEntity.getId())
                .name(exerciseEntity.getName())
                .type(exerciseEntity.getType())
                .imageUrl(exerciseEntity.getImageUrl())
                // TODO: Aca tengo loading lazy para el entity... ver como afecta si pongo eager
                .muscle(null)
                .build();
    }
}
