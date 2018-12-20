package com.example.oa.service;

import com.example.oa.po.User;

import java.util.List;

public interface UserService {
    User queryUserByUsernameAndPwd(String username, String pwd);
    List<User> queryUserList(Integer pageNumber,Integer pageSize,User user);
    int countUser(User user);
    User queryUserByLoginname(String loginname);
    int addUser(User user);
    int updateUserState(Integer state,Integer id);
    int deleteUser(Integer id);
    User queryUserInfoByUserId(Integer id);
    int updateUser(User user);
    List<User> queryNextAdmin(User user,String type);
    int updateByPrimaryKeySelective(User record);
}
