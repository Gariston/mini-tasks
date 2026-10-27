package com.example.minitasks.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.minitasks.web.dto.CreateTaskDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateTaskAndGetById() throws Exception {
        CreateTaskDTO dto = new CreateTaskDTO("Estudiar Spring Boot");

        // 1. POST /v1/tasks -> Debe responder 201 y traer Location con /v2/tasks/
        var response = mockMvc.perform(post("/v1/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", containsString("/v2/tasks/")))
                .andReturn();

        String location = response.getResponse().getHeader("Location");
        String taskId = location.substring(location.lastIndexOf("/") + 1);

        // 2. GET /v2/tasks/{id} -> Debe responder 200 con el título y completed false
        mockMvc.perform(get("/v2/tasks/" + taskId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Estudiar Spring Boot"))
                .andExpect(jsonPath("$.completed").value(false));
    }

    @Test
    void shouldReturn404WhenTaskDoesNotExist() throws Exception {
        mockMvc.perform(get("/v2/tasks/id-no-existente"))
                .andExpect(status().isNotFound());
    }
}