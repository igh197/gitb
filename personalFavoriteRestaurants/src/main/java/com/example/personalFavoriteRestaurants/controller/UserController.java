package com.example.personalFavoriteRestaurants.controller;


import com.example.personalFavoriteRestaurants.entity.User;
import com.example.personalFavoriteRestaurants.entity.network.UserRequest;

import com.example.personalFavoriteRestaurants.entity.network.UserResponse;
import com.example.personalFavoriteRestaurants.repository.UserRepository;
import com.example.personalFavoriteRestaurants.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@Controller
@RequestMapping("")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;


    @PostMapping("/user/new")
    public User save(@RequestBody UserRequest userRequest) {
        return userService.save(userRequest);
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Integer id, Model model){
        model.addAttribute("user",userRepository.findUserById(id));
        return "/myPage";
    }
    @PatchMapping("/user/{id}")
    public User update(@PathVariable Integer id,@RequestBody UserRequest request) {
      return userService.update(id, request);
    }


}