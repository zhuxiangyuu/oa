package com.example.oa.mapper;


import com.example.oa.po.Announce;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface AnnounceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(@Param("announce")Announce announce);

    int insertSelective(Announce announce);

    int updateByPrimaryKeySelective(Announce record);

    int updateByPrimaryKey(int id);

     List<Announce> queryAnnounceList(@Param("title")String title,
                                      @Param("time1") Date time1,
                                      @Param("time2") Date time2,
                                      @Param("pageNumber")int pageNumber,
                                      @Param("pageSize")int pageSize);

    int countAnnounce();
    Announce lookAnnounceById(@Param("id")int id);
}