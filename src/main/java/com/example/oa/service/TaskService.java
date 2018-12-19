package com.example.oa.service;

import com.example.oa.po.Task;

import java.util.List;

public interface TaskService {
    List<Task> queryTaskSelective(Integer pageNumber, Integer pageSize, Task task);
    int countTaskSelective(Task task);
    int updateTaskState(Integer state,Integer id);
    String getTaskPage(Integer id);
}
