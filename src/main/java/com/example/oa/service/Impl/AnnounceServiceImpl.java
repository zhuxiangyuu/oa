package com.example.oa.service.Impl;

import com.example.oa.mapper.AnnounceMapper;
import com.example.oa.po.Announce;
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

    public List<Announce> queryAnnounceList(@Param("title")String title,
                                            @Param("time1") Date time1,
                                            @Param("time2") Date time2,
                                            @Param("pageNumber")int pageNumber,
                                            @Param("pageSize")int pageSize) {

        return announceMapper.queryAnnounceList(title,time1,time2,pageNumber,pageSize);
    }

    public int countAnnounce() {

        return announceMapper.countAnnounce();
    }

    @Override
    public Announce lookAnnounceById(@Param("id")int id) {
        return announceMapper.lookAnnounceById(id);
    }

    @Override
    public void addAnnounce(Announce announce) {
       // announceMapper.addAnnounce(announce);
    }
}
