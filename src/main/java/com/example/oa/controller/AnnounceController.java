package com.example.oa.controller;

import com.alibaba.fastjson.JSON;
import com.example.oa.po.Announce;
import com.example.oa.po.Task;
import com.example.oa.service.AnnounceService;
import com.example.oa.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/announce")
public class AnnounceController {
    @Resource
    AnnounceService announceservice;
    @Resource
    TaskService taskService;

    //查询通告列表
    @RequestMapping("/list")
    @ResponseBody
    public String queryAnnounceList(String title, String time1, String time2, int page, int rows) {
        Date date1 = null;
        Date date2 = null;
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
        List<Announce> list = announceservice.queryAnnounceList(title, date1, date2, (page - 1) * rows, rows);
        Map<String, Object> map = new HashMap();
        map.put("total", announceservice.countAnnounce());
        map.put("rows", list);
        String jsonString = JSON.toJSONStringWithDateFormat(map, "MM/dd/yyyy");
        return jsonString;
    }
    //根据状态查询通告列表
    @RequestMapping("/queryListByState/{state}")
    @ResponseBody
    public String queryAnnounceListByState(String title, String time1, String time2, int page, int rows,@PathVariable int state) {
        Date date1 = null;
        Date date2 = null;
        try {
            if (time1 != null && time1!="") {
                date1 = new SimpleDateFormat("MM/dd/yyyy").parse(time1);
            }
            if (time2 != null && time2!="") {
                date2 = new SimpleDateFormat("MM/dd/yyyy").parse(time2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Announce> list = announceservice.queryAnnounceListByState(title, date1, date2, (page - 1) * rows, rows,state);
        Map<String, Object> map = new HashMap();
        map.put("total", announceservice.countAnnounce());
        map.put("rows", list);
        String jsonString = JSON.toJSONStringWithDateFormat(map, "MM/dd/yyyy");
        return jsonString;
    }


    //根据id查询一个通告
    @RequestMapping("/look")
    @ResponseBody
    public String lookAnnounceById(int id) {
        Announce announce = announceservice.lookAnnounceById(id);
        Map<String, Object> map = new HashMap();
        map.put("announce", announce);
        Task task = taskService.queryTaskByTaskId(Integer.valueOf(2 + "" + id));
        map.put("task",task);
        return JSON.toJSONStringWithDateFormat(map, "MM/dd/yyyy");
    }

    //添加一条通告
    @RequestMapping("/add/{userId}")
    public String addAnnounce(Announce announce,@PathVariable int userId) {
        announce.setUserid(userId);
        // 发布
        announceservice.addAnnounce(announce);

        return "/tonggao/demo1/list";
    }

    @RequestMapping("/del/{id}")
    public String deleteAnnounceById(@PathVariable int id) {
        announceservice.deleteAnnounceById(id);
        return "/tonggao/demo1/list";
    }

    //编辑并发布一条通告
    @RequestMapping("/save/{userId}")
    public String updateByPrimaryKeySelective(Announce record , @PathVariable int userId) {
        record.setUserid(userId);
        announceservice.updateByPrimaryKeySelective(record);
        return "/tonggao/demo1/list";
    }
}
