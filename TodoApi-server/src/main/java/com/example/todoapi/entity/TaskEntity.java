package com.example.todoapi.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TaskEntity {

    long id;

    String title;

    String content;

    Integer compF;

    LocalDate compDate;

    Integer pinF;

    String imageUrl;

}