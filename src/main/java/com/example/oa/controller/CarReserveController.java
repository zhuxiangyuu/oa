package com.example.oa.controller;

import com.alibaba.fastjson.JSON;
import com.example.oa.po.Car;
import com.example.oa.po.CarReserve;
import com.example.oa.po.Task;
import com.example.oa.po.User;
import com.example.oa.service.CarReserveService;
import com.example.oa.service.CarService;
import com.example.oa.service.TaskService;
import com.example.oa.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/carreserve")
public class CarReserveController {
    @Resource
    CarService carService;
    @Resource
    UserService userService;
    @Resource
    CarReserveService carReserveService;
    @Resource
    TaskService taskService;

    //查询下一个审批人
    @RequestMapping("/nextAdmin/{userid}")
    @ResponseBody
    public String queryNextAdminByUserId(@PathVariable Integer userid){
        User user = userService.queryUserInfoByUserId(userid);
        List<User> list = userService.queryNextAdmin(user,"用车申请");
        return JSON.toJSONStringWithDateFormat(list,"MM/dd/yyyy");
    }
    @RequestMapping("/add")
    @ResponseBody
    public String addCarReserve(CarReserve carReserve){
        return carReserveService.addCarReserve(carReserve);
    }
    @RequestMapping("/queryCarid")
    @ResponseBody
    public String queryCarid(){
        List<Car> list = carService.queryCaridIsNotExist();
        String str = JSON.toJSONString(list);
        return str;
    }
    @RequestMapping("/look")
    @ResponseBody
    public String queryCarReserveAndTask(int id){
        CarReserve carReserve = carReserveService.queryCarReserveAndTask(id);
        Map<String ,Object> map = new HashMap();
        map.put("carReserve",carReserve);
        Task task = taskService.queryTaskByTaskId(Integer.valueOf(1 + "" + id));
        map.put("task",task);
        User user = userService.queryUserInfoByUserId(carReserve.getUserid());
        map.put("user",user);
        return JSON.toJSONStringWithDateFormat(map,"MM/dd/yyyy");
    }
}
