package com.we3.codingdashboard.controller;

import com.we3.codingdashboard.model.CodingDashboard;
import com.we3.codingdashboard.repository.CodingDashboardRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coding_dashboard")
public class CodingDashboardController {
    private final CodingDashboardRepository repository;

    public CodingDashboardController(CodingDashboardRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<CodingDashboard> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CodingDashboard> findById(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @PostMapping
    public void add(@RequestBody CodingDashboard codingDashboard) {
        repository.save(codingDashboard);
    }

    @PutMapping("/{id}")
    public void updateById(@RequestBody CodingDashboard codingDashboard, @PathVariable Integer id) {
        if (repository.existsById(id)) {
            repository.save(codingDashboard);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
