package com.jotta.WorkoutTracker.infrastructure.controller;

import com.jotta.WorkoutTracker.domain.port.in.ExerciseService;
import com.jotta.WorkoutTracker.infrastructure.controller.dto.AllExercisesDto;
import com.jotta.WorkoutTracker.infrastructure.controller.dto.ExerciseDto;
import com.jotta.WorkoutTracker.infrastructure.controller.mapper.ExerciseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/exercises")
public class ExerciseControllerImpl implements ExerciseController {
    private final ExerciseService exerciseService;

    @GetMapping("/{exerciseId}")
    public ResponseEntity<ExerciseDto> getById(Integer exerciseId) {
        return ResponseEntity.ok(ExerciseMapper.toDto(exerciseService.getById(exerciseId)));
    }

    @GetMapping("")
    public ResponseEntity<AllExercisesDto> getAll() {
        return ResponseEntity.ok(new AllExercisesDto(
                exerciseService.getAll().stream().map(ExerciseMapper::toDto).toList()
        ));
    }
}
