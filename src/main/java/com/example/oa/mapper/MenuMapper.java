package com.example.oa.mapper;


import com.example.oa.po.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> queryMenu();

    List<Menu> queryMenuByRoleIdAndPid(@Param("roleid") Integer roleid,@Param("pid") Integer pid);

    List<Integer> getCheckMenuByRoleid(@Param("roleid") Integer roleid);
}