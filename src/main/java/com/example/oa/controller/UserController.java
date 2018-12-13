package com.example.oa.controller;

import com.example.oa.po.User;
import com.example.oa.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/login")
    public String login(String username, String pwd, HttpSession session) {
        System.out.println("123___________");
        User user = userService.queryUserByUsernameAndPwd(username,pwd);
        System.out.print("用户查询 ————————————————————>"+user);
        if(user!=null){
            // 用户名密码输入正确
            session.setAttribute("user",user);
            return "/index";
        }else{
            // 用户名密码输入错误
            return "/login";
        }
    }
}
