package com.example.hardcoredemo.dao;

import com.example.hardcoredemo.model.LzUser;
import com.example.hardcoredemo.model.LzUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LzUserMapper {
    long countByExample(LzUserExample example);

    int deleteByExample(LzUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LzUser record);

    int insertSelective(LzUser record);

    List<LzUser> selectByExample(LzUserExample example);

    LzUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LzUser record, @Param("example") LzUserExample example);

    int updateByExample(@Param("record") LzUser record, @Param("example") LzUserExample example);

    int updateByPrimaryKeySelective(LzUser record);

    int updateByPrimaryKey(LzUser record);
}