package com.example.personalFavoriteRestaurants.controller;


import com.example.personalFavoriteRestaurants.entity.User;
import com.example.personalFavoriteRestaurants.entity.network.UserRequest;
import com.example.personalFavoriteRestaurants.entity.network.UserResponse;
import com.example.personalFavoriteRestaurants.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("")
public class UserController{
    private final UserService userService;
    @PostMapping("/user/new")
    public User save(@RequestBody UserRequest userRequest){
        return userService.save(userRequest);
    }

}
