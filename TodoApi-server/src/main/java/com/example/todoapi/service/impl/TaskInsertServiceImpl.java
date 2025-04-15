package com.example.todoapi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapi.common.model.task.TaskCreateForm;
import com.example.todoapi.common.model.task.TaskDto;
import com.example.todoapi.common.service.TaskCommonService;
import com.example.todoapi.entity.TaskEntity;
import com.example.todoapi.mapper.TaskInsertMapper;
import com.example.todoapi.service.TaskInsertService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskInsertServiceImpl implements TaskInsertService {

    private final TaskInsertMapper taskInsertMapper;

    @Autowired
    private final TaskCommonService commonService;

    public TaskDto create(TaskCreateForm form) {

        TaskEntity entity = new TaskEntity();
        entity.setTitle(form.getTitle());
        entity.setContent(form.getContent());
        entity.setCompDate(form.getCompDate());

        // 登録処理
        taskInsertMapper.insert(entity);

        // 返却情報
        Optional<TaskEntity> res = commonService.selectByPrimaryKey(entity.getId());
        return commonService.getTask(entity.getId(), res);
    }
}