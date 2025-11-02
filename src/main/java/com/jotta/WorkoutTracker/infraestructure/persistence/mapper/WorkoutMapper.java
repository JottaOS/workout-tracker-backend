package com.jotta.WorkoutTracker.infraestructure.persistence.mapper;

import com.jotta.WorkoutTracker.domain.model.Exercise;
import com.jotta.WorkoutTracker.domain.model.Workout;
import com.jotta.WorkoutTracker.domain.model.WorkoutExercise;
import com.jotta.WorkoutTracker.domain.model.WorkoutExerciseDetail;
import com.jotta.WorkoutTracker.infraestructure.persistence.entity.ExerciseEntity;
import com.jotta.WorkoutTracker.infraestructure.persistence.entity.WorkoutEntity;
import com.jotta.WorkoutTracker.infraestructure.persistence.entity.WorkoutExerciseDetailEntity;
import com.jotta.WorkoutTracker.infraestructure.persistence.entity.WorkoutExerciseEntity;

import java.util.List;

public class WorkoutMapper {

    public static Workout toDomain(WorkoutEntity entity) {
        List<WorkoutExercise> exercises = entity.getExercises().stream()
                .map(WorkoutMapper::toDomain)
                .toList();

        return Workout.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .sets(entity.getSets())
                .volume(entity.getVolume())
                .startedAt(entity.getStartedAt())
                .finishedAt(entity.getFinishedAt())
                .exercises(exercises)
                .build();
    }

    public static WorkoutEntity toEntity(Workout workout) {
        return WorkoutEntity.builder()
                .id(workout.getId())
                .title(workout.getTitle())
                .volume(workout.getVolume())
                .sets(workout.getSets())
                .startedAt(workout.getStartedAt())
                .finishedAt(workout.getFinishedAt())
                .build();
    }


    private static WorkoutExercise toDomain(WorkoutExerciseEntity entity) {
        List<WorkoutExerciseDetail> details = entity.getDetails().stream()
                .map(detail -> toDomain(detail, entity.getExercise()))
                .toList();

        return WorkoutExercise.builder()
                .workoutId(entity.getId().getWorkoutId())
                .exerciseId(entity.getId().getExerciseId())
                .restSeconds(entity.getRestSeconds())
                .notes(entity.getNotes())
                .details(details)
                .build();
    }

    private static WorkoutExerciseDetail toDomain(
            WorkoutExerciseDetailEntity entity,
            ExerciseEntity exerciseEntity
    ) {
        Exercise exercise = ExerciseMapper.toDomain(exerciseEntity);

        return WorkoutExerciseDetail.builder()
                .exercise(exercise)
                .item(entity.getId().getItem())
                .type(entity.getType())
                .reps(entity.getReps())
                .weight(entity.getWeight())
                .distanceMeters(entity.getDistanceMeters())
                .durationSeconds(entity.getDurationSeconds())
                .build();
    }

}
