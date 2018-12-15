package com.example.oa.controller;

import com.alibaba.fastjson.JSON;
import com.example.oa.po.Announce;
import com.example.oa.po.User;
import com.example.oa.service.AnnounceService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/announce")
public class AnnounceController {
    @Resource
    AnnounceService announceservice;

    @RequestMapping("/list")
    @ResponseBody
    public String queryAnnounceList(String title, String time1, String time2, int page, int rows, Map<String, Object> map) {
        Date date1 = null;
        Date date2 = null;
        System.out.println("time1:" + time1 + "time2:" + time2);
        try {
            if (time1 != null && !"".equals(time1)) {
                date1 = new SimpleDateFormat("MM/dd/yyyy").parse(time1);
            }
            if (time2 != null && !"".equals(time2)) {
                date2 = new SimpleDateFormat("MM/dd/yyyy").parse(time2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Date1:" + date1 + "Date2:" + date2);
        List<Announce> list = announceservice.queryAnnounceList(title, date1, date2, (page - 1) * rows, rows);
        map.put("total", announceservice.countAnnounce());
        map.put("rows", list);
        String jsonString = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
        return jsonString;
    }
    //根据id查询一个列表
    @RequestMapping("/look")
    @ResponseBody
    public String lookAnnounceById(@Param("id") int id, Map<String, Object> map) {
        Announce announce = announceservice.lookAnnounceById(id);
        map.put("announce", announce);
        String jsonString = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
        return jsonString;
    }
    @RequestMapping("/add")
    @ResponseBody
    public String addAnnounce(int state,Announce announce, HttpSession session){
        announce.setState(state);
        User user = (User)session.getAttribute("user");
        announce.setUserid(user.getId());
        announceservice.addAnnounce(announce);
        return "666";
    }
}
