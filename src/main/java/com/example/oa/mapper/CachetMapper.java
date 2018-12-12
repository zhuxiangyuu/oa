package com.example.oa.mapper;


import com.example.oa.po.Cachet;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CachetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cachet record);

    int insertSelective(Cachet record);

    Cachet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cachet record);

    int updateByPrimaryKey(Cachet record);
}