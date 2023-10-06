package com.we3.codingdashboard.repository;

import com.we3.codingdashboard.model.CodingDashboard;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CodingDashboardRepository extends ListCrudRepository<CodingDashboard, Long> {
    public List<CodingDashboard> findByUsername(String username);
}