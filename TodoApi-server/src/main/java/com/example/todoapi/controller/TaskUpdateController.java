package com.example.todoapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapi.api.TasksUpdateApi;
import com.example.todoapi.common.model.task.TaskDto;
import com.example.todoapi.common.model.task.TaskUpdateForm;
import com.example.todoapi.service.TaskUpdateService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TaskUpdateController implements TasksUpdateApi {

    private final TaskUpdateService service;

    @Override
    public ResponseEntity<TaskDto> editTask(Long taskId, TaskUpdateForm form) {

        // 更新処理呼び出し
        TaskDto dto = service.update(taskId, form);

        // 処理結果返却200
        return ResponseEntity.ok(dto);
    }
}