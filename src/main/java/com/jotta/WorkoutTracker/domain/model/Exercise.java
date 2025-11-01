package com.jotta.WorkoutTracker.domain.model;

import com.jotta.WorkoutTracker.shared.ExerciseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Exercise {
    private Integer id;
    private String name;
    private ExerciseType type;
    private String imageUrl;
    private Muscle muscle;
}
