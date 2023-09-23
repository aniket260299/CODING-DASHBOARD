package com.we3.codingdashboard.model;

import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

public record CodingDashboard(
        @Id Long id,
        String title,
        String solution,
        String hint,
        String notes,
        String link,
        Integer difficulty,
        String tags,
        Timestamp date_created,
        Timestamp date_updated,
        String username
) {
}
