package com.example.backend.Service;

import java.util.List;

import com.example.backend.pojo.Todo;

public interface TodoService {

    Todo CreateNewTask(Todo todo);
    List<Todo> FindAllRecords();
    Todo UpdateTask(Todo todo);
    String DeleteTask(int taskId);
    
}
