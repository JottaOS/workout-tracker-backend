package com.jotta.WorkoutTracker.infrastructure.persistence.mapper;

import com.jotta.WorkoutTracker.domain.model.Exercise;
import com.jotta.WorkoutTracker.domain.model.Workout;
import com.jotta.WorkoutTracker.domain.model.WorkoutExercise;
import com.jotta.WorkoutTracker.domain.model.WorkoutExerciseDetail;
import com.jotta.WorkoutTracker.infrastructure.persistence.entity.ExerciseEntity;
import com.jotta.WorkoutTracker.infrastructure.persistence.entity.WorkoutEntity;
import com.jotta.WorkoutTracker.infrastructure.persistence.entity.WorkoutExerciseDetailEntity;
import com.jotta.WorkoutTracker.infrastructure.persistence.entity.WorkoutExerciseEntity;
import com.jotta.WorkoutTracker.infrastructure.persistence.entity.embedded.WorkoutExerciseDetailId;
import com.jotta.WorkoutTracker.infrastructure.persistence.entity.embedded.WorkoutExerciseId;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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

    public static WorkoutEntity toEntity(Workout workout) {
        final var workoutEntity = WorkoutEntity.builder()
                .id(workout.getId())
                .title(workout.getTitle())
                .volume(workout.getVolume())
                .sets(workout.getSets())
                .startedAt(workout.getStartedAt())
                .finishedAt(workout.getFinishedAt())
                .build();

        final var exercises = workout.getExercises()
                .stream()
                .map(item -> toEntity(item, workoutEntity))
                .collect(Collectors.toSet());

        workoutEntity.setExercises(exercises);
        return workoutEntity;
    }

    private static WorkoutExerciseEntity toEntity(WorkoutExercise exercise,
                                                  WorkoutEntity workoutEntity) {

        final var workoutExerciseEntity = WorkoutExerciseEntity.builder()
                .id(new WorkoutExerciseId(exercise.getWorkoutId(), exercise.getExerciseId()))
                .restSeconds(exercise.getRestSeconds())
                .notes(exercise.getNotes())
                .workout(workoutEntity)
                .build();

        AtomicInteger index = new AtomicInteger(1);
        final var details = exercise.getDetails()
                .stream()
                .map(item -> {
                    final var detailId = new WorkoutExerciseDetailId(
                            workoutExerciseEntity.getId(),
                            (short) index.getAndIncrement()
                    );
                    return toEntity(item, detailId, workoutExerciseEntity);
                })
                .collect(Collectors.toSet());

        workoutExerciseEntity.setDetails(details);
        return workoutExerciseEntity;
    }

    private static WorkoutExerciseDetailEntity toEntity(
            WorkoutExerciseDetail detail,
            WorkoutExerciseDetailId id,
            WorkoutExerciseEntity workoutExercise
    ) {
        return WorkoutExerciseDetailEntity.builder()
                .id(id)
                .type(detail.getType())
                .reps(detail.getReps())
                .weight(detail.getWeight())
                .distanceMeters(detail.getDistanceMeters())
                .durationSeconds(detail.getDurationSeconds())
                .workoutExercise(workoutExercise)
                .build();
    }
}
