package com.example.oa.controller;

import com.alibaba.fastjson.JSON;
import com.example.oa.po.Organization;
import com.example.oa.service.OrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
    @Resource
    OrganizationService organizationService;

    /**
     * 查询机构列表
     * @return
     */
    @RequestMapping("/queryOrganizationList")
    @ResponseBody
    public String queryOrganizationList(){
        return JSON.toJSONString(organizationService.queryOrganizationList());
    }
}
