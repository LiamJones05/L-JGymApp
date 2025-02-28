package com.gymApp.gymtracker.controller;

import com.yourcompany.gymtracker.model.LoginRequest;
import com.yourcompany.gymtracker.model.User;
import com.yourcompany.gymtracker.security.jwt.JwtTokenProvider;
import com.yourcompany.gymtracker.service.UserDetailsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserDetailsServiceImpl userDetailsService;
    private final JwtTokenProvider tokenProvider;

    public AuthController(UserDetailsServiceImpl userDetailsService, JwtTokenProvider tokenProvider) {
        this.userDetailsService = userDetailsService;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        User user = userDetailsService.loadUserByUsername(loginRequest.getUsername());

        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String jwtToken = tokenProvider.generateToken(user);
        return ResponseEntity.ok(jwtToken);
    }
}
