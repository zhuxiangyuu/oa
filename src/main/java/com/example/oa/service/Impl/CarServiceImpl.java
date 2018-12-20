package com.example.oa.service.Impl;

import com.example.oa.mapper.CarMapper;
import com.example.oa.po.Car;
import com.example.oa.service.CarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CarServiceImpl implements CarService {

    @Resource
    CarMapper carMapper;
    public List<Car> queryCarList(int pageNumber,int pageSize) {

        return carMapper.queryCarList(pageNumber,pageSize);
    }

    public int countCar() {
        return carMapper.countCar();
    }

    public int deleteCar(int id) {
        return carMapper.deleteByPrimaryKey(id);
    }

    public String queryCarid(String carid) {
        if(carMapper.queryCarid(carid)!=null){
            return "false";
        }else{
            return "true";
        }
    }

    @Override
    public int addCar(Car car) {
        return carMapper.insertSelective(car);
    }

    @Override
    public Car queryCarById(int id) {
        return carMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateCar(Car car) {
        return carMapper.updateByPrimaryKeySelective(car);
    }

    @Override
    public List<Car> queryCaridIsNotExist() {
        return carMapper.queryCaridIsNotExist();
    }
}
