package com.jotta.WorkoutTracker.infrastructure.persistence.adapter;

import com.jotta.WorkoutTracker.domain.model.Workout;
import com.jotta.WorkoutTracker.domain.port.out.WorkoutRepository;
import com.jotta.WorkoutTracker.infrastructure.persistence.mapper.WorkoutMapper;
import com.jotta.WorkoutTracker.infrastructure.persistence.repository.WorkoutJpaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class WorkoutRepositoryAdapter implements WorkoutRepository {
    private final WorkoutJpaRepository workoutJpaRepository;

    public Optional<Workout> getById(Integer workoutId) {
        return workoutJpaRepository.findByIdWithDetails(workoutId)
                .map(WorkoutMapper::toDomain);
    }

    public List<Workout> getAll(Boolean isTemplate) {
        return workoutJpaRepository.findAllByIsTemplate(isTemplate).stream()
                .map(WorkoutMapper::toDomain)
                .toList();
    }

    @Transactional
    public Workout save(Workout workout) {
        final var entity = workoutJpaRepository.save(WorkoutMapper.toEntity(workout));
        workout.setId(entity.getId());
        return workout;
    }

    @Transactional
    public void deleteById(Integer workoutId) {
        workoutJpaRepository.deleteById(workoutId);
    }
}
