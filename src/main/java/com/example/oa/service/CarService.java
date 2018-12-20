package com.example.oa.service;

import com.example.oa.po.Car;

import java.util.List;

public interface CarService {
    List<Car> queryCarList(int pageNumber, int pageSize);
    int countCar();

    int deleteCar(int id);

    String queryCarid(String carid);

    int addCar(Car car);

    Car queryCarById(int id);

    int  updateCar(Car car);

    List<Car> queryCaridIsNotExist();
}
