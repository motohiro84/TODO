package com.example.todoapi.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.todoapi.entity.TaskEntity;

@Mapper
public interface TaskUpdateMapper {

    void updateByPrimaryKey(TaskEntity entity);
}