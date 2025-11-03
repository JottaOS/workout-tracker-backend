package com.jotta.WorkoutTracker.infrastructure.controller.mapper;

import com.jotta.WorkoutTracker.domain.model.Workout;
import com.jotta.WorkoutTracker.domain.model.WorkoutExercise;
import com.jotta.WorkoutTracker.domain.model.WorkoutExerciseDetail;
import com.jotta.WorkoutTracker.infrastructure.controller.dto.WorkoutDto;
import com.jotta.WorkoutTracker.infrastructure.controller.dto.WorkoutExerciseDetailDto;
import com.jotta.WorkoutTracker.infrastructure.controller.dto.WorkoutExerciseDto;

public class WorkoutMapper {
    public static WorkoutDto toDto(Workout workout) {
        return WorkoutDto.builder()
                .id(workout.getId())
                .title(workout.getTitle())
                .volume(workout.getVolume())
                .sets(workout.getSets())
                .startedAt(workout.getStartedAt())
                .finishedAt(workout.getFinishedAt())
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
