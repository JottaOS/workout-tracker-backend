package com.jotta.WorkoutTracker.infrastructure.persistence.repository;

import com.jotta.WorkoutTracker.infrastructure.persistence.entity.MuscleEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MuscleJpaRepository extends JpaRepository<MuscleEntity, Integer> {
}
