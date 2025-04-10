package com.example.todoapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todoapi.common.model.task.TaskDto;

@Service
public interface DashboardService {

    /**
    * ピン留めタスク一覧取得
    *
    * @return List<TaskEntity> ピン留めタスク情報リスト
    */
    public List<TaskDto> DashboardList();
}