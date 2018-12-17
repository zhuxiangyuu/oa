package com.example.oa.controller;

import com.alibaba.fastjson.JSON;
import com.example.oa.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/dept")
public class DeptController {
    @Resource
    DeptService deptService;
    @RequestMapping("/queryDeptByOrgId/{orgId}")
    @ResponseBody
    public String queryDeptByOrgId(@PathVariable Integer orgId){
        return JSON.toJSONString(deptService.queryDeptByOrgId(orgId));
    }
}
