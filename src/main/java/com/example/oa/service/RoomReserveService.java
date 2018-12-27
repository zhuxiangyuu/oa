package com.example.oa.service;

import com.example.oa.po.RoomReserve;

public interface RoomReserveService {
    int deleteByPrimaryKey(Integer id);

    int insert(RoomReserve record);

    int insertSelective(RoomReserve record);

    RoomReserve selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoomReserve record);

    int updateByPrimaryKey(RoomReserve record);

    int queryRoomReserveId();

}
