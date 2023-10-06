package com.we3.codingdashboard.controller;

import com.we3.codingdashboard.model.CodingDashboard;
import com.we3.codingdashboard.repository.CodingDashboardRepository;
import com.we3.codingdashboard.service.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coding-dashboard")
@AllArgsConstructor
public class CodingDashboardController {
    private final CodingDashboardRepository repository;
    private final TokenService tokenService;

    @GetMapping
    public List<CodingDashboard> findAll() {
        return repository.findByUsername(tokenService.getCurrentUserName());
    }

    @GetMapping("/{id}")
    public Optional<CodingDashboard> findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "", method = {RequestMethod.PUT, RequestMethod.POST})
    public CodingDashboard addOrUpdate(@RequestBody CodingDashboard codingDashboard) {
        return repository.save(codingDashboard);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
