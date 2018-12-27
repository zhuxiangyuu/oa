package com.example.oa.mapper;


import com.example.oa.po.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    List<Room> queryRoomList(@Param("pageNumber")int pageNumber, @Param("pageSize")int pageSize);

    int countRoom();

    Room queryRoomByName(@Param("name") String name);

    List<Room> queryRoomNameByState();

}