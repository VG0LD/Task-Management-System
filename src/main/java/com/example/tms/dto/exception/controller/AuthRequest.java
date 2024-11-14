package com.example.tms.dto.exception.controller;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}

