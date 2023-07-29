package com.we3.codingdashboard.controller;

import com.we3.codingdashboard.model.UserInfo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final JdbcUserDetailsManager jdbcUserDetailsManager;
    private final PasswordEncoder encoder;

    @GetMapping("/{username}")
    public UserInfo findByUsername(@PathVariable String username) {
        UserDetails userDetails = jdbcUserDetailsManager.loadUserByUsername(username);
        Collection<? extends GrantedAuthority> authorities =  userDetails.getAuthorities();
        StringBuffer roles = new StringBuffer();
        for(GrantedAuthority authority : authorities){
            if(roles.isEmpty())
                roles.append(authority.getAuthority().substring(5));
            else {
                roles.append(',');
                roles.append(authority.getAuthority().substring(5));
            }
        }
        return new UserInfo(userDetails.getUsername(), "dummyPassword", roles.toString());
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
