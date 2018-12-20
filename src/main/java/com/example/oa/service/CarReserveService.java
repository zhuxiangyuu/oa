package com.example.oa.service;

import com.example.oa.po.CarReserve;

public interface CarReserveService {
    String addCarReserve(CarReserve carReserve);
    CarReserve queryCarReserveAndTask(int id);
}
