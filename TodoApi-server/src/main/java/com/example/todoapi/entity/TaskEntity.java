package com.example.todoapi.entity;

import lombok.Data;

@Data
public class TaskEntity {

    long id;

    String title;

    String content;

    Integer compF;

    Integer pinF;

}