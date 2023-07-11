package com.we3.codingdashboard.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public record CodingDashboard(@Id Integer id, String title, String solution, String hint, String revision_notes,
                              String link, Integer difficulty, String tags, LocalDateTime date_created,
                              LocalDateTime date_updated) {
}
