package com.jotta.WorkoutTracker.infrastructure.controller;

import com.jotta.WorkoutTracker.domain.port.in.WorkoutService;
import com.jotta.WorkoutTracker.infrastructure.controller.dto.AllWorkoutsDto;
import com.jotta.WorkoutTracker.infrastructure.controller.dto.WorkoutDto;
import com.jotta.WorkoutTracker.infrastructure.controller.mapper.WorkoutMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/workouts")
public class WorkoutControllerImpl implements WorkoutController {
    private final WorkoutService workoutService;

    @GetMapping("/{workoutId}")
    public ResponseEntity<WorkoutDto> getById(@PathVariable Integer workoutId) {
        return ResponseEntity.ok(WorkoutMapper.toDto(workoutService.getWorkout(workoutId)));
    }

    @GetMapping
    public ResponseEntity<AllWorkoutsDto> getAll(@RequestParam(defaultValue = "false") Boolean isTemplate) {
        return ResponseEntity.ok(new AllWorkoutsDto(
                workoutService.getAllWorkouts(isTemplate)
                        .stream()
                        .map(WorkoutMapper::toDto)
                        .toList()
        ));
    }

    @PostMapping
    public ResponseEntity<WorkoutDto> createWorkout(@Valid @RequestBody WorkoutDto workoutRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(WorkoutMapper.toDto(workoutService.createWorkout(WorkoutMapper.toDomain(workoutRequest))));
    }

    @PutMapping("/{workoutId}")
    public ResponseEntity<WorkoutDto> updateWorkout(@PathVariable Integer workoutId,
                                                    @Valid @RequestBody WorkoutDto workoutDto) {
        return ResponseEntity.ok(
                WorkoutMapper.toDto(workoutService.updateWorkout(workoutId, WorkoutMapper.toDomain(workoutDto)))
        );
    }

    @DeleteMapping("/{workoutId}")
    public ResponseEntity<Void> deleteWorkout(@PathVariable Integer workoutId) {
        workoutService.deleteWorkout(workoutId);
        return ResponseEntity.accepted().build();
    }


}
