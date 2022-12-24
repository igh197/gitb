package com.example.personalFavoriteRestaurants.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;
import java.io.File;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    
    private String category;

    private String address;

    private LocalTime openTime;

    private LocalTime closeTime;

    private File logo;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String description;

    @ManyToOne
    private User user;

}
