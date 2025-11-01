package com.jotta.WorkoutTracker.infraestructure.controller;

import com.jotta.WorkoutTracker.infraestructure.controller.dto.ApiErrorResponse;
import com.jotta.WorkoutTracker.infraestructure.controller.dto.AllMusclesDto;
import com.jotta.WorkoutTracker.infraestructure.controller.dto.MuscleDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;


@OpenAPIDefinition(info = @Info(title = "Workout tracker API", version = "1.0", description = "All endpoints and types exposed for a RESTful Workout Tracker API"))
@Tag(name = "MuscleController", description = "All muscle related operations")
public interface MuscleController {
    @Operation(summary = "Get muscle by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Muscle obtained successfully", content = @Content(schema = @Schema(implementation = MuscleDto.class))),
            @ApiResponse(responseCode = "404", description = "Muscle not found", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    ResponseEntity<MuscleDto> getById(Integer muscleId);

    @Operation(summary = "Get all muscles", description = "Gets all muscles without pagination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Muscle obtained successfully", content = @Content(schema = @Schema(implementation = AllMusclesDto.class))),
            @ApiResponse(responseCode = "404", description = "Muscle not found", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    ResponseEntity<AllMusclesDto> getAll();
}
