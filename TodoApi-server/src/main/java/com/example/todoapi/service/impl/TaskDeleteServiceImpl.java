package com.example.todoapi.service.impl;

import org.springframework.stereotype.Service;

import com.example.todoapi.common.exception.TaskEntityNotFoundException;
import com.example.todoapi.common.service.TaskCommonService;
import com.example.todoapi.mapper.TaskDeleteMapper;
import com.example.todoapi.service.TaskDeleteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskDeleteServiceImpl implements TaskDeleteService {

    private final TaskDeleteMapper taskDeleteMapper;

    private final TaskCommonService commonService;

    public void delete(Long taskId) {

        // 存在チェック
        commonService.selectByPrimaryKey(taskId)
                .orElseThrow(() -> new TaskEntityNotFoundException(taskId));

        // 削除処理
        taskDeleteMapper.deleteByPrimaryKey(taskId);
    }
}