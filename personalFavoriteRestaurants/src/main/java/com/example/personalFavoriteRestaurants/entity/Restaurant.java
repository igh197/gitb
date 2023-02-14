package com.example.personalFavoriteRestaurants.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import java.awt.*;
import java.io.File;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private String category;

    private String address;

    private String openTime;

    private String closeTime;

    private File logo;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String description;
    @JsonIgnore
    @ManyToOne
    private User user;


}
