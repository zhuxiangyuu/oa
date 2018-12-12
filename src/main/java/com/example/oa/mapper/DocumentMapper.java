package com.example.oa.mapper;


import com.example.oa.po.Document;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DocumentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Document record);

    int insertSelective(Document record);

    Document selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKey(Document record);
}