package com.example.backend.Dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class TodoDto {

    @NotEmpty(message="type is required")
    private String type;

    @NotEmpty(message = "description is required")
    @Size(message = "description should be more than 5 character")
    private String description;

    private Boolean status;

    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    
}
