package com.example.todoapi.common.exception;

public class TaskEntityNotFoundException extends RuntimeException {

    public TaskEntityNotFoundException(long taskId) {
        super("TaskEntity (id = " + taskId + ") is not found.");
    }
}