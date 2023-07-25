package com.we3.codingdashboard.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record CodingDashboard(@Id Long id, String title, String solution, String hint, String revision_notes,
        String link, Integer difficulty, String tags, LocalDateTime date_created,
        LocalDateTime date_updated) {
}
