package com.we3.codingdashboard.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.we3.codingdashboard.repository.UserInfoRepository;
import com.we3.codingdashboard.model.UserInfo;

@RestController
@RequestMapping("/api/user")
public class UserInfoController {
    public final UserInfoRepository repository;

    public UserInfoController(UserInfoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<UserInfo> getAllUserInfo() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserInfo> getAllUserInfoById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public void createUserInfo(@RequestBody UserInfo userInfo) {
        repository.save(userInfo);
    }

    @PutMapping("/{id}")
    public void updateUserInfo(@PathVariable Long id, @RequestBody UserInfo userInfo) {
        if (repository.existsById(id)) {
            repository.save(userInfo);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

}
