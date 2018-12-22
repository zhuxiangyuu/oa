package com.example.oa.controller;

import com.alibaba.fastjson.JSON;
import com.example.oa.po.Room;
import com.example.oa.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Resource
    RoomService roomService;

    @RequestMapping("/list")
    @ResponseBody
    public String queryRoomList(int page, int rows){
        List<Room> list = roomService.queryRoomList((page - 1) * rows, rows);
        Map<String, Object> map = new HashMap();
        map.put("total", roomService.countRoom());
        map.put("rows", list);
        String jsonString = JSON.toJSONString(map);
        return jsonString;
    }
    //根据ID查看会议室
    @RequestMapping("/look")
    @ResponseBody
    public String lookRoomById(int id){
        Room room = roomService.selectByPrimaryKey(id);
        Map<String, Object> map = new HashMap();
        map.put("room", room);
        String jsonString = JSON.toJSONString(map);
        return jsonString;
    }
    //根据name查询数据库有没有重名的会议室名称
    @RequestMapping("/queryRoomByName")
    @ResponseBody
    public String queryRoomByName(String name){
        return roomService.queryRoomByName(name);
    }

    //添加会议室
    @RequestMapping("/add")
    public String addRoom(Room room){
        roomService.insertSelective(room);
        return "/xingzheng/demo1/list";
    }

    //根据ID删除一条会议室
    @RequestMapping("/delete/{id}")
    public String delRoomById(@PathVariable int id){
        roomService.deleteByPrimaryKey(id);
        return "/xingzheng/demo1/list";
    }

}
