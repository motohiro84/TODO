package com.example.todoapi.service;

import org.springframework.stereotype.Service;

import com.example.todoapi.common.model.task.TaskDto;
import com.example.todoapi.common.model.task.TaskPinForm;

@Service
public interface TaskPinnedService {

    /**
    *
    * @param form タスク入力情報
    *
    * @return TaskEntity タスク情報
    */
    public TaskDto pinned(TaskPinForm form);
}