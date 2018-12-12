package com.example.oa.mapper;


import com.example.oa.po.Vcard;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VcardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Vcard record);

    int insertSelective(Vcard record);

    Vcard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Vcard record);

    int updateByPrimaryKey(Vcard record);
}