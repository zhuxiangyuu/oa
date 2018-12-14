package com.example.oa.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.oa.po.User;
import com.example.oa.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/login")
    public String login(String username, String pwd, HttpSession session) {
        User user = userService.queryUserByUsernameAndPwd(username,pwd);
        if(user!=null){
            // 用户名密码输入正确
            session.setAttribute("user",user);
            return "/index";
        }else{
            // 用户名密码输入错误
            return "/login";
        }
    }
    @RequestMapping("/queryUserList")
    @ResponseBody
    public String queryUserList(Integer page, Integer rows , Map<String,Object> map){
        List<User> list = userService.queryUserList((page - 1) * rows, rows);
        map.put("total", userService.countUser());
        map.put("rows", list);
        String jsonString =JSONArray.toJSONString(map);
        return jsonString;
    }
}
