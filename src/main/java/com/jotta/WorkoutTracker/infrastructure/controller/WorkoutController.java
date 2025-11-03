package com.jotta.WorkoutTracker.infrastructure.controller;

import com.jotta.WorkoutTracker.infrastructure.controller.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;


@Tag(name = "WorkoutController", description = "All workout related operations")
public interface WorkoutController {
    @Operation(summary = "Get workout by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Workout obtained successfully", content = @Content(schema = @Schema(implementation = WorkoutDto.class))),
            @ApiResponse(responseCode = "404", description = "Workout not found", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    ResponseEntity<WorkoutDto> getById(Integer workoutId);

    @Operation(summary = "Get all workouts", description = "Gets all workouts without pagination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Workouts obtained successfully", content = @Content(schema = @Schema(implementation = AllWorkoutsDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    ResponseEntity<AllWorkoutsDto> getAll();
}
