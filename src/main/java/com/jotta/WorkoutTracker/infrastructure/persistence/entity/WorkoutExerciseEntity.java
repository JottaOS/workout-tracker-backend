package com.jotta.WorkoutTracker.infrastructure.persistence.entity;

import com.jotta.WorkoutTracker.infrastructure.persistence.entity.embedded.WorkoutExerciseId;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "workout_exercise")
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WorkoutExerciseEntity {

    @EmbeddedId
    @EqualsAndHashCode.Include
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
//    @MapsId("exerciseId")
    @JoinColumn(name = "exercise_id", insertable = false, updatable = false)
    private ExerciseEntity exercise;

    @OneToMany(
            mappedBy = "workoutExercise",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<WorkoutExerciseDetailEntity> details;
}
