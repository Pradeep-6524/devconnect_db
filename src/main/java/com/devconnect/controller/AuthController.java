package com.devconnect.controller;

import com.devconnect.dto.AuthRequest;
import com.devconnect.dto.AuthResponse;
import com.devconnect.security.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest authRequest) {
        try {
            // 1. Authenticate user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword()
                    )
            );

            // 2. Generate token using username
            String token = jwtUtil.generateToken(authRequest.getUsername());

            // 3. Return response
            return ResponseEntity.ok(new AuthResponse(token));

        } catch (AuthenticationException ex) {
            return ResponseEntity.status(401).build(); // Unauthorized
        }
    }
}
