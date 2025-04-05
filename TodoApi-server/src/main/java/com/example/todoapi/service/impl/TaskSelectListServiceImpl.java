package com.example.todoapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapi.common.model.task.TaskDto;
import com.example.todoapi.common.service.TaskCommonService;
import com.example.todoapi.entity.TaskEntity;
import com.example.todoapi.mapper.TaskSelectListMapper;
import com.example.todoapi.service.TaskSelectListService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskSelectListServiceImpl implements TaskSelectListService {

    private final TaskSelectListMapper taskSelectListMapper;

    @Autowired
    private final TaskCommonService commonService;

    public List<TaskDto> selectList(String title) {

        List<TaskEntity> recordList = taskSelectListMapper.selectList(title);

        List<TaskDto> taskList = recordList.stream()
                .map(record -> commonService.toTaskDto(record))
                .collect(Collectors.toList());

        return taskList;
    }
}