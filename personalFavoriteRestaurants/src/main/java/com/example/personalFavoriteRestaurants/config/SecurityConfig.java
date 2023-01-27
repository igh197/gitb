package com.example.personalFavoriteRestaurants.config;


import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig{


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }




    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws
            Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/login.html","/restaurants.html","/restaurants","/restaurant/{id}","/signup.html","/user/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/user/new","/restaurant/new").permitAll()
                .antMatchers(HttpMethod.PATCH,"/user/{id}").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .usernameParameter("account")
                .passwordParameter("password")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/restaurants")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/login.html")
        ;

        return http.build();
    }


}
