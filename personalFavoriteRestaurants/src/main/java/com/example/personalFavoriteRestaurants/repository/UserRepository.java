package com.example.personalFavoriteRestaurants.repository;

import com.example.personalFavoriteRestaurants.entity.User;
import com.example.personalFavoriteRestaurants.entity.network.UserRequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByAccount(String account);

    Optional<User> findById(Integer id);
    User findUserById(Integer id);
    Optional<User> save(UserRequest userRequest);
}
