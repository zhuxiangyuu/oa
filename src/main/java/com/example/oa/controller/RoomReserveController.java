package com.example.oa.controller;

import com.alibaba.fastjson.JSON;
import com.example.oa.po.Room;
import com.example.oa.po.RoomReserve;
import com.example.oa.service.RoomReserveService;
import com.example.oa.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/roomReserve")
public class RoomReserveController {
    @Resource
    RoomReserveService roomReserveService;
    @Resource
    RoomService roomService;

    @RequestMapping("/queryRoomName")
    @ResponseBody
    public String queryRoomNameByState(){
        List<Room> list = roomService.queryRoomNameByState();
        return JSON.toJSONString(list);
    }
    @RequestMapping("/add")
    @ResponseBody
    public String addRoomNameByState(String a,String x4,int name,int userId,int type,int adminid){
        SimpleDateFormat sf=new SimpleDateFormat("MM/dd/yyyy hh:mm");
        Date date1=null;
        Date date2=null;
        try {
            date1=sf.parse(a);
            date2=sf.parse(x4);
        }catch (Exception e){

        }
        RoomReserve roomReserve=new RoomReserve();
        roomReserve.setStarttime(date1);
        roomReserve.setEndtime(date2);
        roomReserve.setRoomid(name);
        roomReserve.setUserid(userId);
        roomReserve.setType(type);
        roomReserve.setAdminid(adminid);
        roomReserve.setState(1);
        return String.valueOf(roomReserveService.insertSelective(roomReserve));
    }
}
