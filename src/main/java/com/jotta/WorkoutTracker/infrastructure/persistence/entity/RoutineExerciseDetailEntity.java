package com.jotta.WorkoutTracker.infrastructure.persistence.entity;

import com.jotta.WorkoutTracker.infrastructure.persistence.entity.embedded.RoutineExerciseDetailId;
import com.jotta.WorkoutTracker.shared.SetType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "routine_exercise_detail")
public class RoutineExerciseDetailEntity {

    @EmbeddedId
    private RoutineExerciseDetailId id;

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
    @MapsId("routineId")
    @JoinColumn(name = "routine_id", insertable = false, updatable = false)
    private RoutineEntity routine;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("exerciseId")
    @JoinColumn(name = "exercise_id", insertable = false, updatable = false)
    private ExerciseEntity exercise;
}
