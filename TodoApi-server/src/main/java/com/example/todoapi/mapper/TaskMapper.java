package com.example.todoapi.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.todoapi.entity.TaskEntity;

@Mapper
public interface TaskMapper {

    Optional<TaskEntity> selectByPrimaryKey(long taskId);
}