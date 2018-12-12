package com.example.oa.mapper;


import com.example.oa.po.Leave;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LeaveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Leave record);

    int insertSelective(Leave record);

    Leave selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Leave record);

    int updateByPrimaryKey(Leave record);
}