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
public class RoutineExerciseId implements Serializable {
    @Column(name = "routine_id")
    private Integer routineId;

    @Column(name = "exercise_id")
    private Integer exerciseId;
}
