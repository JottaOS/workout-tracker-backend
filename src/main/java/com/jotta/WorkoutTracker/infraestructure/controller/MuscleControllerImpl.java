package com.jotta.WorkoutTracker.infraestructure.controller;

import com.jotta.WorkoutTracker.domain.port.in.MuscleService;
import com.jotta.WorkoutTracker.infraestructure.controller.dto.AllMusclesDto;
import com.jotta.WorkoutTracker.infraestructure.controller.dto.MuscleDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/muscles")
@RequiredArgsConstructor
public class MuscleControllerImpl implements MuscleController {

    private final MuscleService muscleService;

    @GetMapping("/{muscleId}")
    public ResponseEntity<MuscleDto> getById(@PathVariable Integer muscleId) {
        log.info("[getById] GET -> request: {}", muscleId);
        final var muscle = muscleService.getById(muscleId);
        return ResponseEntity.ok(new MuscleDto(muscle.getId(), muscle.getName()));
    }

    @GetMapping()
    public ResponseEntity<AllMusclesDto> getAll() {
        log.info("[getAll] GET");
        return ResponseEntity.ok(new AllMusclesDto(muscleService.getAll()
                .stream()
                .map(muscle -> new MuscleDto(muscle.getId(), muscle.getName()))
                .toList()));
    }
}
