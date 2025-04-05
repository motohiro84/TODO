package com.example.todoapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapi.api.TasksSelectListApi;
import com.example.todoapi.common.model.common.PageDto;
import com.example.todoapi.common.model.task.TaskDto;
import com.example.todoapi.common.model.task.TaskListDto;
import com.example.todoapi.service.TaskSelectListService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TaskSelectListController implements TasksSelectListApi {

    private final TaskSelectListService service;

    @Override
    public ResponseEntity<TaskListDto> listTasks(String title) {

        System.out.println("全体取得");

        // 検索処理呼び出し
        List<TaskDto> dtoList = service.selectList(title);

        // ページ情報設定
        PageDto pageDto = new PageDto();
//        pageDto.setLimit(limit);
//        pageDto.setOffset(offset);
        pageDto.setSize(dtoList.size());

        // 応答データ設定
        TaskListDto dto = new TaskListDto();
        dto.setPage(pageDto);
        dto.setResults(dtoList);

        // 処理結果返却200
        return ResponseEntity.ok(dto);
    }
}