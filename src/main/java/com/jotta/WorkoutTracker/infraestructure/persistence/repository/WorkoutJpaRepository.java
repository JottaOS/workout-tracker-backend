package com.jotta.WorkoutTracker.infraestructure.persistence.repository;

import com.jotta.WorkoutTracker.infraestructure.persistence.entity.WorkoutEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WorkoutJpaRepository extends JpaRepository<WorkoutEntity, Integer> {

    @EntityGraph(attributePaths = {
            "exercises",
            "exercises.exercise",
            "exercises.details"
    })
    Optional<WorkoutEntity> findByIdWithDetails(Integer workoutId);

    @EntityGraph(attributePaths = {
            "exercises",
            "exercises.exercise",
            "exercises.details"
    })
    List<WorkoutEntity> findAllWithDetails();
}
