package com.example.todoapi.service;

import org.springframework.stereotype.Service;

import com.example.todoapi.common.model.task.TaskDto;

@Service
public interface TaskSelectDetailService {

    /**
    * タスク詳細取得
    *
    * @param taskId 詳細検索用のタスクID
    *
    * @return TaskEntity タスク情報
    */
    public TaskDto selectShow(long taskId);
}