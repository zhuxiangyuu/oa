package com.example.oa.service.Impl;

import com.example.oa.mapper.RoleMapper;
import com.example.oa.mapper.RoleMenuMapper;
import com.example.oa.po.RoleMenuKey;
import com.example.oa.service.RoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    @Resource
    RoleMenuMapper roleMenuMapper;
    @Override
    public int insert(RoleMenuKey roleMenu) {
        return roleMenuMapper.insert(roleMenu);
    }
}
