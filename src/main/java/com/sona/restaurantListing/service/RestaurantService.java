package com.sona.restaurantListing.service;

import com.sona.restaurantListing.dto.RestaurantDto;
import com.sona.restaurantListing.mapper.RestaurantMapper;
import com.sona.restaurantListing.repositoryJpa.RestaurantRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepositoryJpa restaurantRepositoryJpa;

    public List<RestaurantDto> fetchAllRestaurant(){
        return RestaurantMapper.INSTANCE.mapRestaurantEntityRestaurantDtoList(restaurantRepositoryJpa.findAll());
    }

    public RestaurantDto addRestaurant(RestaurantDto restaurantDto) {
        return RestaurantMapper.INSTANCE.mapRestaurantEntityRestaurantDto(
                restaurantRepositoryJpa.save(RestaurantMapper.INSTANCE.mapRestaurantDtoRestaurantEntity(restaurantDto)));
    }
}
