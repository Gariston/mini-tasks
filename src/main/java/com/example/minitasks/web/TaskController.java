package com.example.minitasks.web;

import com.example.minitasks.domain.Task;
import com.example.minitasks.web.dto.CreateTaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    private final List<Task> tasksInMemory = new ArrayList<>();

    @GetMapping("/v1/tasks")
    public List<Task> getAllTasksV1() {
        return tasksInMemory;
    }

    @PostMapping("/v1/tasks")
    public ResponseEntity<Void> createTaskV1(@RequestBody CreateTaskDTO dto) {
        Task task = new Task(dto.getTitle());
        tasksInMemory.add(task);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/v2/tasks/{id}")
                .buildAndExpand(task.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/v2/tasks/{id}")
    public ResponseEntity<Task> getTaskByIdV2(@PathVariable String id) {
        return tasksInMemory.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}