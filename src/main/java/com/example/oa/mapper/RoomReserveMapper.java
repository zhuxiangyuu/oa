package com.example.oa.mapper;


import com.example.oa.po.RoomReserve;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomReserveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoomReserve record);

    int insertSelective(RoomReserve record);

    RoomReserve selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoomReserve record);

    int updateByPrimaryKey(RoomReserve record);
}