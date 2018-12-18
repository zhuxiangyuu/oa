package com.example.oa.service;

import com.example.oa.po.Role;

import java.util.List;

public interface RoleService {
    List<Role> queryRoleList();
    List<Role> queryRolePage(Integer pageNumber,Integer pageSize,String name);
    int countRole(String name);
    Role queryRoleByName(String name);
    int updateRoleState(Integer state,Integer id);
    int addRole(Role role);
    int updateRole(Role role);
    int deleteRole(Integer id);
    Role queryRoleInfoByRoleId(Integer id);
}
