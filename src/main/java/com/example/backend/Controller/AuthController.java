package com.example.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.AuthService.JwtService;
import com.example.backend.Dtos.LoginRequestDto;
import com.example.backend.Dtos.LoginResponseDto;
import com.example.backend.Service.AuthService;
import com.example.backend.pojo.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginRequestDto requestDto) {
        User authenticatedUser = authService.authenticate(requestDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

//        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());
        LoginResponseDto responseDto = new LoginResponseDto(jwtToken);

        return ResponseEntity.ok(responseDto);
    }

    
}
