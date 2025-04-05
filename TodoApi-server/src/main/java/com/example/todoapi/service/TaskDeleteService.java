package com.example.todoapi.service;

import org.springframework.stereotype.Service;

@Service
public interface TaskDeleteService {

    /**
    * タスク削除
    *
    * @param taskId 削除対象のタスクID
    */
    public void delete(Long taskId);
}