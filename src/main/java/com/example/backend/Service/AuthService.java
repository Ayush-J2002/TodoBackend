package com.example.backend.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication; 
import com.example.backend.Dtos.LoginRequestDto;
import com.example.backend.Exception.UserNotFound;
import com.example.backend.pojo.User;
import com.example.backend.repo.UserRepo;

@Service
public class AuthService{
      @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public User authenticate(LoginRequestDto requestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestDto.getUsername(),
                        requestDto.getPassword()
                )
        );

        return userRepo.findByUsername(requestDto.getUsername()).orElseThrow();
    }
    public User getCurrentUser() throws UserNotFound {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        Optional<User> optionalUser = userRepo.findByUsername(userName);
        if(optionalUser.isEmpty()) {
            throw new UserNotFound("User not found, Please re-login!");
        }

        return optionalUser.get();
    }
}