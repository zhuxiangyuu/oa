package com.example.oa.mapper;


import com.example.oa.po.OrgDeptKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrgDeptMapper {
    int deleteByPrimaryKey(OrgDeptKey key);

    int insert(OrgDeptKey record);

    int insertSelective(OrgDeptKey record);
}