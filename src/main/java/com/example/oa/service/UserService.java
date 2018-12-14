package com.example.oa.service;

import com.example.oa.po.User;

import java.util.List;

public interface UserService {
    User queryUserByUsernameAndPwd(String username, String pwd);
    List<User> queryUserList(Integer pageNumber,Integer pageSize);
    int countUser();
}
