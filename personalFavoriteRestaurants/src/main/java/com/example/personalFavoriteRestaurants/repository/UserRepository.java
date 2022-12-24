package com.example.personalFavoriteRestaurants.repository;

import com.example.personalFavoriteRestaurants.entity.User;
import com.example.personalFavoriteRestaurants.entity.network.UserRequest;
import com.example.personalFavoriteRestaurants.entity.network.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByAccount(String account);
    User save(UserRequest userRequest);
}
