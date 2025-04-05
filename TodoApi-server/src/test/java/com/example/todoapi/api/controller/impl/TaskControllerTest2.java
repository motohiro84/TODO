package com.example.todoapi.api.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.todoapi.entity.TaskEntity;


@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest2 {


    @Test
    void createTaskTest() throws Exception {

        List<TaskEntity> testList = new ArrayList<TaskEntity>();

        for (int i = 1; i <= 2; i++) {
            TaskEntity task = new TaskEntity();
            task.setId(i);
            task.setTitle("test" + i);
            task.setContent("内容" + i);
            task.setCompF(0);
            task.setPinF(0);
            testList.add(task);
        }

        System.out.print(testList);
    }

}
