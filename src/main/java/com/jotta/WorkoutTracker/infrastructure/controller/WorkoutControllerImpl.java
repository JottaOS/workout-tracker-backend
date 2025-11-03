package com.jotta.WorkoutTracker.infrastructure.controller;

import com.jotta.WorkoutTracker.domain.port.in.WorkoutService;
import com.jotta.WorkoutTracker.infrastructure.controller.dto.AllWorkoutsDto;
import com.jotta.WorkoutTracker.infrastructure.controller.dto.WorkoutDto;
import com.jotta.WorkoutTracker.infrastructure.controller.mapper.WorkoutMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/workouts")
public class WorkoutControllerImpl implements WorkoutController {
    private final WorkoutService workoutService;

    @GetMapping("/{workoutId}")
    public ResponseEntity<WorkoutDto> getById(Integer workoutId) {
        return ResponseEntity.ok(WorkoutMapper.toDto(workoutService.getWorkout(workoutId)));
    }

    @GetMapping()
    public ResponseEntity<AllWorkoutsDto> getAll() {
        return ResponseEntity.ok(new AllWorkoutsDto(
                workoutService.getAllWorkouts()
                        .stream()
                        .map(WorkoutMapper::toDto)
                        .toList()
        ));
    }
}
