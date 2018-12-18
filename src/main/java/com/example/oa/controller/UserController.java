package com.example.oa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.oa.po.User;
import com.example.oa.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @ResponseBody
    @RequestMapping("/queryUserByLoginname")
    public Boolean queryUserByLoginname(String loginname) {
        User user = userService.queryUserByLoginname(loginname);
        return user == null ? true : false;
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

    @RequestMapping("/updateUserState/{state}/{id}")
    public String updateUserState(@PathVariable Integer state, @PathVariable Integer id) {
        userService.updateUserState(state, id);
        return "/system/user/list";
    }

    public String updateUserInfo() {
        return "";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(User user) {
        user.setJob(setUserJob(user.getJob()));
        userService.addUser(user);
        return "true";
    }

    @RequestMapping("/updateUser/{id}")
    @ResponseBody
    public String updateUser(User user,@PathVariable Integer id) {
        user.setId(id);
        user.setJob(setUserJob(user.getJob()));
        userService.updateUser(user);
        return "true";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "/system/user/list";
    }

    @ResponseBody
    @RequestMapping("/queryUserInfoByUserId")
    public String queryUserInfoByUserId(Integer id) {
        return JSON.toJSONString(userService.queryUserInfoByUserId(id));
    }

    public String setUserJob(String number) {
        if ("1".equals(number)) {
            return "普通用户";
        } else if ("2".equals(number)) {
            return "助理";
        } else if ("3".equals(number)) {
            return "部门经理";
        } else {
            return "总监";
        }
    }
}
