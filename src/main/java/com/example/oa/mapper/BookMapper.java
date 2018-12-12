package com.example.oa.mapper;


import com.example.oa.po.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    int deleteByPrimaryKey(String bookid);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(String bookid);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}