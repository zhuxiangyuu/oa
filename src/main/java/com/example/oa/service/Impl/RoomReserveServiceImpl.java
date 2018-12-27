package com.example.oa.service.Impl;

import com.example.oa.mapper.RoomReserveMapper;
import com.example.oa.mapper.TaskMapper;
import com.example.oa.mapper.UserMapper;
import com.example.oa.po.RoomReserve;
import com.example.oa.po.Task;
import com.example.oa.po.User;
import com.example.oa.service.RoomReserveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class RoomReserveServiceImpl implements RoomReserveService {

    @Resource
    RoomReserveMapper roomReserveMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    TaskMapper taskMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(RoomReserve record) {
        return roomReserveMapper.insert(record);
    }
    @Override
    public int insertSelective(RoomReserve record) {

            roomReserveMapper.insertSelective(record);
            int taskId = roomReserveMapper.queryRoomReserveId();
            Task task = new Task();
            //状态
            task.setState(1);
            /// 任务类型
            //  (1.会议室管理 2.用户车管理 3.用章管理 4.图书借阅申请 5.名片印制流程 6.请假申请 7.出差申请 8.收入证明流程 9.通告申请)
            task.setType(1);
            // 任务编号( 任务类型+你任务的ID）
            task.setTaskid(Integer.valueOf(1 + "" + taskId));
            // 任务名称（用户名称+某某申请）
            User user = userMapper.selectByPrimaryKey(record.getUserid());
            task.setName(user.getName() + "会议室申请");
            task.setUserid(record.getUserid());
            // 任务审核人
            task.setAdminid(record.getAdminid());
            // 发起时间
            task.setStarttime(new Date());

            return taskMapper.insertSelective(task);
    }

    @Override
    public RoomReserve selectByPrimaryKey(Integer id) {
        return roomReserveMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RoomReserve record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(RoomReserve record) {
        return 0;
    }

    @Override
    public int queryRoomReserveId() {
        return roomReserveMapper.queryRoomReserveId();
    }


}
