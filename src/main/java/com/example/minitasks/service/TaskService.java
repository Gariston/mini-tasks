package com.example.minitasks.service;

import com.example.minitasks.domain.Task;
import com.example.minitasks.web.dto.CreateTaskDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    public Task createTask(CreateTaskDTO dto) {
        String cleanTitle = dto.getTitle() != null ? dto.getTitle().strip() : "";
        Task task = new Task(cleanTitle);
        tasks.add(task);
        return task;
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Optional<Task> getTaskById(String id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst();
    }
}