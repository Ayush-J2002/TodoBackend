package com.example.backend.pojo;

import com.example.backend.Dtos.TodoDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String type;

    @Column
    private String details;

    @Column
    private boolean status;


    public Todo() {
    }

    public Todo(int id, String type, String details,boolean status) {
        this.id = id;
        this.type = type;
        this.details = details;
        this.status=status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Todo getTodo(TodoDto todoDto){
        Todo todo=new Todo();
        todo.setType(todoDto.getType());
        todo.setDetails(todoDto.getDescription());
        todo.setStatus(todoDto.getStatus());
        return todo;
    }

}
