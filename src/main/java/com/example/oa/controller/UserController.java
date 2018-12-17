package com.example.oa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.oa.po.User;
import com.example.oa.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    /**
     * 用户登录
     *
     * @param username
     * @param pwd
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String login(String username, String pwd, HttpSession session) {
        User user = userService.queryUserByUsernameAndPwd(username, pwd);
        if (user != null) {
            // 用户名密码输入正确
            session.setAttribute("user", user);
            return "/index";
        } else {
            // 用户名密码输入错误
            return "/login";
        }
    }

    /**
     * 查询用户列表
     *
     * @param user
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/queryUserList")
    @ResponseBody
    public String queryUserList(User user, Integer page, Integer rows) {
        List<User> list = userService.queryUserList((page - 1) * rows, rows, user);
        Map<String, Object> map = new HashMap();
        map.put("total", userService.countUser(user));
        map.put("rows", list);
        String jsonString = JSON.toJSONString(map);
        return jsonString;
    }

    public String updateUserState() {
        return "";
    }

    public String updateUserInfo() {
        return "";
    }

    public String addUser() {
        return "";
    }

    public String deleteUser() {
        return "";
    }

    public String queryUserInfoByUserId() {
        return "";
    }
}
