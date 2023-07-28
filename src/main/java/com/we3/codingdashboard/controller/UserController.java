package com.we3.codingdashboard.controller;

import com.we3.codingdashboard.model.UserInfo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final JdbcUserDetailsManager jdbcUserDetailsManager;
    private final PasswordEncoder encoder;

    @GetMapping("/{username}")
    public boolean findUsername(@PathVariable String username) {
        return jdbcUserDetailsManager.userExists(username);
    }

    @PostMapping
    public void createUser(@RequestBody UserInfo userInfo) {
        jdbcUserDetailsManager.createUser(userInfo.getUserDetails(encoder));
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        jdbcUserDetailsManager.deleteUser(username);
    }

    @PutMapping
    public void updateUser(@RequestBody UserInfo userInfo) {
        jdbcUserDetailsManager.updateUser(userInfo.getUserDetails(encoder));
    }
}
