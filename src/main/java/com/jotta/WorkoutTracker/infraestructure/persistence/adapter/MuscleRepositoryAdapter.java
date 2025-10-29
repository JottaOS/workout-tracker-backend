package com.jotta.WorkoutTracker.infraestructure.persistence.adapter;

import com.jotta.WorkoutTracker.domain.model.Muscle;
import com.jotta.WorkoutTracker.domain.repository.MuscleRepository;
import com.jotta.WorkoutTracker.infraestructure.persistence.repository.MuscleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MuscleRepositoryAdapter implements MuscleRepository {

    private final MuscleJpaRepository muscleJpaRepository;

    public Optional<Muscle> findById(Integer id) {
        return muscleJpaRepository.findById(id)
                .map(entity -> new Muscle(entity.getId(), entity.getName()));

    }

    public List<Muscle> findAll() {
        return muscleJpaRepository.findAll()
                .stream()
                .map(entity -> new Muscle(entity.getId(), entity.getName()))
                .toList();
    }
}
