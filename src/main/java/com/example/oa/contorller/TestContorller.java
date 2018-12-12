package com.example.oa.contorller;

import com.alibaba.fastjson.JSON;
import com.example.oa.po.User;
import com.example.oa.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/emp")
public class TestContorller {
    @Resource
    TestService testService;

    @RequestMapping("/list")
    public String queryUser(){
        int i=1;
        User user=testService.selectByPrimaryKey(i);
        //吧list转换成json

        String jsonstr = JSON.toJSONStringWithDateFormat(user,"yyyy-MM-dd hh:mm:ss");
        return jsonstr;
    }
}
