package com.example.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.backend.Service.TodoServiceImpl;
import com.example.backend.pojo.Todo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1")
public class TodoController {
    
    @Autowired
    private TodoServiceImpl todoimpl;

    @PostMapping("/addTask")
    public Todo addTask(@RequestBody Todo todo) {
     return todoimpl.CreateNewTask(todo);
    }

    @GetMapping("/showAll")
    public List<Todo> getAllTask() {
        return todoimpl.FindAllRecords();
    }

    @PutMapping("/update")
    public Todo updateTask(@RequestBody Todo todo) {
        
        return todoimpl.UpdateTask(todo);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id){
        return todoimpl.DeleteTask(id);
    }
    
    

}
