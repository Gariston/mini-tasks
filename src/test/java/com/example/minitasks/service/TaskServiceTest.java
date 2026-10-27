package com.example.minitasks.service;

import com.example.minitasks.domain.Task;
import com.example.minitasks.web.dto.CreateTaskDTO;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TaskServiceTest {

    private final TaskService taskService = new TaskService();

    @Test
    void createStripsTitleEdges() {
        // Título con espacios al inicio y al final
        CreateTaskDTO dto = new CreateTaskDTO("   Repasar Spring Boot   ");

        Task result = taskService.createTask(dto);

        // Debe eliminar los espacios exteriores manteniendo los interiores
        assertThat(result.getTitle()).isEqualTo("Repasar Spring Boot");
        assertThat(result.isCompleted()).isFalse();
    }
}