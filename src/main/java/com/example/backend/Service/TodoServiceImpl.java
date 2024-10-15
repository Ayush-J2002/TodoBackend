package com.example.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.pojo.Todo;
import com.example.backend.repo.TodoRepo;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    TodoRepo todoRepo;
    @Override
    public Todo CreateNewTask(Todo todo) {
        return todoRepo.save(todo);
    }

    @Override
    public List<Todo> FindAllRecords() {
       List<Todo>taskList=todoRepo.findAll();
       return taskList;
    }

    @Override
    public String DeleteTask(int taskId) {
        todoRepo.deleteById(taskId);
       return taskId+" id is deleted";
    }

    @Override
    public Todo UpdateTask(Todo todo) {
        Todo todo1=todoRepo.findById(todo.getId()).orElseThrow(()->new RuntimeException("task not found")); 
        todo1.setType(todo.getType());
        todo1.setDetails(todo.getDetails());
        todo1.setStatus(todo.isStatus());
        return todoRepo.save(todo1);
    }

    
}
