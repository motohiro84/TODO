package com.example.todoapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapi.api.TasksSelectDetailApi;
import com.example.todoapi.common.model.task.TaskDto;
import com.example.todoapi.service.TaskSelectDetailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TaskSelectDetailController implements TasksSelectDetailApi {

    private final TaskSelectDetailService service;

    @Override
    public ResponseEntity<TaskDto> showTask(Long taskId) {

        // 検索処理呼び出し
        TaskDto dto = service.selectShow(taskId);

//        System.out.println("取得");

        // 処理結果返却200
        return ResponseEntity.ok(dto);
    }
}