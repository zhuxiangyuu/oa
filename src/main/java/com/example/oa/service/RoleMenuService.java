package com.example.oa.service;

import com.example.oa.po.RoleMenuKey;

public interface RoleMenuService {
    int insert(RoleMenuKey roleMenu);
    int deleteByRoleId(Integer roleid);
}
