package com.jotta.WorkoutTracker.infraestructure.controller;

import com.jotta.WorkoutTracker.infraestructure.controller.dto.ApiErrorResponse;
import com.jotta.WorkoutTracker.infraestructure.controller.dto.AllExercisesDto;
import com.jotta.WorkoutTracker.infraestructure.controller.dto.ExerciseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;


@Tag(name = "ExerciseController", description = "All exercise related operations")
public interface ExerciseController {
    @Operation(summary = "Get exercise by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exercise obtained successfully", content = @Content(schema = @Schema(implementation = ExerciseDto.class))),
            @ApiResponse(responseCode = "404", description = "Exercise not found", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    ResponseEntity<ExerciseDto> getById(Integer exerciseId);

    @Operation(summary = "Get all exercises", description = "Gets all exercises without pagination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exercise obtained successfully", content = @Content(schema = @Schema(implementation = AllExercisesDto.class))),
            @ApiResponse(responseCode = "404", description = "Exercise not found", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    ResponseEntity<AllExercisesDto> getAll();
}
