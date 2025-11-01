package com.jotta.WorkoutTracker.infraestructure.persistence.adapter;

import com.jotta.WorkoutTracker.domain.model.Exercise;
import com.jotta.WorkoutTracker.domain.model.Muscle;
import com.jotta.WorkoutTracker.domain.port.out.ExerciseRepository;
import com.jotta.WorkoutTracker.infraestructure.persistence.repository.ExerciseJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExerciseRepositoryAdapter implements ExerciseRepository {

    private final ExerciseJpaRepository muscleJpaRepository;

    public Optional<Exercise> findById(Integer id) {
        return muscleJpaRepository.findById(id)
                .map(entity -> Exercise.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .type(entity.getType())
                        .imageUrl(entity.getImageUrl())
                        .muscle(new Muscle(entity.getMuscle().getId(), entity.getMuscle().getName()))
                        .build()
                    );

    }

    public List<Exercise> findAll() {
        return muscleJpaRepository.findAll()
                .stream()
                .map(entity -> Exercise.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .type(entity.getType())
                        .imageUrl(entity.getImageUrl())
                        .muscle(new Muscle(entity.getMuscle().getId(), entity.getMuscle().getName()))
                        .build())
                .toList();
    }
}
