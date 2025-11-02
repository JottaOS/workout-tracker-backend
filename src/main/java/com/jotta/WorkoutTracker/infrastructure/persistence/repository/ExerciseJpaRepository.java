package com.jotta.WorkoutTracker.infrastructure.persistence.repository;

import com.jotta.WorkoutTracker.infrastructure.persistence.entity.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExerciseJpaRepository extends JpaRepository<ExerciseEntity, Integer> {
}
