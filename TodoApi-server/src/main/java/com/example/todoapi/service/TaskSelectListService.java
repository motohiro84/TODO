package com.example.todoapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todoapi.common.model.task.TaskDto;

@Service
public interface TaskSelectListService {

    /**
    * タスク一覧取得
    * 検索用のタイトルが設定されていない場合、全件取得
    *
    * @param title 検索用のタイトル
    *
    * @return List<TaskEntity> タスク情報リスト
    */
    public List<TaskDto> selectList(String title);
}