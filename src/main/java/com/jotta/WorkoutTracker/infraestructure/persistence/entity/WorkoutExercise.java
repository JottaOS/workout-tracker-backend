package com.jotta.WorkoutTracker.infraestructure.persistence.entity;

import com.jotta.WorkoutTracker.infraestructure.persistence.entity.embedded.WorkoutExerciseId;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "workout_exercise")
@Data
public class WorkoutExercise {

    @EmbeddedId
    private WorkoutExerciseId id;

    @Column(name = "rest_seconds")
    private Integer restSeconds;

    @Column
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("workoutId")
    @JoinColumn(name = "workout_id", insertable = false, updatable = false)
    private Workout workout;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("exerciseId")
    @JoinColumn(name = "exercise_id", insertable = false, updatable = false)
    private Exercise exercise;
}
