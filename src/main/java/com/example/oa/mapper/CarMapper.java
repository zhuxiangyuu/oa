package com.example.oa.mapper;


import com.example.oa.po.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    List<Car> queryCarList(@Param("pageNumber")int pageNumber,@Param("pageSize")int pageSize);

    int countCar();

    Car queryCarid(@Param("carid")String carid);

    List<Car> queryCaridIsNotExist();
}