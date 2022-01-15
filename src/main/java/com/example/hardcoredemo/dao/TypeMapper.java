package com.example.hardcoredemo.dao;

import com.example.hardcoredemo.model.BdStaff;
import com.example.hardcoredemo.model.BdStaffExample;
import com.example.hardcoredemo.model.BdStaffWithBLOBs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TypeMapper {
    long countByExample(BdStaffExample example);

    int deleteByExample(BdStaffExample example);

    int deleteByPrimaryKey(String id);

    int insert(BdStaffWithBLOBs record);

    int insertSelective(BdStaffWithBLOBs record);

    List<BdStaffWithBLOBs> selectByExampleWithBLOBs(BdStaffExample example);

    List<BdStaff> selectByExample(BdStaffExample example);

    BdStaffWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BdStaffWithBLOBs record, @Param("example") BdStaffExample example);

    int updateByExampleWithBLOBs(@Param("record") BdStaffWithBLOBs record, @Param("example") BdStaffExample example);

    int updateByExample(@Param("record") BdStaff record, @Param("example") BdStaffExample example);

    int updateByPrimaryKeySelective(BdStaffWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BdStaffWithBLOBs record);

    int updateByPrimaryKey(BdStaff record);
}