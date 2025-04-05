package com.example.todoapi.api.controller.impl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.todoapi.common.model.task.TaskCreateForm;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void listTasksTest() throws Exception {

        mockMvc.perform(get("/tasks/").param("title", "タスク"))
                .andExpect(status().isOk());

    }


    @Test
    void createTaskTest() throws Exception {

        TaskCreateForm form = new TaskCreateForm();
        form.setTitle("登録テスト");
        form.setContent("登録内容");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(form);

        mockMvc.perform(post("/tasks/").contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());

    }

}
