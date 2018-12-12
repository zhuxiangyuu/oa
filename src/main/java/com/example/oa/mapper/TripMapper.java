package com.example.oa.mapper;


import com.example.oa.po.Trip;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TripMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Trip record);

    int insertSelective(Trip record);

    Trip selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Trip record);

    int updateByPrimaryKey(Trip record);
}