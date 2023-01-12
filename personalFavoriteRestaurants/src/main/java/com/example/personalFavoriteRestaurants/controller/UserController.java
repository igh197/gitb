package com.example.personalFavoriteRestaurants.controller;


import com.example.personalFavoriteRestaurants.entity.User;
import com.example.personalFavoriteRestaurants.entity.network.UserRequest;

import com.example.personalFavoriteRestaurants.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;


    @PostMapping("/user/new")
    public User save(@RequestBody UserRequest userRequest) {
        return userService.save(userRequest);
    }


    @PatchMapping("/user/{id}")
    public User update(@PathVariable Integer id,@RequestBody UserRequest userRequest) {
      return userService.update(id, userRequest);
    }


}