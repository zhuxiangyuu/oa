package com.example.oa.mapper;


import com.example.oa.po.Log;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}