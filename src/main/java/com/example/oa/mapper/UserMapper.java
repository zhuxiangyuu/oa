package com.example.oa.mapper;


import com.example.oa.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User queryUserByUsernameAndPwd(@Param("username") String username, @Param("pwd")String pwd);

    List<User> queryUserList(@Param("pageNumber")Integer pageNumber,@Param("pageSize")Integer pageSize,@Param("user")User user);

    int countUser(@Param("user")User user);

    User queryUserByLoginname(@Param("loginname")String loginname);

    int updateUserState(@Param("state")Integer state,@Param("id")Integer id);

    List<User> queryNextAdmin(@Param("roleId")Integer roleId,@Param("orgId")Integer orgId,@Param("deptId")Integer deptId);
}