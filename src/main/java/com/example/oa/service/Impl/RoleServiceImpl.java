package com.example.oa.service.Impl;

import com.example.oa.mapper.RoleMapper;
import com.example.oa.po.Role;
import com.example.oa.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    RoleMapper roleMapper;


    @Override
    public List<Role> queryRoleList() {
        return roleMapper.queryRoleList();
    }

    @Override
    public List<Role> queryRolePage(Integer pageNumber, Integer pageSize, String name) {
        return roleMapper.queryRolePage(pageNumber,pageSize,name);
    }

    @Override
    public int countRole(String name) {
        return roleMapper.countRole(name);
    }

    @Override
    public Role queryRoleByName(String name) {
        return roleMapper.queryRoleByName(name);
    }

    @Override
    public int updateRoleState(Integer state, Integer id) {
        return roleMapper.updateRoleState(state,id);
    }

    @Override
    public int addRole(Role role) {
        return roleMapper.insertSelective(role);
    }

    @Override
    public int updateRole(Role role) {
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int deleteRole(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Role queryRoleInfoByRoleId(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
