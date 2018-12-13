package com.example.oa.service;

import com.example.oa.po.User;

public interface UserService {
    User queryUserByUsernameAndPwd(String username, String pwd);
}
