package com.sona.restaurantListing.repositoryJpa;

import com.sona.restaurantListing.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepositoryJpa extends JpaRepository<RestaurantEntity, Integer> {
    boolean existsByRestaurantNameAndRestaurantCity(String restaurantName, String restaurantCity);
    List<RestaurantEntity> findByRestaurantCityIgnoreCase(String city);
    List<RestaurantEntity> findByRestaurantNameIgnoreCase(String name);
    List<RestaurantEntity> findByRestaurantNameIgnoreCaseAndRestaurantCityIgnoreCase(String name, String city);
}
