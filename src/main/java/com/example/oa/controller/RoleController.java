package com.example.oa.controller;

import com.alibaba.fastjson.JSON;
import com.example.oa.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Resource
    RoleService roleService;
    @RequestMapping("/queryRoleList")
    @ResponseBody
    public String queryRoleList(){
        return JSON.toJSONString(roleService.queryRoleList());
    }
}
