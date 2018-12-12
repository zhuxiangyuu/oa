package com.example.oa.mapper;


import com.example.oa.po.CarReserve;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarReserveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarReserve record);

    int insertSelective(CarReserve record);

    CarReserve selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarReserve record);

    int updateByPrimaryKey(CarReserve record);
}