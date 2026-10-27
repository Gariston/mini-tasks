package com.example.minitasks.domain;

import java.util.UUID;

public class Task {
    private String id;
    private String title;
    private boolean completed;

    public Task(String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.completed = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}