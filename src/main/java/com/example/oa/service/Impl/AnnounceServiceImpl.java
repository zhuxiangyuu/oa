package com.example.oa.service.Impl;

import com.example.oa.mapper.AnnounceMapper;
import com.example.oa.mapper.TaskMapper;
import com.example.oa.mapper.UserMapper;
import com.example.oa.po.Announce;
import com.example.oa.po.Task;
import com.example.oa.po.User;
import com.example.oa.service.AnnounceService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class AnnounceServiceImpl implements AnnounceService {
    @Resource
    AnnounceMapper announceMapper;
    @Resource
    TaskMapper taskMapper;
    @Resource
    UserMapper userMapper;
    public List<Announce> queryAnnounceList(String title,
                                             Date time1,
                                             Date time2,
                                           int pageNumber,
                                          int pageSize) {

        return announceMapper.queryAnnounceList(title,time1,time2,pageNumber,pageSize);
    }

    public List<Announce> queryAnnounceListByState(String title,
                                            Date time1,
                                            Date time2,
                                            int pageNumber,
                                            int pageSize,
                                                   int state) {

        return announceMapper.queryAnnounceListByState(title,time1,time2,pageNumber,pageSize,state);
    }

    public int countAnnounce() {

        return announceMapper.countAnnounce();
    }

    @Override
    public Announce lookAnnounceById (int id) {
        return announceMapper.lookAnnounceById(id);
    }
    //添加一条通告并添加一条待处理任务
    public int addAnnounce(Announce announce) {
        announceMapper.insertSelective(announce);
        // 添加审核
        // 查询刚添加的Id
        int taskId = announceMapper.queryAnnounceId();
        Task task = new Task();
        //状态
        task.setState(1);
        /// 任务类型
        //  (1.会议室管理 2.用户车管理 3.用章管理 4.图书借阅申请 5.名片印制流程 6.请假申请 7.出差申请 8.收入证明流程 9.通告申请)
        task.setType(9);
        // 任务编号( 任务类型+你任务的ID）
        task.setTaskid(Integer.valueOf(9 + "" + taskId));
        // 任务名称（用户名称+某某申请）
        User user = userMapper.selectByPrimaryKey(announce.getUserid());
        task.setName(user.getName() + "通告申请");
        task.setUserid(announce.getUserid());
        // 任务审核人
        task.setAdminid(announce.getAdminid());
        // 发起时间
        task.setStarttime(new Date());

        taskMapper.insertSelective(task);

        return 666;
    }

    //删除一条通告并删除一条待处理任务
    public int deleteAnnounceById(int id) {
        int taskid = Integer.valueOf(9 + "" + id);
        taskMapper.delByTaskId(taskid);
        return announceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Announce record) {
        int taskid = Integer.valueOf(9 + "" + record.getId());
        taskMapper.updateByTaskid(taskid);
        announceMapper.updateByPrimaryKeySelective(record);
        return 666;
    }
}
