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
}
