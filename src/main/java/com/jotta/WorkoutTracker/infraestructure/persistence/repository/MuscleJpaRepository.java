package com.jotta.WorkoutTracker.infraestructure.persistence.repository;

import com.jotta.WorkoutTracker.infraestructure.persistence.entity.MuscleEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MuscleJpaRepository extends JpaRepository<MuscleEntity, Integer> {
}
