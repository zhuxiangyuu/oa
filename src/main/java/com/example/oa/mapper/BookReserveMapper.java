package com.example.oa.mapper;


import com.example.oa.po.BookReserve;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookReserveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookReserve record);

    int insertSelective(BookReserve record);

    BookReserve selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookReserve record);

    int updateByPrimaryKey(BookReserve record);
}