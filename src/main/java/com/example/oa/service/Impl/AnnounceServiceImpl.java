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

    public List<Announce> queryAnnounceList(String title,
                                             Date time1,
                                             Date time2,
                                           int pageNumber,
                                          int pageSize) {

        return announceMapper.queryAnnounceList(title,time1,time2,pageNumber,pageSize);
    }

    public int countAnnounce() {

        return announceMapper.countAnnounce();
    }

    @Override
    public Announce lookAnnounceById(@Param("id")int id) {
        return announceMapper.lookAnnounceById(id);
    }

    public int addAnnounce(Announce announce) {
        if(announce.getState()==2){
            return announceMapper.insert(announce);
        }else{
            return announceMapper.insertSelective(announce);
        }

    }

    public void updateAnnounceById(int id) {
        try{
            announceMapper.updateByPrimaryKey(id);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int deleteAnnounceById(int id) {
        return announceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Announce record) {
        record.setState(2);
        return announceMapper.updateByPrimaryKeySelective(record);
    }
}
