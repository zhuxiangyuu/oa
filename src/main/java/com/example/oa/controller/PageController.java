package com.example.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PageController {

    @RequestMapping(value="/page/{page1}/{page2}/{page3}")
    public String turnPage(@PathVariable String page1,@PathVariable String page2,@PathVariable String page3){
        StringBuffer stringBuffer =  new StringBuffer(page1);
        stringBuffer.append("/"+page2);
        stringBuffer.append("/"+page3);
            return stringBuffer.toString();
    }
}
