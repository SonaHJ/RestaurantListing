package com.sona.restaurantListing.controller;

import com.sona.restaurantListing.dto.RestaurantDto;
import com.sona.restaurantListing.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/fetchRestaurant")
    public ResponseEntity<List<RestaurantDto>> fetchAllRestaurant(){
        return ResponseEntity.ok().body(restaurantService.fetchAllRestaurant());
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDto> addRestaurant(@RequestBody RestaurantDto restaurantDto){
        return ResponseEntity.ok().body(restaurantService.addRestaurant(restaurantDto));
    }
}
