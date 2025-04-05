package com.example.todoapi.service;

import org.springframework.stereotype.Service;

import com.example.todoapi.common.model.task.TaskDto;
import com.example.todoapi.common.model.task.TaskUpdateForm;

@Service
public interface TaskUpdateService {

    /**
    * タスク更新
    *
    * @param taskId 更新用タスクID
    * @param form タスク入力情報
    *
    * @return TaskEntity タスク情報
    */
    public TaskDto update(Long taskId, TaskUpdateForm form);
}