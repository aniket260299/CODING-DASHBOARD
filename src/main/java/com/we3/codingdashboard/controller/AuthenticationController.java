package com.we3.codingdashboard.controller;

import com.we3.codingdashboard.model.AuthRequest;
import com.we3.codingdashboard.model.UserInfo;
import com.we3.codingdashboard.service.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthenticationController {
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final JdbcUserDetailsManager jdbcUserDetailsManager;
    private final PasswordEncoder encoder;
    @PostMapping("/sign-in")
    public String signIn(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password()));
        return tokenService.generateToken(authentication);
    }

    @PostMapping("/sign-up")
    public String signUp(@RequestBody AuthRequest authRequest) {
        UserInfo userInfo = new UserInfo(authRequest.username(), authRequest.password(), "USER");
        jdbcUserDetailsManager.createUser(userInfo.getUserDetails(encoder));
        return "sign-up completed";
    }

}
