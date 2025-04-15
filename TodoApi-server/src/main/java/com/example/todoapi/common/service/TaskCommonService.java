package com.example.todoapi.common.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.todoapi.common.exception.TaskEntityNotFoundException;
import com.example.todoapi.common.model.task.TaskDto;
import com.example.todoapi.entity.TaskEntity;
import com.example.todoapi.mapper.TaskMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskCommonService {

    public final TaskMapper taskMapper;

    public Optional<TaskEntity> selectByPrimaryKey(long taskId) {

        Optional<TaskEntity> taskOpt = taskMapper.selectByPrimaryKey(taskId);

        return taskOpt;
    }

    public TaskDto getTask(long taskId, Optional<TaskEntity> taskOpt) {

        taskOpt.orElseThrow(() -> new TaskEntityNotFoundException(taskId));

        TaskDto task = taskOpt.map
                (entity -> toTaskDto(entity)).get();

        return task;
    }

    /**
     * @param record データベースから取得した情報
     *
     * @return ENTITYに詰め替えた後のDto
     */
    public TaskDto toTaskDto(TaskEntity entity) {

        TaskDto taskDto = new TaskDto();

        taskDto.setId(entity.getId());
        taskDto.setTitle(entity.getTitle());
        taskDto.setContent(entity.getContent());
        taskDto.setCompF(entity.getCompF());
        taskDto.setCompDate(entity.getCompDate());
        taskDto.setPinF(entity.getPinF());
        taskDto.setImageUrl(entity.getImageUrl());

        return taskDto;
   }
}