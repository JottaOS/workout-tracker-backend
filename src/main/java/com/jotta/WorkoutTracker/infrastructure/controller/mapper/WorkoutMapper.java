package com.jotta.WorkoutTracker.infrastructure.controller.mapper;

import com.jotta.WorkoutTracker.domain.model.Workout;
import com.jotta.WorkoutTracker.domain.model.WorkoutExercise;
import com.jotta.WorkoutTracker.domain.model.WorkoutExerciseDetail;
import com.jotta.WorkoutTracker.infrastructure.controller.dto.WorkoutDto;
import com.jotta.WorkoutTracker.infrastructure.controller.dto.WorkoutExerciseDetailDto;
import com.jotta.WorkoutTracker.infrastructure.controller.dto.WorkoutExerciseDto;

import java.util.concurrent.atomic.AtomicInteger;

public class WorkoutMapper {
    public static Workout toDomain(WorkoutDto workoutDto) {
        return Workout.builder()
                .id(workoutDto.id())
                .title(workoutDto.title())
                .startedAt(workoutDto.startedAt())
                .finishedAt(workoutDto.finishedAt())
                .volume(workoutDto.volume())
                .sets(workoutDto.sets())
                .isTemplate(workoutDto.isTemplate())
                .exercises(workoutDto.exercises()
                        .stream()
                        .map(exercise -> toDomain(exercise, workoutDto.id()))
                        .toList())
                .build();
    }

    public static WorkoutExercise toDomain(WorkoutExerciseDto dto, Integer workoutId) {
        AtomicInteger index = new AtomicInteger(1);

        return WorkoutExercise.builder()
                .workoutId(workoutId)
                .exerciseId(dto.exerciseId())
                .notes(dto.notes())
                .restSeconds(dto.restSeconds())
                .details(dto.details().stream().map((item) -> toDomain(item, (short) index.getAndIncrement())).toList())
                .build();
    }

    public static WorkoutExerciseDetail toDomain(WorkoutExerciseDetailDto dto, Short index) {
        return WorkoutExerciseDetail.builder()
                .item(index)
                .exercise(null) // settear en service
                .type(dto.type())
                .weight(dto.weight())
                .distanceMeters(dto.distanceMeters())
                .durationSeconds(dto.durationSeconds())
                .reps(dto.reps())
                .build();
    }

    public static WorkoutDto toDto(Workout workout) {
        return WorkoutDto.builder()
                .id(workout.getId())
                .title(workout.getTitle())
                .volume(workout.getVolume())
                .sets(workout.getSets())
                .startedAt(workout.getStartedAt())
                .finishedAt(workout.getFinishedAt())
                .isTemplate(workout.getIsTemplate())
                .exercises(workout.getExercises().stream().map(WorkoutMapper::toDto).toList())
                .build();
    }

    public static WorkoutExerciseDto toDto(WorkoutExercise workoutExercise) {
        return WorkoutExerciseDto.builder()
                .exerciseId(workoutExercise.getExerciseId())
                .restSeconds(workoutExercise.getRestSeconds())
                .notes(workoutExercise.getNotes())
                .details(workoutExercise.getDetails().stream().map(WorkoutMapper::toDto).toList())
                .build();
    }

    public static WorkoutExerciseDetailDto toDto(WorkoutExerciseDetail detail) {
        return WorkoutExerciseDetailDto.builder()
                .type(detail.getType())
                .reps(detail.getReps())
                .weight(detail.getWeight())
                .distanceMeters(detail.getDistanceMeters())
                .durationSeconds(detail.getDurationSeconds())
                .build();
    }
}
