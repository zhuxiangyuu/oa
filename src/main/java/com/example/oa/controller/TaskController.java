package com.example.oa.controller;

import com.alibaba.fastjson.JSON;
import com.example.oa.po.Task;
import com.example.oa.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Resource
    TaskService taskService;

    /**
     *  待处理任务列表
     * @param page
     * @param rows
     * @param task
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryRolePage")
    public String queryTaskByStateAndUser(Integer page, Integer rows, Task task){
        List<Task> list = taskService.queryTaskByStateAndUser((page - 1) * rows, rows, task);
        Map<String, Object> map = new HashMap();
        map.put("total", taskService.countTaskByStateAndUser(task));
        map.put("rows", list);
        String jsonString = JSON.toJSONString(map);
        return jsonString;
    }

    /**
     * 根据id跳转不同的申请查看页面
     * @param id
     * @return
     */
    @RequestMapping("/look/{id}")
    public String look(@PathVariable Integer id){
        return "";
    }


}
