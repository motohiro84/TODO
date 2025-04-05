package com.example.todoapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapi.api.TasksDeleteApi;
import com.example.todoapi.service.TaskDeleteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TaskDeleteController implements TasksDeleteApi {

    private final TaskDeleteService service;

    @Override
    public ResponseEntity<Void> deleteTask(Long taskId) {

        // 削除処理呼び出し
        service.delete(taskId);

        // 処理結果返却204
        return ResponseEntity.noContent().build();
    }
}