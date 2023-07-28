package com.we3.codingdashboard.model;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public record UserInfo(String username, String password, String authorities) {
    public UserDetails getUserDetails(PasswordEncoder encoder){
        return User.builder()
                .username(username.toLowerCase())
                .password(encoder.encode(password))
                .roles(authorities.toUpperCase().split(","))
                .build();
    }
}
