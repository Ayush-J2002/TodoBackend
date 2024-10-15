package com.example.backend.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.pojo.Todo;

@Repository
public interface TodoRepo extends JpaRepository<Todo,Integer> {
    //public Todo findById(Integer id);
    
}
