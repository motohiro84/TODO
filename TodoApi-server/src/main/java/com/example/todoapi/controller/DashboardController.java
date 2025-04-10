package com.example.todoapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapi.api.DashboardApi;
import com.example.todoapi.common.model.dashboard.DashboardTaskListDto;
import com.example.todoapi.common.model.task.TaskDto;
import com.example.todoapi.service.DashboardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DashboardController implements DashboardApi {

    private final DashboardService service;

    @Override
    public ResponseEntity<DashboardTaskListDto> dashboardTasks() {

        // 検索処理呼び出し
        List<TaskDto> dtoList = service.DashboardList();

        // 応答データ設定
        DashboardTaskListDto dto = new DashboardTaskListDto();
        dto.setResults(dtoList);

        // 処理結果返却200
        return ResponseEntity.ok(dto);
    }
}