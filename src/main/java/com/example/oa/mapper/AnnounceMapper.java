package com.example.oa.mapper;


import com.example.oa.po.Announce;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnounceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Announce record);

    int insertSelective(Announce record);

    Announce selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Announce record);

    int updateByPrimaryKey(Announce record);

     List<Announce> queryAnnounceList();
}