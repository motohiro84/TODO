package com.example.todoapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapi.api.TasksPinnedApi;
import com.example.todoapi.common.model.task.TaskDto;
import com.example.todoapi.common.model.task.TaskPinForm;
import com.example.todoapi.service.TaskPinnedService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TaskPinnedController implements TasksPinnedApi {

    private final TaskPinnedService service;

    @Override
    public ResponseEntity<TaskDto> pinnedTask(TaskPinForm form) {

        // 更新処理呼び出し
        TaskDto dto = service.pinned(form);

        // 処理結果返却200
        return ResponseEntity.ok(dto);
    }
}