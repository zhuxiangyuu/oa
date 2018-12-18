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
    public List<User> queryUserList(Integer pageNumber,Integer pageSize,User user) {
        return userMapper.queryUserList(pageNumber,pageSize,user);
    }

    @Override
    public int countUser(User user) {
        return userMapper.countUser(user);
    }

    @Override
    public User queryUserByLoginname(String loginname) {
        return userMapper.queryUserByLoginname(loginname);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int updateUserState(Integer state,Integer id) {
        return userMapper.updateUserState(state,id);
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User queryUserInfoByUserId(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<User> queryNextAdmin(User user,String type) {
        int deptid=0;
        int orgid=0;
        int roleid=0;
        if("用章管理".equals(type)){
            // 部门
            deptid = getDeptId(user.getDeptid());
            // 角色
            roleid = getRoleId(user.getRoleid());
            // 机构
            orgid =user.getOrgid();

        }else if("图书借阅管理".equals(type)){

        }
        return userMapper.queryNextAdmin(roleid,orgid,deptid);
    }

    public int getRoleId(Integer roleid){
        if(roleid==1){
            return 2;
        }else if (roleid==2){
            return 3;
        }else if (roleid==3){
            return 4;
        }
        return 2;
    }

    public int getDeptId(Integer deptid){
        return deptid<3?deptid:7;
    }

}
