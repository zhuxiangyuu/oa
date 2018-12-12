package com.example.oa.mapper;


import com.example.oa.po.Room;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);
}