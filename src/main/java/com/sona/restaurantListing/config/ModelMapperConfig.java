package com.sona.restaurantListing.config;

import com.sona.restaurantListing.dto.RestaurantDto;
import com.sona.restaurantListing.entity.RestaurantEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(RestaurantDto.class, RestaurantEntity.class).addMappings(mapper -> {
            mapper.skip(RestaurantEntity::setRestaurantId);
        });
        return modelMapper;
    }
}
