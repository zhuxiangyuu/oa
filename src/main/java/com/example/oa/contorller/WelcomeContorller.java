package com.example.oa.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class WelcomeContorller {


    @RequestMapping("/")
    public String welcome(){
        return "login";
    }
}
