package com.sona.restaurantListing.repositoryJpa;

import com.sona.restaurantListing.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepositoryJpa extends JpaRepository<RestaurantEntity, Integer> {
}
