package com.example.oa.mapper;


import com.example.oa.po.RoleMenuKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMenuMapper {
    int deleteByPrimaryKey(RoleMenuKey key);

    int insert(RoleMenuKey record);

    int insertSelective(RoleMenuKey record);
}