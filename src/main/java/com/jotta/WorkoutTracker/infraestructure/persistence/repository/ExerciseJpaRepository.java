package com.jotta.WorkoutTracker.infraestructure.persistence.repository;

import com.jotta.WorkoutTracker.infraestructure.persistence.entity.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExerciseJpaRepository extends JpaRepository<ExerciseEntity, Integer> {
}
