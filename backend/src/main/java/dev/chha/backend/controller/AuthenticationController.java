package dev.chha.backend.controller;

import dev.chha.backend.dto.LoginResponseDto;
import dev.chha.backend.dto.LoginDto;
import dev.chha.backend.dto.RegisterDto;
import dev.chha.backend.model.User;
import dev.chha.backend.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authService;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegisterDto user) {
        return authService.registerUser(user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname());
    }

    @PostMapping("/login")
    public LoginResponseDto loginUser(@RequestBody LoginDto user) {
        return authService.loginUser(user.getUsername(), user.getPassword());
    }
}
