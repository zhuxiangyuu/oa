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

    /**
     * 查询 机构下的部门列表
     *
     * @param orgId
     * @return
     */
    @RequestMapping("/queryDeptByOrgId/{orgId}")
    @ResponseBody
    public String queryDeptByOrgId(@PathVariable Integer orgId) {
        return JSON.toJSONString(deptService.queryDeptByOrgId(orgId));
    }

    /**
     * 查询当前登录人的部门
     *
     * @param id
     * @return
     */
    @RequestMapping("/selectByPrimaryKey/{id}")
    @ResponseBody
    public String selectByPrimaryKey(@PathVariable Integer id) {
        return JSON.toJSONString(deptService.selectByPrimaryKey(id));
    }
}
