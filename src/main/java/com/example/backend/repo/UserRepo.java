package com.example.backend.repo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.pojo.User;


@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

    Optional<User> findByUsername(String username);

    
} 
