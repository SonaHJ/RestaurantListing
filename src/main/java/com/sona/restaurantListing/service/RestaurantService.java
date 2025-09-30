package com.sona.restaurantListing.service;

import com.sona.restaurantListing.dto.RestaurantDto;
import com.sona.restaurantListing.entity.RestaurantEntity;
import com.sona.restaurantListing.mapper.RestaurantMapper;
import com.sona.restaurantListing.repositoryJpa.RestaurantRepositoryJpa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    private final RestaurantRepositoryJpa restaurantRepositoryJpa;
    private final ModelMapper modelMapper;

    public RestaurantService(RestaurantRepositoryJpa restaurantRepositoryJpa, ModelMapper modelMapper) {
        this.restaurantRepositoryJpa = restaurantRepositoryJpa;
        this.modelMapper = modelMapper;
    }

    public List<RestaurantDto> fetchAllRestaurant(){
        List<RestaurantEntity> entities = restaurantRepositoryJpa.findAll();
        return entities.stream()
                .map(entity -> modelMapper.map(entity, RestaurantDto.class))
                .collect(Collectors.toList());
    }

    public RestaurantDto addRestaurant(RestaurantDto restaurantDto) {
        /*boolean exists = restaurantRepositoryJpa.existsByRestaurantNameAndRestaurantCity(
                dto.getRestaurantName(), dto.getRestaurantCity());

        if (exists) {
            throw new RestaurantAlreadyExistsException("A restaurant with the same name and city already exists.");
        }*/
        RestaurantEntity entity = modelMapper.map(restaurantDto, RestaurantEntity.class);
        RestaurantEntity savedEntity = restaurantRepositoryJpa.save(entity);
        return modelMapper.map(savedEntity, RestaurantDto.class);
    }

    public List<RestaurantDto> getRestaurants(String name, String city) {
        List<RestaurantEntity> restaurantEntityList;

        if (name != null && !name.isEmpty() && city != null && !city.isEmpty()) {
            restaurantEntityList = restaurantRepositoryJpa.findByRestaurantNameIgnoreCaseAndRestaurantCityIgnoreCase(name, city);
        } else if (name != null && !name.isEmpty()) {
            restaurantEntityList = restaurantRepositoryJpa.findByRestaurantNameIgnoreCase(name);
        } else if (city != null && !city.isEmpty()) {
            restaurantEntityList = restaurantRepositoryJpa.findByRestaurantCityIgnoreCase(city);
        } else {
            restaurantEntityList = restaurantRepositoryJpa.findAll();
        }

        return restaurantEntityList.stream()
                .map(entity -> modelMapper.map(entity, RestaurantDto.class))
                .collect(Collectors.toList());
    }
}
