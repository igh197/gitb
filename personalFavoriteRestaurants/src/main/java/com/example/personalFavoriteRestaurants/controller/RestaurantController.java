package com.example.personalFavoriteRestaurants.controller;


import com.example.personalFavoriteRestaurants.entity.Restaurant;
import com.example.personalFavoriteRestaurants.entity.RestaurantLogo;
import com.example.personalFavoriteRestaurants.entity.network.RestaurantRequest;
import com.example.personalFavoriteRestaurants.repository.RestaurantLogoRepository;
import com.example.personalFavoriteRestaurants.repository.RestaurantRepository;
import com.example.personalFavoriteRestaurants.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Map;
import java.util.Optional;


@RequiredArgsConstructor
@Controller
@RequestMapping("")
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantLogoRepository restaurantLogoRepository;
    @GetMapping("/restaurants")
    public String search(@PageableDefault Pageable pageable, Model model){
        model.addAttribute("restaurants",restaurantRepository.findAll());
        return "/restaurants";
    }

    @PostMapping(value = "/restaurant/new")
    public String create(@ModelAttribute RestaurantRequest restaurantRequest){
        restaurantService.create(restaurantRequest);
        return "/restaurants";
    }
    @GetMapping("/restaurant/{id}")
    public String read(@PathVariable Long id,Model model){
        Restaurant res = restaurantRepository.findRestaurantById(id);
        model.addAttribute("restaurant",restaurantRepository.findRestaurantById(id));
        model.addAttribute("restaurant.logo",restaurantLogoRepository.findById(res.getId()).orElseThrow().getLogoUrl());
        restaurantService.read(id);
        return "/restaurant";
    }
    @PutMapping("/restaurant/{id}")
    public void update(@PathVariable Long id,RestaurantRequest restaurantRequest){
        restaurantService.update(id,restaurantRequest);
    }
    @DeleteMapping("/restaurant/{id}")
    public void delete(@PathVariable Long id){
        restaurantService.delete(id);
    }


    @PostMapping(value="/restaurant/img")
    public void getLogoImage(MultipartFile logo) throws IOException {

        String logoName = logo.getOriginalFilename();
        String path = "C:\\Users\\한인규\\Documents\\img";
        Path imgPath = Paths.get(path+logoName);
        Files.write(imgPath,logo.getBytes());
        RestaurantLogo resLogo = new RestaurantLogo(logoName,path);
        restaurantLogoRepository.save(resLogo);

    }


}
