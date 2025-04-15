package com.example.todoapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapi.common.model.task.TaskDto;
import com.example.todoapi.common.service.TaskCommonService;
import com.example.todoapi.entity.TaskEntity;
import com.example.todoapi.mapper.DashboardMapper;
import com.example.todoapi.service.DashboardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final DashboardMapper dashboardMapper;

    @Autowired
    private final TaskCommonService commonService;

    public List<TaskDto> DashboardList() {

        List<TaskEntity> recordList = dashboardMapper.selectDashboardList(12, 0);

        List<TaskDto> taskList = recordList.stream()
                .map(record -> commonService.toTaskDto(record))
                .collect(Collectors.toList());

        return taskList;
    }
}