package com.example.oa.service.Impl;

import com.example.oa.mapper.TaskMapper;
import com.example.oa.po.Task;
import com.example.oa.service.TaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {

    @Resource
    TaskMapper taskMapper;

    @Override
    public List<Task> queryTaskSelective(Integer pageNumber, Integer pageSize, Task task) {
        return taskMapper.queryTaskSelective(pageNumber,pageSize,task);
    }

    @Override
    public int countTaskSelective(Task task) {
        return taskMapper.countTaskSelective(task);
    }

    @Override
    public int updateTaskState(Integer state, Integer id) {
        Task task = taskMapper.selectByPrimaryKey(id);
        // 更新任务表
        task.setState(state);
        task.setSubtime(new Date());
        return taskMapper.updateByPrimaryKeySelective(task);
    }

    @Override
    public String getTaskPage(Integer id) {
        Task task = taskMapper.selectByPrimaryKey(id);
        // 得到更新的是那个申请表
        int type = task.getType();
        // 得到申请表的Id
        int taskId =  Integer.valueOf( String.valueOf(task.getTaskid()).substring(1));
        switch (type){
            // 会议室管理
            case 1:
                return "/xingzheng/demo1/look?id="+taskId;
            // 用户车管理
            case 2:
                return "/xingzheng/demo2/look?id="+taskId;
            // 用章管理
            case 3:
                return "/xingzheng/demo3/look?id="+taskId;
            // 图书借阅申请
            case 4:
                return "/xingzheng/demo4/look?id="+taskId;
            // 名片印制流程
            case 5:
                return "/xingzheng/demo5/look?id="+taskId;
            // 请假申请
            case 6:
                return "/renshi/demo1/look?id="+taskId;
            // 出差申请
            case 7:
                return "/renshi/demo2/look?id="+taskId;
            // 收入证明申请
            default:
                return "/renshi/demo3/look?id="+taskId;
        }
    }
}
