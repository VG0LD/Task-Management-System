package com.example.tms.dto.exception.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.tms.dto.exception.security.JwtUtil;
import com.example.tms.dto.exception.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;


    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        String token = jwtUtil.generateToken(authRequest.getUsername());
        return token;
    }
}
