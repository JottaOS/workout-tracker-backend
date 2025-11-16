package com.jotta.WorkoutTracker.infrastructure.persistence.repository;

import com.jotta.WorkoutTracker.infrastructure.persistence.entity.WorkoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface WorkoutJpaRepository extends JpaRepository<WorkoutEntity, Integer> {

    @Query("""
                SELECT w FROM WorkoutEntity w
                LEFT JOIN FETCH w.exercises we
                LEFT JOIN FETCH we.details
                LEFT JOIN FETCH we.exercise
                WHERE w.id = :id
            """)
    Optional<WorkoutEntity> findByIdWithDetails(@Param("id") Integer id);

    @Query("""
                SELECT w FROM WorkoutEntity w
                LEFT JOIN FETCH w.exercises we
                LEFT JOIN FETCH we.details
                LEFT JOIN FETCH we.exercise
                WHERE w.isTemplate = :isTemplate
            """)
    List<WorkoutEntity> findAllByIsTemplate(Boolean isTemplate);
}
