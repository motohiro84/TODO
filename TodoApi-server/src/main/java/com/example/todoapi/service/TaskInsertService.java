package com.example.todoapi.service;

import org.springframework.stereotype.Service;

import com.example.todoapi.common.model.task.TaskCreateForm;
import com.example.todoapi.common.model.task.TaskDto;

@Service
public interface TaskInsertService {

    /**
    * タスク登録
    *
    * @param form タスク入力情報
    *
    * @return TaskEntity タスク情報
    */
    public TaskDto create(TaskCreateForm form);
}