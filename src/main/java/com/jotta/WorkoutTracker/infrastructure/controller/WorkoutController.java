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

    @Operation(summary = "Get all workouts", description = "Gets all workouts without pagination. If isTemplate is true, then returns all template workouts (routines). Otherwise workouts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Workouts obtained successfully", content = @Content(schema = @Schema(implementation = AllWorkoutsDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    ResponseEntity<AllWorkoutsDto> getAll(Boolean isTemplate);


    @Operation(summary = "Create a workout", description = "Creates a workout with exercises and set details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Workout created successfully", content = @Content(schema = @Schema(implementation = WorkoutDto.class))),
            @ApiResponse(responseCode = "404", description = "An entity has not been found", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    ResponseEntity<WorkoutDto> createWorkout(WorkoutDto workoutRequest);


    @Operation(summary = "Update a workout", description = "Updates a workout with exercises and set details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Workout updated successfully", content = @Content(schema = @Schema(implementation = WorkoutDto.class))),
            @ApiResponse(responseCode = "404", description = "An entity has not been found", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    ResponseEntity<WorkoutDto> updateWorkout(Integer workoutId, WorkoutDto workoutDto);

    @Operation(summary = "Delete a workout", description = "Delete a workout by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Workout deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Workout not found", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    ResponseEntity<Void> deleteWorkout(Integer workoutId);

}
