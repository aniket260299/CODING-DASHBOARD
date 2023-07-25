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
    public List<UserInfo> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserInfo> findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "", method = { RequestMethod.PUT, RequestMethod.POST })
    public void addOrUpdate(@RequestBody UserInfo userInfo) {
        repository.save(userInfo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

}
