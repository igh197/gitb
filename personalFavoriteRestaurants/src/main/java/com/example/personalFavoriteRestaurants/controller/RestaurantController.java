package com.example.personalFavoriteRestaurants.controller;


import com.example.personalFavoriteRestaurants.entity.network.RestaurantRequest;
import com.example.personalFavoriteRestaurants.entity.network.RestaurantResponse;
import com.example.personalFavoriteRestaurants.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RestaurantController {
    private final RestaurantService restaurantService;
    @GetMapping("/restaurants")
    public List<RestaurantResponse> search(@PageableDefault Pageable pageable){

        return restaurantService.search(pageable);
    }

    @PostMapping("/restaurants/new")
    public RestaurantResponse create(@RequestBody RestaurantRequest restaurantRequest){
        return restaurantService.create(restaurantRequest);
    }
    @GetMapping("/restaurant/{id}")
    public RestaurantResponse read(@PathVariable Long id){
        return restaurantService.read(id);
    }
    @PutMapping("/restaurant/{id}")
    public void update(@PathVariable Long id,RestaurantRequest restaurantRequest){
        restaurantService.update(id,restaurantRequest);
    }
    @DeleteMapping("/restaurant/{id}")
    public void delete(@PathVariable Long id){
        restaurantService.delete(id);
    }
}
