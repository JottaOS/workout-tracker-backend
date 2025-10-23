package com.jotta.WorkoutTracker.infraestructure.persistence.entity.embedded;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class WorkoutExerciseDetailId implements Serializable {
    @Column(name = "workout_id")
    private Integer workoutId;

    @Column(name = "exercise_id")
    private Integer exerciseId;

    @Column
    private Short item;
}
