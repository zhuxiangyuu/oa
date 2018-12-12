package com.example.oa.mapper;


import com.example.oa.po.Car;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);
}