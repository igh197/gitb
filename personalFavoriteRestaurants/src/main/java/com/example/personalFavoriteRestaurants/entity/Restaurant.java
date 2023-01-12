package com.example.personalFavoriteRestaurants.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import java.io.File;

import java.time.LocalDateTime;
import java.time.LocalTime;
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private String category;

    private String address;

    private LocalTime openTime;

    private LocalTime closeTime;

    private File logo;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String description;
    @JsonIgnore
    @ManyToOne
    private User user;


}
