package com.example.oa.service.Impl;

import com.example.oa.mapper.UserMapper;
import com.example.oa.po.User;
import com.example.oa.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements TestService {
    @Resource
    UserMapper userMapper;
    public User selectByPrimaryKey(Integer id) {

        return userMapper.selectByPrimaryKey(id);
    }
}
