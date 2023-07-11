package com.we3.codingdashboard.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.we3.codingdashboard.model.CodingDashboard;

public interface CodingDashboardRepository extends ListCrudRepository<CodingDashboard, Integer> {
}