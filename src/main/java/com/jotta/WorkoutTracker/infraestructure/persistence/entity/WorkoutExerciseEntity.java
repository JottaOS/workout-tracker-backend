package com.jotta.WorkoutTracker.infraestructure.persistence.entity;

import com.jotta.WorkoutTracker.infraestructure.persistence.entity.embedded.WorkoutExerciseId;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workout_exercise")
@Data
public class WorkoutExerciseEntity {

    @EmbeddedId
    private WorkoutExerciseId id;

    @Column(name = "rest_seconds")
    private Integer restSeconds;

    @Column
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("workoutId")
    @JoinColumn(name = "workout_id", insertable = false, updatable = false)
    private WorkoutEntity workout;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("exerciseId")
    @JoinColumn(name = "exercise_id", insertable = false, updatable = false)
    private ExerciseEntity exercise;

    @OneToMany(
            mappedBy = "workoutExercise",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<WorkoutExerciseDetailEntity> details = new ArrayList<>();
}
