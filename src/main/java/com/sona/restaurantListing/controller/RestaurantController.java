package com.sona.restaurantListing.controller;

import com.sona.restaurantListing.dto.RestaurantDto;
import com.sona.restaurantListing.service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @Operation(summary = "Fetch a list of Restaurant",
            description = "Provides paginated access to the details of the Restaurant",
            responses = {@ApiResponse(responseCode = "200", description = "Page of Restaurant details.")})
    @GetMapping("/getAll")
    public ResponseEntity<List<RestaurantDto>> fetchAllRestaurant(){
        return ResponseEntity.ok().body(restaurantService.fetchAllRestaurant());
    }

    @Operation(summary = "Add a new Restaurant.",
            description = "Adds a new Restaurant to the list",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The Restaurant details.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestaurantDto.class))),
            responses = {
                    @ApiResponse(responseCode = "201", description = "The Restaurant has been added.",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = RestaurantDto.class))),
                    @ApiResponse(responseCode = "409", description = "A repository already exist for the submitted request.", content = @Content())})

    @PostMapping("/add")
    public ResponseEntity<RestaurantDto> addRestaurant(@Valid @RequestBody RestaurantDto restaurantDto){
        return ResponseEntity.ok().body(restaurantService.addRestaurant(restaurantDto));
    }

    @GetMapping("/search")
    public ResponseEntity<List<RestaurantDto>> searchRestaurants(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String city) {

        List<RestaurantDto> restaurants = restaurantService.getRestaurants(name, city);
        return ResponseEntity.ok(restaurants);
    }
}
