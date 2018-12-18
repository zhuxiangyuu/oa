package com.example.oa.mapper;


import com.example.oa.po.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> queryRoleList();

    List<Role> queryRolePage(@Param("pageNumber")Integer pageNumber, @Param("pageSize")Integer pageSize, @Param("name")String name);

    int countRole(@Param("name")String name);

    Role queryRoleByName(@Param("name")String name);

    int updateRoleState(@Param("state")Integer state, @Param("id")Integer id);
}