package com.jotta.WorkoutTracker.infrastructure.controller.dto;

import com.jotta.WorkoutTracker.shared.ExerciseType;
import lombok.*;

@Data
@Builder
public class ExerciseDto {
    private Integer id;
    private String name;
    private ExerciseType type;
    private String imageUrl;
    private Muscle muscle;

    @Data
    @Builder
    public static class Muscle {
        private Integer id;
        private String name;
    }
}
