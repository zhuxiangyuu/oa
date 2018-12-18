package com.example.oa.service;

import com.example.oa.po.Task;

import java.util.List;

public interface TaskService {
    List<Task> queryTaskByStateAndUser(Integer pageNumber, Integer pageSize, Task task);
    int countTaskByStateAndUser(Task task);
}
