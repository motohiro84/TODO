package com.example.todoapi.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapi.api.TasksInsertApi;
import com.example.todoapi.common.model.task.TaskCreateForm;
import com.example.todoapi.common.model.task.TaskDto;
import com.example.todoapi.service.TaskInsertService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TaskInsertController implements TasksInsertApi {

    private final TaskInsertService service;

    @Override
    public ResponseEntity<TaskDto> createTask(TaskCreateForm form) {

//        System.out.println("登録");

        // 登録処理呼び出し
        TaskDto dto = service.create(form);

        // 処理結果返却201
        return ResponseEntity
                .created(URI.create("/tasks/" + dto.getId()))
                .body(dto);
    }
}