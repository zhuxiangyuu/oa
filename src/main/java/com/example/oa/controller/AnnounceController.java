package com.example.oa.controller;

import com.example.oa.service.AnnounceService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class AnnounceController {
    @Resource
    AnnounceService announceservice;
    public String qqueryAnnounceList(){

        return  "";
    }
}
