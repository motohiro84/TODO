package com.example.todoapi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapi.common.exception.TaskEntityNotFoundException;
import com.example.todoapi.common.model.task.TaskDto;
import com.example.todoapi.common.model.task.TaskUpdateForm;
import com.example.todoapi.common.service.TaskCommonService;
import com.example.todoapi.entity.TaskEntity;
import com.example.todoapi.mapper.TaskUpdateMapper;
import com.example.todoapi.service.TaskUpdateService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskUpdateServiceImpl implements TaskUpdateService {

    private final TaskUpdateMapper taskUpdateMapper;

    @Autowired
    private final TaskCommonService commonService;

    public TaskDto update(Long taskId, TaskUpdateForm form) {

        // 存在チェック
        commonService.selectByPrimaryKey(taskId).orElseThrow(() -> new TaskEntityNotFoundException(taskId));

        TaskEntity record = new TaskEntity();
        record.setId(taskId);
        record.setTitle(form.getTitle());
        record.setContent(form.getContent());
        record.setCompF(form.getCompF());

        // 更新処理
        taskUpdateMapper.updateByPrimaryKey(record);

        // 返却情報
        Optional<TaskEntity> res = commonService.selectByPrimaryKey(taskId);
        return commonService.getTask(taskId, res);
    }
}