package com.example.oa.mapper;


import com.example.oa.po.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    List<Task> queryTaskSelective(@Param("pageNumber") Integer pageNumber, @Param("pageSize")Integer pageSize, @Param("task")Task task);

    int countTaskSelective(@Param("task")Task task);
}