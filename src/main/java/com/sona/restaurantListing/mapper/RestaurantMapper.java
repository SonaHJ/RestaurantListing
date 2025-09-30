package com.sona.restaurantListing.mapper;

import com.sona.restaurantListing.dto.RestaurantDto;
import com.sona.restaurantListing.entity.RestaurantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    RestaurantEntity mapRestaurantDtoRestaurantEntity(RestaurantDto RestaurantDto);
    RestaurantDto mapRestaurantEntityRestaurantDto(RestaurantEntity RestaurantEntity);

    List<RestaurantEntity> mapRestaurantDtoRestaurantEntityList(List<RestaurantDto> RestaurantDtoList);
    List<RestaurantDto> mapRestaurantEntityRestaurantDtoList(List<RestaurantEntity> entities);
}