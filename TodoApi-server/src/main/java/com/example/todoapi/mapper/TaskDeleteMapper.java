package com.example.todoapi.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskDeleteMapper {

    void deleteByPrimaryKey(Long taskId);
}