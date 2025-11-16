package com.jotta.WorkoutTracker.infrastructure.persistence.entity;

import com.jotta.WorkoutTracker.infrastructure.persistence.entity.embedded.WorkoutExerciseDetailId;
import com.jotta.WorkoutTracker.shared.SetType;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "workout_exercise_detail")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutExerciseDetailEntity {

    @EmbeddedId
    @EqualsAndHashCode.Include
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
    @JoinColumns({
            @JoinColumn(name = "workout_id", referencedColumnName = "workout_id", insertable = false, updatable = false),
            @JoinColumn(name = "exercise_id", referencedColumnName = "exercise_id", insertable = false, updatable = false)
    })
    private WorkoutExerciseEntity workoutExercise;
}
