package com.we3.codingdashboard.model;

import org.springframework.data.annotation.Id;

public record UserInfo(@Id Long user_id, String username, String password, String roles) {

}
