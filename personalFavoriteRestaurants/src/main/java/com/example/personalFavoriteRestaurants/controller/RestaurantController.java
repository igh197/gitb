package com.example.personalFavoriteRestaurants.controller;


import com.example.personalFavoriteRestaurants.entity.Restaurant;
import com.example.personalFavoriteRestaurants.entity.network.RestaurantRequest;
import com.example.personalFavoriteRestaurants.entity.network.RestaurantResponse;
import com.example.personalFavoriteRestaurants.repository.RestaurantRepository;
import com.example.personalFavoriteRestaurants.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final RestaurantRepository restaurantRepository;
    @GetMapping("/restaurants")
    public String search(@PageableDefault Pageable pageable, Model model){
        model.addAttribute("restaurants",restaurantRepository.findAll());
        return "restaurants";
    }

    @PostMapping(value = "/restaurant/new")
    public Restaurant create(@ModelAttribute RestaurantRequest restaurantRequest){
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
