package com.sona.restaurantListing.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {
    private int restaurantId;
    private String restaurantName;
    private String restaurantPhone;
    private String restaurantEmail;
    private String restaurantDescription;
    private String restaurantCity;
    private String restaurantAddress;
}
