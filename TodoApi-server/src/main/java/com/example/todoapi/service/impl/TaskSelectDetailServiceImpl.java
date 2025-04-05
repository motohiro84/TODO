package com.example.todoapi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapi.common.model.task.TaskDto;
import com.example.todoapi.common.service.TaskCommonService;
import com.example.todoapi.entity.TaskEntity;
import com.example.todoapi.service.TaskSelectDetailService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskSelectDetailServiceImpl implements TaskSelectDetailService {

    @Autowired
    private final TaskCommonService commonService;

    public TaskDto selectShow(long taskId) {

        // 返却情報
        Optional<TaskEntity> res = commonService.selectByPrimaryKey(taskId);
        return commonService.getTask(taskId, res);
    }
}