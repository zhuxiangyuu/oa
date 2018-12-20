package com.example.oa.service.Impl;

import com.example.oa.mapper.CarReserveMapper;
import com.example.oa.mapper.TaskMapper;
import com.example.oa.mapper.UserMapper;
import com.example.oa.po.CarReserve;
import com.example.oa.po.Task;
import com.example.oa.po.User;
import com.example.oa.service.CarReserveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class CarReserveServiceImpl implements CarReserveService {
    @Resource
    CarReserveMapper carReserveMapper;
    @Resource
    TaskMapper taskMapper;
    @Resource
    UserMapper userMapper;
    public String addCarReserve(CarReserve carReserve) {
        try {
            // 添加申请
            carReserveMapper.insertSelective(carReserve);
            // 查询刚添加的Id
            int taskId = carReserveMapper.queryCarReserveId();
            // 添加审核
            Task task = new Task();
            //状态
            task.setState(1);
            /// 任务类型
            //  (1.会议室管理 2.用户车管理 3.用章管理 4.图书借阅申请 5.名片印制流程 6.请假申请 7.出差申请 8.收入证明流程 )
            task.setType(2);
            // 任务编号( 任务类型+你任务的ID）
            task.setTaskid(Integer.valueOf(2 + "" + taskId));
            // 任务名称（用户名称+某某申请）
            User user = userMapper.selectByPrimaryKey(carReserve.getUserid());
            task.setName(user.getName() + "用车申请");
            task.setUserid(carReserve.getUserid());
            // 任务审核人
            task.setAdminid(carReserve.getAdminid());
            // 发起时间
            task.setStarttime(new Date());

            taskMapper.insertSelective(task);
            return "true" ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "false";
    }



    @Override
    public CarReserve queryCarReserveAndTask(int id) {
        return carReserveMapper.selectByPrimaryKey(id);
    }
}
