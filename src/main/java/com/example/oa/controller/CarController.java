package com.example.oa.controller;

import com.alibaba.fastjson.JSON;
import com.example.oa.po.Car;
import com.example.oa.service.CarService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/car")
public class CarController {
    @Resource
    CarService carService;

    //查询列表
    @RequestMapping("/list")
    @ResponseBody
    public String queryCarList(int page, int rows){
        List<Car> list = carService.queryCarList((page - 1) * rows, rows);
        Map<String, Object> map = new HashMap();
        map.put("total", carService.countCar());
        map.put("rows", list);
        String jsonString = JSON.toJSONString(map);
        return jsonString;
    }
    //根据Id删除
    @RequestMapping("/delete/{id}")
    public String deleteCar(@PathVariable int id){
        carService.deleteCar(id);
        return "/xingzheng/demo2/list";
    }
    //根据carid查询数据库有没有重名的车辆
    @RequestMapping("/querycarid")
    @ResponseBody
    public String queryCarid(String carid){
        return carService.queryCarid(carid);
    }
    //添加一辆车
    @RequestMapping("/add")
    public String addCar(Car car){
        carService.addCar(car);
        return "/xingzheng/demo2/list";
    }
    //根据主键Id查询车辆并赋值
    @RequestMapping("/look")
    @ResponseBody
    public String queryCarById(int id){
        Car car = carService.queryCarById(id);
        Map<String, Object> map = new HashMap();
        map.put("car", car);
        String jsonString = JSON.toJSONString(map);
        return jsonString;
    }
    @RequestMapping("/save")
    public String updateCar(Car car){
        carService.updateCar(car);
        return "/xingzheng/demo2/list";
    }
}
