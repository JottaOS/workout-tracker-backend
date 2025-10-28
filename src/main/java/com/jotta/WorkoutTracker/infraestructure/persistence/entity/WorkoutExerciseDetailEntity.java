package com.jotta.WorkoutTracker.infraestructure.persistence.entity;

import com.jotta.WorkoutTracker.infraestructure.persistence.entity.embedded.WorkoutExerciseDetailId;
import com.jotta.WorkoutTracker.shared.SetType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "workout_exercise_detail")
public class WorkoutExerciseDetailEntity {

    @EmbeddedId
    private WorkoutExerciseDetailId id;

    @Enumerated(value = EnumType.STRING)
    private SetType type;

    @Column
    private Short reps;

    @Column
    private Short weight;

    @Column(name = "distance_meters")
    private Integer distanceMeters;

    @Column(name = "duration_seconds")
    private Integer durationSeconds;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("workoutId")
    @JoinColumn(name = "workout_id", insertable = false, updatable = false)
    private WorkoutEntity workout;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("exerciseId")
    @JoinColumn(name = "exercise_id", insertable = false, updatable = false)
    private ExerciseEntity exercise;
}
