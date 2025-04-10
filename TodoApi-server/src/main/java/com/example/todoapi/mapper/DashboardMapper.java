package com.example.todoapi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.todoapi.entity.TaskEntity;

@Mapper
public interface DashboardMapper {

    List<TaskEntity> selectDashboardList(@Param("limit") int limit, @Param("offset") int offset);
}