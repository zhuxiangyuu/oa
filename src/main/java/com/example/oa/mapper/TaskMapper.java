package com.example.oa.mapper;


import com.example.oa.po.Task;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
}