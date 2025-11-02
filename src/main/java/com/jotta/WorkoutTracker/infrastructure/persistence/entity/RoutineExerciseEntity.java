package com.jotta.WorkoutTracker.infrastructure.persistence.entity;

import com.jotta.WorkoutTracker.infrastructure.persistence.entity.embedded.RoutineExerciseId;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "routine_exercise")
@Data
public class RoutineExerciseEntity {

    @EmbeddedId
    private RoutineExerciseId id;

    @Column(name = "rest_seconds")
    private Integer restSeconds;

    @Column
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("routineId")
    @JoinColumn(name = "routine_id", insertable = false, updatable = false)
    private RoutineEntity routine;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("exerciseId")
    @JoinColumn(name = "exercise_id", insertable = false, updatable = false)
    private ExerciseEntity exercise;
}
