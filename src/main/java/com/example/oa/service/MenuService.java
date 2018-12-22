package com.example.oa.service;

import com.example.oa.po.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuService {
    List<Menu> queryMenu();

    List<Menu> queryMenuByRoleIdAndPid(Integer roleid,Integer pid);

    List<Integer> getCheckMenuByRoleid(Integer roleid);
}
