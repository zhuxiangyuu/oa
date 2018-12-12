package com.example.oa.mapper;


import com.example.oa.po.Organization;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrganizationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
}