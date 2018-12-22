package com.example.oa.mapper;


import com.example.oa.po.RoleMenuKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleMenuMapper {
    int deleteByPrimaryKey(RoleMenuKey key);

    int insert(RoleMenuKey record);

    int insertSelective(RoleMenuKey record);

    int deleteByRoleId(@Param("roleid") Integer roleid);
}