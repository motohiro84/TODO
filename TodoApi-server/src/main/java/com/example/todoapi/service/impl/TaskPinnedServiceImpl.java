package com.example.todoapi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapi.common.exception.TaskEntityNotFoundException;
import com.example.todoapi.common.model.task.TaskDto;
import com.example.todoapi.common.model.task.TaskPinForm;
import com.example.todoapi.common.service.TaskCommonService;
import com.example.todoapi.entity.TaskEntity;
import com.example.todoapi.mapper.TaskPinnedMapper;
import com.example.todoapi.service.TaskPinnedService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskPinnedServiceImpl implements TaskPinnedService {

    private final TaskPinnedMapper taskPinnedMapper;

    @Autowired
    private final TaskCommonService commonService;

    public TaskDto pinned(TaskPinForm form) {

        long taskId = form.getId();

        // 存在チェック
        commonService.selectByPrimaryKey(taskId)
                        .orElseThrow(() -> new TaskEntityNotFoundException(taskId));

        TaskEntity record = new TaskEntity();
        record.setId(taskId);
        record.setPinF(form.getPinF());

        // 更新処理
        taskPinnedMapper.updatePinFlg(record);

        // 返却情報
        Optional<TaskEntity> res = commonService.selectByPrimaryKey(taskId);
        return commonService.getTask(taskId, res);
    }
}