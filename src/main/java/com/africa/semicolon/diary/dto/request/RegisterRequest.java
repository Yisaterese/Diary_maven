package com.africa.semicolon.diary.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String password;
    private String username;
}
