package com.example.oa.service.Impl;

import com.example.oa.mapper.UserMapper;
import com.example.oa.po.User;
import com.example.oa.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public User queryUserByUsernameAndPwd(String username, String pwd) {
        return userMapper.queryUserByUsernameAndPwd(username,pwd);
    }

    @Override
    public List<User> queryUserList(Integer pageNumber,Integer pageSize) {
        return userMapper.queryUserList(pageNumber,pageSize);
    }

    @Override
    public int countUser() {
        return userMapper.countUser();
    }
}
