package com.example.oa.service;

import com.example.oa.po.Room;

import java.util.List;

public interface RoomService {
    int deleteByPrimaryKey(Integer id);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    List<Room> queryRoomList(int pageNumber,int pageSize);

    int countRoom();

    String queryRoomByName(String name);

}
