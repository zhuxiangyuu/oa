package com.example.oa.service.Impl;

import com.example.oa.mapper.MenuMapper;
import com.example.oa.po.Menu;
import com.example.oa.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    MenuMapper menuMapper;

    @Override
    public List<Menu> queryMenu() {
        return menuMapper.queryMenu();
    }

    @Override
    public List<Menu> queryMenuByRoleIdAndPid(Integer roleid, Integer pid) {
        return menuMapper.queryMenuByRoleIdAndPid(roleid,pid);
    }

    @Override
    public List<Integer> getCheckMenuByRoleid(Integer roleid) {
        return menuMapper.getCheckMenuByRoleid(roleid);
    }

}
