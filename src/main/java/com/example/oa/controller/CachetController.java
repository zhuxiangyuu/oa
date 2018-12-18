package com.example.oa.controller;

import com.example.oa.service.CachetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/cachet")
public class CachetController {

    @Resource
    CachetService cachetService;


}
