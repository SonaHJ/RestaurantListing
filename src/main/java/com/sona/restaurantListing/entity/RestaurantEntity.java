package com.sona.restaurantListing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "restaurant_entity",
        indexes = {
                @Index(name = "idx_restaurant_name", columnList = "restaurantName"),
                @Index(name = "idx_city", columnList = "restaurantCity")
        },
        uniqueConstraints = @UniqueConstraint(columnNames = {"restaurantName", "restaurantCity"})
)
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int restaurantId;
    private String restaurantName;
    private String restaurantPhone;
    private String restaurantEmail;
    private String restaurantDescription;
    private String restaurantCity;
    private String restaurantAddress;
}
