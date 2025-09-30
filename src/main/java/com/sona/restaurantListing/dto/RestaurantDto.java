package com.sona.restaurantListing.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {
    private int restaurantId;

    @NotBlank(message = "Restaurant name must not be empty")
    private String restaurantName;
    @Pattern(
            regexp = "^\\+[1-9]\\d{7,14}$",
            message = "Phone number must be in the format +<CountryCode><PhoneNumber>"
    )
    private String restaurantPhone;
    @Email(message = "Please provide a valid email address")
    @NotBlank(message = "Email must not be blank")
    private String restaurantEmail;
    private String restaurantDescription;
    @NotBlank(message = "City is required")
    private String restaurantCity;
    private String restaurantAddress;
}
