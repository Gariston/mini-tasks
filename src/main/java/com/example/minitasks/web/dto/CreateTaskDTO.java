package com.example.minitasks.web.dto;

public class CreateTaskDTO {
    private String title;

    public CreateTaskDTO() {
    }

    public CreateTaskDTO(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}